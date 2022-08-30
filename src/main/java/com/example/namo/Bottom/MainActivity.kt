package com.example.namo.Bottom

import android.app.NotificationManager
import android.content.Intent

import android.content.res.ColorStateList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.Bottom.Todo.TodoFragment
import com.example.namo.Bottom.Custom.CustomFragment
import com.example.namo.Bottom.Diary.DiaryFragment
import com.example.namo.Bottom.Group.GroupFragment
import com.example.namo.Bottom.Home.HomeFragment
import com.example.namo.Floating.Category.CategoryActivity

import com.example.namo.Floating.Todo.AddTodoActivity
import com.example.namo.R

import com.example.namo.databinding.ActivityMainBinding
import com.jakewharton.threetenabp.AndroidThreeTen


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    private var isFabOpen:Boolean = true
    private var lastFragment : Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)
        AndroidThreeTen.init(this)
        Log.d("MAIN_LIFE","메인액티비티 온크리에이트")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        Log.d("FAB", lastFragment.toString())
        fabVisible()
        toggleFab()

        binding.fabMainFab.setOnClickListener {
            toggleFab()
        }

        binding.fabCalenderFab.setOnClickListener {
            Toast.makeText(this, "캘린더 추가 버튼 클릭", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

            toggleFab()
        }

//        binding.fabTodoFab.setOnClickListener {
//            Toast.makeText(this, "투두 추가 버튼 클릭", Toast.LENGTH_SHORT).show()
//
//
//            val intent = Intent(this, AddTodoActivity::class.java)
//            startActivity(intent)
//
//            toggleFab()
//        }

        binding.fabCategoryFab.setOnClickListener {
            Toast.makeText(this, "카테고리 추가 버튼 클릭", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)

            toggleFab()
        }

        binding.mainDarkView.setOnClickListener {
            toggleFab()
            binding.mainDarkView.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN_LIFE","메인액티비티 온스타트")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN_LIFE","메인액티비티 온리줌")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN_LIFE","메인액티비티 온포즈")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN_LIFE","메인액티비티 온스탑")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN_LIFE","메인액티비티 온디스트로이")
    }


//    override fun onResume() {
//        super.onResume()
//        Log.d("ONRESUME", "activity onResume")
//
//        binding.fabMainFab.setImageDrawable(getDrawable(R.drawable.floating_add))
//    }

    private fun fabVisible(){
//        lastFragment == ScheduleFragment() ||
        if(lastFragment == 1 ){
            Log.d("FAB", "visible")
            binding.fabCalenderFab.show()
//            binding.fabTodoFab.show()
            binding.fabCategoryFab.show()
            binding.fabMainFab.visibility = View.VISIBLE
            isFabOpen = !isFabOpen
            toggleFab()
        } else {
            Log.d("FAB", "gone")
            binding.fabCalenderFab.hide()
//            binding.fabTodoFab.hide()
            binding.fabCategoryFab.hide()
            binding.fabMainFab.visibility = View.GONE
        }


    }

    private fun toggleFab(){

        //플로팅 액션 버튼 닫기 - 열려있는 플로팅 버튼 집어넣는 애니메이션
        if(isFabOpen){
            Log.d("FabClose", "closing")
            binding.fabMainFab.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,
                R.color.MainOrange
            ))
            binding.fabMainFab.supportImageTintList = ContextCompat.getColorStateList(this,
                R.color.white
            )
            binding.mainDarkView.visibility = View.GONE
            binding.fabCalenderText.visibility = View.GONE
            binding.fabCategoryText.visibility = View.GONE
//            binding.fabTodoText.visibility = View.GONE
//            binding.fabTodoFab.hide()
            binding.fabCategoryFab.hide()
            binding.fabCalenderFab.hide()
            binding.fabMainFab.setImageResource(R.drawable.floating_add)
        }

        //플로팅 액션 버튼 열기 - 닫혀있는 플로팅 버튼 꺼내는 애니메이션
        else{
            Log.d("FabOpen", "opening")
            binding.fabMainFab.backgroundTintList = AppCompatResources.getColorStateList(this, android.R.color.black)
            binding.fabMainFab.supportImageTintList = ContextCompat.getColorStateList(this,
                R.color.white
            )
//            binding.fabCategoryFab.backgroundTintList = AppCompatResources.getColorStateList(this, android.R.color.white)
//            binding.fabCategoryFab.supportImageTintList = ContextCompat.getColorStateList(this, R.color.black)
//            binding.fabCalenderFab.backgroundTintList = AppCompatResources.getColorStateList(this, android.R.color.white)
//            binding.fabCalenderFab.supportImageTintList = ContextCompat.getColorStateList(this, R.color.black)
//            binding.fabTodoFab.backgroundTintList = AppCompatResources.getColorStateList(this, android.R.color.white)
//            binding.fabTodoFab.supportImageTintList = ContextCompat.getColorStateList(this, R.color.black)
            binding.fabMainFab.setColorFilter(getColor(R.color.MainOrange))
            binding.mainDarkView.visibility = View.VISIBLE
//            binding.fabTodoFab.show()
            binding.fabCategoryFab.show()
            binding.fabCalenderFab.show()
            binding.fabCalenderText.visibility = View.VISIBLE
            binding.fabCategoryText.visibility = View.VISIBLE
//            binding.fabTodoText.visibility = View.VISIBLE
            binding.fabMainFab.setImageResource(R.drawable.floating_add_close)
        }

        isFabOpen = !isFabOpen

    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> { //홈 화면
                    lastFragment = 1
                    Log.d("FAB", lastFragment.toString())
                    fabVisible()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
//                R.id.checklistFragment -> { //체크리스트 화면
//                    lastFragment = 2
//                    Log.d("FAB", lastFragment.toString())
//                    fabVisible()
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.main_frm, TodoFragment())
//                        .commitAllowingStateLoss()
//                    return@setOnItemSelectedListener true
//                }
                R.id.diaryFragment -> { //친구목록 화면
                    lastFragment = 3
                    Log.d("FAB", lastFragment.toString())
                    fabVisible()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, DiaryFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.groupFragment -> { //그룹목록 화면
                    lastFragment = 4
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, GroupFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.customFragment -> { //커스텀 화면
                    lastFragment = 5
                    Log.d("FAB", lastFragment.toString())
                    fabVisible()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, CustomFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}