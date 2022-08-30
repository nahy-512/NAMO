package com.example.namo.Floating.Category

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Data.Category.CategoryService
import com.example.namo.R
import com.example.namo.databinding.ActivityCategoryEditBinding
import com.kakao.sdk.auth.AuthApiClient

class CategoryEditActivity : AppCompatActivity(), CategoryDeleteView {

    lateinit var binding: ActivityCategoryEditBinding

    private var access : String = ""
    private var refresh : String = ""
    private var site : String = ""

    private var categoryIdx : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(R.id.floating_category_edit_frm, CategoryDetailFragment()) //수정
            .commitAllowingStateLoss()

    }

    override fun onStart() {
        super.onStart()

        //CateogrySetting에서 넘어온 리사이클러뷰 idx 받기
        val spf = getSharedPreferences("Category", Context.MODE_PRIVATE)
        val categoryJson = spf.getString("categoryJson", null)
        categoryIdx = spf.getInt("categoryIdx", 0)

        if (categoryJson != null ) {

            getToken()

            /** 3.3 카테고리 삭제 */
            binding.floatingCategoryDeleteIv.setOnClickListener {
                Log.d("DELETE-CATEGORY", "카테고리를 삭제합시다")
                Log.d("SPF-Category-Edit-ACT", "삭제 전 categoryIdx = ${categoryIdx}")
                deleteCategory() //카테고리 삭제
                finish()
            }
        }
    }

    override fun onPause() {
        super.onPause()

        Log.d("Category-Edit-ACT","포커스 잃음")

        finish()
    }

    override fun onDeleteCategorySuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Log.d("DELETE_CATEGORY_SUCCESS","SUCCESS, result : ${result}")
                Toast.makeText(this, "카테고리 삭제에 성공했습니다.\n 해당 카테고리의 일정은 기본 카테고리로 설정됩니다", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onGetCategoryFailure(code: Int, message: String) {
        Log.d("Category-EDIT-ACT/Category-RESPONSE", "${code}, ${message}")

        when(code) {
            3050 -> {
                Toast.makeText(this, "기본 카테고리는 삭제할 수 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteCategory(){ //카테고리 삭제
        val categoryService = CategoryService()
        categoryService.setCategoryDeleteView(this)

        categoryService.deleteScheduleCategory(access, categoryIdx)
        Log.d("DELETE_CATEGORY_DATA",access)
//        Log.d("DELETE_CATEGORY_DATA",refresh)
        Log.d("DELETE_CATEGORY_DATA",categoryIdx.toString())
    }

    private fun getToken() {

        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access", "")!!
        refresh = spf!!.getString("refresh", "")!!
    }
}