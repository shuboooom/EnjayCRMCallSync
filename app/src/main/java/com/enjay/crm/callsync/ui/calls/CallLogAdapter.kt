package com.enjay.crm.callsync.ui.calls

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.model.CallLogItem
import com.enjay.crm.callsync.data.model.CallType
import com.enjay.crm.callsync.databinding.ItemCallLogBinding
import com.enjay.crm.callsync.databinding.ItemCallLogHeaderBinding
import com.enjay.crm.callsync.util.AvatarGenerator
import com.enjay.crm.callsync.util.CallLogFormatter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class CallLogAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<CallLogListItem> = emptyList()
    private var onCallActionClicked: ((CallLogItem, android.view.View) -> Unit)? = null
    private var onItemClicked: ((CallLogItem, android.view.View) -> Unit)? = null
    private var actionMode: CallActionMode = CallActionMode.MENU

    fun submitCalls(calls: List<CallLogItem>) {
        items = buildListItems(calls)
        notifyDataSetChanged()
    }

    fun setOnCallActionClicked(listener: (CallLogItem, android.view.View) -> Unit) {
        onCallActionClicked = listener
    }

    fun setOnItemClicked(listener: (CallLogItem, android.view.View) -> Unit) {
        onItemClicked = listener
    }

    fun setActionMode(mode: CallActionMode) {
        actionMode = mode
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is CallLogListItem.Header -> VIEW_TYPE_HEADER
        is CallLogListItem.Entry -> VIEW_TYPE_ENTRY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemCallLogHeaderBinding.inflate(inflater, parent, false))
            else -> EntryViewHolder(ItemCallLogBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is CallLogListItem.Header -> (holder as HeaderViewHolder).bind(item)
            is CallLogListItem.Entry -> (holder as EntryViewHolder).bind(item.call, actionMode, onCallActionClicked, onItemClicked)
        }
    }

    private fun buildListItems(calls: List<CallLogItem>): List<CallLogListItem> {
        if (calls.isEmpty()) return emptyList()
        val zoneId = ZoneId.systemDefault()
        val grouped = calls.groupBy { item ->
            Instant.ofEpochMilli(item.timestamp).atZone(zoneId).toLocalDate()
        }

        return buildList {
            grouped.toSortedMap(compareByDescending { it }).forEach { (date, dayCalls) ->
                add(CallLogListItem.Header(headerTitle(date)))
                dayCalls.forEach { add(CallLogListItem.Entry(it)) }
            }
        }
    }

    private fun headerTitle(date: LocalDate): String {
        val today = LocalDate.now()
        val yesterday = today.minusDays(1)
        return when (date) {
            today -> contextStringProvider(R.string.label_today)
            yesterday -> contextStringProvider(R.string.label_yesterday)
            else -> headerDateFormatter.format(date)
        }
    }

    private class HeaderViewHolder(
        private val binding: ItemCallLogHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CallLogListItem.Header) {
            binding.headerText.text = item.title
        }
    }

    private class EntryViewHolder(
        private val binding: ItemCallLogBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CallLogItem,
            actionMode: CallActionMode,
            onCallActionClicked: ((CallLogItem, android.view.View) -> Unit)?,
            onItemClicked: ((CallLogItem, android.view.View) -> Unit)?,
        ) {
            val context = binding.root.context
            val displayName = item.name?.takeIf { it.isNotBlank() }
                ?: item.phoneNumber?.takeIf { it.isNotBlank() }
                ?: context.getString(R.string.unknown_number)
            val avatar = AvatarGenerator.create(displayName)
            binding.avatarText.text = avatar.label
            binding.avatarText.setTextColor(ContextCompat.getColor(context, avatar.foregroundColorRes))
            binding.avatarContainer.setCardBackgroundColor(ContextCompat.getColor(context, avatar.backgroundColorRes))
            binding.nameText.text = displayName
            binding.typeText.text = item.callType.displayLabel(context)
            binding.typeText.setTextColor(ContextCompat.getColor(context, item.callType.badgeForeground()))
            binding.typeIcon.setImageResource(item.callType.directionIcon())
            binding.typeIcon.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, item.callType.badgeForeground()))
            binding.timeText.text = CallLogFormatter.formatTime(item.timestamp)
            binding.durationText.text = CallLogFormatter.formatDuration(item.durationSeconds)
            binding.durationIcon.visibility = if (item.durationSeconds > 0) android.view.View.VISIBLE else android.view.View.GONE
            binding.durationText.visibility = if (item.durationSeconds > 0) android.view.View.VISIBLE else android.view.View.GONE
            binding.callActionIcon.setImageResource(actionMode.iconRes)
            val touchTarget = binding.root.getChildAt(0)
            touchTarget.setOnClickListener { anchor ->
                onItemClicked?.invoke(item, anchor)
            }
            binding.callActionIcon.setOnClickListener { anchor ->
                onCallActionClicked?.invoke(item, anchor)
            }
        }
    }

    sealed interface CallLogListItem {
        data class Header(val title: String) : CallLogListItem
        data class Entry(val call: CallLogItem) : CallLogListItem
    }

    enum class CallActionMode(val iconRes: Int) {
        MENU(R.drawable.more_vert_24dp),
        DIRECT_CALL(R.drawable.ic_call_24),
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ENTRY = 1
        private val headerDateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.getDefault())

        private lateinit var contextStringProvider: (Int) -> String

        fun attachStringProvider(provider: (Int) -> String) {
            contextStringProvider = provider
        }
    }
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

private fun CallType.displayLabel(context: android.content.Context): String = when (this) {
    CallType.INCOMING -> context.getString(R.string.call_type_incoming)
    CallType.OUTGOING -> context.getString(R.string.call_type_outgoing)
    CallType.MISSED -> context.getString(R.string.call_type_missed)
    CallType.REJECTED -> context.getString(R.string.call_type_rejected)
    CallType.OTHER -> context.getString(R.string.call_type_other)
}
