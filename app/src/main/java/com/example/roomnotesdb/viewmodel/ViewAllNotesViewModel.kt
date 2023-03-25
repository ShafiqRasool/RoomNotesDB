package com.example.roomnotesdb.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomnotesdb.adapter.ViewAllNotesAdapter
import com.example.roomnotesdb.dao.NoteDao
import com.example.roomnotesdb.datamodel.Note
import com.example.roomnotesdb.db.NotesDatabase
import com.example.roomnotesdb.repository.NotesRepository

class ViewAllNotesViewModel(context: Context):ViewModel() {

 val repo:NotesRepository
 val notesList:LiveData<List<Note>>
    init {
        val dao:NoteDao=NotesDatabase.getDatabase(context).getDao() as NoteDao
        repo=NotesRepository(dao)
        notesList=repo.getAllNotes()


    }


}