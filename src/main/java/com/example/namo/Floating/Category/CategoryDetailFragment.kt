package com.example.namo.Floating.Category

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.namo.Data.Category.*
import com.example.namo.Floating.Category.Adapter.CategotyPaletteRVAdapter
import com.example.namo.R
import com.example.namo.databinding.FragmentCategoryDetailBinding
import com.google.gson.Gson


class CategoryDetailFragment: Fragment(), CategoryDetailView { //카테고리 추가
    lateinit var binding: FragmentCategoryDetailBinding
    private var gson: Gson = Gson()

    private var access : String = ""
    private var refresh : String = ""
    private var site : String = "" //카카오랑 네이버 구별

    private var categoryIdx : Int = 0

    //팔레트 아이템 position
    private var pos = 0

    //카테고리 생성한 or 수정한
    lateinit var category : ScheduleCategory
    lateinit var editCategory : EditScheduleCategory
    private var name : String = ""
    private var color : String = ""
    private var share = 1

    //카테고리 받아온
    private var editName : String = ""
    private var editColor : String = ""
    private var editShare = 1

    //팔레트
    var paletteDatas = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)

        //CategorySetting에서 넘어온 SharedPreference
        val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
        val categoryJson = spf.getString("categoryJson", null)
        val edit = spf.getInt("edit", 0)

        Log.e("SPF-CATEGORY-EDIT-Start", "edit (T/F) = ${spf.getInt("edit",0)}")


        onClickBackIv() // 뒤로가기

        onClickSaveIv() // 저장시

