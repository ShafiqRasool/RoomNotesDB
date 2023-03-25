package com.example.roomnotesdb.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomnotesdb.dao.NoteDao
import com.example.roomnotesdb.datamodel.Note
import com.example.roomnotesdb.db.NotesDatabase

class NotesRepository(private val noteDao: NoteDao ){

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    suspend fun update(note: Note){
        noteDao.update(note)
    }
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
     fun getAllNotes():LiveData<List<Note>>{
        return  noteDao.getAllNotes()
    }

}
