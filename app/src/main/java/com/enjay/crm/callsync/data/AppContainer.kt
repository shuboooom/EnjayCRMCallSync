package com.enjay.crm.callsync.data

import android.content.Context
import androidx.room.Room
import com.enjay.crm.callsync.data.local.AppDatabase
import com.enjay.crm.callsync.data.repository.AndroidPermissionStateProvider
import com.enjay.crm.callsync.data.repository.CallLogRepository
import com.enjay.crm.callsync.data.repository.ContactsRepository
import com.enjay.crm.callsync.data.repository.DeviceCallLogRepository
import com.enjay.crm.callsync.data.repository.DeviceContactsRepository
import com.enjay.crm.callsync.data.repository.LeadCallLogRepository
import com.enjay.crm.callsync.data.repository.LeadRepository
import com.enjay.crm.callsync.data.repository.PermissionStateProvider
import com.enjay.crm.callsync.data.repository.RoomLeadCallLogRepository
import com.enjay.crm.callsync.data.repository.RoomLeadRepository

class AppContainer(context: Context) {
    private val appContext = context.applicationContext

    private val database: AppDatabase by lazy {
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "enjay-call-sync.db",
        ).addMigrations(AppDatabase.MIGRATION_1_2).build()
    }

    val leadRepository: LeadRepository by lazy {
        RoomLeadRepository(database.leadDao())
    }

    val leadCallLogRepository: LeadCallLogRepository by lazy {
        RoomLeadCallLogRepository(database.leadCallLogDao())
    }

    val callLogRepository: CallLogRepository by lazy {
        DeviceCallLogRepository(appContext)
    }

    val contactsRepository: ContactsRepository by lazy {
        DeviceContactsRepository(appContext)
    }

    val permissionStateProvider: PermissionStateProvider by lazy {
        AndroidPermissionStateProvider(appContext)
    }
}
