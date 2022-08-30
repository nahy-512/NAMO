package com.example.namo.Bottom.Group.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Group.PeopleDummy
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.databinding.ItemPeopleBinding


//참석자 리사이클러뷰
class GroupPeopleRVApater( private var peopleList:ArrayList<moimAttendences>) : RecyclerView.Adapter<GroupPeopleRVApater.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPeopleBinding =
            ItemPeopleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people=peopleList[position]
        holder.bind(people)
    }

    override fun getItemCount(): Int = peopleList.size

    class ViewHolder(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: moimAttendences) {
            binding.peopleNameTv.text = name.username
            name.userIdx
        }
    }
}