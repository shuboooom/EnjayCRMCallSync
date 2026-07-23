package com.enjay.crm.callsync.ui.postcall

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentPostCallDetailBinding
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import com.enjay.crm.callsync.util.CallLogFormatter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class PostCallDetailFragment : Fragment(R.layout.fragment_post_call_detail) {

    private var _binding: FragmentPostCallDetailBinding? = null
    private val binding get() = _binding!!

    private val postCallActivityId: Long
        get() = requireArguments().getLong(ARG_POST_CALL_ACTIVITY_ID)

    private val viewModel: PostCallDetailViewModel by viewModels {
        AppViewModelFactory(requireActivity().application, postCallActivityId = postCallActivityId)
    }

    private var hasShownNotFound = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPostCallDetailBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val activity = state.postCallActivity
                    if (activity == null) {
                        if (!state.isLoading && !hasShownNotFound) {
                            hasShownNotFound = true
                            Snackbar.make(binding.root, R.string.post_call_detail_not_found, Snackbar.LENGTH_SHORT).show()
                        }
                        return@collect
                    }

                    binding.leadNameText.text = state.lead?.name ?: getString(R.string.unknown_name)
                    binding.leadPhoneText.text = state.lead?.phone ?: getString(R.string.unknown_number)
                    binding.callNotesText.text = activity.callNotes
                    binding.callOutcomeText.text = activity.callOutcome
                    binding.followUpText.text = CallLogFormatter.formatDateTime(activity.followUpAt)
                    binding.nextActionText.text = activity.nextAction
                    binding.additionalRemarksText.text = activity.additionalRemarks.orEmpty()
                    binding.additionalRemarksGroup.visibility =
                        if (activity.additionalRemarks.isNullOrBlank()) View.GONE else View.VISIBLE
                }
            }
        }

        viewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_POST_CALL_ACTIVITY_ID = "postCallActivityId"
    }
}
