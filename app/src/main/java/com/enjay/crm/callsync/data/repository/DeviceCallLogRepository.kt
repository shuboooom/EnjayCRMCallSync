package com.enjay.crm.callsync.data.repository

import android.content.Context
import android.provider.CallLog
import com.enjay.crm.callsync.data.model.CallLogItem
import com.enjay.crm.callsync.data.model.CallType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeviceCallLogRepository(
    context: Context,
) : CallLogRepository {

    private val appContext = context.applicationContext

    override suspend fun getRecentCalls(limit: Int): List<CallLogItem> = withContext(Dispatchers.IO) {
        val resolver = appContext.contentResolver
        val projection = arrayOf(
            CallLog.Calls._ID,
            CallLog.Calls.CACHED_NAME,
            CallLog.Calls.NUMBER,
            CallLog.Calls.TYPE,
            CallLog.Calls.DATE,
            CallLog.Calls.DURATION,
        )

        resolver.query(
            CallLog.Calls.CONTENT_URI,
            projection,
            null,
            null,
            "${CallLog.Calls.DATE} DESC",
        )?.use { cursor ->
            val idIndex = cursor.getColumnIndexOrThrow(CallLog.Calls._ID)
            val nameIndex = cursor.getColumnIndexOrThrow(CallLog.Calls.CACHED_NAME)
            val numberIndex = cursor.getColumnIndexOrThrow(CallLog.Calls.NUMBER)
            val typeIndex = cursor.getColumnIndexOrThrow(CallLog.Calls.TYPE)
            val dateIndex = cursor.getColumnIndexOrThrow(CallLog.Calls.DATE)
            val durationIndex = cursor.getColumnIndexOrThrow(CallLog.Calls.DURATION)

            buildList {
                while (cursor.moveToNext() && size < limit) {
                    add(
                        CallLogItem(
                            id = cursor.getLong(idIndex),
                            name = cursor.getString(nameIndex),
                            phoneNumber = cursor.getString(numberIndex),
                            callType = cursor.getInt(typeIndex).toCallType(),
                            timestamp = cursor.getLong(dateIndex),
                            durationSeconds = cursor.getLong(durationIndex),
                        ),
                    )
                }
            }
        } ?: emptyList()
    }

    override suspend fun getMostRecentCall(): CallLogItem? = getRecentCalls(limit = 1).firstOrNull()

    private fun Int.toCallType(): CallType = when (this) {
        CallLog.Calls.INCOMING_TYPE -> CallType.INCOMING
        CallLog.Calls.OUTGOING_TYPE -> CallType.OUTGOING
        CallLog.Calls.MISSED_TYPE -> CallType.MISSED
        CallLog.Calls.REJECTED_TYPE -> CallType.REJECTED
        else -> CallType.OTHER
    }
}
