package com.example.gajanand.mvvmdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gajanand.mvvmdemo.databinding.ItemHeroBinding
import com.example.gajanand.mvvmdemo.model.Hero

class HeroAdapter(val items: List<Hero>, val context: Context) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = ItemHeroBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(inflate!!)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(items[position])

    class ViewHolder(val itemBinding: ItemHeroBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Hero) {
            itemBinding.item = item
            itemBinding.executePendingBindings()
        }
    }


}