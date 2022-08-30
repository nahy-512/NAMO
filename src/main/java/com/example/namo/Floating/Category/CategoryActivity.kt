package com.example.namo.Floating.Category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.R
import com.example.namo.databinding.ActivityCategoryBinding


class CategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(R.id.floating_category_frm, CategorySettingFragment())
            .commitAllowingStateLoss()

        binding.floatingCategoryDarkView.setOnClickListener {
            //닫기 전에 저장? 알리기?
            finish()
        }

    }

}