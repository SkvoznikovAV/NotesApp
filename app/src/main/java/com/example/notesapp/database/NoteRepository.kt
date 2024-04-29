package com.example.notesapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.notesapp.Note
import java.util.UUID

private const val DATABASE_NAME = "notes-database"
class NoteRepository private constructor(context: Context) {
    private val database: NotesDatabase = Room.databaseBuilder(
        context.applicationContext,
        NotesDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val notesDao = database.notesDao()

    fun getNotes(): LiveData<List<Note>> = notesDao.getNotes()

    fun getNote(id: UUID): LiveData<Note?> = notesDao.getNote(id)
    companion object{
        private var INSTANCE: NoteRepository? = null

        fun initialize(context: Context){
            if (INSTANCE==null){
                INSTANCE = NoteRepository(context)
            }
        }

        fun get(): NoteRepository{
            return INSTANCE?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}