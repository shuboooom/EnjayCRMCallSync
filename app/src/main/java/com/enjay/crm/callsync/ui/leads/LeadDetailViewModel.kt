package com.enjay.crm.callsync.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.local.LeadCallLogEntity
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.model.DeviceContactMatch
import com.enjay.crm.callsync.data.repository.ContactsRepository
import com.enjay.crm.callsync.data.repository.LeadCallLogRepository
import com.enjay.crm.callsync.data.repository.LeadRepository
import com.enjay.crm.callsync.data.repository.PostCallActivityRepository
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
    val callLogs: List<LeadCallLogItemUiModel> = emptyList(),
)

class LeadDetailViewModel(
    private val leadId: Long,
    private val leadRepository: LeadRepository,
    private val leadCallLogRepository: LeadCallLogRepository,
    private val postCallActivityRepository: PostCallActivityRepository,
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
                postCallActivityRepository.observePostCallActivitiesByLeadId(leadId),
            ) { lead, callLogs, postCallActivities ->
                Triple(lead, callLogs, postCallActivities)
            }.collectLatest { (lead, callLogs, postCallActivities) ->
                val contact = lead?.let { contactsRepository.findContactByPhoneNumber(it.phone) }
                val postCallByCallLogId = postCallActivities.associateBy { it.leadCallLogId }
                _uiState.value = LeadDetailUiState(
                    isLoading = false,
                    lead = lead,
                    deviceContact = contact,
                    callLogs = callLogs.map { callLog ->
                        LeadCallLogItemUiModel(
                            callLog = callLog,
                            postCallActivity = postCallByCallLogId[callLog.id],
                        )
                    },
                )
            }
        }
    }
}
