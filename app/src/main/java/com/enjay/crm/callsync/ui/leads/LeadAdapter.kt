package com.enjay.crm.callsync.ui.leads

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.databinding.ItemLeadBinding
import com.enjay.crm.callsync.util.AvatarGenerator

class LeadAdapter(
    private val onLeadClicked: (LeadEntity) -> Unit,
) : ListAdapter<LeadEntity, LeadAdapter.LeadViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadViewHolder {
        val binding = ItemLeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeadViewHolder(binding, onLeadClicked)
    }

    override fun onBindViewHolder(holder: LeadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LeadViewHolder(
        private val binding: ItemLeadBinding,
        private val onLeadClicked: (LeadEntity) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LeadEntity) {
            val context = binding.root.context
            val avatar = AvatarGenerator.create(item.name.ifBlank { item.phone })
            binding.avatarText.text = avatar.label
            binding.avatarText.setTextColor(ContextCompat.getColor(context, avatar.foregroundColorRes))
            binding.avatarContainer.setCardBackgroundColor(ContextCompat.getColor(context, avatar.backgroundColorRes))
            binding.nameText.text = item.name
            binding.phoneText.text = item.phone
            binding.root.setOnClickListener { onLeadClicked(item) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<LeadEntity>() {
            override fun areItemsTheSame(oldItem: LeadEntity, newItem: LeadEntity): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: LeadEntity, newItem: LeadEntity): Boolean = oldItem == newItem
        }
    }
}
