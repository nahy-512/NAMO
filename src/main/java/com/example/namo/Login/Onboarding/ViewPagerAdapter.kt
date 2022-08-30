package com.example.namo.Login.Onboarding

import android.view.ViewGroup
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    list: ArrayList<Fragment>,
    fm:FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {


    val fragmentList = list

    inner class ViewPagerViewHolder()

    override fun getItemCount(): Int {
        return fragmentList.size //온보딩 화면 개수
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}