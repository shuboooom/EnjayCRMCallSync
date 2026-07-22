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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentLeadDetailBinding
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
        val callLogAdapter = LeadCallLogAdapter()
        binding.callLogsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.callLogsRecyclerView.adapter = callLogAdapter

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

                    binding.nameText.text = lead.name
                    binding.phoneText.text = lead.phone
                    binding.leadIdText.text = lead.id.toString()
                    currentPhoneNumber = lead.phone

                    val deviceContact = state.deviceContact
                    binding.deviceContactCard.visibility = if (deviceContact != null) View.VISIBLE else View.GONE
                    if (deviceContact != null) {
                        binding.deviceContactNameText.text = deviceContact.displayName
                        binding.deviceContactPhoneText.text = deviceContact.phoneNumber
                        binding.deviceContactCard.setOnClickListener {
                            startActivity(
                                Intent(Intent.ACTION_VIEW, deviceContact.lookupUri).apply {
                                    setDataAndType(deviceContact.lookupUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE)
                                },
                            )
                        }
                    }

                    callLogAdapter.submitList(state.callLogs)
                    binding.callLogsEmptyText.visibility = if (state.callLogs.isEmpty()) View.VISIBLE else View.GONE
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_LEAD_ID = "leadId"
    }
}
