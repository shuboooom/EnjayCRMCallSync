package com.enjay.crm.callsync.ui.leads

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.core.view.MenuProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentLeadDetailBinding
import com.enjay.crm.callsync.ui.postcall.PostCallActivityFormActivity
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import kotlinx.coroutines.launch

class LeadDetailFragment : Fragment(R.layout.fragment_lead_detail) {

    private var _binding: FragmentLeadDetailBinding? = null
    private val binding get() = _binding!!

    private val leadId: Long
        get() = requireArguments().getLong(ARG_LEAD_ID)

    private val viewModel: LeadDetailViewModel by viewModels {
        AppViewModelFactory(requireActivity().application, leadId)
    }
    private var hasShownLeadNotFound = false
    private var currentPhoneNumber: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLeadDetailBinding.bind(view)
        setupToolbarActions()
        val headerAdapter = LeadDetailHeaderAdapter()
        val deviceContactAdapter = DeviceContactAdapter()
        val sectionHeaderAdapter = LeadDetailSectionHeaderAdapter()
        val emptyAdapter = LeadDetailEmptyAdapter()
        val callLogAdapter = LeadCallLogAdapter(::openPostCallDetail, ::openAddPostCall)
        binding.leadDetailRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.leadDetailRecyclerView.adapter = ConcatAdapter(
            headerAdapter,
            deviceContactAdapter,
            sectionHeaderAdapter,
            emptyAdapter,
            callLogAdapter,
        )

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val lead = state.lead
                    if (lead == null) {
                        if (!state.isLoading && !hasShownLeadNotFound) {
                            hasShownLeadNotFound = true
                            Snackbar.make(binding.root, R.string.lead_not_found, Snackbar.LENGTH_SHORT).show()
                        }
                        return@collect
                    }

                    headerAdapter.submitLead(lead)
                    currentPhoneNumber = lead.phone

                    deviceContactAdapter.submitDeviceContact(state.deviceContact)
                    callLogAdapter.submitList(state.callLogs)
                    emptyAdapter.setVisible(state.callLogs.isEmpty())
                }
            }
        }
        viewModel.loadLead()
    }

    private fun setupToolbarActions() {
        requireActivity().addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.lead_detail_actions_menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return when (menuItem.itemId) {
                        R.id.action_call_lead -> {
                            openDialer()
                            true
                        }

                        R.id.action_message_lead -> {
                            openMessenger()
                            true
                        }

                        else -> false
                    }
                }
            },
            viewLifecycleOwner,
            Lifecycle.State.RESUMED,
        )
    }

    private fun openDialer() {
        currentPhoneNumber?.takeIf { it.isNotBlank() }?.let { phoneNumber ->
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
        }
    }

    private fun openMessenger() {
        currentPhoneNumber?.takeIf { it.isNotBlank() }?.let { phoneNumber ->
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber")))
        }
    }

    private fun openPostCallDetail(postCallActivityId: Long) {
        findNavController().navigate(
            R.id.postCallDetailFragment,
            Bundle().apply {
                putLong("postCallActivityId", postCallActivityId)
            },
        )
    }

    private fun openAddPostCall(item: LeadCallLogItemUiModel) {
        val lead = viewModel.uiState.value.lead ?: return
        val callLog = item.callLog
        startActivity(
            Intent(requireContext(), PostCallActivityFormActivity::class.java).apply {
                putExtra(PostCallActivityFormActivity.EXTRA_LEAD_ID, lead.id)
                putExtra(PostCallActivityFormActivity.EXTRA_LEAD_CALL_LOG_ID, callLog.id)
                putExtra(PostCallActivityFormActivity.EXTRA_LEAD_NAME, lead.name)
                putExtra(PostCallActivityFormActivity.EXTRA_PHONE_NUMBER, callLog.phoneNumber)
                putExtra(PostCallActivityFormActivity.EXTRA_CALL_TYPE, callLog.callType.name)
                putExtra(PostCallActivityFormActivity.EXTRA_CALL_TIMESTAMP, callLog.timestamp)
                putExtra(PostCallActivityFormActivity.EXTRA_CALL_DURATION_SECONDS, callLog.durationSeconds)
            },
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_LEAD_ID = "leadId"
    }
}
