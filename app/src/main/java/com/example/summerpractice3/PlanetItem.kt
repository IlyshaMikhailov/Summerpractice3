package com.example.summerpractice3

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpractice3.databinding.ItemPlanetBinding

class PlanetItem(
    private val binding: ItemPlanetBinding,
    private val glide: RequestManager,
    private val onItemClick: (Planet) -> Unit,
) : ViewHolder(binding.root) {
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(planet: Planet) {
        binding.run {
            tvTitle.text = planet.name
            tvDesc.text = planet.capitalkrator
            glide.load(planet.url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.error)
                .apply(options)
                .into(binding.ivImage)
            root.setOnClickListener {
                onItemClick(planet)
            }
        }
    }
}