package com.example.namo.Bottom.Home.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Data.Schedule.GetMonthScheduleRes
import com.example.namo.R
import kotlinx.android.synthetic.main.item_list_calendar.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarAdapter(val context : Context, val calendarLayout : LinearLayout, val pageIndex : Int, val date : Date, dateList : ArrayList<Int>, val prevTail : Int, val nextHead : Int, val monthEvent:ArrayList<GetMonthScheduleRes> )
    : RecyclerView.Adapter<CalendarAdapter.CalendarItemHolder>(){

    private val TAG = javaClass.simpleName
    var dataList : ArrayList<Int> = arrayListOf()
    init {
        dataList = dateList
    }

    interface ItemClick {
        fun onClick(
            view: View,
            year: Int,
            month: Int,
            date : Int,
            first: Int,
            last: Int,
            position: Int
        )
    }

    var itemClick : ItemClick? = null

    var isFirstMonth = false
    var isLastMonth = false

    var before = false
    var after = false

    var year = 0
    var month = 0

    var firstIndex : Int = 0
    var lastIndex : Int = 0
    var pos : Int = 0


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_calendar, parent, false)

        return CalendarItemHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarItemHolder, position: Int) {
        val h = calendarLayout.height / 6
        holder.itemView.layoutParams.height = h
        changeDays()

        holder?.bind(dataList[position], position, context)
        holder?.eventShow(dataList[position], position)


//        Log.d("MONTH_BIND", "$before before $after after")

        if (itemClick != null) {
            holder?.itemView?.setOnClickListener {

                    v -> itemClick?.onClick(v, year, month - 1, dataList[position], firstIndex, lastIndex, position)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class CalendarItemHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!){
        var itemCalendarDateText : TextView = itemView!!.item_calendar_date_text

        var color = R.color.MainOrange

        fun bind(data : Int, position: Int, context: Context){
            val firstDateIndex = prevTail
            val lastDateIndex = dataList.size - nextHead - 1

            firstIndex = firstDateIndex
            lastIndex = lastDateIndex
            pos = position

            //날짜 표시
            itemCalendarDateText.setText(data.toString())

            //오늘날짜 처리
            var dateString: String = SimpleDateFormat("dd", Locale.KOREA).format(date)
            var dateInt = dateString.toInt()
            if (pageIndex == 0 && dataList[position] == dateInt){
                itemCalendarDateText.setTypeface(itemCalendarDateText.typeface, Typeface.BOLD)
            }

            //현재 월이 아니면 회색처리
            if (position < firstDateIndex || position > lastDateIndex){
                itemCalendarDateText.alpha = 0.4f
            }

            //이전 달 또는 다음 달이면 월 계산
            if (position < firstDateIndex) {
                if (isFirstMonth){
                    year -= 1
                    month = 12
                }
                else month = month - 1
            }
            else if(position > lastDateIndex) {
                if (isLastMonth){
                    year += 1
                    month = 1
                } else month = month + 1
            }
        }

        fun eventShow(data : Int, position: Int){

            var count = 0

            val date : Date = Date(year.toInt() - 1900, month.toInt() - 1, data, 0,0)
//            Log.d("DATE",date.toString())

            for (i in monthEvent){

                var color = R.color.MainOrange
                when(i.categoryColor){
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
                    "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.schedule)).substring(2).toUpperCase() -> {
                        color = R.color.schedule
                    }
                    "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.schedule_plan)).substring(2).toUpperCase() -> {
                        color = R.color.schedule_plan
                    }
                    "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.schedule_parttime)).substring(2).toUpperCase() -> {
                        color = R.color.schedule_parttime
                    }
                    "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.schedule_special)).substring(2).toUpperCase() -> {
                        color = R.color.schedule_special
                    }
                    "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.schedule_group)).substring(2).toUpperCase() -> {
                        color = R.color.schedule_group
                    }
                    else -> color = R.color.MainOrange
                }

