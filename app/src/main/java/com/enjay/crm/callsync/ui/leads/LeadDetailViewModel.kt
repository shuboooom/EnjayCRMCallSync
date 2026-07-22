package com.enjay.crm.callsync.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.model.DeviceContactMatch
import com.enjay.crm.callsync.data.repository.ContactsRepository
import com.enjay.crm.callsync.data.repository.LeadCallLogRepository
import com.enjay.crm.callsync.data.repository.LeadRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

data class LeadDetailUiState(
    val isLoading: Boolean = true,
    val lead: LeadEntity? = null,
    val deviceContact: DeviceContactMatch? = null,
    val callLogs: List<LeadCallLogEntity> = emptyList(),
)

class LeadDetailViewModel(
    private val leadId: Long,
    private val leadRepository: LeadRepository,
    private val leadCallLogRepository: LeadCallLogRepository,
    private val contactsRepository: ContactsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LeadDetailUiState())
    val uiState: StateFlow<LeadDetailUiState> = _uiState.asStateFlow()
    private var hasStarted = false

    fun loadLead() {
        if (hasStarted) return
        hasStarted = true
        viewModelScope.launch {
            combine(
                leadRepository.observeLeadById(leadId),
                leadCallLogRepository.observeLeadCallLogs(leadId),
            ) { lead, callLogs ->
                lead to callLogs
            }.collectLatest { (lead, callLogs) ->
                val contact = lead?.let { contactsRepository.findContactByPhoneNumber(it.phone) }
                _uiState.value = LeadDetailUiState(
                    isLoading = false,
                    lead = lead,
                    deviceContact = contact,
                    callLogs = callLogs,
                )
            }
        }
    }
}
