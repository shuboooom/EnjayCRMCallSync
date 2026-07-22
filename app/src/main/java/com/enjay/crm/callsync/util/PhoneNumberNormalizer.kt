package com.enjay.crm.callsync.util

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

object PhoneNumberNormalizer {

    private const val DEFAULT_REGION = "IN"
    private val phoneNumberUtil: PhoneNumberUtil by lazy { PhoneNumberUtil.getInstance() }

    fun normalize(value: String): String = digitsOnly(value)

    fun isViable(value: String): Boolean = lookupKeys(value).any { it.length >= 7 }

    fun lookupKeyBlob(value: String): String {
        val keys = lookupKeys(value)
        return if (keys.isEmpty()) "" else "|${keys.sorted().joinToString("|")}|"
    }

    fun lookupKeys(value: String): Set<String> {
        val digits = digitsOnly(value)
        if (digits.isBlank()) return emptySet()

        return linkedSetOf<String>().apply {
            add(digits)
            add(digits.trimStart('0'))
            add(digits.takeLast(10))

            parse(value)?.let { parsed ->
                val national = phoneNumberUtil.getNationalSignificantNumber(parsed)
                val countryCode = parsed.countryCode.toString()
                val e164Digits = digitsOnly(
                    phoneNumberUtil.format(parsed, PhoneNumberUtil.PhoneNumberFormat.E164),
                )

                add(national)
                add(national.trimStart('0'))
                add(national.takeLast(10))
                add("$countryCode$national")
                add("0$national")
                add(e164Digits)
            }
        }.filter { it.isNotBlank() && it.length >= 7 }.toSet()
    }

    private fun parse(value: String): com.google.i18n.phonenumbers.Phonenumber.PhoneNumber? {
        return try {
            phoneNumberUtil.parse(value, DEFAULT_REGION)
        } catch (_: NumberParseException) {
            try {
                phoneNumberUtil.parse(digitsOnly(value), DEFAULT_REGION)
            } catch (_: NumberParseException) {
                null
            }
        }
    }

    private fun digitsOnly(value: String): String = value.filter(Char::isDigit)
}
