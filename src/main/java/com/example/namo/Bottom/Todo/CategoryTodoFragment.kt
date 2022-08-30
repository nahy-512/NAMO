package com.example.namo.Bottom.Todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.Data.Category.todo.CategoryContent
import com.example.namo.Floating.Todo.AddTodoActivity
import com.example.namo.Floating.Todo.NewTodoFragment
import com.example.namo.R
import com.example.namo.databinding.FragmentCategoryTodoBinding
import com.google.gson.Gson

class CategoryTodoFragment : Fragment() {
    lateinit var binding: FragmentCategoryTodoBinding
    private var categoryContentDatas = ArrayList<CategoryContent>()

    private var gson: Gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryTodoBinding.inflate(inflater, container, false)

        binding.categoryTodoCloseTv.setOnClickListener {
            (context as AddTodoActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.add_todo_frm, NewTodoFragment()).commitAllowingStateLoss()
            (context as AddTodoActivity).supportFragmentManager.popBackStack()
        }

        categoryContentDatas.apply {
            add(
                CategoryContent(
                    "할일",
                    R.color.todo
                )
            )
            add(
                CategoryContent(
                    "약속",
                    R.color.todo_assignment
                )
            )
            add(
                CategoryContent(
                    "집안일",
                    R.color.todo_housework
                )
            )
            add(
                CategoryContent(
                    "과제",
                    R.color.todo_study
                )
            )
        }

//        val categoryContentRVAdapater = CategoryContentRVAdapater(categoryContentDatas)
//        binding.categoryTodoContentRv.adapter = categoryContentRVAdapater
//        binding.categoryTodoContentRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//
//        categoryContentRVAdapater.setMyItemClickListener(object:
//            CategoryContentRVAdapater.MyItemClickListener {
//            override fun onItemClick( categoryContent: CategoryContent, position : Int) {
//                Log.d("category-todo-item", "투두 카테고리 아이템을 클릭했음")
//
//                val spf = requireActivity().getSharedPreferences("TodoCategory", Context.MODE_PRIVATE)
//                val editor = spf.edit()
//                val categoryJson = gson.toJson(categoryContent)
//                editor.putString("todoCategoryJson", categoryJson)
//                editor.putString("todoCategory",categoryContent.name)
//                editor.putInt("todoColor",categoryContent.color!!)
//                editor.putInt("todoPosition",position)
//                editor.apply()
//
//                (context as AddTodoActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.add_todo_frm, NewTodoFragment()).commitAllowingStateLoss()
//                (context as AddTodoActivity).supportFragmentManager.popBackStack()
//
//                Log.d("TODO-CATEGORY", "$categoryContent , $position")
//            }
//        })


        return binding.root
    }
}