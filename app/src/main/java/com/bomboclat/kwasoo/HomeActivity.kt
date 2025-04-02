package com.bomboclat.kwasoo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import javax.security.auth.Subject

class HomeActivity : AppCompatActivity() {
    private lateinit var subjectsRecyclerView: RecyclerView
    private lateinit var addSubjectButton: Button
    private var subjects = mutableListOf<Subject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        subjectsRecyclerView = findViewById(R.id.subjectsRecyclerView)
        addSubjectButton = findViewById(R.id.addSubjectButton)

        addSubjectButton.setOnClickListener {
            startActivity(Intent(this, AddSubjectActivity::class.java))
        }

        loadSubjects()
    }

    private fun loadSubjects() {
        // Load subjects from database (pseudo code)
        subjects = loadSubjectsFromDatabase()
        if (subjects.isEmpty()) {
            Toast.makeText(this, "No subjects available", Toast.LENGTH_SHORT).show()
        } else {
            // Set up RecyclerView adapter (pseudo code)
            subjectsRecyclerView.adapter = SubjectsAdapter(subjects) { subject ->
                val intent = Intent(this, ClassActivitiesActivity::class.java)
                intent.putExtra("subjectId", subject.id)
                startActivity(intent)
            }
        }
    }
}