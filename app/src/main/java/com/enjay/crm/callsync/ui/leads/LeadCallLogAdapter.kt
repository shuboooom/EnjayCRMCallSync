package com.enjay.crm.callsync.ui.leads

import android.content.res.ColorStateList
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.model.CallType
import com.enjay.crm.callsync.databinding.ItemCallLogBinding
import com.enjay.crm.callsync.util.AvatarGenerator
import com.enjay.crm.callsync.util.CallLogFormatter

class LeadCallLogAdapter :
    ListAdapter<LeadCallLogEntity, LeadCallLogAdapter.LeadCallLogViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadCallLogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LeadCallLogViewHolder(ItemCallLogBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: LeadCallLogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LeadCallLogViewHolder(
        private val binding: ItemCallLogBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LeadCallLogEntity) {
            val context = binding.root.context
            val displayName = item.phoneNumber
            val avatar = AvatarGenerator.create(displayName)

            binding.avatarText.text = avatar.label
            binding.avatarText.setTextColor(ContextCompat.getColor(context, avatar.foregroundColorRes))
            binding.avatarContainer.setCardBackgroundColor(ContextCompat.getColor(context, avatar.backgroundColorRes))
            binding.nameText.text = displayName

            val typeColor = ContextCompat.getColor(context, item.callType.badgeForeground())
            binding.typeText.text = item.callType.label(context)
            binding.typeText.setTextColor(typeColor)
            binding.typeIcon.setImageResource(item.callType.directionIcon())
            binding.typeIcon.imageTintList = ColorStateList.valueOf(typeColor)

            binding.timeText.text = CallLogFormatter.formatTime(item.startTime)
            binding.durationText.text = CallLogFormatter.formatDuration(item.durationSeconds)
            val hasDuration = item.durationSeconds > 0
            binding.durationIcon.visibility = if (hasDuration) View.VISIBLE else View.GONE
            binding.durationText.visibility = if (hasDuration) View.VISIBLE else View.GONE
            binding.callActionIcon.visibility = View.GONE
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<LeadCallLogEntity>() {
            override fun areItemsTheSame(oldItem: LeadCallLogEntity, newItem: LeadCallLogEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: LeadCallLogEntity, newItem: LeadCallLogEntity): Boolean {
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
