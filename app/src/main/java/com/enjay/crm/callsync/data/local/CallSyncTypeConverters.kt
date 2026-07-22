package com.enjay.crm.callsync.data.local

import androidx.room.TypeConverter
import com.enjay.crm.callsync.data.model.CallType

class CallSyncTypeConverters {
    @TypeConverter
    fun callTypeToString(value: CallType): String = value.name

    @TypeConverter
    fun stringToCallType(value: String): CallType = CallType.valueOf(value)
}
