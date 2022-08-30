package com.example.namo.Bottom.Group.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.namo.Bottom.Group.GroupCalendarFragment


//GroupCalendarWrapperFragment와 이어지는 어댑터
class GroupCalendarPagerFragmentStateAdapter(fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {

        private val pageCount = Int.MAX_VALUE
    val groupFragmentPosition = Int.MAX_VALUE / 2

    override fun getItemCount(): Int = pageCount

    override fun createFragment(position: Int): Fragment {
        val groupCalendarFragment = GroupCalendarFragment(position)

        return groupCalendarFragment
    }

}