package com.example.namo.Bottom.Home.Record

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namo.databinding.ItemGalleryBinding

//RecordEditActivity랑 연결
class RecordViewRVAdapter(private val items:ArrayList<Uri>, val context: Context):
    RecyclerView.Adapter<RecordViewRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGalleryBinding =
            ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item=items[position]

        Glide.with(context).load(item)
            .into(holder.binding.galleryImg1Iv)

    }


    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(uri:Uri){
            binding.galleryImg1Iv.setImageURI(uri)
        }

    }

}