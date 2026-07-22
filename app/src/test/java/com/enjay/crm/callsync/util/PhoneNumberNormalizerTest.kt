package com.enjay.crm.callsync.util

import org.junit.Assert.assertTrue
import org.junit.Test

class PhoneNumberNormalizerTest {

    @Test
    fun `lookup keys include direct local indian mobile number`() {
        val keys = PhoneNumberNormalizer.lookupKeys("7698243229")

        assertTrue(keys.contains("7698243229"))
        assertTrue(keys.contains("917698243229"))
        assertTrue(keys.contains("07698243229"))
    }

    @Test
    fun `lookup keys match plus91 input against local lead number`() {
        val localKeys = PhoneNumberNormalizer.lookupKeys("7698243229")
        val plusKeys = PhoneNumberNormalizer.lookupKeys("+917698243229")

        assertTrue(localKeys.intersect(plusKeys).isNotEmpty())
        assertTrue(plusKeys.contains("7698243229"))
    }

    @Test
    fun `lookup keys match zero prefixed number against local lead number`() {
        val localKeys = PhoneNumberNormalizer.lookupKeys("7698243229")
        val zeroPrefixedKeys = PhoneNumberNormalizer.lookupKeys("07698243229")

        assertTrue(localKeys.intersect(zeroPrefixedKeys).isNotEmpty())
        assertTrue(zeroPrefixedKeys.contains("7698243229"))
    }
}
