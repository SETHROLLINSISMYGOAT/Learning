package com.example.learning

import android.content.Intent
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn = findViewById<CardView>(R.id.Pe1)
        val btn1= findViewById<CardView>(R.id.Pe2)
        btn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://tempo-deployment-61efead2-9f26-47fd-b6f5-4fd498a50cb-ar05cueem.vercel.app/")
            startActivity(intent)
        }
        btn1.setOnClickListener {
            val intent1 =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent1)

        }



    }
}