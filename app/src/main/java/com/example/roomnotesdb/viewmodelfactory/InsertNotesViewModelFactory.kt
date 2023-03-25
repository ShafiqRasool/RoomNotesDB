package com.example.roomnotesdb.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomnotesdb.viewmodel.InsertNotesViewModel

@Suppress("UNCHECKED_CAST")
class InsertNotesViewModelFactory(val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(InsertNotesViewModel::class.java)){
            return InsertNotesViewModel(context) as T
        }
        throw java.lang.IllegalArgumentException("Model class not found")
    }
}