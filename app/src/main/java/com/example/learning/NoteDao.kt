package com.example.learning

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: NoteEntity)
    @Query("SELECT * FROM NoteEntity")
    suspend fun getAllNotes(): List<NoteEntity>
}