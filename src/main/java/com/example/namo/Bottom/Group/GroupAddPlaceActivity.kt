package com.example.namo.Bottom.Group

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.Adapter.GroupAddPhotoAdapter
import com.example.namo.Bottom.Group.Adapter.GroupPeopleRVApater
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.*
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import com.example.namo.databinding.ActivityGroupAddPlaceBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.item_group_add_gallery.view.group_add_gallery_rv
import kotlinx.android.synthetic.main.item_group_add_place.view.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.lang.reflect.Type


//그룹 기록 추가 Activity
class GroupAddPlaceActivity: Activity() ,GroupMemoView{
    lateinit var binding: ActivityGroupAddPlaceBinding

    private var photo=ArrayList<Uri>()
    private var access : String = ""
    private lateinit var adapter: GroupAddPhotoAdapter
    lateinit var schedule : ScheduleRes
    private lateinit var moimPeople:ArrayList<moimAttendences>
    private lateinit var view:View
    private var eachpay = "금액 정산"
    private var paySave = 0
   // private var attendences : ArrayList<Int> = arrayListOf()
    private var fileList1=ArrayList<MultipartBody.Part>()
    private var fileList2=ArrayList<MultipartBody.Part>()
    private var fileList3=ArrayList<MultipartBody.Part>()
    private var moimMemoLocationDto= ArrayList<MoimMemoLocationDto>()
    private lateinit var MoimMemoLocationDto:MoimMemoLocationDto

    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupAddPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //헤더에 카카오 토큰 받기
        val spf =getSharedPreferences("token", MODE_PRIVATE)
        access = spf.getString("access","")!!

        if(intent.hasExtra("schedules")){
            schedule = intent.getSerializableExtra("schedules") as ScheduleRes
        }
        addPlace()
        initRecyclerView()
        onClickListener()

        var date = schedule.startDate


