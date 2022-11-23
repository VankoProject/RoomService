package com.hfad.notesapp.roomservice.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.notesapp.roomservice.REPOSITORY
import com.hfad.notesapp.roomservice.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailNoteViewModel: ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
}