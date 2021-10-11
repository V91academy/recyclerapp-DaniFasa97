package com.v1bottoni.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val list: List<Boomer>, val context: Context, var onItemClick:((Int) -> Unit)) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val desc: Any
        var imageView: ImageView
      var testView: TextView

        init {
         imageView = itemView.findViewById(R.id.item_image)
         testView = itemView.findViewById(R.id.item_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            layoutInflater.from(parent.context).inflate(R.layout.layout_item_card, parent,false)
    return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val recipe = list[position]
        holder.imageView.setImageResource(recipe.imageUrl)
        holder.testView.text = recipe.title
        holder.desc.text = recipe.description
        holder.testView.setOnClickListener {
            onItemClick.invoke(recipe.id)
        }
    }

    override fun getItemCount() = list.size{
        TODO("Not yet implemented")
    }

}