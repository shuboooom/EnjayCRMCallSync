package com.enjay.crm.callsync.data.repository

import android.content.Context
import android.provider.ContactsContract
import com.enjay.crm.callsync.data.model.DeviceContactMatch
import com.enjay.crm.callsync.util.PhoneNumberNormalizer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeviceContactsRepository(
    context: Context,
) : ContactsRepository {

    private val appContext = context.applicationContext

    override suspend fun findContactByPhoneNumber(phoneNumber: String): DeviceContactMatch? =
        withContext(Dispatchers.IO) {
            val normalizedPhone = PhoneNumberNormalizer.normalize(phoneNumber)
            if (normalizedPhone.isBlank()) return@withContext null

            val phoneSuffix = normalizedPhone.takeLast(10)
            val projection = arrayOf(
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY,
            )

            val selection = buildString {
                append("${ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER} = ?")
                append(" OR ${ContactsContract.CommonDataKinds.Phone.NUMBER} LIKE ?")
            }
            val args = arrayOf(normalizedPhone, "%$phoneSuffix")

            appContext.contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection,
                selection,
                args,
                null,
            )?.use { cursor ->
                if (!cursor.moveToFirst()) return@withContext null

                val contactId = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
                val name = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val number = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val lookup = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY)

                val id = cursor.getLong(contactId)
                val lookupKey = cursor.getString(lookup)
                val uri = ContactsContract.Contacts.getLookupUri(id, lookupKey)

                DeviceContactMatch(
                    contactId = id,
                    displayName = cursor.getString(name),
                    phoneNumber = cursor.getString(number),
                    lookupUri = uri,
                )
            }
        }
}
