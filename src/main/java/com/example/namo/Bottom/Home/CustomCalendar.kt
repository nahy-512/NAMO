package com.example.namo.Bottom.Home

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Home.Adapter.CalendarAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.GetMonthScheduleRes
import com.example.namo.Data.Schedule.MonthSchedule
import com.example.namo.Data.Schedule.ScheduleService
import com.example.namo.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustomCalendar(val mContext : Context, val calendarLayout : LinearLayout, val calendar_view : RecyclerView, val calendar_year_month_text : TextView, val date : Date, val pageIndex : Int, access : String) : MonthSchedule {
    companion object {
        const val DAYS_OF_WEEK = 7
        const val LOW_OF_CALENDAR = 6
    }

    val calendar = Calendar.getInstance()

    var prevTail = 0
    var nextHead = 0
    var currentMaxDate = 0

    var dateList = arrayListOf<Int>()

    lateinit var calendarAdapter : CalendarAdapter

    private var access = access
    private var cnt = 0

    private var sendDate = date

    var eventList = ArrayList<GetMonthScheduleRes>()


    init {
        calendar.time = date
    }

    fun initBaseCalendar(){
//        cnt++
//        Log.d("INIT_LIFE","이닛베이스캘린더 ${cnt} 번 실행됨")
//        Log.d("INIT_LIFE","이닛베이스캘린더 실행")
        makeMonthDate()
        getMonthScheduleData()
    }

    private fun getMonthScheduleData(){
//        Log.d("GET_MONTH_LIFE","겟몬스스케줄캘린더 ${cnt} 번 실행됨")
//        Log.d("GET_MONTH_LIFE","겟몬스스케줄데이터 실행")
        //포맷 적용
        var dateTime : String = SimpleDateFormat("yyyy-MM",
            Locale.KOREA
        ).format(sendDate)
//        Log.e("DATE", dateTime.toString())

        val scheduleService = ScheduleService()
        scheduleService.setMonthScheduleView(this)

        scheduleService.monthSchedule(access, dateTime)
        Log.d("MONTH_SCHEDULE_DATA",access)
        Log.d("MONTH_SCHEDULE_DATA",dateTime.toString())
    }

    private fun makeMonthDate(){
        dateList.clear()

        calendar.set(Calendar.DATE, 1)

        currentMaxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        //DAY_OF_WEEK는 요일을 반환, 일요일이 1, 토요일이 7
        prevTail = calendar.get(Calendar.DAY_OF_WEEK) - 1
        //-> 이번 달 시작이 화요일(3)이면 전 달은 끝의 일,월요일(2) 날짜만 받으면 되니까

        makePrevTail(calendar.clone() as Calendar)
        makeCurrentMonth(calendar)

        nextHead = LOW_OF_CALENDAR * DAYS_OF_WEEK - (prevTail + currentMaxDate)
        //다음달은 7*6 칸 중 전 달 날들 + 이번 달 날들 하고 남은 칸만큼 받으면 되니까
        makeNextHead()
    }

    private fun makePrevTail(calendar : Calendar){
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        var maxOffsetDate = maxDate - prevTail

        for (i in 1..prevTail) dateList.add(++maxOffsetDate)
    }

    private fun makeCurrentMonth(calendar : Calendar){
        for (i in 1..calendar.getActualMaximum(Calendar.DATE)) dateList.add(i)
    }

    private fun makeNextHead(){
        var date = 1

        for (i in 1..nextHead) dateList.add(date++)
    }

    override fun onGetMonthScheduleSuccess(
        code: Int,
        results: List<GetMonthScheduleRes>
    ) {
        when(code){
            1000 -> {
                eventList = ArrayList(results)
                Log.d("ONGET_EVENTLIST","SUCCESS, result : ${results.toString()}")
                Log.d("ONGET_EVENTLIST","eventlist : ${eventList.toString()}")

                calendarAdapter = CalendarAdapter(mContext, calendarLayout, pageIndex, date, dateList, prevTail, nextHead, eventList)
                calendar_view.adapter = calendarAdapter
                calendar_view.layoutManager = GridLayoutManager(mContext, 7, GridLayoutManager.VERTICAL, false)
                calendar_view.setHasFixedSize(true)

                calendarAdapter.itemClick = object : CalendarAdapter.ItemClick {
                    override fun onClick(view: View, year : Int, month : Int, day: Int, firstDateIndex : Int, lastDateIndex : Int, position : Int) {

//                        var sendDate = changeSendDate()
//                        var stringDate = changeDate()
//                        var stringDay = ""
//                        if (day < 10) stringDay = "0" + day else stringDay = "$day"
//                        stringDate = "$stringDate.$stringDay"
//                        sendDate = "$sendDate-$stringDay"


                        if (mContext is MainActivity){
                            if (position < firstDateIndex || position > lastDateIndex){
                                return
                            }

                            mContext.supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, ScheduleFragment(year, month, day))
                                .commitAllowingStateLoss()
                        }
//                        val firstDateIndex = calendarAdapter.dataList.indexOf(1)
//                        val lastDateIndex = calendarAdapter.dataList.lastIndexOf(currentMaxDate)
//                        //현재 월의 1일 이전, 현재 월의 마지막일 이후는 터치 Disable
//                        if (position < firstDateIndex || position > lastDateIndex){
//                            return
//                        }
//                        val day = calendarAdapter.dataList[position].toString()
//                        val date = "${calendar_year_month_text}${day}일"
//                        Log.d("TEST_FOR_FURANG", "${date}")

                    }
                }

//                calendarAdapter.notifyDataSetChanged()
            }
        }

    }

    private fun changeDate() : String{
        //포맷 적용
        var dateTime : String = SimpleDateFormat(
            mContext.getString(R.string.calendar_year_month_format),
            Locale.KOREA
        ).format(date.time)

        return dateTime
    }

    private fun changeSendDate() : String{
        //포맷 적용
        var dateTime : String = SimpleDateFormat(
            mContext.getString(R.string.event_year_month_format),
            Locale.KOREA
        ).format(date.time)

        return dateTime
    }
}