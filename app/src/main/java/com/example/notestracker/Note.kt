package com.example.notestracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "tasks")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val task: String,
    val date: Long = System.currentTimeMillis()
) {
    val formattedDate: String
        get() = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault()).format(Date(date))
}
