package com.enjay.crm.callsync.ui.more

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.databinding.FragmentMoreBinding
import com.enjay.crm.callsync.sync.SyncWorkScheduler
import com.enjay.crm.callsync.ui.common.AppViewModelFactory
import com.enjay.crm.callsync.util.CallLogFormatter
import kotlinx.coroutines.launch

class MoreFragment : Fragment(R.layout.fragment_more) {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MoreViewModel by viewModels {
        AppViewModelFactory(requireActivity().application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMoreBinding.bind(view)

        binding.syncNowButton.setOnClickListener {
            SyncWorkScheduler.triggerManualSync(requireContext())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    val syncState = state.syncState
                    val workDebugState = state.workDebugState
                    val pendingSyncCounts = state.pendingSyncCounts
                    binding.syncStatusTitleText.text = getString(
                        R.string.more_sync_status_format,
                        syncState?.lastSyncStatus ?: getString(R.string.more_sync_status_idle),
                    )
                    binding.syncStatusBodyText.text = getString(
                        R.string.more_sync_last_sync_format,
                        syncState?.lastSyncCompletedAt?.let(CallLogFormatter::formatDateTime)
                            ?: getString(R.string.more_sync_never),
                    )
                    binding.syncWorkerTypeText.text = getString(
                        R.string.more_sync_worker_type_format,
                        workDebugState.workerType ?: getString(R.string.more_sync_worker_none),
                    )
                    binding.syncWorkerStateText.text = getString(
                        R.string.more_sync_worker_state_format,
                        workDebugState.workerState ?: getString(R.string.more_sync_worker_idle),
                    )
                    binding.syncRetryText.text = getString(
                        R.string.more_sync_retry_attempt_format,
                        workDebugState.retryAttempt,
                    )
                    binding.syncReasonText.text = getString(
                        R.string.more_sync_reason_format,
                        workDebugState.reason ?: getString(R.string.more_sync_reason_none),
                    )
                    binding.syncErrorText.text = getString(
                        R.string.more_sync_last_error_format,
                        syncState?.lastSyncError ?: getString(R.string.more_sync_error_none),
                    )
                    binding.syncNowButton.isEnabled = !workDebugState.isSyncRunning
                    binding.pendingLeadsCountText.text = pendingSyncCounts.leads.toString()
                    binding.pendingCallLogsCountText.text = pendingSyncCounts.callLogs.toString()
                    binding.pendingPostCallsCountText.text = pendingSyncCounts.postCallActivities.toString()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
