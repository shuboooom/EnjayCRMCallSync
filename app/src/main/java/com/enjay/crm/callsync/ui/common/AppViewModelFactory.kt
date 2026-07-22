package com.enjay.crm.callsync.ui.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.ui.calls.CallsViewModel
import com.enjay.crm.callsync.ui.leads.AddLeadViewModel
import com.enjay.crm.callsync.ui.leads.LeadDetailViewModel
import com.enjay.crm.callsync.ui.leads.LeadsViewModel
import com.enjay.crm.callsync.ui.permissions.PermissionsViewModel

class AppViewModelFactory(
    private val application: Application,
    private val leadId: Long? = null,
) : ViewModelProvider.Factory {

    private val container = (application as EnjayCallSyncApp).appContainer

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PermissionsViewModel::class.java) -> {
                PermissionsViewModel(container.permissionStateProvider) as T
            }

            modelClass.isAssignableFrom(CallsViewModel::class.java) -> {
                CallsViewModel(
                    container.callLogRepository,
                    container.leadRepository,
                    container.permissionStateProvider,
                ) as T
            }

            modelClass.isAssignableFrom(LeadsViewModel::class.java) -> {
                LeadsViewModel(container.leadRepository) as T
            }

            modelClass.isAssignableFrom(AddLeadViewModel::class.java) -> {
                AddLeadViewModel(container.leadRepository) as T
            }

            modelClass.isAssignableFrom(LeadDetailViewModel::class.java) -> {
                LeadDetailViewModel(
                    leadId = requireNotNull(leadId),
                    leadRepository = container.leadRepository,
                    leadCallLogRepository = container.leadCallLogRepository,
                    contactsRepository = container.contactsRepository,
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
