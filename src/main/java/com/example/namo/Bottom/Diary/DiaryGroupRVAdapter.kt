package com.example.namo.Bottom.Diary

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namo.databinding.ItemDiaryGalleryBinding

class DiaryGroupRVAdapter (private val urls: List<String?>,val context: Context) :  RecyclerView.Adapter<DiaryGroupRVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDiaryGalleryBinding = ItemDiaryGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val uri=urls.filterNotNull()[position]

        Glide.with(context)
            .load(uri?.toUri())
            .into(holder.imageUrl)
    }

    override fun getItemCount(): Int = urls.size


    inner class ViewHolder(val binding: ItemDiaryGalleryBinding): RecyclerView.ViewHolder(binding.root) {
        val imageUrl= binding.galleryImg1Iv
    }

}