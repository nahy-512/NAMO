package com.example.namo.Floating.Category

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.Data.Category.*
import com.example.namo.Data.Category.todo.TodoCategoryService
import com.example.namo.R
import com.example.namo.databinding.FragmentTodoCategoryDetailBinding
import com.google.gson.Gson

class TodoCategoryDetailFragment : Fragment(),TodoCateView {
    lateinit var binding: FragmentTodoCategoryDetailBinding

    private var gson: Gson = Gson()
    private var access : String = ""
    private var refresh : String = ""
    private val todoCate= ArrayList<TodoCategory>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentTodoCategoryDetailBinding.inflate(inflater, container, false)

        binding.categoryBackIv.setOnClickListener {
            (context as CategoryActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.floating_category_frm, CategorySettingFragment())
                .commitAllowingStateLoss()
        }

        binding.categorySaveTv.setOnClickListener {
            putCategory()
        }

        getToken()

       //  binding.categoryTitleTv.setText(arguments?.getString("name"))
       //  binding.arguments?.getString("color")

        return binding.root
    }

private fun putCategory(){

    val name=binding.categoryTitleTv.text
    val categoryJson = gson.toJson(todoCate)

    val categoryService= TodoCategoryService()
    categoryService.setCateView(this)
    categoryService.putTodoCategory(access, refresh, TodoCategory(name.toString(),categoryJson) )

}

private fun getToken(){

    val spf = activity?.getSharedPreferences("prefs", Activity.MODE_PRIVATE)
    val getAcc = spf!!.getString("accessToken","")
    val getRef = spf!!.getString("refreshToken","")

    access = getAcc!!
    refresh = getRef!!

    Log.d("TOKEN-ACC",access)
    Log.d("TOKEN-REF",refresh)

}

    override fun onTodoCateSuccess(code: Int, result: CategoryResult) {

    }
}