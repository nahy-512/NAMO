package com.example.namo.Bottom.Group.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.databinding.ItemGroupPayActivityBinding
import kotlinx.android.synthetic.main.item_group_pay_activity.view.*


//정산 페이지 닉네임 체크
class GroupPayActivityRVAdapter(private var peopleList : ArrayList<moimAttendences>, private var memberIsChecked : ArrayList<Boolean>)
    : RecyclerView.Adapter<GroupPayActivityRVAdapter.ViewHolder>(){

    interface PeopleItemClickListener{
        fun onItemClick(peopleList : ArrayList<moimAttendences>, memberIsChecked: ArrayList<Boolean>)
    }
    private lateinit var mItemClickListener : PeopleItemClickListener
    fun setPeopleItemClickListener(itemClickListener : PeopleItemClickListener){
        mItemClickListener = itemClickListener
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding : ItemGroupPayActivityBinding = ItemGroupPayActivityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        Log.d("PAY", peopleList.toString())
        Log.d("PAY", memberIsChecked.toString())


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(peopleList[position], memberIsChecked[position])
        holder.itemView.item_group_pay_activity_checkBox.setOnClickListener {
            memberIsChecked.set(position, holder.itemView.item_group_pay_activity_checkBox.isChecked)
            Log.d("PAY_CHECK", peopleList[position].username + peopleList[position].userIdx.toString())
            Log.d("PAY_CHECK", memberIsChecked.toString())
            if (memberIsChecked.size != 0){
                mItemClickListener.onItemClick(peopleList, memberIsChecked)
            }

        }



//        holder.itemView.item_group_pay_activity_checkBox.
//        setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
//           // holder.itemView.item_group_pay_activity_checkBox.isChecked=!holder.itemView.item_group_pay_activity_checkBox.isChecked
//            if(isChecked) {
//                mItemClickListener.onItemClick(peopleList)
//            }
//            else{}
//
//        })
    }

    override fun getItemCount(): Int = peopleList.size

    inner class ViewHolder(val binding : ItemGroupPayActivityBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(attendences: moimAttendences, isChecked : Boolean){
            binding.itemGroupActivityName.text = attendences.username
            binding.itemGroupPayActivityCheckBox.isChecked = isChecked
            Log.d("PAY_bind", attendences.username + attendences.userIdx.toString())
            Log.d("PAY_bind", memberIsChecked.toString())
//          attendences.userIdx
        }
    }

}