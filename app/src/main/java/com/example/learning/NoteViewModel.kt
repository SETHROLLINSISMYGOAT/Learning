
package com.example.learning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// Step 1: Create a ViewModel class
class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    private val _notes = MutableLiveData<List<NoteEntity>>()

    // Step 3: Expose LiveData (read-only) to Activity
    val notes: LiveData<List<NoteEntity>> get() = _notes
    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = repository.getAllNotes()
        }
    }



    // Step 4: Function to add a new note
    fun addNote(text: String) {
        viewModelScope.launch {
            val note = NoteEntity(text = text)
            repository.addNote(note)
            loadNotes()
        }
    }
}
