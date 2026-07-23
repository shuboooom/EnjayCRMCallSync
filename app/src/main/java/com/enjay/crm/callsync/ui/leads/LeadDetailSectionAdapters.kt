package com.enjay.crm.callsync.ui.leads

import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.model.DeviceContactMatch
import com.enjay.crm.callsync.databinding.ItemDeviceContactCardBinding
import com.enjay.crm.callsync.databinding.ItemLeadDetailEmptyBinding
import com.enjay.crm.callsync.databinding.ItemLeadDetailHeaderBinding
import com.enjay.crm.callsync.databinding.ItemLeadDetailSectionHeaderBinding

class LeadDetailHeaderAdapter : RecyclerView.Adapter<LeadDetailHeaderAdapter.ViewHolder>() {
    private var lead: LeadEntity? = null

    fun submitLead(value: LeadEntity?) {
        lead = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLeadDetailHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(requireNotNull(lead))
    }

    override fun getItemCount(): Int = if (lead == null) 0 else 1

    class ViewHolder(
        private val binding: ItemLeadDetailHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(lead: LeadEntity) {
            binding.leadIdText.text = lead.id.toString()
            binding.nameText.text = lead.name
            binding.phoneText.text = lead.phone
        }
    }
}

class DeviceContactAdapter : RecyclerView.Adapter<DeviceContactAdapter.ViewHolder>() {
    private var deviceContact: DeviceContactMatch? = null

    fun submitDeviceContact(value: DeviceContactMatch?) {
        deviceContact = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDeviceContactCardBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(requireNotNull(deviceContact))
    }

    override fun getItemCount(): Int = if (deviceContact == null) 0 else 1

    class ViewHolder(
        private val binding: ItemDeviceContactCardBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(deviceContact: DeviceContactMatch) {
            binding.deviceContactNameText.text = deviceContact.displayName
            binding.deviceContactPhoneText.text = deviceContact.phoneNumber
            binding.deviceContactCard.setOnClickListener {
                it.context.startActivity(
                    Intent(Intent.ACTION_VIEW, deviceContact.lookupUri).apply {
                        setDataAndType(deviceContact.lookupUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE)
                    },
                )
            }
        }
    }
}

class LeadDetailSectionHeaderAdapter : RecyclerView.Adapter<LeadDetailSectionHeaderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLeadDetailSectionHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = Unit

    override fun getItemCount(): Int = 1

    class ViewHolder(
        binding: ItemLeadDetailSectionHeaderBinding,
    ) : RecyclerView.ViewHolder(binding.root)
}

class LeadDetailEmptyAdapter : RecyclerView.Adapter<LeadDetailEmptyAdapter.ViewHolder>() {
    private var visible = false

    fun setVisible(value: Boolean) {
        if (visible == value) return
        visible = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLeadDetailEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = Unit

    override fun getItemCount(): Int = if (visible) 1 else 0

    class ViewHolder(
        binding: ItemLeadDetailEmptyBinding,
    ) : RecyclerView.ViewHolder(binding.root)
}
