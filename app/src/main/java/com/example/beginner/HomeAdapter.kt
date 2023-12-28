package com.example.beginner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beginner.databinding.RvItemBinding
import com.example.beginner.model.Univ

class HomeAdapter(private val onItemClick: (Univ) -> Unit) :
    ListAdapter<Univ, HomeAdapter.HomeViewHolder>(
        DiffCallback()
    ) {
    class HomeViewHolder(
        private val binding: RvItemBinding,
        private val onItemClick: (Univ) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(univ: Univ) {
            binding.apply {
                tvNama.text = univ.namaUniv
                tvTahun.text = univ.tahunBerdiri
                tvDeskripsi.text = univ.deskripsi
                Glide.with(itemView.context)
                    .load(univ.gambarUrl)
                    .into(ivGambar)
                root.setOnClickListener {
                    onItemClick.invoke(univ)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val univ = getItem(position)
        holder.bind(univ)
    }

    private class DiffCallback : DiffUtil.ItemCallback<Univ>() {
        override fun areItemsTheSame(oldItem: Univ, newItem: Univ): Boolean {
            return oldItem.namaUniv == newItem.namaUniv
        }

        override fun areContentsTheSame(oldItem: Univ, newItem: Univ): Boolean {
            return oldItem == newItem
        }
    }
}