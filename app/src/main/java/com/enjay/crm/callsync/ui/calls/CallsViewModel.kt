package com.enjay.crm.callsync.ui.calls

import android.Manifest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.model.CallLogItem
import com.enjay.crm.callsync.data.repository.CallLogRepository
import com.enjay.crm.callsync.data.repository.LeadRepository
import com.enjay.crm.callsync.data.repository.PermissionStateProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class CallsTab {
    PERSONAL,
    BUSINESS,
}

data class CallsUiState(
    val isLoading: Boolean = false,
    val hasPermission: Boolean = true,
    val selectedTab: CallsTab = CallsTab.PERSONAL,
    val personalCalls: List<CallLogItem> = emptyList(),
    val businessCalls: List<CallLogItem> = emptyList(),
)

class CallsViewModel(
    private val callLogRepository: CallLogRepository,
    private val leadRepository: LeadRepository,
    private val permissionStateProvider: PermissionStateProvider,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CallsUiState(isLoading = true))
    val uiState: StateFlow<CallsUiState> = _uiState.asStateFlow()

    fun loadCalls() {
        val hasPermission = permissionStateProvider.isPermissionGranted(Manifest.permission.READ_CALL_LOG)
        if (!hasPermission) {
            _uiState.value = CallsUiState(hasPermission = false)
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, hasPermission = true)
            val calls = callLogRepository.getRecentCalls()
            val leadMatchByNumber = mutableMapOf<String, Boolean>()
            val personalCalls = ArrayList<CallLogItem>(calls.size)
            val businessCalls = ArrayList<CallLogItem>(calls.size)

            calls.forEach { call ->
                val number = call.phoneNumber?.trim().orEmpty()
                val isBusiness = when {
                    number.isBlank() -> false
                    else -> leadMatchByNumber.getOrPut(number) {
                        leadRepository.findLeadByPhoneNumber(number) != null
                    }
                }

                if (isBusiness) {
                    businessCalls += call
                } else {
                    personalCalls += call
                }
            }

            _uiState.value = CallsUiState(
                isLoading = false,
                hasPermission = true,
                selectedTab = _uiState.value.selectedTab,
                personalCalls = personalCalls,
                businessCalls = businessCalls,
            )
        }
    }

    fun selectTab(tab: CallsTab) {
        if (_uiState.value.selectedTab == tab) return
        _uiState.value = _uiState.value.copy(selectedTab = tab)
    }
}
