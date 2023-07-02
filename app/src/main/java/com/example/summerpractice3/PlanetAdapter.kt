package com.example.summerpractice3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpractice3.databinding.ItemPlanetBinding

class PlanetAdapter(
    private var list: List<Planet>,
    private val glide: RequestManager,
    private val onItemClick: (Planet) -> Unit,
) : RecyclerView.Adapter<PlanetItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetItem = PlanetItem(
        ItemPlanetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<Planet>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PlanetItem, position: Int) {
        holder.onBind(list[position])
    }
}
