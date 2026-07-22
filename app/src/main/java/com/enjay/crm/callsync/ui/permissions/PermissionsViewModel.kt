package com.enjay.crm.callsync.ui.permissions

import android.Manifest
import android.os.Build
import androidx.lifecycle.ViewModel
import com.enjay.crm.callsync.core.AppPermissions
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.data.model.PermissionItem
import com.enjay.crm.callsync.data.repository.PermissionStateProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PermissionsViewModel(
    private val permissionStateProvider: PermissionStateProvider,
) : ViewModel() {

    private val _permissions = MutableStateFlow(emptyList<PermissionItem>())
    val permissions: StateFlow<List<PermissionItem>> = _permissions.asStateFlow()

    val requiredPermissions = AppPermissions.requiredPermissions()

    fun refreshPermissions() {
        _permissions.value = listOf(
            PermissionItem(
                permission = Manifest.permission.READ_CALL_LOG,
                titleRes = R.string.permission_call_log_title,
                descriptionRes = R.string.permission_call_log_description,
                granted = permissionStateProvider.isPermissionGranted(Manifest.permission.READ_CALL_LOG),
            ),
            PermissionItem(
                permission = Manifest.permission.READ_CONTACTS,
                titleRes = R.string.permission_contacts_title,
                descriptionRes = R.string.permission_contacts_description,
                granted = permissionStateProvider.isPermissionGranted(Manifest.permission.READ_CONTACTS),
            ),
            PermissionItem(
                permission = Manifest.permission.READ_PHONE_STATE,
                titleRes = R.string.permission_phone_state_title,
                descriptionRes = R.string.permission_phone_state_description,
                granted = permissionStateProvider.isPermissionGranted(Manifest.permission.READ_PHONE_STATE),
            ),
            PermissionItem(
                permission = Manifest.permission.CALL_PHONE,
                titleRes = R.string.permission_call_phone_title,
                descriptionRes = R.string.permission_call_phone_description,
                granted = permissionStateProvider.isPermissionGranted(Manifest.permission.CALL_PHONE),
            ),
            PermissionItem(
                permission = Manifest.permission.POST_NOTIFICATIONS,
                titleRes = R.string.permission_notifications_title,
                descriptionRes = R.string.permission_notifications_description,
                granted = Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
                    permissionStateProvider.isPermissionGranted(Manifest.permission.POST_NOTIFICATIONS),
            ),
        ).filterNot { it.granted }
    }

    fun markRequested(permission: String) {
        permissionStateProvider.markPermissionRequested(permission)
    }

    fun areAllGranted(): Boolean = requiredPermissions.all(permissionStateProvider::isPermissionGranted)
}
