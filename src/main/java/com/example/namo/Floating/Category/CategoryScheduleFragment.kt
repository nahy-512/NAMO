package com.example.namo.Bottom.Todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Home.Adapter.CategoryContentRVAdapater
import com.example.namo.Bottom.Home.EditScheduleActivity
import com.example.namo.Bottom.Home.EditScheduleFragment
import com.example.namo.Data.Category.CategoryService
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.Data.Login.GlobalApplication
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.TempSchedule
import com.example.namo.Floating.Category.*
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.Floating.Schedule.NewScheduleFragment
import com.example.namo.R
import com.example.namo.databinding.FragmentCategoryScheduleBinding
import com.google.gson.Gson
import com.kakao.sdk.auth.AuthApiClient


class CategoryScheduleFragment(val pos : Int, val schedule : GetScheduleRes, tempSchedule: TempSchedule) : Fragment(), CategoryView { //일정 추가에서 카테고리 선택하는 부분

    private val global = GlobalApplication()

    lateinit var binding: FragmentCategoryScheduleBinding

    private var gson: Gson = Gson()

    private var access : String = ""

    private var tempSchedule = tempSchedule

    companion object {
        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryScheduleBinding.inflate(inflater, container, false)

        binding.categoryCloseTv.setOnClickListener {
            if (pos == 0){
                (context as AddActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.add_frm, NewScheduleFragment()).commitAllowingStateLoss()
                (context as AddActivity).supportFragmentManager.popBackStack()
            }
            else if (pos == 1){
                (context as EditScheduleActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.edit_frm, EditScheduleFragment(schedule)).commitAllowingStateLoss()
                (context as EditScheduleActivity).supportFragmentManager.popBackStack()
            }
        }

        moveToCategoryEdit() //카테고리 편집으로 이동

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        getToken() //토큰 집어넣기
    }

    override fun onResume() {
        super.onResume()
        getCategorys() //카테고리 가져오기
    }

    //리사이클러뷰 어댑터 연결
    private fun initRecyclerView(result: ArrayList<InquiryCategoryInfo>) {

        val categoryListAdapter = CategoryContentRVAdapater(requireContext(), result)
        binding.categoryContentRv.adapter = categoryListAdapter
        binding.categoryContentRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //아이템 클릭
        categoryListAdapter.setMyItemClickListener(object : CategoryContentRVAdapater.MyItemClickListener {
            override fun onItemClick(category: InquiryCategoryInfo, position: Int) {
                Log.e("SCHEDULE-CATEGORY", "$category , $position")
                Log.d("category-item", "카테고리 아이템을 클릭했음")

                //카테고리 클릭하면 NewScheduleFragment로 데이터 보냄 (코코아)
                val spf = requireActivity().getSharedPreferences("ScheduleCategory", Context.MODE_PRIVATE)
                val editor = spf.edit()
                val categoryJson = gson.toJson(category)

                editor.putString("scheduleCategoryJson", categoryJson)
                editor.putInt("scheduleCategoryIdx",category.categoryIdx)
                editor.putString("scheduleCategory",category.name)
                editor.putString("scheduleColor",category.color.toString())
                editor.putInt("categoryPosition",position)
                editor.apply()

                Log.d("spf-category", "보내는 쪽 ${spf.getInt("scheduleCategoryIdx", 0)}, ${spf.getString("scheduleCategory", "")}, ${spf.getString("scheduleColor", "")}, position = ${spf.getInt("categoryPosition", 0)} ")

                tempSchedule.categoryName = category.name
                tempSchedule.categoryColor = Color.parseColor(category.color)
                tempSchedule.categoryIdx = category.categoryIdx
                putPref()

                if (pos == 0){
                    (context as AddActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.add_frm, NewScheduleFragment()).commitAllowingStateLoss()
                    (context as AddActivity).supportFragmentManager.popBackStack()
                }
                else if (pos == 1){
                    (context as EditScheduleActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.edit_frm, EditScheduleFragment(schedule)).commitAllowingStateLoss()
                    (context as EditScheduleActivity).supportFragmentManager.popBackStack()
                }

            }
        })


    }

    private fun moveToCategoryEdit() {
        binding.categoryEditLl.setOnClickListener {
            startActivity(Intent(activity, CategoryActivity::class.java))
        }
    }

    private fun putPref(){
        val sharedPreferences = requireActivity().getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(tempSchedule)
        editor.putString(KEY_DATA, json)
        editor.apply()
        Log.d("CATEGORY_PREF", tempSchedule.toString())
    }


    private fun getCategorys() {
        val categoryService = CategoryService()
        categoryService.setCategoryView(this)

        categoryService.getAllScheduleCategory(access)
    }

    /** 3.5 카테고리 리스트 전체 조회 */
    override fun onGetAllCategorySuccess(code: Int, results: ArrayList<InquiryCategoryInfo>) {
        binding.categoryLoadingPb.visibility= View.GONE
        initRecyclerView(results)
    }

    override fun onGetCategoryLoading() {
        binding.categoryLoadingPb.visibility= View.VISIBLE
    }

    override fun onGetCategoryFailure(code: Int, message: String) {
        Log.d("Category-Schedule-FRAG/Category-RESPONSE", "${code}, ${message}")
    }

    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("Category-Schedule-FRAG/TOKEN-ACC",access)

    }

}