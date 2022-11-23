package com.hfad.notesapp.roomservice

import android.os.Bundle
import com.hfad.notesapp.roomservice.db.repository.NoteRepository

lateinit var APP: MainActivity
lateinit var REPOSITORY: NoteRepository
const val KEY = "note"