package com.example.test2.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.DetailActivity
import com.example.test2.R
import com.example.test2.data.DataModel

class PostAdapter(val dataModel: MutableList<DataModel>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_post, parent, false)
        return PostViewHolder(view)
    }

    // Bind data to the ViewHolder and set click listener
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = dataModel[position]

        // Set click listener to open DetailActivity with item details
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("date", currentItem.date)
            intent.putExtra("name", currentItem.name)
            intent.putExtra("type", currentItem.type)
            holder.itemView.context.startActivity(intent)
        }

        // Bind data to the ViewHolder
        holder.bindView(currentItem)
    }

    // Return the number of data items
    override fun getItemCount(): Int {
        return dataModel.size
    }
}

// ViewHolder for the individual data items
class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    private val tvName: TextView = itemView.findViewById(R.id.tvName)
    private val tvType: TextView = itemView.findViewById(R.id.tvType)

    // Bind data to the views
    fun bindView(dataModel: DataModel) {
        tvDate.text = dataModel.date
        tvName.text = dataModel.name
        tvType.text = dataModel.type
    }
}