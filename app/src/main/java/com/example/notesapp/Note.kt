package com.example.notesapp

import java.util.Date
import java.util.UUID

data class Note(val title: String,
    val description: String="Описание не указано",
    val date: Date = Date()) {

    private val id: UUID = UUID.randomUUID()
}