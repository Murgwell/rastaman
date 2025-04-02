package com.bomboclat.kwasoo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import javax.security.auth.Subject

class AddSubjectActivity : AppCompatActivity() {

    private lateinit var subjectNameEditText: EditText
    private lateinit var subjectCodeEditText: EditText
    private lateinit var gradeLevelEditText: EditText
    private lateinit var roomNumberEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)

        // Initialize views
        subjectNameEditText = findViewById(R.id.subjectNameEditText)
        subjectCodeEditText = findViewById(R.id.subjectCodeEditText)
        gradeLevelEditText = findViewById(R.id.gradeLevelEditText)
        roomNumberEditText = findViewById(R.id.roomNumberEditText)
        timeEditText = findViewById(R.id.timeEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            saveSubject()
        }
    }

    private fun saveSubject() {
        val subjectName = subjectNameEditText.text.toString().trim()
        val subjectCode = subjectCodeEditText.text.toString().trim()
        val gradeLevel = gradeLevelEditText.text.toString().trim()
        val roomNumber = roomNumberEditText.text.toString().trim()
        val time = timeEditText.text.toString().trim()

        // Validate required fields
        if (subjectName.isEmpty() || subjectCode.isEmpty() || roomNumber.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a Subject object (define this data class)
        val subject = Subject(
            name = subjectName,
            code = subjectCode,
            gradeLevel = gradeLevel.ifEmpty { null }, // Optional
            roomNumber = roomNumber,
            time = time
        )


        // Return to HomeActivity
        Toast.makeText(this, "Subject saved", Toast.LENGTH_SHORT).show()
        finish()
    }
}