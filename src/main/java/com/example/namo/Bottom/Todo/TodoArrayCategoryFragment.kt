package com.example.namo.Bottom.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Data.Todo.Todo
import com.example.namo.R
import com.example.namo.Bottom.Todo.Adapter.TodoCategoryRVAdapter
import com.example.namo.Bottom.Todo.Adapter.TodoListRVAdapter
import com.example.namo.databinding.FragmentTodoArrayCategoryBinding

class TodoArrayCategoryFragment : Fragment() {

    private var todoCategoryDatas = ArrayList<Todo>()
    private var todoCDatas = ArrayList<Todo>()
    lateinit var binding : FragmentTodoArrayCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentTodoArrayCategoryBinding.inflate(inflater, container, false)

        applyCategoryData() //카테고리 리사이클러뷰
        applyTodoData() //카테고리별 To-do 리스트 리사이클러뷰

        return binding.root
    }

    /* 카테고리 리사이클러뷰(가로 스크롤) */
    private fun applyCategoryData() {
        // 어댑터와 데이터리스트 연결
        val categoryRVAdapter = TodoCategoryRVAdapter(todoCategoryDatas) //매개변수로 만들었던 데이터리스트를 던져줌
        binding.todoCategoryCategoryRv.adapter = categoryRVAdapter //리사이클러뷰에 어댑터 연결
        binding.todoCategoryCategoryRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) //레이아웃매니저 설정

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        todoCategoryDatas.apply {
            add(Todo("할일"))
            add(Todo("과제"))
            add(Todo("집안일"))
            add(Todo("공부"))
        }
    }

    /* 카테고리별 To-do 리스트 리사이클러뷰(세로 스크롤) */
    private fun applyTodoData() {
        // 어댑터와 데이터리스트 연결
        val todoRVAdapter = TodoListRVAdapter(todoCDatas) //매개변수로 만들었던 데이터리스트를 던져줌
        binding.todoCategoryTodolistRv.adapter = todoRVAdapter //리사이클러뷰에 어댑터 연결
        binding.todoCategoryTodolistRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //레이아웃매니저 설정

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        todoCDatas.apply {
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022/07/02"))
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022/07/02"))
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022/07/02"))
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022/07/02"))
            add(Todo("UMC 해커톤 구글폼 제출", 1, "2022/07/02"))
        }
    }
}

