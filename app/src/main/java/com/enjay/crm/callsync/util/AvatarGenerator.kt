package com.enjay.crm.callsync.util

import com.enjay.crm.callsync.R

data class AvatarStyle(
    val label: String,
    val backgroundColorRes: Int,
    val foregroundColorRes: Int,
)

object AvatarGenerator {
    private val palette = listOf(
        R.color.badge_outgoing_bg to R.color.badge_outgoing_fg,
        R.color.badge_incoming_bg to R.color.badge_incoming_fg,
        R.color.badge_missed_bg to R.color.badge_missed_fg,
        R.color.primary_container to R.color.primary_dark,
        R.color.badge_other_bg to R.color.badge_other_fg,
    )

    fun create(seed: String): AvatarStyle {
        val normalized = seed.trim().ifBlank { "#" }
        val label = normalized.first().uppercase()
        val colors = palette[kotlin.math.abs(normalized.hashCode()) % palette.size]
        return AvatarStyle(
            label = label,
            backgroundColorRes = colors.first,
            foregroundColorRes = colors.second,
        )
    }
}
