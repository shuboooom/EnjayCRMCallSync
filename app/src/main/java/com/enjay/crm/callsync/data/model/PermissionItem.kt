package com.enjay.crm.callsync.data.model

data class PermissionItem(
    val permission: String,
    val titleRes: Int,
    val descriptionRes: Int,
    val granted: Boolean,
)
