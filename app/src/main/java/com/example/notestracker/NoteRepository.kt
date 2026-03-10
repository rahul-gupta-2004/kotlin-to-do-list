package com.example.notestracker

import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoteRepository(private val noteDao: NoteDao) {

    val allTasks: Flow<List<Note>> = noteDao.getAllTasks()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val quoteApi = retrofit.create(QuoteApiService::class.java)

    suspend fun insert(task: Note) {
        noteDao.insertTask(task)
    }

    suspend fun delete(task: Note) {
        noteDao.deleteTask(task)
    }

    suspend fun getRandomQuote(): Quote? {
        return try {
            val response = quoteApi.getRandomQuote()
            if (response.isNotEmpty()) {
                Quote(response[0].q, response[0].a)
            } else null
        } catch (e: Exception) {
            Quote("Keep going, you're doing great!", "Inspiration")
        }
    }
}
