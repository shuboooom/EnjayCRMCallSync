package com.enjay.crm.callsync.ui.postcall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.local.LeadEntity
import com.enjay.crm.callsync.data.local.PostCallActivityEntity
import com.enjay.crm.callsync.data.repository.LeadRepository
import com.enjay.crm.callsync.data.repository.PostCallActivityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

data class PostCallDetailUiState(
    val isLoading: Boolean = true,
    val postCallActivity: PostCallActivityEntity? = null,
    val lead: LeadEntity? = null,
)

class PostCallDetailViewModel(
    private val postCallActivityId: Long,
    private val postCallActivityRepository: PostCallActivityRepository,
    private val leadRepository: LeadRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PostCallDetailUiState())
    val uiState: StateFlow<PostCallDetailUiState> = _uiState.asStateFlow()
    private var hasStarted = false

    fun load() {
        if (hasStarted) return
        hasStarted = true
        viewModelScope.launch {
            postCallActivityRepository.observePostCallActivityById(postCallActivityId)
                .collectLatest { activity ->
                    if (activity == null) {
                        _uiState.value = PostCallDetailUiState(isLoading = false)
                    } else {
                        leadRepository.observeLeadById(activity.leadId)
                            .collectLatest { lead ->
                                _uiState.value = PostCallDetailUiState(
                                    isLoading = false,
                                    postCallActivity = activity,
                                    lead = lead,
                                )
                            }
                    }
                }
        }
    }
}
