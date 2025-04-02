package com.bomboclat.kwasoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            registerUser ()
        }
    }

    private fun registerUser () {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Check if username already exists (pseudo code)
        if (usernameExists(username)) {
            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
        } else {
            // Save user (pseudo code)
            saveUser (username, password)
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}