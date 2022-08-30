package com.example.namo.Bottom.Home.Record

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.databinding.ItemGalleryBinding

//RecordWriteActivity랑 연결
class RecordGalleryRVAdapter( private val urls: List<String?>, val context: Context):
    RecyclerView.Adapter<RecordGalleryRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGalleryBinding =
            ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


       val uri=urls.filterNotNull()[position]

        GlideApp.with(context)
            .load(uri?.toUri())
            .into(holder.imageUrl)


    }
    override fun getItemCount(): Int = urls.size

    class ViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
           val imageUrl= binding.galleryImg1Iv

    }

}




