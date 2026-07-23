package com.enjay.crm.callsync.ui.leads

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.model.CallType
import com.enjay.crm.callsync.databinding.ItemLeadCallLogBinding
import com.enjay.crm.callsync.util.AvatarGenerator
import com.enjay.crm.callsync.util.CallLogFormatter

class LeadCallLogAdapter(
    private val onPostCallClicked: (Long) -> Unit,
    private val onAddPostCallClicked: (LeadCallLogItemUiModel) -> Unit,
) : ListAdapter<LeadCallLogItemUiModel, LeadCallLogAdapter.LeadCallLogViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadCallLogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LeadCallLogViewHolder(
            ItemLeadCallLogBinding.inflate(inflater, parent, false),
            onPostCallClicked,
            onAddPostCallClicked,
        )
    }

    override fun onBindViewHolder(holder: LeadCallLogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LeadCallLogViewHolder(
        private val binding: ItemLeadCallLogBinding,
        private val onPostCallClicked: (Long) -> Unit,
        private val onAddPostCallClicked: (LeadCallLogItemUiModel) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LeadCallLogItemUiModel) {
            val context = binding.root.context
            val callLog = item.callLog
            val displayName = callLog.phoneNumber
            val avatar = AvatarGenerator.create(displayName)
            val callBinding = binding.callLogCard
            val innerCard = callBinding.root as MaterialCardView

            (innerCard.layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin = 0
            innerCard.setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            innerCard.cardElevation = 0f
            innerCard.strokeWidth = 0
            callBinding.avatarText.text = avatar.label
            callBinding.avatarText.setTextColor(ContextCompat.getColor(context, avatar.foregroundColorRes))
            callBinding.avatarContainer.setCardBackgroundColor(ContextCompat.getColor(context, avatar.backgroundColorRes))
            callBinding.nameText.text = displayName

            val typeColor = ContextCompat.getColor(context, callLog.callType.badgeForeground())
            callBinding.typeText.text = callLog.callType.label(context)
            callBinding.typeText.setTextColor(typeColor)
            callBinding.typeIcon.setImageResource(callLog.callType.directionIcon())
            callBinding.typeIcon.imageTintList = ColorStateList.valueOf(typeColor)

            callBinding.timeText.text = CallLogFormatter.formatTime(callLog.startTime)
            callBinding.durationText.text = CallLogFormatter.formatDuration(callLog.durationSeconds)
            val hasDuration = callLog.durationSeconds > 0
            callBinding.durationIcon.visibility = if (hasDuration) View.VISIBLE else View.GONE
            callBinding.durationText.visibility = if (hasDuration) View.VISIBLE else View.GONE
            callBinding.callActionIcon.visibility = View.VISIBLE

            val postCallActivity = item.postCallActivity
            binding.postCallSummaryCard.visibility = if (postCallActivity != null) View.VISIBLE else View.GONE
            if (postCallActivity != null) {
                callBinding.callActionIcon.setImageResource(R.drawable.ic_call_24)
                callBinding.callActionIcon.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(context, R.color.badge_outgoing_fg),
                )
                callBinding.callActionIcon.alpha = 0f
                callBinding.callActionIcon.isClickable = false
                callBinding.callActionIcon.isFocusable = false
                callBinding.callActionIcon.setOnClickListener(null)
                binding.viewPostCallText.setOnClickListener {
                    onPostCallClicked(postCallActivity.id)
                }
                binding.postCallSummaryCard.setOnClickListener {
                    onPostCallClicked(postCallActivity.id)
                }
            } else {
                callBinding.callActionIcon.alpha = 1f
                callBinding.callActionIcon.isClickable = true
                callBinding.callActionIcon.isFocusable = true
                callBinding.callActionIcon.setImageResource(R.drawable.ic_add_24)
                callBinding.callActionIcon.imageTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(context, R.color.badge_outgoing_fg),
                )
                callBinding.callActionIcon.setOnClickListener {
                    onAddPostCallClicked(item)
                }
                binding.viewPostCallText.setOnClickListener(null)
                binding.postCallSummaryCard.setOnClickListener(null)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<LeadCallLogItemUiModel>() {
            override fun areItemsTheSame(oldItem: LeadCallLogItemUiModel, newItem: LeadCallLogItemUiModel): Boolean {
                return oldItem.callLog.id == newItem.callLog.id
            }

            override fun areContentsTheSame(oldItem: LeadCallLogItemUiModel, newItem: LeadCallLogItemUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}

private fun CallType.label(context: android.content.Context): String = when (this) {
    CallType.INCOMING -> context.getString(R.string.call_type_incoming)
    CallType.OUTGOING -> context.getString(R.string.call_type_outgoing)
    CallType.MISSED -> context.getString(R.string.call_type_missed)
    CallType.REJECTED -> context.getString(R.string.call_type_rejected)
    CallType.OTHER -> context.getString(R.string.call_type_other)
}

private fun CallType.badgeForeground(): Int = when (this) {
    CallType.INCOMING -> R.color.badge_incoming_fg
    CallType.OUTGOING -> R.color.badge_outgoing_fg
    CallType.MISSED -> R.color.badge_missed_fg
    CallType.REJECTED -> R.color.badge_missed_fg
    CallType.OTHER -> R.color.badge_other_fg
}

private fun CallType.directionIcon(): Int = when (this) {
    CallType.INCOMING -> R.drawable.call_received_24dp
    CallType.OUTGOING -> R.drawable.call_made_24dp
    CallType.MISSED -> R.drawable.call_missed_24dp
    CallType.REJECTED -> R.drawable.phone_cancel_24dp
    CallType.OTHER -> R.drawable.ic_call_24
}
