package com.example.namo.Bottom.Home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namo.Bottom.Home.Adapter.CalendarAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentCalendarBinding
import com.kakao.sdk.auth.AuthApiClient
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarFragment(index : Int) : Fragment() {
    private val TAG = javaClass.simpleName
    lateinit var mContext : Context
    lateinit var mActivity : MainActivity

    var pageIndex = index
    lateinit var currentDate : Date

    lateinit var calendar_year_month_text : TextView
    lateinit var calendar_layout : LinearLayout
    lateinit var calendar_view : RecyclerView
    lateinit var calendarAdapter : CalendarAdapter

    lateinit var binding : FragmentCalendarBinding

    lateinit var customCalendar : CustomCalendar
    var dateList : ArrayList<Int> = arrayListOf()

    private var access = ""


    companion object {
        var instance : CalendarFragment? = null
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
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        binding = FragmentCalendarBinding.inflate(inflater, container, false)

        getToken()
        initView(view)
//        initCalendar()

//        Log.d("ONCREATEVIEW_CALENDAR_LIFE", "온크리에이트뷰 캘린더")

        return view
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d("ONSTART_CALENDAR_LIFE", "온스타트 캘린더")
//
//    }

    override fun onResume() {
        super.onResume()
//        Log.d("ONRESUME_CALENDAR_LIFE", "온리줌 캘린더")
        initCalendar()

    }

//    override fun onPause() {
//        super.onPause()
//
//        Log.d("ONPAUSE_CALENDAR_LIFE", "온포즈 캘린더")
//    }

//    override fun onStop() {
//        super.onStop()
//
//        Log.d("ONSTOP_CALENDAR_LIFE_LIFE", "온스탑 캘린더")
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        Log.d("ONACTIVITYCREATED_CALENDAR_LIFE", "온액티비티크리에이티드 캘린더")
//    }

    fun initView(view : View){
        pageIndex -= (Int.MAX_VALUE/2)
        Log.e(TAG, "Calendar Index : $pageIndex")
        calendar_year_month_text = view.calendar_year_month_text
        calendar_layout = view.calendar_layout
        calendar_view = view.calendar_view

        //날짜 적용
        val date = Calendar.getInstance().run {
            add(Calendar.MONTH, pageIndex)
            time
        }
        currentDate = date
        Log.e(TAG, "$date")

        //포맷 적용
        var dateTime : String = SimpleDateFormat(
            mContext.getString(R.string.calendar_year_month_format),
            Locale.KOREA
        ).format(date.time)
        calendar_year_month_text.setText(dateTime)

    }

    fun initCalendar() {

        customCalendar = CustomCalendar(mContext, calendar_layout, calendar_view, calendar_year_month_text, currentDate, pageIndex, access)
        customCalendar.initBaseCalendar()
        dateList = customCalendar.dateList

//        calendarAdapter = CalendarAdapter(mContext, calendar_layout, currentDate, access, refresh)
//        calendar_view.adapter = calendarAdapter
//        calendar_view.layoutManager = GridLayoutManager(mContext, 7, GridLayoutManager.VERTICAL, false)
//        calendar_view.setHasFixedSize(true)
//        calendarAdapter.itemClick = object : CalendarAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val firstDateIndex = calendarAdapter.dataList.indexOf(1)
//                val lastDateIndex = calendarAdapter.dataList.lastIndexOf(calendarAdapter.customCalendar.currentMaxDate)
//                //현재 월의 1일 이전, 현재 월의 마지막일 이후는 터치 Disable
//                if (position < firstDateIndex || position > lastDateIndex){
//                    return
//                }
//                val day = calendarAdapter.dataList[position].toString()
//                val date = "${calendar_year_month_text}${day}일"
//                Log.d(TAG, "${date}")
//
//            }
//        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d("ONDESTROYVIEW_CALENDAR_LIFE", "온디스트로이뷰 캘린더")
//    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
//        Log.d("ONDESTROY_CALENDAR_LIFE", "온디스트로이 캘린더")
    }


    private fun getToken(){
        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)
        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)

    }
}