package com.example.namo.Bottom.Todo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Home.Adapter.CategoryContentRVAdapater
import com.example.namo.Data.Category.CategoryService
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.Floating.Category.*
import com.example.namo.Floating.Category.Adapter.SetCategoryRVAdapter
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.Floating.Schedule.NewScheduleFragment
import com.example.namo.R
import com.example.namo.databinding.FragmentCategoryScheduleBinding
import com.google.gson.Gson
import com.kakao.sdk.auth.AuthApiClient

//class CategoryFragment : Fragment(), CategoryView { //일정 추가에서 카테고리 선택하는 부분
//    lateinit var binding: FragmentCategoryScheduleBinding
//
//    private lateinit var categoryListAdapter: SetCategoryRVAdapter
//    private var gson: Gson = Gson()
//
//    private var access : String = ""
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentCategoryScheduleBinding.inflate(inflater, container, false)
//
//        binding.categoryCloseTv.setOnClickListener {
//            (context as AddActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.add_frm, NewScheduleFragment()).commitAllowingStateLoss() //닫기
//            (context as AddActivity).supportFragmentManager.popBackStack()
//        }
//
//        binding.categoryEditLl.setOnClickListener {
//            (context as AddActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.add_frm, CategorySettingFragment()).commitAllowingStateLoss() //카테고리 편집으로 이동
//            (context as AddActivity).supportFragmentManager.popBackStack()
//        }
//
//
//        return binding.root
//    }
//
//    override fun onStart() {
//        super.onStart()
//        getToken() //토큰 집어넣기
//        getCategorys() //카테고리 가져오기
//    }
//
//    //리사이클러뷰 어댑터 연결
//    private fun initRecyclerView(result: ArrayList<InquiryCategoryInfo>) {
//
//        val categoryListAdapter = CategoryContentRVAdapater(requireContext(), result)
//
//        //자꾸 오류나서 주석
////        binding.categoryContentRv.adapter = categoryListAdapter
////        binding.categoryContentRv.layoutManager =
////            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//
//        //아이템 클릭
//        categoryListAdapter.setMyItemClickListener(object : CategoryContentRVAdapater.MyItemClickListener {
//            override fun onItemClick(category: InquiryCategoryInfo, position: Int) {
//                Log.e("SCHEDULE-CATEGORY", "$category , $position")
//                Log.d("category-item", "카테고리 아이템을 클릭했음")
//
//                //카테고리 클릭하면 NewScheduleFragment로 데이터 보냄 (코코아)
//                val spf = requireActivity().getSharedPreferences("ScheduleCategory", Context.MODE_PRIVATE)
//                val editor = spf.edit()
//                val categoryJson = gson.toJson(category)
//
//                editor.putString("scheduleCategoryJson", categoryJson)
//                editor.putInt("scheduleCategoryIdx",category.categoryIdx)
//                editor.putString("scheduleCategory",category.name)
//                editor.putString("scheduleColor",category.color.toString())
//                editor.putInt("categoryPosition",position)
//                editor.apply()
//
//                Log.d("spf-category", "보내는 쪽 ${spf.getInt("scheduleCategoryIdx", 0)}, ${spf.getString("scheduleCategory", "")}, ${spf.getString("scheduleColor", "")}, position = ${spf.getInt("categoryPosition", 0)} ")
//
//                (context as AddActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.add_frm, NewScheduleFragment()).commitAllowingStateLoss()
//                (context as AddActivity).supportFragmentManager.popBackStack()
//
//            }
//        })
//
//
//    }
//
//    private fun getCategorys() {
//        val categoryService = CategoryService()
//        categoryService.setCategoryView(this)
//
//        categoryService.getAllScheduleCategory(access)
//
//        Log.d("Category-Schedule-FRAG/ACCESS",access)
//    }
//
//    /** 3.5 카테고리 리스트 전체 조회 */
//    override fun onGetAllCategorySuccess(code: Int, results: ArrayList<InquiryCategoryInfo>) {
//        binding.categoryLoadingPb.visibility= View.GONE
////        initRecyclerView(results)
//    }
//
//    override fun onGetCategoryLoading() {
//        binding.categoryLoadingPb.visibility= View.VISIBLE
//    }
//
//    override fun onGetCategoryFailure(code: Int, message: String) {
//        Log.d("Category-Schedule-FRAG/Category-RESPONSE", "${code}, ${message}")
//    }
//
//    private fun getToken(){
//
//        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)
//
//        access = spf!!.getString("access","")!!
//
//        Log.d("Category-Schedule-FRAG/TOKEN-ACC",access)
//
//    }

//}