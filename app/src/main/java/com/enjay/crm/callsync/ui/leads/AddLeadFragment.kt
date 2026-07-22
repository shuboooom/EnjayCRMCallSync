package com.enjay.crm.callsync.ui.leads

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentAddLeadBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import kotlinx.coroutines.launch

class AddLeadFragment : Fragment(R.layout.fragment_add_lead) {

    private var _binding: FragmentAddLeadBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddLeadViewModel by viewModels {
        AppViewModelFactory(requireActivity().application)
    }

    private val prefillName: String?
        get() = arguments?.getString(ARG_PREFILL_NAME)

    private val prefillPhone: String?
        get() = arguments?.getString(ARG_PREFILL_PHONE)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddLeadBinding.bind(view)
        if (savedInstanceState == null) {
            binding.nameEditText.setText(prefillName.orEmpty())
            binding.phoneEditText.setText(prefillPhone.orEmpty())
        }

        binding.saveButton.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val result = viewModel.saveLead(
                    name = binding.nameEditText.text?.toString().orEmpty(),
                    phone = binding.phoneEditText.text?.toString().orEmpty(),
                )
                binding.nameInputLayout.error = result.nameErrorRes?.let(::getString)
                binding.phoneInputLayout.error = result.phoneErrorRes?.let(::getString)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.events.collect { event ->
                    if (event is AddLeadEvent.Success) {
                        Snackbar.make(binding.root, R.string.lead_saved_message, Snackbar.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_PREFILL_NAME = "prefillName"
        const val ARG_PREFILL_PHONE = "prefillPhone"
    }
}