//        paletteRV() //팔레트 리사이클러뷰

        // 기본색상 선택 */
        setColor()

        // 팔레트 색상 선택 */
        setPaletteColor()


        // 카테고리 공유 여부 */
        binding.categoryToggleIv.setOnClickListener {
            setToggle()
        }

        getToken()

        return binding.root
    }


    override fun onStart() {
        super.onStart()

        //CategorySetting에서 넘어온 SharedPreference
        val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
        val edit = spf.getInt("edit", 0)

        if ( edit == 1 ) { // 데이터 조회 후 바인딩

            Log.d("Category", "카테고리 수정 모드입니다")
            inquiryCategoryData() //조회 먼저


        }

    }

    override fun onStop() {
        super.onStop()

        val pref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("name",name).apply()
        editor.putString("color",color).apply()
        editor.putInt("share", share).apply()
        Log.d("CATEGORY-ONSTOP", "onStop, $name, $color, $share")

    }


    //팔레트 리사뷰
    private fun paletteRV() {

        paletteDatas.apply {
            add("#EB5353");add("#EC9B3B");add("#FBCB0A");add("#96BB7C");add("#5A8F7B")
            add("#82C4C3");add("#187498");add("#8571BF");add("#E36488");add("#858585")
        }

        val categoryDetailRVAdapter = CategotyPaletteRVAdapter(paletteDatas) // 더미데이터랑 Adapter 연결
//        binding.categoryNewPaletteRv.adapter = categoryDetailRVAdapter // 리사이클러뷰에 어댑터를 연결
//        binding.categoryNewPaletteRv.layoutManager = GridLayoutManager(context, 5)

        categoryDetailRVAdapter.setMyItemClickListener(object: CategotyPaletteRVAdapter.MyPaletteItemClickListener {
            override fun onItemClick(position: Int) {
                pos = position
                Log.d("CategoryDetailFrag", "click-position: $pos")
                Clear() //기본 색상 선택 취소
                getPaletteColor()
                Log.d("CategoryDetailFrag", "color = $color")

            }
        })

    }

    //팔레트 색상 가져오기
    fun getPaletteColor() {
        if (pos == 0) {
            color = "#EB5353"
        } else if (pos == 1)
            color = "#EC9B3B"
        else if (pos == 2)
            color = "#FBCB0A"
        else if (pos == 3)
            color = "#96BB7C"
        else if (pos == 4)
            color = "#5A8F7B"
        else if (pos == 5)
            color = "#82C4C3"
        else if (pos == 6)
            color = "#187498"
        else if (pos == 7)
            color = "#8571BF"
        else if (pos == 8)
            color = "#E36488"
        else if (pos == 9)
            color = "#858585"
    }

    private fun onClickBackIv() { //뒤로 가기
        binding.categoryDetailBackIv.setOnClickListener {

            //CategorySetting에서 넘어온 SharedPreference
            val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
            val categoryJson = spf.getString("categoryJson", null)
            val edit = spf.getInt("edit", 0)

            if (categoryJson != null && edit == 1){

                Log.d("SPF-CATEGORY-EDIT", "${edit}")
                spf.edit().clear().commit()
                Log.d("SPF-CATEGORY2-EDIT", "${spf.getInt("edit",0)}")

                val intent = Intent(getActivity(), CategoryActivity::class.java) //리사이클러뷰에서 넘어온 값(CategoryEditActivity)
                startActivity(intent)
            } else {
                (context as CategoryActivity).supportFragmentManager.beginTransaction() //
                    .replace(R.id.floating_category_frm, CategorySettingFragment())
                    .commitAllowingStateLoss()
            }
        }
    }

    private fun onClickSaveIv() {

        binding.categoryDetailSaveTv.setOnClickListener {
            //CategorySetting에서 넘어온 SharedPreference
            val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
//            val categoryJson = spf.getString("categoryJson", null)
            val edit = spf.getInt("edit", 0)

            if ( edit == 0 ) { // 새 카테고리 생성

                Log.d("Category", "새 카테고리 생성입니다.")

                if(binding.categoryDetailTitleTv.text.toString().isEmpty()){
                    Toast.makeText(context as CategoryActivity, "카테고리 이름을 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                else if (color.length <= 1) {
                    Toast.makeText(context as CategoryActivity, "카테고리 색을 선택해주세요", Toast.LENGTH_SHORT).show()
                }
                else{
                    name = binding.categoryDetailTitleTv.text.toString()
                    Log.d("SEND-CATEGORY", "name : ${name}, color : ${color}, share : ${share}")
                    category = ScheduleCategory(name, color, share)
                    inputCategoryData()
                    (context as CategoryActivity).supportFragmentManager.beginTransaction() //
                        .replace(R.id.floating_category_frm, CategorySettingFragment())
                        .commitAllowingStateLoss()
//                    activity?.finish()
                }


            } else { // 카테고리 수정

                Log.d("Category", "카테고리 수정으로 넘어갑니다")

                name = binding.categoryDetailTitleTv.text.toString()
                setColor()
                binding.categoryToggleIv.setOnClickListener { setToggle() }


                if( (name == editName) && (color == editColor) && (share == editShare)){
                    Toast.makeText(context as CategoryEditActivity, "수정 사항이 없습니다", Toast.LENGTH_SHORT).show()
                }
                else{
                    Log.d("Edit-CATEGORY", "name : ${name}, color : ${color}, share : ${share}")
                    editCategory = EditScheduleCategory(categoryIdx, name, color, share)
                    editCategoryData()
                    activity?.finish()
                }
            }

        }
    }

    /** API 연동 함수 */

    private fun inputCategoryData(){ // 3.1 카테고리 생성
        val categoryService = CategoryService()
        categoryService.setCategorySetView(this)

        categoryService.postScheduleCategory(access, category)
        Log.d("GET_CATEGORY_DATA",access)
//        Log.d("GET_CATEGORY_DATA",refresh)
        Log.d("GET_CATEGORY_DATA",category.toString())
    }

    private fun inquiryCategoryData(){ // 3.4 카테고리 조회
        val categoryService = CategoryService()
        categoryService.setCategorySetView(this)
        Log.d("inquiryCategoryData()", "카테고리 조회를 시작합니다")

        //CateogrySetting에서 넘어온 리사이클러뷰 idx 받기
        val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
        categoryIdx = spf.getInt("categoryIdx", 0)
        Log.d("SPF-Category-Detail-FRAG", "넘어온 categoryIdx = ${categoryIdx}")

        categoryService.getScheduleCategory(access, categoryIdx)
        Log.d("INQUIRY_CATEGORY_DATA",access)
        Log.d("INQUIRY_CATEGORY_DATA",categoryIdx.toString())
    }

    private fun editCategoryData(){ // 3.2 카테고리 수정
        val categoryService = CategoryService()
        categoryService.setCategorySetView(this)

//        //CateogrySetting에서 넘어온 리사이클러뷰 idx 받기
//        val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
//        categoryIdx = spf.getInt("categoryIdx", 0)
//        Log.d("SPF-Category-Detail-FRAG", "넘어온 categoryIdx = ${categoryIdx}")

        categoryService.editScheduleCategory(access, editCategory)
        Log.d("EDIT_CATEGORY_DATA",access)
        Log.d("EDIT_CATEGORY_DATA",editCategory.toString())
    }

    //3.1 카테고리 생성
    override fun onInputCategorySuccess(code: Int, result: PostCategoryResult) {
        when(code){
            1000 -> {
                Log.d("ONINPUT_CATEGORY_SUCCESS","SUCCESS, result : ${result.categoryIdx}")
                activity?.finish()
            }
        }
    }

    //3.2 카테고리 수정
    override fun onEditCategorySuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Toast.makeText(context, "카테고리 수정에 성공했습니다.", Toast.LENGTH_SHORT).show()
                Log.d("ONEDIT_CATEGORY_SUCCESS","SUCCESS, result : ${result}")
                activity?.finish()
            }
        }
    }

    //3.4 카테고리 하나 조회
    override fun onGetCategorySuccess(code: Int, results: InquiryCategoryResult) {
        when(code){
            1000 -> {
//                Toast.makeText(context, "카테고리 조회에 성공했습니다.", Toast.LENGTH_SHORT).show()
                Log.d("ONINQUIRY_CATEGORY_SUCCESS","SUCCESS, result : ${results}")
                editName = results.name
                editColor = results.color
                editShare = results.share

                //데이터 초기화
                name = editName
                color = editColor
                share = editShare

                Log.d("ONINQUIRY_CATEGORY_RESULT","editName : ${editName}, editColor : ${editColor}, editShare : ${editShare}")
//                Log.d("CategoryInfo", "name = $name, editName = $editName")
//                Log.d("CategoryInfo", "color = $color, editColor = $editColor")
//                Log.d("CategoryInfo", "share = $share, editShare = $editShare")

                setItemData()

            }
        }
    }

    //실패시
    override fun onGetCategoryFailure(code: Int, message: String) {
        Log.d("Category-DETAIL-FRAG/Category-RESPONSE", "${code}, ${message}")

        when(code) {
            3016 -> {   //3016이면 access 만료된 거라 refresh 가지고 다시 받아와야 함
                //이거 그냥 앱 실행할 때 refresh로 access 무조건 받아오는 걸로
            }
            3049 -> {
                Toast.makeText(context as CategoryEditActivity, "기본 카테고리의 조작 권한이 없습니다", Toast.LENGTH_SHORT).show()
            }

        }
    }


    /** 리사이클러뷰에서 넘어온 데이터 반영 함수 -> 조회에서 쓰일 거 */

    private fun setItemData() { //아이템에서 넘어온 데이터를 바인딩 해봅시다

        binding.categoryDetailTitleTv.setText(editName) //name

        setItemColor() //color

        if (editShare == 0)  //share
            binding.categoryToggleIv.setImageResource(R.drawable.ic_toggle_off)

    }

    private fun setItemColor() { //아이템에서 넘어온 색 체크 표시
        when(editColor) {
            "#DE8989" -> binding.scheduleColorSelectIv.visibility = View.VISIBLE
            "#E1B000" -> binding.schedulePlanColorSelectIv.visibility = View.VISIBLE
            "#5C8596" -> binding.scheduleParttimeColorSelectIv.visibility = View.VISIBLE
            "#DA6022" -> binding.scheduleGroupColorSelectIv.visibility = View.VISIBLE
            //팔레트 컬러
            "#EB5353" -> {
                binding.categoryPaletteSelectIv1.visibility = View.VISIBLE
                pos = 1
            }
            "#EC9B3B" -> {
                binding.categoryPaletteSelectIv2.visibility = View.VISIBLE
                pos = 2
            }
            "#FBCB0A" -> {
                binding.categoryPaletteSelectIv3.visibility = View.VISIBLE
                pos = 3
            }
            "#96BB7C" -> {
                binding.categoryPaletteSelectIv4.visibility = View.VISIBLE
                pos = 4
            }
            "#5A8F7B" -> {
                binding.categoryPaletteSelectIv5.visibility = View.VISIBLE
                pos = 5
            }
            "#82C4C3" -> {
                binding.categoryPaletteSelectIv6.visibility = View.VISIBLE
                pos = 6
            }
            "#187498" -> {
                binding.categoryPaletteSelectIv7.visibility = View.VISIBLE
                pos = 7
            }
            "#8571BF" -> {
                binding.categoryPaletteSelectIv8.visibility = View.VISIBLE
                pos = 8
            }
            "#E36488" -> {
                binding.categoryPaletteSelectIv9.visibility = View.VISIBLE
                pos = 9
            }
            "#858585" -> {
                binding.categoryPaletteSelectIv10.visibility = View.VISIBLE
                pos = 10
            }
            else -> {}

        }

    }


    /** 내부 작동 함수 */

    private fun setToggle() {
        if (share == 1) {
            binding.categoryToggleIv.setImageResource(R.drawable.ic_toggle_off)
            share = 0
        }
        else {
            binding.categoryToggleIv.setImageResource(R.drawable.ic_toggle_on)
            share = 1
        }
    }

    private fun setColor() {
        binding.scheduleColorCv.setOnClickListener {
            Clear()
            binding.scheduleColorSelectIv.visibility = View.VISIBLE

//            //색을 어떻게 받아오나
//            val colors = ContextCompat.getColor(context as CategoryActivity, R.color.schedule_group)
//            Log.d("category", "colors: $colors")

            color = "#DE8989"
            Log.d("CategoryDetailFragment", "click-color: $color")
//            Log.d("CATEGORY-DEFAULT", "첫번째 아이템 $color $default, $plan, $parttime, $group")
            pos = 0
        }
        binding.schedulePlanColorCv.setOnClickListener {
            Clear()
            binding.schedulePlanColorSelectIv.visibility = View.VISIBLE
            color = "#E1B000"
            Log.d("CategoryDetailFragment", "click-color: $color")
            pos = 0
        }
        binding.scheduleParttimeColorCv.setOnClickListener {
            Clear()
            binding.scheduleParttimeColorSelectIv.visibility = View.VISIBLE
            color = "#5C8596"
            Log.d("CategoryDetailFragment", "click-color: $color")
            pos = 0
        }
        binding.scheduleGroupColorCv.setOnClickListener {
            Clear()
            binding.scheduleGroupColorSelectIv.visibility = View.VISIBLE
            color = "#DA6022"
            Log.d("CategoryDetailFragment", "click-color: $color")
            pos = 0
        }
    }

    private fun Clear() { //클릭 초기화
        if (pos == 0 ) {
            color = ""
            binding.scheduleColorSelectIv.visibility = View.GONE
            binding.schedulePlanColorSelectIv.visibility = View.GONE
            binding.scheduleParttimeColorSelectIv.visibility = View.GONE
            binding.scheduleGroupColorSelectIv.visibility = View.GONE
        }
        else
            Clear2()
    }

    private fun setPaletteColor() {
        Clear()
        binding.categoryPaletteCv1.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv1.visibility = View.VISIBLE
            color = "#EB5353"
            pos = 1
        }
        binding.categoryPaletteCv2.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv2.visibility = View.VISIBLE
            color = "#EC9B3B"
            pos = 2
        }
        binding.categoryPaletteCv3.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv3.visibility = View.VISIBLE
            color = "#FBCB0A"
            pos = 3
        }
        binding.categoryPaletteCv4.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv4.visibility = View.VISIBLE
            color = "#96BB7C"
            pos = 4
        }
        binding.categoryPaletteCv5.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv5.visibility = View.VISIBLE
            color = "#5A8F7B"
            pos = 5
        }
        binding.categoryPaletteCv6.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv6.visibility = View.VISIBLE
            color = "#82C4C3"
            pos = 6
        }
        binding.categoryPaletteCv7.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv7.visibility = View.VISIBLE
            color = "#187498"
            pos = 7
        }
        binding.categoryPaletteCv8.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv8.visibility = View.VISIBLE
            color = "#8571BF"
            pos = 8
        }
        binding.categoryPaletteCv9.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv9.visibility = View.VISIBLE
            color = "#E36488"
            pos = 9
        }
        binding.categoryPaletteCv10.setOnClickListener {
            Clear2()
            binding.categoryPaletteSelectIv10.visibility = View.VISIBLE
            color = "#858585"
            pos = 10
        }
    }

    private fun Clear2() { //팔레트 클릭 초기화
        if (pos == 0 )
            Clear()

        color = ""
        when(pos) {
            1 -> binding.categoryPaletteSelectIv1.visibility = View.GONE
            2 -> binding.categoryPaletteSelectIv2.visibility = View.GONE
            3 -> binding.categoryPaletteSelectIv3.visibility = View.GONE
            4 -> binding.categoryPaletteSelectIv4.visibility = View.GONE
            5 -> binding.categoryPaletteSelectIv5.visibility = View.GONE
            6 -> binding.categoryPaletteSelectIv6.visibility = View.GONE
            7 -> binding.categoryPaletteSelectIv7.visibility = View.GONE
            8 -> binding.categoryPaletteSelectIv8.visibility = View.GONE
            9 -> binding.categoryPaletteSelectIv9.visibility = View.GONE
            10 -> binding.categoryPaletteSelectIv10.visibility = View.GONE
            else -> {}
        }


    }

    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!
        refresh = spf!!.getString("refresh","")!!

//        val spf = activity?.getSharedPreferences("prefs", Activity.MODE_PRIVATE)
//
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

    private fun getSharedPref() { // API 대신 리사이클러뷰 아이템에 저장된 데이터 가져오는 방법

        val spf = requireActivity().getSharedPreferences("Category", Context.MODE_PRIVATE)
        val editor = spf.edit()
        val categoryJson = spf.getString("categoryJson", null)

        editor.putString("categoryJson", categoryJson)
        editor.putString("name",name)
        editor.putString("color",color)
        editor.putInt("share",share)
        editor.apply()

        if (categoryJson != null){

            binding.categoryDetailTitleTv.setText(spf.getString("category",""))
        }
    }

}