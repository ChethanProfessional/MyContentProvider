package com.example.mycontentprovider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.mycontentprovider.ui.theme.MyContentProviderTheme
import com.example.mycontentprovider.viewmodel.ContactsViewModel
import com.example.mycontentprovider.viewmodel.ContactsViewModelFactory
import com.example.mycontentprovider.views.ContactPermissionHandler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = ContactsRepository(applicationContext)
        val viewModelFactory = ContactsViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[ContactsViewModel::class.java]
        setContent {
            MyContentProviderTheme {
                ContactPermissionHandler(viewModel)
            }
        }
    }
}
