package com.example.notesapp.database

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class NotesTypeConverter {
    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }
    @TypeConverter
    fun toDate(millis: Long?):Date?{
        return millis?.let{
            Date(it)
        }
    }
    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?): String?{
        return uuid?.toString()
    }

}