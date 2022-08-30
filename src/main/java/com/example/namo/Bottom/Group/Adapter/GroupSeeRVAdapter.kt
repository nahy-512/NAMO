package com.example.namo.Bottom.Group.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Group.getMoimMemoLocationRes
import com.example.namo.databinding.ItemGroupAddPlaceBinding
import com.example.namo.databinding.ItemGroupSeePlaceBinding


//그룹 기록 보기 화면 어댑터
class GroupSeeRVAdapter(private var placeList:ArrayList<getMoimMemoLocationRes>): RecyclerView.Adapter<GroupSeeRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGroupSeePlaceBinding =
            ItemGroupSeePlaceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(placeList[position])
    }

    override fun getItemCount(): Int =placeList.size

    class ViewHolder(val binding: ItemGroupSeePlaceBinding ) : RecyclerView.ViewHolder(binding.root) {

        var context: Context = binding.root.context

        @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
        fun bind(place:getMoimMemoLocationRes) {
                binding.itemPlaceNameTv.setText(place.location)
            place.locationIdx
            place.attendences
                binding.itemPlaceMoneyTv.text=place.amount.toString() + "원"
                binding.groupAddGalleryRv.adapter=GroupSeePhotoRVAdapter(place.locationimg.filterNotNull(),context)
            binding.groupAddGalleryRv.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)

        }

    }

}
