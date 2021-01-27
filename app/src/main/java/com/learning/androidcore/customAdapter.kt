package com.learning.androidcore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: List<Manga>, val context: Context) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val background: ImageView
        val title: TextView
        val description: TextView

        init {
            background = view.findViewById(R.id.backgroundCardView)
            title = view.findViewById(R.id.textCardView)
            description = view.findViewById(R.id.descriptionCardView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    private fun getImageResource(image: String): Int {
        return context.resources.getIdentifier("drawable/${image}", null, context.packageName)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position].name
        val image = getImageResource(dataSet[position].image)
        holder.background.setImageResource(image)
        holder.description.text = dataSet[position].description

    }


    override fun getItemCount(): Int {
        return dataSet.size
    }
}