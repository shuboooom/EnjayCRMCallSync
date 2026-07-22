package com.enjay.crm.callsync.ui.calls

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentCallsBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class CallsFragment : Fragment(R.layout.fragment_calls) {

    private var _binding: FragmentCallsBinding? = null
    private val binding get() = _binding!!
    private var tabLayoutMediator: TabLayoutMediator? = null
    private val viewModel: CallsViewModel by activityViewModels {
        AppViewModelFactory(requireActivity().application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCallsBinding.bind(view)
        binding.callsTabLayout.visibility = View.VISIBLE
        binding.callsViewPager.adapter = CallsPagerAdapter(this)
        tabLayoutMediator = TabLayoutMediator(binding.callsTabLayout, binding.callsViewPager) { tab, position ->
            tab.setText(
                if (position == CallsPagerAdapter.POSITION_BUSINESS) {
                    R.string.tab_business
                } else {
                    R.string.tab_personal
                },
            )
        }.also(TabLayoutMediator::attach)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCalls()
    }

    override fun onDestroyView() {
        tabLayoutMediator?.detach()
        tabLayoutMediator = null
        binding.callsViewPager.adapter = null
        super.onDestroyView()
        _binding = null
    }
}