//                Log.d("MONTHEVENT", i.categoryColor.toString())
                //시작일과 끝일이 같은 날짜일 때
                if (isSameStartEnd(i)){
                    if (isSameDay(i, date)){
                        count += showingSame(i, this, color)
                    }
                }
                //시작일과 끝일이 다른 날짜일 때
                else {
                    if (isSameAsStart(i, date)){
//                        Log.d("SAME_AS_START","$date 날, ${i.startDate} 이벤트")
                        count += showingStart(i, this, color)
                    }
                    else if (isBetweenStartEnd(i, date)){
//                        Log.d("SAME_AS_BETWEEN","$date 날, ${i.startDate} 시작일, ${i.endDate} 이벤트")
                        count += showingBetween(i, this, color)
                    }
                    else if (isSameAsEnd(i, date)){
//                        Log.d("SAME_AS_END","$date 날, ${i.endDate} 이벤트")
                        count += showingEnd(i, this, color)
                    }
                }
            }
            if (count > 0){
                Log.d("COUNT", count.toString())
                itemView!!.item_calendar_event_count.setText("+$count")
                itemView!!.item_calendar_event_count.visibility = View.VISIBLE
            }

        }
    }

    fun changeDays(){
        year = SimpleDateFormat("yyyy", Locale.KOREA).format(date).toInt()
        month = SimpleDateFormat("MM", Locale.KOREA).format(date).toInt()
        if (month == 1) {
            isFirstMonth = true
            isLastMonth = false
        }
        else if (month == 12) {
            isFirstMonth = false
            isLastMonth = true
        }
        else{
            isFirstMonth = false
            isLastMonth = false
        }
//        Log.d("DAYS", "$year 년 $month 월 $isFirstMonth 1월인지 $isLastMonth 12월인지")
    }

    private fun isSameStartEnd(event : GetMonthScheduleRes) : Boolean {
        var startDate = event.toCalendar(event.startDate)
        var endDate = event.toCalendar(event.endDate)

        return startDate.equals(endDate)
    }

    private fun isSameDay(event: GetMonthScheduleRes, day : Date) : Boolean {
        return isSameAsStart(event, day)
    }

    private fun isSameAsStart(event : GetMonthScheduleRes, day : Date) : Boolean {
        var startDate = event.toCalendar(event.startDate)
        var cal = Calendar.getInstance()
        cal.set(day.year + 1900, day.month, day.date, 0, 0)

//        Log.d("IS_SAME_AS_START","$startDate 시작일과 $cal 날짜")
        return startDate.equals(cal)
    }

    private fun isSameAsEnd(event : GetMonthScheduleRes, day : Date) : Boolean {
        var endDate = event.toCalendar(event.endDate)
        var cal = Calendar.getInstance()
        cal.set(day.year + 1900, day.month, day.date, 0, 0)

        return endDate.equals(cal)
    }

    private fun isBetweenStartEnd(event : GetMonthScheduleRes, day : Date) : Boolean {
        var startDate = event.toDate(event.startDate)
        var endDate = event.toDate(event.endDate)

        return day.after(startDate) && day.before(endDate)
    }

    @SuppressLint("ResourceType")
    private fun showingSame(event : GetMonthScheduleRes, holder : CalendarItemHolder, color : Int) : Int {
        var num = 0
        if (event.position == 0){
            if (holder.itemView.item_calendar_event1.visibility == View.INVISIBLE){
                event.position = 1
                holder.itemView.item_calendar_event1.text = event.name
                holder.itemView.item_calendar_event1.visibility = View.VISIBLE
                holder.itemView.item_calendar_event1.setBackgroundResource(R.drawable.border_round_left_right)
                holder.itemView.item_calendar_event1.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
            }
            else if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                event.position = 2
                holder.itemView.item_calendar_event2.text = event.name
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
                holder.itemView.item_calendar_event2.setBackgroundResource(R.drawable.border_round_left_right)
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = event.name
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
                holder.itemView.item_calendar_event2.setBackgroundResource(R.drawable.border_round_left_right)
            }
            else
                num++
        }

        return num
    }

    private fun showingStart(event : GetMonthScheduleRes, holder : CalendarItemHolder, color : Int) : Int{
        var num = 0
        if (event.position == 0){
            if (holder.itemView.item_calendar_event1.visibility == View.INVISIBLE){
                event.position = 1
                holder.itemView.item_calendar_event1.text = event.name
                holder.itemView.item_calendar_event1.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event1.visibility = View.VISIBLE
                holder.itemView.item_calendar_event1.setBackgroundResource(R.drawable.border_round_left)
            }
            else if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                event.position = 2
                holder.itemView.item_calendar_event2.text = event.name
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
                holder.itemView.item_calendar_event2.setBackgroundResource(R.drawable.border_round_left)
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = event.name
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
                holder.itemView.item_calendar_event3.setBackgroundResource(R.drawable.border_round_left)
            }
            else num++
        }

        return num
    }

    private fun showingBetween (event : GetMonthScheduleRes, holder : CalendarItemHolder, color : Int) : Int{
        var num = 0
        if (event.position == 1){
            if (holder.itemView.item_calendar_event1.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event1.text = ""
                holder.itemView.item_calendar_event1.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event1.visibility = View.VISIBLE
            }
            else if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                event.position = 2
                holder.itemView.item_calendar_event2.text = ""
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
            }
            else num++
        }
        else if (event.position == 2){
            if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event2.text = ""
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
            }
            else num++
        }
        else if (event.position == 3){
            if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
            }
            else num++
        }

        return num
    }

    private fun showingEnd (event : GetMonthScheduleRes, holder : CalendarItemHolder, color : Int) : Int{
        var num = 0
        if (event.position == 1){
            if (holder.itemView.item_calendar_event1.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event1.text = ""
                holder.itemView.item_calendar_event1.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event1.visibility = View.VISIBLE
                holder.itemView.item_calendar_event1.setBackgroundResource(R.drawable.border_round_right)
            }
            else if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                event.position = 2
                holder.itemView.item_calendar_event2.text = ""
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
                holder.itemView.item_calendar_event2.setBackgroundResource(R.drawable.border_round_right)
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
                holder.itemView.item_calendar_event3.setBackgroundResource(R.drawable.border_round_right)
            }
            else num++
        }
        else if (event.position == 2){
            if (holder.itemView.item_calendar_event2.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event2.text = ""
                holder.itemView.item_calendar_event2.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event2.visibility = View.VISIBLE
                holder.itemView.item_calendar_event2.setBackgroundResource(R.drawable.border_round_right)
            }
            else if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                event.position = 3
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
                holder.itemView.item_calendar_event3.setBackgroundResource(R.drawable.border_round_right)
            }
            else num++
        }
        else if (event.position == 3){
            if (holder.itemView.item_calendar_event3.visibility == View.INVISIBLE){
                holder.itemView.item_calendar_event3.text = ""
                holder.itemView.item_calendar_event3.backgroundTintList = ColorStateList.valueOf(context.getColor(color))
                holder.itemView.item_calendar_event3.visibility = View.VISIBLE
                holder.itemView.item_calendar_event3.setBackgroundResource(R.drawable.border_round_right)
            }
            else num++
        }

        return num
    }




}