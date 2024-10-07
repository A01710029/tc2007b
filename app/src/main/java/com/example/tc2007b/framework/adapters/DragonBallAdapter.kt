package com.example.tc2007b.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007b.databinding.ItemCharacterBinding
import com.example.tc2007b.framework.adapters.viewholders.DragonBallViewHolder
import com.example.tc2007b.data.network.model.Character

class DragonBallAdapter: RecyclerView.Adapter<DragonBallViewHolder>()  {
    var items:List<Character> = mutableListOf()

    lateinit var context: Context

    fun DragonBallAdapter(basicData : List<Character>, context: Context){
        this.items = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: DragonBallViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DragonBallViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}