package com.example.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.notesapp.Note
import java.util.UUID

@Dao
interface NotesDao {
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>
    @Query("SELECT * FROM note WHERE id=(:id)")
    fun getNote(id: UUID): LiveData<Note?>
}