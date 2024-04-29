package com.example.notesapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Note(var title: String,
    var description: String="Описание не указано",
    var date: Date = Date()) {

    @PrimaryKey var id: UUID = UUID.randomUUID()
}