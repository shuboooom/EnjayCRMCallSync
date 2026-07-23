package com.enjay.crm.callsync.data

import android.content.Context
import android.provider.Settings
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
import com.enjay.crm.callsync.data.repository.PostCallActivityRepository
import com.enjay.crm.callsync.data.repository.RoomLeadCallLogRepository
import com.enjay.crm.callsync.data.repository.RoomPostCallActivityRepository
import com.enjay.crm.callsync.data.repository.RoomLeadRepository
import com.enjay.crm.callsync.data.repository.RoomSyncMetadataRepository
import com.enjay.crm.callsync.data.repository.SyncMetadataRepository
import com.enjay.crm.callsync.data.sync.DefaultSyncRepository
import com.enjay.crm.callsync.data.sync.SyncApi
import com.enjay.crm.callsync.data.sync.SyncCoordinator
import com.enjay.crm.callsync.data.sync.SyncRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {
    private val appContext = context.applicationContext

    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "enjay-call-sync.db",
        ).addMigrations(
            AppDatabase.MIGRATION_1_2,
            AppDatabase.MIGRATION_2_3,
            AppDatabase.MIGRATION_3_4,
        ).build()
    }

    val leadRepository: LeadRepository by lazy {
        RoomLeadRepository(database.leadDao())
    }

    val leadCallLogRepository: LeadCallLogRepository by lazy {
        RoomLeadCallLogRepository(database.leadCallLogDao())
    }

    val postCallActivityRepository: PostCallActivityRepository by lazy {
        RoomPostCallActivityRepository(database.postCallActivityDao())
    }

    val syncMetadataRepository: SyncMetadataRepository by lazy {
        RoomSyncMetadataRepository(database.syncMetadataDao())
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

    private val syncApi: SyncApi by lazy {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl("https://enjaydummycrm.web.app/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SyncApi::class.java)
    }

    val syncRepository: SyncRepository by lazy {
        DefaultSyncRepository(
            database = database,
            syncApi = syncApi,
            syncMetadataRepository = syncMetadataRepository,
            deviceIdProvider = {
                Settings.Secure.getString(appContext.contentResolver, Settings.Secure.ANDROID_ID)
                    ?: "android-${System.currentTimeMillis()}"
            },
        )
    }

    val syncCoordinator: SyncCoordinator by lazy {
        SyncCoordinator(syncRepository)
    }
}
