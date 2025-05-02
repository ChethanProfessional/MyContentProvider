package com.example.mycontentprovider.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycontentprovider.viewmodel.ContactsViewModel
import com.example.mycontentprovider.model.Contact

@Composable
fun ContactsScreen(viewModel: ContactsViewModel) {
    val contacts by viewModel.contacts

    LaunchedEffect(Unit) {
        viewModel.loadContacts()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(contacts) { contact ->
            ContactItem(contact)
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = contact.name, style = MaterialTheme.typography.titleMedium)
        Text(text = contact.phoneNumber, style = MaterialTheme.typography.bodyMedium)
        HorizontalDivider()
    }
}
