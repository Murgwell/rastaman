package com.bomboclat.kwasoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        // Load current user data (pseudo code)
        val currentUser = getCurrentUser()
        usernameEditText.setText(currentUser.username)

        findViewById<Button>(R.id.updateButton).setOnClickListener {
            updateProfile()
        }

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            logout()
        }
    }

    private fun updateProfile() {
        val newUsername = usernameEditText.text.toString()
        val newPassword = passwordEditText.text.toString()

        // Update user in database (pseudo code)
        updateUser(newUsername, newPassword)
        Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
    }

    private fun logout() {
        // Clear session and return to login screen
        clearSession()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}