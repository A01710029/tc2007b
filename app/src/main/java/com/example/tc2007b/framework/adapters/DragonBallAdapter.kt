package com.example.tc2007b.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007b.databinding.ItemCharacterBinding
import com.example.tc2007b.framework.adapters.viewholders.DragonBallViewHolder
import com.example.tc2007b.data.network.model.CharacterBase

class DragonBallAdapter(var items:List<CharacterBase>, private val context: Context):
    RecyclerView.Adapter<DragonBallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DragonBallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DragonBallViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: List<CharacterBase>) {
        items = newItems
        notifyDataSetChanged()  // Notify the RecyclerView that the data has changed
    }
}