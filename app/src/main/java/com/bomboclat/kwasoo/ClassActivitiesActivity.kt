package com.bomboclat.kwasoo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ClassActivitiesActivity : AppCompatActivity() {

    private lateinit var subject: Subject
    private lateinit var activitiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_activities)

        // Get subject ID from intent
        val subjectId = intent.getStringExtra("subjectId")
        subject = getSubjectFromDatabase(subjectId) // Pseudo code

        // Setup RecyclerView for activities
        activitiesRecyclerView = findViewById(R.id.activitiesRecyclerView)
        loadActivities()

        // Edit button
        findViewById<Button>(R.id.editSubjectButton).setOnClickListener {
            val intent = Intent(this, EditSubjectActivity::class.java).apply {
                putExtra("subjectId", subject.id)
            }
            startActivity(intent)
        }
    }

    private fun loadActivities() {
        // Load activities from database (pseudo code)
        val activities = getActivitiesForSubject(subject.id)
        activitiesRecyclerView.adapter = ActivitiesAdapter(activities) { activity ->
            // Handle activity click (e.g., archive on long press)
        }
    }
}