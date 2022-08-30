package com.example.namo.Bottom.Group.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Group.AddPlaceDummy
import com.example.namo.Data.Group.GroupRetrofitInterface
import com.example.namo.databinding.ItemGroupAddPlaceBinding

//장소 추가 전체 리사이클러뷰
//class GroupAddPlaceRVAdapter(addPlace: ArrayList<MoimMemoLocationDto>) : RecyclerView.Adapter<GroupAddPlaceRVAdapter.ViewHolder>() {
//
//    private var placeList =ArrayList<AddPlaceDummy>()
//
//    private lateinit var allItemClickListener: MyItemClickListener
//    interface MyItemClickListener {
//        fun onItemsClick(uri:AddPlaceDummy, position: Int)
//    }
//    fun setsMyItemClickListener(itemClickListener: MyItemClickListener) {
//        allItemClickListener = itemClickListener
//    }
//
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        val binding: ItemGroupAddPlaceBinding =
//            ItemGroupAddPlaceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
////        val place=placeList[position]
////        holder.bind(place)
////
////        holder.binding.galleryLv.setOnClickListener {
////
////        //    allItemClickListener.onItemsClick(photoList[position])
////        }
//
//
//    }
//
//    override fun getItemCount(): Int =placeList.size
//
//    class ViewHolder(val binding: ItemGroupAddPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        var context: Context = binding.root.context
//
//        @SuppressLint("NotifyDataSetChanged")
//        fun bind(add:MoimMemoLocationDto) {
//
//           binding.itemPlaceNameTv.setText("장소")
//            binding.itemPlaceMoneyTv.text = "정산 금액"
//
//            binding.groupGalleryLv.setOnClickListener {
//
//                binding.groupGalleryLv.visibility = GONE
//
////                val groupAddPhotoRVAdapter = GroupAddPhotoAdapter()
////                binding.groupAddGalleryRv.adapter = groupAddPhotoRVAdapter
////                binding.groupAddGalleryRv.layoutManager =
////                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//            }
//        }
//
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun addItem(places: AddPlaceDummy){
//        placeList.add(places)
//    }
//}
//
