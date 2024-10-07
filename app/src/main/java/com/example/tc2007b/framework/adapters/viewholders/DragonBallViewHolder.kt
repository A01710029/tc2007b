package com.example.tc2007b.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.tc2007b.databinding.ItemCharacterBinding
import com.example.tc2007b.data.network.model.CharacterBase

class DragonBallViewHolder
    (private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterBase, context: Context){
            binding.TVName.text = item.name
            binding.TVDescription.text = item.description
            binding.TVKi.text = item.ki
            binding.TVMaxKi.text = item.maxKi
            binding.TVRace.text = item.race
            binding.TVGender.text = item.gender
            binding.TVAffiliation.text = item.affiliation

            getImage(item.image, binding.IVPhoto, binding.root.context)
        }

    private fun getImage(image:String, imageView: ImageView, context: Context){
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .fitCenter()
            .priority(Priority.HIGH)

        Glide.with(context)
            .load(image)
            .apply(requestOptions)
            .into(imageView)
    }
}