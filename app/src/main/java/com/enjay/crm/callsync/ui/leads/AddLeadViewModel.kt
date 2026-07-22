package com.enjay.crm.callsync.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enjay.crm.callsync.data.repository.LeadRepository
import com.enjay.crm.callsync.util.PhoneNumberNormalizer
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed interface AddLeadEvent {
    data object Success : AddLeadEvent
}

data class AddLeadValidationResult(
    val nameErrorRes: Int? = null,
    val phoneErrorRes: Int? = null,
)

class AddLeadViewModel(
    private val leadRepository: LeadRepository,
) : ViewModel() {

    private val eventsChannel = Channel<AddLeadEvent>(capacity = Channel.BUFFERED)
    val events = eventsChannel.receiveAsFlow()

    suspend fun saveLead(name: String, phone: String): AddLeadValidationResult {
        val trimmedName = name.trim()
        val trimmedPhone = phone.trim()

        val nameError = if (trimmedName.isBlank()) com.enjay.crm.callsync.R.string.validation_name_required else null
        val phoneError = when {
            trimmedPhone.isBlank() -> com.enjay.crm.callsync.R.string.validation_phone_required
            !PhoneNumberNormalizer.isViable(trimmedPhone) -> com.enjay.crm.callsync.R.string.validation_phone_invalid
            else -> null
        }

        if (nameError != null || phoneError != null) {
            return AddLeadValidationResult(
                nameErrorRes = nameError,
                phoneErrorRes = phoneError,
            )
        }

        viewModelScope.launch {
            leadRepository.addLead(trimmedName, trimmedPhone)
            eventsChannel.send(AddLeadEvent.Success)
        }
        return AddLeadValidationResult()
    }
}
