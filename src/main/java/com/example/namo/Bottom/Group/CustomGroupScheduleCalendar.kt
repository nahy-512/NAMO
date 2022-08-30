package com.example.namo.Bottom.Group

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter
import com.example.namo.Bottom.Home.CustomCalendar
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.*
import com.example.namo.Data.Login.GlobalApplication
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter


class CustomGroupScheduleCalendar(val mContext : Context, val groupCalendarLayout : LinearLayout, val groupCalendar_view : RecyclerView, val groupCalendar_year_month_text : TextView, val date : Date, val pageIndex : Int, access : String, val moimIdx : Int) :
    GroupScheduleView {

    companion object {
        const val DAYS_OF_WEEK = 7
        const val LOW_OF_CALENDAR = 6

        private const val KEY_MEMBER_PREFS = "memberSchedule"
        private const val KEY_MEMBER_DATA = "memberScheduleData"
        private const val KEY_GROUP_PREFS = "groupSchedule"
        private const val KEY_GROUP_DATA = "groupScheduleData"

    }

    val groupCalendar = Calendar.getInstance() //오늘날짜 정보 받아오기

    var prevTail = 0
    var nextHead = 0
    var currentMaxDate = 0

    var dateList = arrayListOf<Int>()

    lateinit var groupCalendarAdapter : GroupCalendarAdapter

    private var access = access

    private var sendDate = date

    var groupEventList = ArrayList<List<GetScheduleRes>>()

    val groupIdx = 0

    init {
        groupCalendar.time = date
    }

    fun initBaseCalendar(){
        makeMonthDate()
        getGroupScheduleData()
    }

    private fun getGroupScheduleData(){
        var dateTime : String = SimpleDateFormat("yyyy-MM", Locale.KOREA).format(sendDate)
        dateTime = dateTime + "-01"

        val groupService = GroupService()
        groupService.setGroupScheduleView(this)

        var groupMonth = GroupMonth(moimIdx, dateTime)

        groupService.getGroupScheduleMonth(access, groupMonth)
        Log.d("MONTH_SCHEDULE_DATA",access)
        Log.d("MONTH_SCHEDULE_DATA",moimIdx.toString())
        Log.d("MONTH_SCHEDULE_DATA",dateTime)
    }

    private fun makeMonthDate(){
        dateList.clear()

        groupCalendar.set(Calendar.DATE, 1)

        currentMaxDate = groupCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        //DAY_OF_WEEK는 요일을 반환, 일요일이 1, 토요일이 7
        prevTail = groupCalendar.get(Calendar.DAY_OF_WEEK) - 1
        //-> 이번 달 시작이 화요일(3)이면 전 달은 끝의 일,월요일(2) 날짜만 받으면 되니까

        makePrevTail(groupCalendar.clone() as Calendar)
        makeCurrentMonth(groupCalendar)

        nextHead = CustomCalendar.LOW_OF_CALENDAR * CustomCalendar.DAYS_OF_WEEK - (prevTail + currentMaxDate)
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

    override fun onInputGroupScheduleSuccess(code: Int, result: GroupScheduleResult) {
        TODO("Not yet implemented")
    }

    override fun onGetGroupScheduleSuccess(code: Int, result: GetMoimScheduleRes) {
        when(code){
            1000 -> {
                var moimIdx = result.moimIdx
                var moimColor = result.moimColor
                var memberSchedule = ArrayList(result.memberSchedule)
                var moimSchedule = ArrayList(result.moimSchedule)

                Log.d("ONGET_GROUP_EVENTLIST","SUCCESS, result : ${result}")
                Log.d("ONGET_GROUP_EVENTLIST","eventlist : moimIdx ${moimIdx}")
                Log.d("ONGET_GROUP_EVENTLIST","eventlist : memberSchedule ${memberSchedule}")
                Log.d("ONGET_GROUP_EVENTLIST","eventlist : moimSchedule ${moimSchedule}")

                groupCalendarAdapter = GroupCalendarAdapter(mContext, groupCalendarLayout, pageIndex, date, dateList, prevTail, nextHead, memberSchedule, moimSchedule, moimColor )
                groupCalendar_view.adapter = groupCalendarAdapter
                groupCalendar_view.layoutManager = GridLayoutManager(mContext, 7, GridLayoutManager.VERTICAL, false)
                groupCalendar_view.setHasFixedSize(true)

                groupCalendarAdapter.itemClick = object : GroupCalendarAdapter.ItemClick {
                    override fun onClick(
                        view: View,
                        year: Int,
                        month: Int,
                        date: Int,
                        firstDateIndex : Int,
                        lastDateIndex : Int,
                        position : Int
                    ) {
                        if (mContext is MainActivity){
                            if (position < firstDateIndex || position > lastDateIndex){
                                return
                            }
                            val day = LocalDate.of(year, month, date)
                            Log.d("MEMBER_SCHEDULE_DATE", day.toString())
                            var startDate = LocalDate.now()
                            var endDate = LocalDate.now()
                            var memberData = ArrayList<MemberSchedule>()
                            var memberEvent = ArrayList<ScheduleRes>()
                            var moimData = ArrayList<ScheduleRes>()
                            Log.d("MEMBER_SCHEDULE_ORIGIN", memberSchedule.toString())

                            for (i in memberSchedule){
                                var memberEvent = ArrayList<ScheduleRes>()
                                for (j in i.scheduleRes) {
                                    startDate = j.toLocal(j.startDate)
                                    endDate = j.toLocal(j.endDate)
                                    Log.d("MEMBER_SCHEDULE_STARTDATE", startDate.toString())
                                    Log.d("MEMBER_SCHEDULE_ENDDATE", endDate.toString())
                                    if ((day.isAfter(startDate) && day.isBefore(endDate))
                                        || day.isEqual(startDate) || day.isEqual(endDate)){
                                        memberEvent.add(j)
                                    }
                                }
                                memberData.add(MemberSchedule(i.memberIdx, i.memberColor, memberEvent))
                                Log.d("MEMBER_SCHEDULE", memberData.toString() + "번째 : " + day.toString())
                            }
                            for (i in moimSchedule) {
                                startDate = i.toLocal(i.startDate)
                                endDate = i.toLocal(i.endDate)
                                if ((day.isAfter(startDate) && day.isBefore(endDate))
                                    || day.isEqual(startDate) || day.isEqual(endDate)){
                                    moimData.add(i)
                                }

                            }
                            Log.d("LOCAL_DATE", "${day.year}년 ${day.monthValue}월 ${day.dayOfMonth}일")
                            Log.d("LOCAL_DATE", "member : ${memberData}")
                            Log.d("LOCAL_DATE", "group : ${moimData}")


                            val intent = Intent(mContext, GroupScheduleActivity::class.java)
                            intent.putExtra("year", day.year)
                            intent.putExtra("month",day.monthValue)
                            intent.putExtra("date",day.dayOfMonth)
                            intent.putExtra("member", memberData)
                            intent.putExtra("moim", moimData)
                            intent.putExtra("moimColor", moimColor)

                            mContext.startActivity(intent)

//                            mContext.supportFragmentManager.beginTransaction()
//                                .replace(R.id.main_frm, SeeGroupScheduleFragment(year, month, date))
//                                .commitAllowingStateLoss()
                        }
                    }
                }

            }
        }
    }
}