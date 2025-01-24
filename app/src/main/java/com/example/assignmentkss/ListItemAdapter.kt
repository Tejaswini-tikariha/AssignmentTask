package com.example.assignmentkss

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentkss.databinding.ListItemViewBinding

class ListItemAdapter(private val items: List<ListDataModel>) :
    RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListDataModel) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}