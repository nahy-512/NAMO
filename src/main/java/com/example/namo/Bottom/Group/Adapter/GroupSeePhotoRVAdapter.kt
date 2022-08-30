package com.example.namo.Bottom.Group.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Home.Record.GlideApp
import com.example.namo.databinding.ItemGalleryBinding

//그룹 기록 보기 화면 사진 어댑터
class GroupSeePhotoRVAdapter (private var photo:List<String>,val context: Context): RecyclerView.Adapter<GroupSeePhotoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGalleryBinding=
            ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val uri=photo[position]

        GlideApp.with(context)
            .load(uri.toUri())
            .into(holder.imageUrl)
    }

    override fun getItemCount(): Int =photo.size

    class ViewHolder(val binding:ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

        val imageUrl= binding.galleryImg1Iv

    }

}
