package com.enjay.crm.callsync

import com.enjay.crm.callsync.util.PhoneNumberNormalizer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PhoneNumberNormalizerTest {

    @Test
    fun normalize_returns_digits_only() {
        assertEquals("919876543210", PhoneNumberNormalizer.normalize("+91 98765-43210"))
    }

    @Test
    fun stripsNonDigitsInsideNumber() {
        assertEquals("9876543210", PhoneNumberNormalizer.normalize("(987) 654-3210"))
    }

    @Test
    fun lookup_keys_bridge_international_and_local_forms() {
        val localKeys = PhoneNumberNormalizer.lookupKeys("7698243229")
        val internationalKeys = PhoneNumberNormalizer.lookupKeys("+91 7698243229")

        assertTrue(localKeys.intersect(internationalKeys).isNotEmpty())
    }
}
