package com.example.namo.Bottom.Group.Adapter


import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Group.AddPlaceDummy
import com.example.namo.databinding.ItemGalleryBinding


class GroupAddPhotoAdapter( private var photoList:ArrayList<Uri>): RecyclerView.Adapter<GroupAddPhotoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGalleryBinding =
            ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val uri=photoList[position]

        holder.bind(uri)

    }

    override fun getItemCount(): Int =photoList.size

    class ViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Uri) {
            binding.galleryImg1Iv.setImageURI(photo)

        }
    }

}