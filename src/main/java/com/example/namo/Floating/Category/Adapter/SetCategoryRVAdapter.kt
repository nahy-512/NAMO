package com.example.namo.Floating.Category.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.databinding.ItemFloatingCategoryBinding

class SetCategoryRVAdapter(val context: Context, val result : ArrayList<InquiryCategoryInfo>):  RecyclerView.Adapter<SetCategoryRVAdapter.ViewHolder>(){

    private lateinit var mItemClickListener: MyItemClickListener //전달받은 리스너 객체를 저장할 변수
    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    } //외부에서 전달받을 수 있는 함수

    interface MyItemClickListener {
        fun onItemClick(category: InquiryCategoryInfo, position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFloatingCategoryBinding = ItemFloatingCategoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (result[position].color == "" || result[position].color == null) {
        } else {
            holder.color.setCardBackgroundColor(Color.parseColor(result[position].color))
        }
        holder.name.text = result[position].name

        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(result[position], position) }

    }

    override fun getItemCount(): Int = result.size

    inner class ViewHolder(val binding: ItemFloatingCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        val name : TextView = binding.itemCategoryNameTv
        val color = binding.itemCategoryColorIv

//        var color = spf.getString("color")
//        val colorString = String

//        fun bind(category: InquiryCategoryInfo) {
//            binding.itemCategoryNameTv.text = category.name
//
//            binding.itemCategoryColorIv.setImageResource(category.color!!)
//        }
    }

}