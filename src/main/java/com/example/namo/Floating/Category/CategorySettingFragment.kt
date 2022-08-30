package com.example.namo.Floating.Category

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.namo.Data.Category.CategoryService
import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.Floating.Category.Adapter.SetCategoryRVAdapter
import com.example.namo.R
import com.example.namo.databinding.FragmentCategorySettingBinding
import com.google.gson.Gson
import com.kakao.sdk.auth.AuthApiClient

class CategorySettingFragment: Fragment(), CategoryView {

    lateinit var binding : FragmentCategorySettingBinding //플로팅 카테고리 설정 화면

    private lateinit var categoryListAdapter: SetCategoryRVAdapter
    private var gson: Gson = Gson()

    private var access : String = ""
    private var refresh : String = ""
    private var site : String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCategorySettingBinding.inflate(inflater, container, false)


        binding.categoryCloseTv.setOnClickListener {
            activity?.finish() //닫힘 버튼 누르면 종료
        }

        binding.categoryDetailSaveTv.setOnClickListener {
            //할 필요가 있나?
            activity?.finish()
        }

        binding.categoryCalendarPaletteSetting.setOnClickListener {
            //팔레트 설정
        }

        /** 새 카테고리 추가 */
        binding.categoryCatenderAddBtn.setOnClickListener {
            //spf 초기화
            val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
            val editor = spf.edit()

            spf.edit().clear().commit()

            editor.putInt("edit", 0) // 화면 넘어가면 edit & delete 불가능 (post만)

            Log.d("Category-Set-FRAG", "카테고리 추가를 클릭했음")
            Log.d("spf-category", "edit(T/F) = ${spf.getInt("edit", 0)}")

            (context as CategoryActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.floating_category_frm, CategoryDetailFragment())
                .commitAllowingStateLoss()
        }


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
        categoryListAdapter = SetCategoryRVAdapter(requireContext(), result)

        binding.categoryCalendarRv.adapter= categoryListAdapter
        binding.categoryCalendarRv.layoutManager = GridLayoutManager(context, 2)

        //아이템 클릭
        categoryListAdapter.setMyItemClickListener(object: SetCategoryRVAdapter.MyItemClickListener {
            override fun onItemClick(category: InquiryCategoryInfo, position: Int) {
                Log.d("Category-Set-FRAG", "카테고리 아이템을 클릭했음")
                Log.e("SET-CATEGORY", "$category , $position")

                val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
                val editor = spf.edit()
                val categoryJson = gson.toJson(category)

                editor.putString("categoryJson", categoryJson)
                editor.putInt("categoryIdx", category.categoryIdx)
                editor.putString("category",category.name)
                editor.putString("color",category.color!!)
                editor.putInt("share",category.share)
                editor.putInt("position",position)
                editor.putInt("edit", 1) // 화면 넘어가면 edit & delete 가능
                editor.apply()

                Log.d("spf-category", "${spf.getInt("categoryIdx", 0)}, ${spf.getString("category", "")}, ${spf.getString("color", "")}")
                Log.d("spf-category", "edit(T/F) = ${spf.getInt("edit", 0)}")

                val intent = Intent(getActivity(), CategoryEditActivity::class.java)
                startActivity(intent)
//                (context as CategoryEditActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.floating_category_edit_frm, CategoryDetailFragment()).commitAllowingStateLoss()
//                (context as CategoryEditActivity).supportFragmentManager.popBackStack()


            }
        })
    }

    private fun getCategorys() {
        val categoryService = CategoryService()
        categoryService.setCategoryView(this)

        categoryService.getAllScheduleCategory(access)

        Log.d("DELETE_CATEGORY_DATA",access)
//        Log.d("DELETE_CATEGORY_DATA",refresh)
//        Log.d("DELETE_CATEGORY_DATA",site)
    }

    override fun onGetCategoryLoading() {
        binding.categoryLoadingPb.visibility= View.VISIBLE
    }

    //3.5 카테고리 전체 조회
    override fun onGetAllCategorySuccess(code: Int, result: ArrayList<InquiryCategoryInfo>) {
        binding.categoryLoadingPb.visibility= View.GONE
        initRecyclerView(result)
    }

    //성공시
    override fun onGetCategoryFailure(code: Int, message: String) {
        binding.categoryLoadingPb.visibility= View.GONE
        Log.d("Category-FRAG/Category-RESPONSE", message)
    }


    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!
        refresh = spf!!.getString("refresh","")!!

//        if (AuthApiClient.instance.hasToken()) {  //발급받은 카카오 토큰이 있는 지 확인
//            Log.d("Catory-TOKEN", "Kakao")
//            access = spf!!.getString("accessToken","")!!
//            refresh = spf!!.getString("refreshToken","")!!
//            site = "kakao"
//        }
//        else { //발급받은 토큰이 없으면 네이버
//            Log.d("Category-TOKEN", "Naver")
//            access = spf!!.getString("accessToken2","")!!
//            refresh = spf!!.getString("refreshToken2","")!!
//            site = "naver"
//        }
//        Log.d("Category-TOKEN-ACC",access)
//        Log.d("Category-TOKEN-REF",refresh)
//        Log.d("Category-TOKEN-SITE",site)
    }

}