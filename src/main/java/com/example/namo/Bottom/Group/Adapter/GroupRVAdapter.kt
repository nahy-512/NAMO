package com.example.namo.Bottom.Group.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.namo.Data.Group.Group
import com.example.namo.Data.Group.GroupListResult
import com.example.namo.databinding.ItemGroupListBinding

// GroupFragment와 연결되는 바텀 그룹 리스트 리사이클러뷰
class GroupRVAdapter(val context: Context, val result: ArrayList<GroupListResult>):  RecyclerView.Adapter<GroupRVAdapter.ViewHolder>() {

    interface ItemClickListener{
        fun onItemClick(group : GroupListResult, position: Int)
    }

    private lateinit var mItemClickListener : ItemClickListener
    private lateinit var mInfoItemClickListener : ItemClickListener

    fun setMyItemClickListener (itemClickListener : ItemClickListener){ //숏클릭
        mItemClickListener = itemClickListener
    }
    fun setInfoItemClickListener (itemClickListener : ItemClickListener){ // 그룹 정보 보기
       mInfoItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemGroupListBinding = ItemGroupListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if(result[position].profileImg == "" || result[position].profileImg == null) {

        } else {
//            Log.d("GroupRVAdapter-profileImg", result[position].profileImg)

            // Glide를 사용해서 받아온 cover에 바인딩한 cover image item에 적용시킴
            Glide.with(context).load(result[position].profileImg).into(holder.profileImg)
        }

        holder.title.text= result[position].name //모임 이름

        var memberArray : String = ""
        for (i in 0 until result[position].moimAttendences.size) {
            for (item in result[position].moimAttendences.get(i).username) {
                memberArray += item
            }
            memberArray += ", " //멤버 간 띄어쓰기

        }

        var member = removeLastNchars(memberArray, 2) //마지막은 콤마 제거
        holder.member.text = member
        holder.num.text= result[position].moimAttendences?.size.toString() //인원 수

        //리스트 누르면 그룹 캘린더 화면
        holder.binding.itemGroupLl.setOnClickListener {
            mItemClickListener.onItemClick(result[position], position)
        }

        //더보기 아이콘 누르면 이름 수정 화면
        holder.binding.itemGroupEditIv.setOnClickListener {
            mInfoItemClickListener.onItemClick(result[position], position)
        }

    }

    override fun getItemCount(): Int = result.size

    inner class ViewHolder(val binding: ItemGroupListBinding): RecyclerView.ViewHolder(binding.root) {
        val profileImg : ImageView = binding.itemGroupCoverImgCiv
        val title : TextView = binding.itemGroupTitleTv
        val member : TextView = binding.itemGroupTotalPeopleNameTv
        val num : TextView = binding.itemGroupTotalPeopleNumTv

    }

    //끝 문자 제거하기
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }
}