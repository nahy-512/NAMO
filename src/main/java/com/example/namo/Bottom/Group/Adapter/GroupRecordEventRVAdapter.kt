package com.example.namo.Bottom.Group.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.GroupPlace
import com.example.namo.databinding.ItemGroupRecordEventBinding

//장소 추가시 나오는 장소 & 옆에 총 정산, 사진 3장
class GroupRecordEventRVAdapter(private val placeList : ArrayList<GroupPlace>) : RecyclerView.Adapter<GroupRecordEventRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemGroupRecordEventBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(place : GroupPlace){
            binding.itemGroupRecordHeaderTv.text = place.placeName
            binding.itemGroupRecordPayTv.text = place.pay
            binding.itemGroupRecordImg1Iv.setImageResource(place.pic1.toInt())
            binding.itemGroupRecordImg2Iv.setImageResource(place.pic2.toInt())
            binding.itemGroupRecordImg3Iv.setImageResource(place.pic3.toInt())
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemGroupRecordEventBinding = ItemGroupRecordEventBinding.inflate(
            LayoutInflater.from(viewGroup.context),viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(placeList[position])
    }

    override fun getItemCount(): Int = placeList.size
}