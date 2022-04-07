package com.example.notes.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    tableName = "notes"
)
data class NoteModel (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String
) : Serializable