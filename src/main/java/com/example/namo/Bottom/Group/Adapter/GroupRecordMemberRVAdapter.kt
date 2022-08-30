package com.example.namo.Bottom.Group.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.databinding.ItemGroupRecordMemberBinding


//동그라미 안에 사람 이름
class GroupRecordMemberRVAdapter(private val memberList : ArrayList<String>) : RecyclerView.Adapter<GroupRecordMemberRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemGroupRecordMemberBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(member : String){
            binding.memberNameTv.text = member
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemGroupRecordMemberBinding = ItemGroupRecordMemberBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memberList[position])
    }

    override fun getItemCount(): Int = memberList.size
}