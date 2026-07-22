package com.enjay.crm.callsync.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object CallLogFormatter {
    private val dateFormatter: DateFormat = DateFormat.getDateTimeInstance(
        DateFormat.MEDIUM,
        DateFormat.SHORT,
        Locale.getDefault(),
    )
    private val timeFormatter = SimpleDateFormat("h:mm a", Locale.getDefault())
    private val headerFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.getDefault())

    fun formatDateTime(timestamp: Long): String = dateFormatter.format(Date(timestamp))
    fun formatTime(timestamp: Long): String = timeFormatter.format(Date(timestamp))
    fun formatHeaderDate(timestamp: Long): String {
        val localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate()
        return headerFormatter.format(localDate)
    }

    fun formatDuration(totalSeconds: Long): String {
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return if (hours > 0) {
            String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        }
    }
}
