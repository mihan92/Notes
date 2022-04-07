package com.example.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.model.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object {
        private var database: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase{
            if (database == null) {
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "database").build()
            } else {
                return database as NoteDataBase
            }
            return database as NoteDataBase
        }
    }
}