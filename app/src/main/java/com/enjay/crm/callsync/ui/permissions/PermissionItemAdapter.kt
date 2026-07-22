package com.enjay.crm.callsync.ui.permissions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.model.PermissionItem
import com.enjay.crm.callsync.databinding.ItemPermissionBinding

class PermissionItemAdapter(
    private val onAllowClicked: (String) -> Unit,
) : ListAdapter<PermissionItem, PermissionItemAdapter.PermissionViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionViewHolder {
        val binding = ItemPermissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PermissionViewHolder(binding, onAllowClicked)
    }

    override fun onBindViewHolder(holder: PermissionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PermissionViewHolder(
        private val binding: ItemPermissionBinding,
        private val onAllowClicked: (String) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PermissionItem) {
            binding.titleText.setText(item.titleRes)
            binding.descriptionText.setText(item.descriptionRes)
            binding.statusChip.text = binding.root.context.getString(
                if (item.granted) R.string.status_allowed else R.string.status_denied,
            )
            binding.allowButton.visibility = if (item.granted) View.GONE else View.VISIBLE
            binding.allowButton.setOnClickListener { onAllowClicked(item.permission) }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PermissionItem>() {
            override fun areItemsTheSame(oldItem: PermissionItem, newItem: PermissionItem): Boolean {
                return oldItem.permission == newItem.permission
            }

            override fun areContentsTheSame(oldItem: PermissionItem, newItem: PermissionItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
