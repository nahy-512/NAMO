package com.example.namo.Bottom.Todo.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.namo.Bottom.Todo.TodoArrayCategoryFragment
import com.example.namo.Bottom.Todo.TodoArrayDateFragment

class TodoVPAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TodoArrayDateFragment()
            else -> TodoArrayCategoryFragment()
        }
    }
}