package com.enjay.crm.callsync.data.sync

import java.time.Instant
import java.time.format.DateTimeFormatter

object SyncDateCodec {
    fun toIso(timestamp: Long?): String? = timestamp?.let {
        DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(it))
    }

    fun fromIso(value: String?): Long? = value?.takeIf { it.isNotBlank() }?.let {
        Instant.parse(it).toEpochMilli()
    }
}
