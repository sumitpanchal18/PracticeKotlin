package com.example.practicekt.activity.rv2.rv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekt.R

class CustomAdapter(private val itemList: List<ItemData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolder for main ItemData
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.textViewItemName)
        val itemDescription: TextView = view.findViewById(R.id.textViewItemDescription)
        val itemImage: ImageView = view.findViewById(R.id.imageViewItem)
        val recyclerViewSubItems: RecyclerView = view.findViewById(R.id.recyclerViewSubItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item_data, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = itemList[position]

        if (holder is ItemViewHolder) {
            // Bind main item data
            holder.itemName.text = itemData.name
            holder.itemDescription.text = itemData.description
            holder.itemImage.setImageResource(itemData.imageResId)

            // Check if this item has sub-items (nested RecyclerView)
            if (itemData.subItems != null) {
                holder.recyclerViewSubItems.visibility = View.VISIBLE
                val subItemAdapter = CustomAdapter(itemData.subItems) // Recursively use the same adapter
                holder.recyclerViewSubItems.layoutManager = LinearLayoutManager(holder.itemView.context)
                holder.recyclerViewSubItems.adapter = subItemAdapter
            } else {
                holder.recyclerViewSubItems.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}
