package com.yourpackage.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yourpackage.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Manual Step: Initialize ViewBinding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.ll_inputs.getChildAt(0).let {
                // In a real app, use IDs for TextInputLayouts
                // This is a manual test of view traversal
            }

            handleLogin()
        }
    }

    private fun handleLogin() {
        // Simple Manual Validation logic
        val emailText = binding.root.findViewWithTag<com.google.android.material.textfield.TextInputEditText>("email")?.text.toString()

        if (emailText.isEmpty()) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show()
        } else {
            // Success Vibe
        }
    }
}