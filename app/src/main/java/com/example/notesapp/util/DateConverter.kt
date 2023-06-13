package com.example.notesapp.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    fun dateFromTimeStamp(timestamp: Long): Date {
        return Date(timestamp)
    }
}