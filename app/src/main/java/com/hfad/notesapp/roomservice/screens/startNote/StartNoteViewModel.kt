package com.hfad.notesapp.roomservice.screens.startNote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.notesapp.roomservice.REPOSITORY
import com.hfad.notesapp.roomservice.db.NoteDatabase
import com.hfad.notesapp.roomservice.db.repository.NoteRepositoryImpl
import com.hfad.notesapp.roomservice.model.NoteModel

class StartNoteViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDataBase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImpl(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}