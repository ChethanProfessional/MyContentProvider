package com.example.mycontentprovider.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycontentprovider.ContactsRepository
import com.example.mycontentprovider.model.Contact
import kotlinx.coroutines.launch

class ContactsViewModel(private val repository: ContactsRepository) : ViewModel() {

    private val _contacts = mutableStateOf<List<Contact>>(emptyList())
    val contacts: State<List<Contact>> = _contacts

    fun loadContacts() {
        viewModelScope.launch {
            _contacts.value = repository.getContacts()
        }
    }
}
