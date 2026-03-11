package com.example.learning

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val noteInput = findViewById<EditText>(R.id.etNote)
        val saveBtn = findViewById<Button>(R.id.btnSave)

        saveBtn.setOnClickListener {
            val noteText = noteInput.text.toString()
            val intent = Intent()
            intent.putExtra("new_note", noteText)
            Timber.d("New note: $noteText")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}