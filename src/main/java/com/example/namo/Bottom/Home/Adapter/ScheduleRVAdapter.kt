package com.example.namo.Bottom.Home.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Home.EditScheduleActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.GetMonthScheduleRes
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import com.example.namo.databinding.ItemScheduleListBinding
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.logging.Handler

class ScheduleRVAdapter (private val context : Context, private val schedule: List<GetScheduleRes>) :  RecyclerView.Adapter<ScheduleRVAdapter.ViewHolder>() {

    interface DayItemClickListener {
        fun onItemClick(schedule: GetScheduleRes)
    }
    private lateinit var mDayItemClickListener: DayItemClickListener
    fun setMyItemClickListener(itemClickListener: DayItemClickListener) {
        mDayItemClickListener = itemClickListener
    }

    private lateinit var mItemClickListener: MyItemClickListener
    interface MyItemClickListener {
        fun onItemsClick(schedule: GetScheduleRes, position: Int)
    }
    fun setsMyItemClickListener(itemClickListener: MyItemClickListener) {
        mItemClickListener = itemClickListener
    }


    private var color = R.color.MainOrange

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemScheduleListBinding = ItemScheduleListBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(schedule[position])

        Log.d("data", schedule[position].endDate.toString())

        //스케줄 리스트 누르면 일정 보기 화면
        holder.binding.scheduleListLayout.setOnClickListener {
            mDayItemClickListener.onItemClick(schedule[position])
        }

        //기록 아이콘 누르면 기록 편집화면으로 이동
        holder.binding.itemScheduleListRecordIv.setOnClickListener {
            mItemClickListener.onItemsClick(schedule[position], position)
        }
    }

    override fun getItemCount(): Int = schedule.size

    inner class ViewHolder(val binding: ItemScheduleListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val view = binding.root

        fun bind(scheduleList: GetScheduleRes) {
            findColor(scheduleList.categoryColor)

            val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val timeFormatter = DateTimeFormatter.ofPattern("a hh:mm")
            var startHour = LocalTime.parse(scheduleList.startDate, serverFormatter).format(timeFormatter)
            var endHour = LocalTime.parse(scheduleList.endDate, serverFormatter).format(timeFormatter)
            binding.itemScheduleListTopTv.text = "${startHour} - ${endHour}"
            binding.itemScheduleListContentTv.text = scheduleList.name
            binding.itemScheduleListCategoryColorIv.backgroundTintList = ColorStateList.valueOf(context.getColor(color))

            //memoIdx 값이 0이면 기록 아이콘 안보이게
            if(scheduleList.memoIdx!=0){
                binding.itemScheduleListRecordIv.visibility= VISIBLE }
            else{
                binding.itemScheduleListRecordIv.visibility= GONE }
            if(scheduleList.moimIdx==1){
                binding.itemScheduleListRecordIv.visibility= GONE
            }


        }
    }


    fun findColor(inputColor : String){
        when(inputColor){
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette1)).substring(2).toUpperCase() -> {
                color = R.color.palette1
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette2)).substring(2).toUpperCase() -> {
                color = R.color.palette2
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette3)).substring(2).toUpperCase() -> {
                color = R.color.palette3
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette4)).substring(2).toUpperCase() -> {
                color = R.color.palette4
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette5)).substring(2).toUpperCase() -> {
                color = R.color.palette5
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette6)).substring(2).toUpperCase() -> {
                color = R.color.palette6
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette7)).substring(2).toUpperCase() -> {
                color = R.color.palette7
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette8)).substring(2).toUpperCase() -> {
                color = R.color.palette8
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette9)).substring(2).toUpperCase() -> {
                color = R.color.palette9
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.palette10)).substring(2).toUpperCase() -> {
                color = R.color.palette10
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.schedule)).substring(2).toUpperCase() -> {
                color = R.color.schedule
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.schedule_plan)).substring(2).toUpperCase() -> {
                color = R.color.schedule_plan
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.schedule_parttime)).substring(2).toUpperCase() -> {
                color = R.color.schedule_parttime
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.schedule_special)).substring(2).toUpperCase() -> {
                color = R.color.schedule_special
            }
            "#" + Integer.toHexString(ContextCompat.getColor(context!!, R.color.schedule_group)).substring(2).toUpperCase() -> {
                color = R.color.schedule_group
            }
            else -> color = R.color.MainOrange
        }
    }

}