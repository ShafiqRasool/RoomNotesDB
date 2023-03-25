package com.example.roomnotesdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.roomnotesdb.dao.NoteDao
import com.example.roomnotesdb.datamodel.Note

@Database(entities = [Note::class], version = 2)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun getDao():NoteDao
    companion object{
        private const val DB_NAME="my_db"


         private var INSTANCE:NotesDatabase?=null

        fun getDatabase(context: Context): NotesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(context) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    DB_NAME
                ).build()

                // return instance
                instance

            }
        }
    }



}