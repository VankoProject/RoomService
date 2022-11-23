package com.hfad.notesapp.roomservice.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hfad.notesapp.roomservice.db.dao.NoteDao
import com.hfad.notesapp.roomservice.model.NoteModel


@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao


    companion object{
        private var dataBase: NoteDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase{
            return if (dataBase == null){
                dataBase = Room.databaseBuilder(context, NoteDatabase::class.java, "bd")
                    .build()
                dataBase as NoteDatabase
            } else {
                dataBase as NoteDatabase
            }
        }
    }
}