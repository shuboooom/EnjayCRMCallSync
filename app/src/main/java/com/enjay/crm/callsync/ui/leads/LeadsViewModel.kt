package com.enjay.crm.callsync.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.repository.LeadRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class LeadsUiState(
    val leads: List<LeadEntity> = emptyList(),
)

class LeadsViewModel(
    leadRepository: LeadRepository,
) : ViewModel() {

    val uiState: StateFlow<LeadsUiState> = leadRepository.observeLeads()
        .map { LeadsUiState(leads = it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = LeadsUiState(),
        )
}
