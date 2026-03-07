package com.example.learning

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.webkit.WebView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.notesRecyclerView)

        val notes = listOf(
            "Learn Kotlin",
            "Build Android apps",
            "Practice debugging"
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotesAdapter(notes)
    }
}