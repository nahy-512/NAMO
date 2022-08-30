package com.example.namo.Bottom.Group.Adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Group.FriendsList
import com.example.namo.Data.Group.GroupInfo
import com.example.namo.Data.Group.InquiryGroupInfoResult
import com.example.namo.databinding.ItemCategoryContentBinding


//그룹 정보창 참석자 정보 리사이클러뷰
class GroupInfoRVAdapter(val context: Context, val result: ArrayList<FriendsList>) : RecyclerView.Adapter<GroupInfoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCategoryContentBinding = ItemCategoryContentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = result[position]
        holder.bind(member)

        Log.d("Group-Member-GroupINfoRVAdapter", member.toString())
    }

    override fun getItemCount(): Int = result.size

    class ViewHolder(val binding: ItemCategoryContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member:FriendsList) {
            binding.itemScheduleCategoryColorCv.setCardBackgroundColor(Color.parseColor(member.color))
            binding.itemScheduleCategoryNameTv.text = member.name
        }
    }
}