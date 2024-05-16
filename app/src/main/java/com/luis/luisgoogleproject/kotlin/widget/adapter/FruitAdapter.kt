package com.luis.luisgoogleproject.kotlin.widget.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.luis.luisgoogleproject.R

class FruitAdapter(private val fruitList:List<Fruit>): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        val fruitImageView: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    // TODO:  点击事件定义在此处，不用传入上下文进来 可通过parent.context来获取上下文
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(parent.context, "我是条目", Toast.LENGTH_SHORT)
        }
        viewHolder.fruitName.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "点击：${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount()=fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImageView.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name

    }

}