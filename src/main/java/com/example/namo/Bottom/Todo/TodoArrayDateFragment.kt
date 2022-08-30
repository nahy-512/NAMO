package com.example.namo.Bottom.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.namo.Data.Todo.CalendarDateModel
import com.example.namo.Data.Todo.Todo
import com.example.namo.R
import com.example.namo.Bottom.Todo.Adapter.TodoCalendarWeekRVAdapter
import com.example.namo.Bottom.Todo.Adapter.TodoDateRVAdapter
import com.example.namo.databinding.FragmentTodoArrayDateBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TodoArrayDateFragment : Fragment() {

    private var todoDDatas = ArrayList<Todo>()
    lateinit var binding: FragmentTodoArrayDateBinding

    //캘린더뷰
    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: TodoCalendarWeekRVAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentTodoArrayDateBinding.inflate(inflater, container, false)

        /* 한줄 캘린더 */
        setUpAdapter()
        setUpClickListener()
        setUpCalendar()

        applyTodoData() //To-do 리사이클러뷰


        return binding.root
    }


    /**
     * Set up click listener
     */
    private fun setUpClickListener() {
        binding.todoDateCalendarNextIv.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        binding.todoDateCalendarPreviousIv.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
    }

    /**
     * Setting up adapter for recyclerview
     */
    private fun setUpAdapter() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.single_calendar_margin)
        binding.todoDateCalendarRv.addItemDecoration(HorizontalItemDecoration(spacingInPixels))
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.todoDateCalendarRv)
        adapter = TodoCalendarWeekRVAdapter { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)
        }
        binding.todoDateCalendarRv.adapter = adapter
    }

    /**
     * Function to setup calendar for every month
     */
    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()
        binding.todoDateMonthTv.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH) // This code will get maximum no. of days in the current month
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
    }


    /** 날짜별 To-do 리스트 리사이클러뷰(세로 스크롤) */
    private fun applyTodoData() {
        // 어댑터와 데이터리스트 연결
        val todoRVAdapter = TodoDateRVAdapter(todoDDatas) //매개변수로 만들었던 데이터리스트를 던져줌
        binding.todoDateRv.adapter = todoRVAdapter //리사이클러뷰에 어댑터 연결
        binding.todoDateRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //레이아웃매니저 설정

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        todoDDatas.apply {
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022-07-30"))
//            add(Todo(todoTop = "할일", todoContent = "2주차 계획 노션 정리하기"))
//            add(Todo(todoTop = "할일", todoContent = "자동 로그인 구현하기"))
        }
    }

    /* To-do 완료 체크 */
    private fun checkTodo() {
        var isCheck: Boolean = false //완료 X

//        //체크 누르면 표시
//        if (isCheck == false) {
//            binding.todoDate1Bt.setOnClickListener {
//                isCheck = true
//                binding.todoDate1Bt.setImageResource(R.drawable.ic_todo_circle_check)
//            }
//        }
//        //한번 더 누르면 신청 취소
//        binding.todoDate1Bt.setOnClickListener {
//            isCheck = false
//            binding.todoDate1Bt.setImageResource(R.drawable.ic_todo_circle_uncheck)
//        }
    }
}