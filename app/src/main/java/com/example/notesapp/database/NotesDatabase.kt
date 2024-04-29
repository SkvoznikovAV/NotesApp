package com.example.notesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notesapp.Note

@Database(entities = [Note::class], version = 1)
@TypeConverters(NotesTypeConverter::class)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun notesDao(): NotesDao
}