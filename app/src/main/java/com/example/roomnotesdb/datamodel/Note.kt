package com.example.roomnotesdb.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteTable")
data class Note(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("Nid")val id:Int?,
    @ColumnInfo("name") val name:String?,
    @ColumnInfo("description")val desc:String?
    ) {

}