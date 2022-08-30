package com.example.namo.Bottom.Group.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Group.ScheduleRes
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import com.example.namo.databinding.ItemScheduleListBinding
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter


//캘린더 날짜 클릭시 나오는 개인 스케줄 보기
class SeeGroupGroupScheduleRVAdapter (private val context : Context?,  private val schedule: ArrayList<ScheduleRes>, private val moimColor : String) :  RecyclerView.Adapter<SeeGroupGroupScheduleRVAdapter.ViewHolder>(){

    var color = R.color.MainOrange

    interface GroupItemClickListener{
        fun onItemClick(schedule : ScheduleRes)
    }
    private lateinit var mItemClickListener : GroupItemClickListener
    fun setMyItemClickListener(itemClickListener : GroupItemClickListener){
        mItemClickListener = itemClickListener
    }

    interface GroupMemoClickListener{
        fun onItemsClick(schedule : ScheduleRes,position: Int)
    }
    private lateinit var nItemClickListener : GroupMemoClickListener
    fun setsMyItemClickListener(itemsClickListener : GroupMemoClickListener){
        nItemClickListener = itemsClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemScheduleListBinding =  ItemScheduleListBinding .inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)


        findColor(moimColor)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(schedule[position])

        Log.d("data",schedule[position].endDate.toString())

        holder.binding.itemScheduleListRecordIv.setOnClickListener {
            nItemClickListener.onItemsClick(schedule[position],position)
        }

    }


    override fun getItemCount(): Int = schedule.size

    inner class ViewHolder(val binding: ItemScheduleListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(scheduleList: ScheduleRes) {
            val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val timeFormatter = DateTimeFormatter.ofPattern("a hh:mm")
            var startHour = LocalTime.parse(scheduleList.startDate, serverFormatter).format(timeFormatter)
            var endHour = LocalTime.parse(scheduleList.endDate, serverFormatter).format(timeFormatter)

            binding.itemScheduleListTopTv.text = "${startHour} - ${endHour}"
            binding.itemScheduleListContentTv.text = scheduleList.name
            binding.itemScheduleListRecordIv.visibility = View.VISIBLE
            binding.itemScheduleListNameLayout.visibility = View.GONE
            //카테고리 색도 해야됨
            binding.itemScheduleListCategoryColorIv.backgroundTintList = ColorStateList.valueOf(context!!.getColor(color))


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