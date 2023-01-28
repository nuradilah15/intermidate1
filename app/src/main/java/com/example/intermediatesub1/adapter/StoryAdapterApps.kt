package com.example.intermediatesub1.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intermediatesub1.api.ListAllStoryItem
import com.example.intermediatesub1.databinding.ItemStoryAppsBinding

class StoryAdapterApps: RecyclerView.Adapter<StoryAdapterApps.ViewHolder>() {

    private val listStory = ArrayList<ListAllStoryItem>()
    private var onItemClickCallback: OnItemClickCallback? =null

    @SuppressLint("NotifyDataSetChanged")
    fun setListStories(itemStory: List<ListAllStoryItem>){
        val diffCallbackAccount = DiffCallBackAccount(listStory, itemStory)
        val diffResult = DiffUtil.calculateDiff(diffCallbackAccount)

        listStory.clear()
        listStory.addAll(itemStory)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapterApps.ViewHolder {
        val binding = ItemStoryAppsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStory[position])
        holder.itemView.setOnClickListener{onItemClickCallback?. onItemClicked(listStory[position])}
    }

    class ViewHolder(private val binding: ItemStoryAppsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(story: ListAllStoryItem){
            with(binding){
                Glide.with(itemView.context)
                    .load(story.photoUrl)
                    .into(imageStory)
                nameTvItem.text = story.name
                descTvItem.text = story.description
                createdAtTvItem.text =story.createdAt
            }
        }
    }

    override fun getItemCount(): Int = listStory.size

    interface OnItemClickCallback{
        fun onItemClicked(story: ListAllStoryItem)
    }


}