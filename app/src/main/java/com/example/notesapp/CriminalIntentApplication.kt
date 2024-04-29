package com.example.notesapp

import android.app.Application
import com.example.notesapp.database.NoteRepository

class CriminalIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        NoteRepository.initialize(this)
    }


}