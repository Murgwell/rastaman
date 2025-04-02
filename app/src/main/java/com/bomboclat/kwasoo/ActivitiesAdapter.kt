package com.bomboclat.kwasoo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ActivitiesAdapter(
    private val activities: List<Activity>,
    private val onLongPress: (Activity) -> Unit
) : RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]
        holder.bind(activity)

        // Long press to archive
        holder.itemView.setOnLongClickListener {
            onLongPress(activity)
            true
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(activity: Activity) {
            // Bind data to views (e.g., activity name, date)
        }
    }
}