package com.example.mycontentprovider

import android.content.Context
import android.provider.ContactsContract
import com.example.mycontentprovider.model.Contact

class ContactsRepository(private val context: Context) {

    fun getContacts(): List<Contact> {
        val contactsList = mutableListOf<Contact>()
        val contentResolver = context.contentResolver

        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )

        cursor?.use {
            val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val phoneIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

            while (it.moveToNext()) {
                val name = it.getString(nameIndex) ?: "No Name"
                val phone = it.getString(phoneIndex) ?: "No Number"
                contactsList.add(Contact(name, phone))
            }
        }

        return contactsList
    }
}
