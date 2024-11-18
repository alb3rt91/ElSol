package com.example.elsol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class SolarAdapter(private val items: List<SolarItem>) : RecyclerView.Adapter<SolarAdapter.SolarViewHolder>() {

    class SolarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.solarImageView)
        val nameView: TextView = view.findViewById(R.id.solarNameTextView)
        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageRes)
        holder.nameView.text = item.name

        holder.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.renombrar -> {
                    // Handle favorite action
                    true
                }
                R.id.copiar -> {
                    // Handle share action
                    true
                }
                R.id.cortar -> {
                    // Handle favorite action
                    true
                }
                R.id.eliminar -> {
                    // Handle share action
                    true
                }
                R.id.mover -> {
                    // Handle share action
                    true
                }
                else -> false
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
