package com.example.learning

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by viewModels()

    lateinit var recyclerView : RecyclerView
    lateinit var adapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.notesRecyclerView)
        val addBtn = findViewById<FloatingActionButton>(R.id.addNoteBtn)

        adapter = NotesAdapter(emptyList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        noteViewModel.notes.observe(this) { notes ->
            adapter.updateNotes(notes.map{it.text})
        }
        noteViewModel.loadNotes()

        addBtn.setOnClickListener {

            val intent = Intent(this, AddNoteActivity::class.java)

            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {

            val newNote = data?.getStringExtra("new_note")

            if (newNote != null) {

                noteViewModel.addNote(newNote)


            }
        }
    }
}