package com.enjay.crm.callsync.ui.postcall

import android.app.NotificationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.local.PostCallActivityEntity
import com.enjay.crm.callsync.data.local.SyncState
import com.enjay.crm.callsync.data.model.CallType
import com.enjay.crm.callsync.sync.SyncWorkScheduler
import com.enjay.crm.callsync.databinding.ActivityPostCallActivityFormBinding
import com.enjay.crm.callsync.util.CallLogFormatter
import com.enjay.crm.callsync.util.applyInsetPadding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class PostCallActivityFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostCallActivityFormBinding

    private val appContainer by lazy { (application as EnjayCallSyncApp).appContainer }

    private val leadId: Long by lazy { intent.getLongExtra(EXTRA_LEAD_ID, -1L) }
    private val leadCallLogId: Long by lazy { intent.getLongExtra(EXTRA_LEAD_CALL_LOG_ID, -1L) }
    private val leadName: String by lazy { intent.getStringExtra(EXTRA_LEAD_NAME).orEmpty() }
    private val phoneNumber: String by lazy { intent.getStringExtra(EXTRA_PHONE_NUMBER).orEmpty() }
    private val callType: String by lazy { intent.getStringExtra(EXTRA_CALL_TYPE).orEmpty() }
    private val callTimestamp: Long by lazy { intent.getLongExtra(EXTRA_CALL_TIMESTAMP, 0L) }
    private val callDurationSeconds: Long by lazy { intent.getLongExtra(EXTRA_CALL_DURATION_SECONDS, 0L) }
    private val notificationId: Int by lazy { intent.getIntExtra(EXTRA_NOTIFICATION_ID, -1) }

    private var selectedFollowUpAt: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostCallActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding.root.applyInsetPadding(top = true, bottom = true)
        dismissLaunchNotification()

        if (leadId <= 0L || leadCallLogId <= 0L) {
            finish()
            return
        }

        setupHeader()
        setupForm()
    }

    private fun dismissLaunchNotification() {
        if (notificationId == -1) return
        val manager = getSystemService(NotificationManager::class.java)
        manager?.cancel(notificationId)
    }

    private fun setupHeader() {
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.leadNameText.text = leadName.ifBlank { getString(R.string.unknown_name) }
        binding.leadPhoneText.text = phoneNumber.ifBlank { getString(R.string.unknown_number) }
        binding.callMetaText.text = getString(
            R.string.post_call_meta_format,
            displayCallType(callType),
            CallLogFormatter.formatTime(callTimestamp),
            CallLogFormatter.formatDuration(callDurationSeconds),
        )
    }

    private fun setupForm() {
        binding.followUpEditText.apply {
            isFocusable = false
            isClickable = true
            setOnClickListener { openDatePicker() }
        }
        binding.followUpInputLayout.setEndIconOnClickListener { openDatePicker() }
        binding.closeButton.setOnClickListener { finish() }
        binding.saveButton.setOnClickListener { savePostCallActivity() }
    }

    private fun openDatePicker() {
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(R.string.title_follow_up_date)
            .setSelection(selectedFollowUpAt ?: System.currentTimeMillis())
            .build()
        picker.addOnPositiveButtonClickListener { selectedDateUtc ->
            openTimePicker(selectedDateUtc)
        }
        picker.show(supportFragmentManager, "followUpDatePicker")
    }

    private fun openTimePicker(selectedDateUtc: Long) {
        val localDateTime = Instant.ofEpochMilli(selectedDateUtc)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
            .atTime(10, 0)
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(localDateTime.hour)
            .setMinute(localDateTime.minute)
            .setTitleText(R.string.title_follow_up_time)
            .build()
        picker.addOnPositiveButtonClickListener {
            val followUpDateTime = localDateTime
                .withHour(picker.hour)
                .withMinute(picker.minute)
            selectedFollowUpAt = followUpDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()
            binding.followUpEditText.setText(CallLogFormatter.formatDateTime(selectedFollowUpAt!!))
            binding.followUpInputLayout.error = null
        }
        picker.show(supportFragmentManager, "followUpTimePicker")
    }

    private fun savePostCallActivity() {
        val callNotes = binding.callNotesEditText.text?.toString().orEmpty().trim()
        val callOutcome = binding.callOutcomeEditText.text?.toString().orEmpty().trim()
        val nextAction = binding.nextActionEditText.text?.toString().orEmpty().trim()
        val additionalRemarks = binding.additionalRemarksEditText.text?.toString().orEmpty().trim()
        val followUpAt = selectedFollowUpAt

        binding.callNotesInputLayout.error = if (callNotes.isBlank()) getString(R.string.validation_call_notes_required) else null
        binding.callOutcomeInputLayout.error = if (callOutcome.isBlank()) getString(R.string.validation_call_outcome_required) else null
        binding.followUpInputLayout.error = if (followUpAt == null) getString(R.string.validation_follow_up_required) else null
        binding.nextActionInputLayout.error = if (nextAction.isBlank()) getString(R.string.validation_next_action_required) else null

        if (callNotes.isBlank() || callOutcome.isBlank() || followUpAt == null || nextAction.isBlank()) {
            return
        }

        binding.saveButton.isEnabled = false
        binding.closeButton.isEnabled = false

        lifecycleScope.launch {
            val now = System.currentTimeMillis()
            val result = appContainer.postCallActivityRepository.addPostCallActivity(
                PostCallActivityEntity(
                    externalId = "",
                    serverId = null,
                    syncState = SyncState.PENDING_CREATE,
                    lastSyncAttemptAt = null,
                    lastSyncedAt = null,
                    syncError = null,
                    deletedAt = null,
                    leadId = leadId,
                    leadCallLogId = leadCallLogId,
                    callNotes = callNotes,
                    callOutcome = callOutcome,
                    followUpAt = followUpAt,
                    nextAction = nextAction,
                    additionalRemarks = additionalRemarks.ifBlank { null },
                    createdAt = now,
                    updatedAt = now,
                ),
            )
            if (result > 0L) {
                appContainer.postCallActivityRepository.assignExternalIdIfMissing(result)
                SyncWorkScheduler.enqueueImmediateSync(this@PostCallActivityFormActivity, "post_call_saved")
                Toast.makeText(
                    this@PostCallActivityFormActivity,
                    R.string.post_call_activity_saved,
                    Toast.LENGTH_SHORT,
                ).show()
                finish()
            } else {
                binding.saveButton.isEnabled = true
                binding.closeButton.isEnabled = true
                Toast.makeText(
                    this@PostCallActivityFormActivity,
                    R.string.post_call_activity_save_failed,
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    }

    private fun displayCallType(rawValue: String): String {
        return when (rawValue) {
            CallType.INCOMING.name -> getString(R.string.call_type_incoming)
            CallType.OUTGOING.name -> getString(R.string.call_type_outgoing)
            CallType.MISSED.name -> getString(R.string.call_type_missed)
            CallType.REJECTED.name -> getString(R.string.call_type_rejected)
            else -> getString(R.string.call_type_other)
        }
    }

    companion object {
        const val EXTRA_LEAD_ID = "leadId"
        const val EXTRA_LEAD_CALL_LOG_ID = "leadCallLogId"
        const val EXTRA_LEAD_NAME = "leadName"
        const val EXTRA_PHONE_NUMBER = "phoneNumber"
        const val EXTRA_CALL_TYPE = "callType"
        const val EXTRA_CALL_TIMESTAMP = "callTimestamp"
        const val EXTRA_CALL_DURATION_SECONDS = "callDurationSeconds"
        const val EXTRA_NOTIFICATION_ID = "notificationId"
    }
}
