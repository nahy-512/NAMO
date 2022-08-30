package com.example.namo.Bottom.Home.Adapter


import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.Data.Group.GroupSchedule
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import com.example.namo.databinding.ItemScheduleListBinding
import kotlinx.android.synthetic.main.item_list_calendar.view.*
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter


//ScheduleFragment랑 연결되는 모임 일정 리사이클러뷰
class GroupScheduleRVAdapter(private val context : Context, private val groupScheduleList: ArrayList<GetScheduleRes>):  RecyclerView.Adapter<GroupScheduleRVAdapter.ViewHolder>(){

    interface GroupDayItemClickListener {
        fun onItemClick(schedule: GetScheduleRes, position: Int)
    }

    private lateinit var mItemClickListener: GroupDayItemClickListener //전달받은 리스너 객체를 저장할 변수
    fun setMyItemClickListener(itemClickListener: GroupDayItemClickListener) {
        mItemClickListener = itemClickListener
    } //외부에서 전달받을 수 있는 함수

    var color = R.color.MainOrange

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GroupScheduleRVAdapter.ViewHolder {
        val binding: ItemScheduleListBinding = ItemScheduleListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupScheduleRVAdapter.ViewHolder, position: Int) {
        holder.bind(groupScheduleList[position])

        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(groupScheduleList[position], position)
        }
    }

    override fun getItemCount(): Int = groupScheduleList.size

    inner class ViewHolder(val binding: ItemScheduleListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(group: GetScheduleRes) {
            findColor(group.categoryColor)

            val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val timeFormatter = DateTimeFormatter.ofPattern("a hh:mm")
            var startHour = LocalTime.parse(group.startDate, serverFormatter).format(timeFormatter)
            var endHour = LocalTime.parse(group.endDate, serverFormatter).format(timeFormatter)

            binding.itemScheduleListTopTv.text = "${startHour} - ${endHour}"
            binding.itemScheduleListContentTv.text = group.name
            binding.itemScheduleListRecordIv.visibility = View.GONE //!
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