package com.example.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_content")
    val noteContent: String,

    @ColumnInfo(name = "entry_time")
    val entryDate: String = "today"
)
