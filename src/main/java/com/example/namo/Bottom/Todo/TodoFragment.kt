package com.example.namo.Bottom.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.Bottom.Todo.Adapter.TodoVPAdapter
import com.example.namo.databinding.FragmentTodoBinding
import com.google.android.material.tabs.TabLayoutMediator

class TodoFragment : Fragment() {

    lateinit var binding: FragmentTodoBinding

    private val information = arrayListOf("날짜", "카테고리")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)

        val todoAdapter = TodoVPAdapter(this)
        binding.todoContentVp.adapter = todoAdapter

        TabLayoutMediator(binding.todoContentTb, binding.todoContentVp){
                tab, position->
            tab.text= information[position]  //포지션에 따른 텍스트
        }.attach()  //탭레이아웃과 뷰페이저를 붙여주는 기능

        return binding.root
    }
}