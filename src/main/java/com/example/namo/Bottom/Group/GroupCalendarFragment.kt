package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.R
import com.example.namo.databinding.FragmentGroupCalendarBinding
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_group_calendar.view.*
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


//캘린더
class GroupCalendarFragment(index : Int) : Fragment() {

    private val TAG = javaClass.simpleName
    lateinit var mContext : Context
    lateinit var mActivity : MainActivity

    var pageIndex = index
    lateinit var currentDate : Date

    lateinit var group_calendar_year_month_text : TextView
    lateinit var group_calendar_layout : LinearLayout
    lateinit var group_calendar_view : RecyclerView
//    lateinit var groupCalendarAdapter : GroupCalendarAdapter

    lateinit var binding : FragmentGroupCalendarBinding

    lateinit var customGroupCalendar : CustomGroupScheduleCalendar
    var dateList : ArrayList<Int> = arrayListOf()

    private var access = ""

    private var moimIdx = 0

    companion object {
        var instance : GroupCalendarFragment? = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity){
            mContext = context
            mActivity = activity as MainActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_group_calendar, container, false)
        binding = FragmentGroupCalendarBinding.inflate(inflater, container, false)

        getToken()
        getMoimIdx()
        initView(view)


        return view
    }

    override fun onResume() {
        super.onResume()
        initCalendar()
    }

    fun initView(view : View){
        pageIndex -= (Int.MAX_VALUE/2)
        Log.e(TAG, "Group Calendar Index : ${pageIndex}")
        group_calendar_year_month_text = view.group_calendar_year_month_text
        group_calendar_layout = view.group_calendar_layout
        group_calendar_view = view.group_calendar_view

        //날짜 적용
        val date = Calendar.getInstance().run {
            add(Calendar.MONTH, pageIndex) // getInstance로 이번 달에서 pageIndex로 원하는 만큼 이동
            time
        }
        currentDate = date //currentDate를 원하는 달의 오늘날짜로 설정
        Log.e(TAG, "$date")

        var dateTime : String = SimpleDateFormat(
            mContext.getString(R.string.calendar_year_month_format),
            Locale.KOREA
        ).format(date.time) //년월 정보를 String 으로 받아옴
        group_calendar_year_month_text.setText(dateTime)
    }

    fun initCalendar(){
        customGroupCalendar = CustomGroupScheduleCalendar(mContext, group_calendar_layout, group_calendar_view, group_calendar_year_month_text, currentDate, pageIndex, access, moimIdx)
        customGroupCalendar.initBaseCalendar()
        dateList = customGroupCalendar.dateList
//        groupCalendarAdapter = GroupCalendarAdapter(mContext, group_calendar_layout, pageIndex, currentDate)
//        group_calendar_view.adapter = groupCalendarAdapter
//        group_calendar_view.layoutManager = GridLayoutManager(mContext, 7, GridLayoutManager.VERTICAL, false)
//        group_calendar_view.setHasFixedSize(true)
//        groupCalendarAdapter.itemClick = object : GroupCalendarAdapter.ItemClick {
//            override fun onClick(view : View, position : Int, year : Int, month : Int, date : Int){
//                val firstDateIndex = groupCalendarAdapter.dataList.indexOf(1)
//                val lastDateIndex = groupCalendarAdapter.dataList.lastIndexOf(groupCalendarAdapter.customGroupCalendar.currentMaxDate)
//
//                if (mContext is MainActivity) {
//                    //현재 월의 1일 이전, 현재 월의 마지막일 이후는 터치 Disable
//                    if (position < firstDateIndex || position > lastDateIndex) {
//                        return
//                    }
//
//                    val intent = Intent(mContext, GroupScheduleActivity::class.java)
//                    intent.putExtra("year",year)
//                    intent.putExtra("month",month)
//                    intent.putExtra("date",date)
//                    startActivity(intent)
//
//                }
//
//
//                val day = groupCalendarAdapter.dataList[position].toString()
//                val date = "${month}월 date : ${date}일 day : ${day}일"
//                Log.d(TAG, "${date}")
//            }
//        }
    }

//    fun initCalendar(){
//        customGroupCalendar = CustomGroupCalendar(mContext, group_calendar_layout, group_calendar_view, group_calendar_year_month_text, currentDate, pageIndex, access, refresh)
//        customGroupCalendar.initBaseCalendar()
//        dateList = customGroupCalendar.dateList //CustomGroupCalendar에서 날 계산해서 받아옴
//    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    private fun getToken(){
        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)
        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)

    }

    private fun getMoimIdx(){
        val spf = requireActivity().getSharedPreferences("Moim", Context.MODE_PRIVATE)
        val editor = spf.edit()

        moimIdx = spf.getInt("moimIdx",-1)
        Log.d("MOIM_IDX", moimIdx.toString())
    }

}