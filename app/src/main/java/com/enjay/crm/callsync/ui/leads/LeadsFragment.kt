package com.enjay.crm.callsync.ui.leads

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentLeadsBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import kotlinx.coroutines.launch

class LeadsFragment : Fragment(R.layout.fragment_leads) {

    private var _binding: FragmentLeadsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LeadsViewModel by viewModels {
        AppViewModelFactory(requireActivity().application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLeadsBinding.bind(view)

        val adapter = LeadAdapter { lead ->
            findNavController().navigate(
                R.id.action_leadsFragment_to_leadDetailFragment,
                bundleOf(LeadDetailFragment.ARG_LEAD_ID to lead.id),
            )
        }
        binding.leadsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.leadsRecyclerView.adapter = adapter

        binding.addLeadFab.setOnClickListener {
            findNavController().navigate(R.id.action_leadsFragment_to_addLeadFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    adapter.submitList(state.leads)
                    val showEmpty = state.leads.isEmpty()
                    binding.emptyStateLayout.visibility = if (showEmpty) View.VISIBLE else View.GONE
                    binding.leadsRecyclerView.visibility = if (showEmpty) View.GONE else View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