        binding.groupAddTitleTv.text=schedule.name
        binding.groupAddInputPlaceTv.text=schedule.location
        binding.groupAddInputDateTv.text=removeLastNchars(date, 3) //초 빼고

    }

    override fun onResume() {
        super.onResume()
        getSharedData()
        binding.itemPlaceMoneyTv.setText(eachpay)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addPlace() {

        binding.groudPlaceAddTv.setOnClickListener {//장소, 정산, 갤러리 레이아웃(장소 추가 버튼 클릭 시)

            count++
            if(count>1){
                Toast.makeText(this,"coming soon!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.groupLayout.visibility = VISIBLE
//                        //레이아웃 가져오기
//                        view = LayoutInflater.from(this)
//                            .inflate(R.layout.item_group_add_place, null, false)
//
//                        //정산 화면에서 정산금액이랑 참석자 인원 idx 받아오기
//
            binding.itemPlaceNameTv.text

            getSharedData()
           binding.itemPlaceMoneyTv.setText(eachpay)


           binding.groupGalleryLv.setOnClickListener {//사진 버튼 누르면 사진 추가

               binding.groupAddGalleryRv.visibility = VISIBLE

                getPermission()
                adapter = GroupAddPhotoAdapter(photo)
            }

            //화살표 누르면 정산 화면 이동
           binding.placeRightArrow.setOnClickListener {

                val intent = Intent(this, GroupPayActivity::class.java)
                startActivity(intent)
            }
//                        view.item_place_name_tv
//
//                        view.item_place_money_tv.text
//
//
//                        view.group_gallery_lv.setOnClickListener {//사진 버튼 누르면 사진 추가
//
//                            view.group_add_gallery_rv.visibility = VISIBLE
//
//                            getPermission()
//                            adapter = GroupAddPhotoAdapter(photo)
//                        }
//
//                        //화살표 누르면 정산 화면 이동
//                        view.right_arrow.setOnClickListener {
//
//                            val intent = Intent(this, GroupPayActivity::class.java)
//                            startActivity(intent)
//                        }
//
//                        //레이아웃 뷰 추가
//                        binding.groupPlaceAddLayout.addView(view)
//
//                    }

        }

    }


    @SuppressLint("IntentReset")
    private fun getPermission(){

        val writePermission = checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if (writePermission == PackageManager.PERMISSION_DENIED || readPermission == PackageManager.PERMISSION_DENIED) {
            // 권한 없어서 요청
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE),200)
        } else {
            // 권한 있음
            val intent = Intent(Intent.ACTION_PICK) //uri 로 이미지 가져오기
            intent.type = "image/*"
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)   //다중 이미지 가져오기
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, 200)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //이미지 선택 후 파일로 변환해서 이미지 리스트에 추가
        super.onActivityResult(requestCode, resultCode, data)
        photo.clear()

        if (resultCode == RESULT_OK && requestCode == 200) {

            if (data?.clipData != null) { // 사진 여러개 선택한 경우
                val count = data.clipData!!.itemCount
                if (count > 3) {
                    Toast.makeText(this, "사진은 3장까지 선택 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                for (i in 0 until count) {
                    val imageUri = data.clipData!!.getItemAt(i).uri    //이미지 uri

                    val file = File(absolutelyPath(imageUri, this))

                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    val add = MultipartBody.Part.createFormData("fileList1",file.name, requestFile)


                        fileList1.add(add)

                     photo.add(imageUri)

                }
            }
        } else { // 단일 선택
            data?.data?.let {
                val imageUri : Uri? = data.data
                if (imageUri != null) {

                    val file = File(absolutelyPath(imageUri, this))

                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    val add = MultipartBody.Part.createFormData("fileList1",file.name, requestFile)


                        fileList1.add(add)

                    photo.add(imageUri)

                } } }

               //장소 추가 리사이클러뷰
       adapter= GroupAddPhotoAdapter(photo)
        binding.groupGalleryLv.visibility = GONE
        adapter.notifyDataSetChanged()
        binding.groupAddGalleryRv.adapter=adapter
        binding.groupAddGalleryRv.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

       //1. 장소, 정산금액, 모임원 먼저 데이터에 넣고 사진 넣어야 된대서 따로 일단 뺌
        binding.groupAddIv.visibility= VISIBLE
        binding.groupAddIv.setOnClickListener{
            addGroupMemo()
            Toast.makeText(this, "그룹 메보가 저장되었습니다", Toast.LENGTH_SHORT).show() //메모 저장
        }

    }

    private fun getSharedData(){
        val sharedPreference = getSharedPreferences("getPay", MODE_PRIVATE)
        val editor = sharedPreference.edit()

        if (sharedPreference.contains("eachPay")){
            paySave = sharedPreference.getInt("eachPay",0)
            eachpay = paySave.toString()
        } else {
            eachpay = "금액 정산"
        }

//
//        editor.putInt("eachPay",eachPay) //정산 금액
//        editor.putString("memberIdx","$checkedMemberIdx") //체크한 사람 useridx 리스트
//        editor.apply()
    }


    // 이미지 절대경로 변환
    @SuppressLint("Recycle")
    private fun absolutelyPath(path: Uri, context: Context): String {
        val proj: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        val c: Cursor? = context.contentResolver.query(path, proj, null, null, null)
        val index = c?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        c?.moveToFirst()
        val result = c?.getString(index!!)

        return result!!
    }


    private fun addGroupMemo(){

        val spf = getSharedPreferences("getPay", AppCompatActivity.MODE_PRIVATE)
//        eachpay = spf.getInt("eachPay", 0)
        val moimIdx = spf.getString("memberIdx", "")
//        Log.d("eachpay", eachpay.toString())
        Log.d("moimIdx", "$moimIdx")


        val listType: Type = object : TypeToken<ArrayList<Int>>() {}.type
        val attendences: ArrayList<Int> = Gson().fromJson(moimIdx, listType)!!
        moimMemoLocationDto.add(
            MoimMemoLocationDto(
               binding.itemPlaceNameTv.text.toString(),
                paySave,
                attendences
            ))

        Log.d("attendances", "$attendences")


        val moimMemoDto= moimMemoDto(schedule.memoIdx,moimMemoLocationDto)
        Log.d("locatoindto","$moimMemoLocationDto")

        val groupMemoService = GroupService()
        groupMemoService.setGroupMemoView(this)
       groupMemoService.addGroupMemo(access,moimMemoDto)

}

    private fun addGroupPhoto(){

        val moimIdxRequestBody= schedule.memoIdx.toString().toRequestBody("text/plain".toMediaTypeOrNull())

        val groupMemoService = GroupService()
        groupMemoService.setGroupMemoView(this)
        groupMemoService.addGroupPhoto(access,moimIdxRequestBody,fileList1, fileList2, fileList3)
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {

        val spf = getSharedPreferences("GroupMemo", Context.MODE_PRIVATE)

        val groupJsons : String = spf.getString("moimAttendences", "").toString()
        val listType: Type = object : TypeToken<ArrayList<moimAttendences>>() {}.type
        moimPeople = Gson().fromJson(groupJsons, listType)!!

        val groupViewRVAdapter= GroupPeopleRVApater(moimPeople)
        binding.groupAddPeopleRv.adapter= groupViewRVAdapter
        binding.groupAddPeopleRv.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun setRecyclerView(isVisible: Boolean) {
        if (isVisible) {
            binding.groupAddPeopleRv.visibility= GONE
            binding.bottomArrow.visibility= VISIBLE
            binding.upArrow.visibility= GONE


        } else {
            binding.groupAddPeopleRv.visibility= VISIBLE
            binding.bottomArrow.visibility= GONE
            binding.upArrow.visibility= VISIBLE
        }

    }

    private fun onClickListener(){

        binding.bottomArrow.setOnClickListener{
            setRecyclerView(false)
        }
        binding.upArrow.setOnClickListener{
            setRecyclerView(true)
        }
        binding.groupAddBackIv.setOnClickListener{
//            finish()
            val intent= Intent(this, GroupSeeActivity::class.java)
            intent.putExtra("schedules", schedule)
            startActivity(intent)
        }


        binding.groupPlaceSaveTv.setOnClickListener {

           // addGroupMemo()
            addGroupPhoto()  //2. 더하기 눌러서 장소, 정산금액, 모임원 추가한 후 사진 저장
            Toast.makeText(this,"저장되었습니다.", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)

            val sharedPreference = getSharedPreferences("getPay", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            if (sharedPreference.contains("eachPay")){
                editor.clear().apply()
            }

            startActivity(intent)
        }

    }

    //끝 문자 제거하기
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }


    override fun onAddGroupMemoSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("AddGroupMemo",result)

            }
        }
    }

    override fun onGetGroupMemoSuccess(code: Int, result: moimMemoResult) {
        when(code){
            1000-> {
                Log.d("GetGroupMemo","$result")

            }
        }
    }

    override fun onContentsGroupMemoSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("AddGroupMemoContents","success")

            }
        }
    }

}

