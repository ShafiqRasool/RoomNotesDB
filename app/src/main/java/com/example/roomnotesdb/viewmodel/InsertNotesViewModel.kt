package com.example.roomnotesdb.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomnotesdb.dao.NoteDao
import com.example.roomnotesdb.datamodel.Note
import com.example.roomnotesdb.db.NotesDatabase
import com.example.roomnotesdb.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsertNotesViewModel(context: Context): ViewModel() {
    var notesRepo:NotesRepository
    val name=MutableLiveData<String>()
    val desc=MutableLiveData<String>()
    var dao: NoteDao

    init {
         val db =NotesDatabase.getDatabase(context)
        dao=db.getDao()

       notesRepo=NotesRepository(dao)
    }
    fun insertNote(){
        val note=Note(0,name.value,desc.value)
        viewModelScope.launch (Dispatchers.IO) {
            notesRepo.insert(note)
        }
    }


}