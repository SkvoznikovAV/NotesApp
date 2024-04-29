package com.example.notesapp

import androidx.lifecycle.ViewModel
import com.example.notesapp.database.NoteRepository

class NotesListViewModel: ViewModel() {
    private val notesRepository = NoteRepository.get()
    val notesListLiveData = notesRepository.getNotes()

    private fun getNotes(): List<Note> {
        return listOf(
            Note("Заметка 1","Описание 1"),
            Note("Заметка 2","Описание 2"),
            Note("Заметка 3"),
            Note("Заметка 4"),
            Note("Заметка 5"),
        )
    }



}