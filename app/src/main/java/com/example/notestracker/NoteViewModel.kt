package com.example.notestracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository = NoteRepository(AppDatabase.getDatabase(application).noteDao())
    
    val allTasks: StateFlow<List<Note>> = repository.allTasks.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote.asStateFlow()

    init {
        fetchQuote()
    }

    private fun fetchQuote() {
        viewModelScope.launch {
            _quote.value = repository.getRandomQuote()
        }
    }

    fun addTask(task: String) {
        viewModelScope.launch {
            repository.insert(Note(task = task))
        }
    }

    fun updateTask(note: Note) {
        viewModelScope.launch {
            repository.insert(note)
        }
    }

    fun deleteTask(task: Note) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }
}
