package com.example.namo.Bottom.Home.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.namo.Bottom.Home.CalendarFragment

class CalendarPagerFragmentStateAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity){

        private val pageCount = Int.MAX_VALUE
    val homeFragmentPosition = Int.MAX_VALUE / 2

    override fun getItemCount(): Int = pageCount

    override fun createFragment(position: Int): Fragment {
        val calendarFragment = CalendarFragment(position)

        return calendarFragment
    }
}