package com.enjay.crm.callsync.ui.calls

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.model.CallLogItem
import com.enjay.crm.callsync.databinding.FragmentCallsPageBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import com.enjay.crm.callsync.ui.leads.LeadDetailFragment
import com.enjay.crm.callsync.ui.leads.AddLeadFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class CallsPageFragment : Fragment(R.layout.fragment_calls_page) {

    private var _binding: FragmentCallsPageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CallsViewModel by activityViewModels {
        AppViewModelFactory(requireActivity().application)
    }

    private val callsTab: CallsTab
        get() = requireArguments().getSerializable(ARG_CALLS_TAB) as CallsTab

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCallsPageBinding.bind(view)

        val adapter = CallLogAdapter()
        CallLogAdapter.attachStringProvider(::getString)
        adapter.setActionMode(
            if (callsTab == CallsTab.BUSINESS) {
                CallLogAdapter.CallActionMode.DIRECT_CALL
            } else {
                CallLogAdapter.CallActionMode.MENU
            },
        )
        adapter.setOnCallActionClicked(::showCallActionsMenu)
        adapter.setOnItemClicked(::handleCallItemTapped)
        binding.callsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.callsRecyclerView.adapter = adapter

        binding.openPermissionsButton.setOnClickListener {
            val uri = Uri.fromParts("package", requireContext().packageName, null)
            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, uri))
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val visibleCalls = when (callsTab) {
                        CallsTab.PERSONAL -> state.personalCalls
                        CallsTab.BUSINESS -> state.businessCalls
                    }
                    adapter.submitCalls(visibleCalls)
                    binding.skeletonLayout.visibility = if (state.isLoading && state.hasPermission) View.VISIBLE else View.GONE
                    val showEmpty = !state.isLoading && visibleCalls.isEmpty()
                    binding.emptyStateLayout.visibility = if (showEmpty) View.VISIBLE else View.GONE
                    binding.callsRecyclerView.visibility = if (showEmpty || state.isLoading) View.GONE else View.VISIBLE

                    if (!state.hasPermission) {
                        binding.emptyTitleText.setText(R.string.calls_permission_title)
                        binding.emptyBodyText.setText(R.string.calls_permission_body)
                        binding.openPermissionsButton.visibility = View.VISIBLE
                    } else {
                        binding.emptyTitleText.setText(
                            if (callsTab == CallsTab.PERSONAL) {
                                R.string.calls_personal_empty_title
                            } else {
                                R.string.calls_business_empty_title
                            },
                        )
                        binding.emptyBodyText.setText(
                            if (callsTab == CallsTab.PERSONAL) {
                                R.string.calls_personal_empty_body
                            } else {
                                R.string.calls_business_empty_body
                            },
                        )
                        binding.openPermissionsButton.visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showCallActionsMenu(item: CallLogItem, anchor: View) {
        if (callsTab == CallsTab.BUSINESS) {
            callNumber(item.phoneNumber, direct = true)
            return
        }

        PopupMenu(
            requireContext(),
            anchor,
            Gravity.END,
            0,
            R.style.Widget_Enjay_PopupMenu,
        ).apply {
            menuInflater.inflate(R.menu.recent_call_actions_menu, menu)
            setForceShowIcon(true)
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_add_as_lead -> {
                        openAddLeadPrefilled(item)
                        true
                    }

                    R.id.action_call_now -> {
                        callNumber(item.phoneNumber, direct = false)
                        true
                    }

                    else -> false
                }
            }
        }.show()
    }

    private fun callNumber(phoneNumber: String?, direct: Boolean) {
        val value = phoneNumber?.trim().orEmpty()
        if (value.isBlank()) return
        val hasCallPermission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CALL_PHONE,
        ) == PackageManager.PERMISSION_GRANTED

        val intent = when {
            direct && hasCallPermission -> Intent(Intent.ACTION_CALL, Uri.parse("tel:$value"))
            else -> Intent(Intent.ACTION_DIAL, Uri.parse("tel:$value"))
        }
        startActivity(intent)

        if (direct && !hasCallPermission) {
            Snackbar.make(binding.root, R.string.call_permission_required_message, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun openAddLeadPrefilled(item: CallLogItem) {
        findNavController().navigate(
            R.id.addLeadFragment,
            Bundle().apply {
                putString(AddLeadFragment.ARG_PREFILL_NAME, item.name)
                putString(AddLeadFragment.ARG_PREFILL_PHONE, item.phoneNumber)
            },
        )
    }

    private fun handleCallItemTapped(item: CallLogItem, anchor: View) {
        if (callsTab == CallsTab.PERSONAL) {
            showCallActionsMenu(item, anchor)
            return
        }
        viewLifecycleOwner.lifecycleScope.launch {
            val leadId = viewModel.findLeadIdByPhoneNumber(item.phoneNumber) ?: return@launch
            findNavController().navigate(
                R.id.leadDetailFragment,
                Bundle().apply {
                    putLong(LeadDetailFragment.ARG_LEAD_ID, leadId)
                },
            )
        }
    }

    companion object {
        private const val ARG_CALLS_TAB = "callsTab"

        fun newInstance(tab: CallsTab): CallsPageFragment {
            return CallsPageFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CALLS_TAB, tab)
                }
            }
        }
    }
}
