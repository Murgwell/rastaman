package com.bomboclat.kwasoo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ArchiveActivity : AppCompatActivity() {

    private lateinit var archivedActivitiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        archivedActivitiesRecyclerView = findViewById(R.id.archivedActivitiesRecyclerView)
        loadArchivedActivities()
    }

    private fun loadArchivedActivities() {
        // Load archived activities from database (pseudo code)
        val archivedActivities = getArchivedActivities()
        if (archivedActivities.isEmpty()) {
            Toast.makeText(this, "No archived activities available", Toast.LENGTH_SHORT).show()
        } else {
            archivedActivitiesRecyclerView.adapter = ArchivedActivitiesAdapter(archivedActivities) { activity ->
                // Restore activity
                restoreActivity(activity)
            }
        }
    }
}