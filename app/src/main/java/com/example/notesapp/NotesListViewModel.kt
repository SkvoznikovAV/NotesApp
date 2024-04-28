package com.example.notesapp

import androidx.lifecycle.ViewModel

class NotesListViewModel: ViewModel() {
    val notesList = getNotes()

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