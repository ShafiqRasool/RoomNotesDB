package com.example.roomnotesdb.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomnotesdb.datamodel.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)
    @Update
    suspend fun update(note:Note)
    @Delete
    suspend fun delete(note:Note)
    @Query("select * from table NoteTable where Nid:id")
    suspend fun getNoteById(id:Int)
    @Query("select * from NoteTable order by ASC")
     fun getAllNotes(): LiveData<List<Note>>

}