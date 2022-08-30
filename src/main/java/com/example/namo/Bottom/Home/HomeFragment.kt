package com.example.namo.Bottom.Home



import android.app.Activity
import android.content.Context
import android.os.Bundle

import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.Bottom.Home.Adapter.CalendarPagerFragmentStateAdapter
//import com.example.namo.Data.Schedule.ScheduleService
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.*
import com.example.namo.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.view.*


import java.util.*


class HomeFragment() : Fragment() {

    private val TAG = javaClass.simpleName
    lateinit var mContext : Context

    lateinit var calendarViewPager : ViewPager2

    companion object {
        var instance : HomeFragment? = null
    }

    lateinit var binding: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity){
            mContext = context
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
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //캘린더 뷰페이저
        calendarViewPager = view.calendarViewPager

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }

    private fun initView(){
        val calendarPagerFragmentStateAdapter = CalendarPagerFragmentStateAdapter(requireActivity())
        calendarViewPager.adapter = calendarPagerFragmentStateAdapter
        calendarViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        calendarPagerFragmentStateAdapter.apply {
            calendarViewPager.setCurrentItem(this.homeFragmentPosition, false)
        }
    }

}