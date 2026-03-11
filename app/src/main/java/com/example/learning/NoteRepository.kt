package com.example.learning

class NoteRepository(private val dao: NoteDao) {
    suspend fun addNote(note: NoteEntity) {

        dao.insert(note)
    }

    suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }
}