package com.example.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.REPOSITORY
import com.example.notes.database.NoteDataBase
import com.example.notes.model.NoteModel
import com.example.notes.repository.NoteRealisation

class StartViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun initDataBase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}