package com.example.namo.Bottom.Home.Record


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.Memo.*
import com.example.namo.R
import com.example.namo.databinding.ActivityRecordEditBinding
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import java.io.*

class RecordEditActivity: AppCompatActivity() , MemoView, GetMemoView {
    lateinit var binding: ActivityRecordEditBinding

    private var access : String = ""

    lateinit var schedule : GetScheduleRes

    var addList =ArrayList<MultipartBody.Part?>()  //생성 이미지 리스트
    var editList=ArrayList<MultipartBody.Part?>()  //편집 이미지 리스트
    var editIdxList=ArrayList<MultipartBody.Part?>()   //편집 식별자 리스트
    var view=ArrayList<Uri>() //glide로 이미지 보기

    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)

        binding = ActivityRecordEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //헤더에 카카오 토큰 받기
        val spf =getSharedPreferences("token", MODE_PRIVATE)
            access = spf.getString("access","")!!

        if(intent.hasExtra("schedule")){
            schedule = intent.getSerializableExtra("schedule") as GetScheduleRes
             }


        bind()
    }

    @SuppressLint("IntentReset")
    private fun getPermission(){

        val writePermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //이미지 선택 후 파일로 변환해서 이미지 리스트에 추가
        super.onActivityResult(requestCode, resultCode, data)

        val memo=getSharedPreferences("getMemoRes", MODE_PRIVATE)
        val memoList=memo.getString("idx","")

        if (resultCode == RESULT_OK && requestCode == 200) {

            if (data?.clipData != null) { // 사진 여러개 선택한 경우
                val count = data.clipData!!.itemCount
                if (count > 3) {
                    Toast.makeText(this, "사진은 3장까지 선택 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                for (i in 0 until count) {
                    val imageUri = data.clipData!!.getItemAt(i).uri    //이미지 uri

                    val  file = File(absolutelyPath(imageUri, this))
                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    val add= MultipartBody.Part.createFormData("imgs", file.name, requestFile)

                    val editfile = MultipartBody.Part.createFormData("fileList", file.name, requestFile)
                    val editIdx = memoList?.let {
                        MultipartBody.Part.createFormData("imgIdxList", it) }

                    if(schedule.memoIdx==0){
                        addList.add(add) }
                    else{
                        editList.add(editfile)
                        editIdxList.add(editIdx) }
                    view.add(imageUri)

                    }

                }
        } else { // 단일 선택
            data?.data?.let {
                val imageUri : Uri? = data.data
                if (imageUri != null) {

                    val  file = File(absolutelyPath(imageUri, this))
                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    val add= MultipartBody.Part.createFormData("imgs", file.name, requestFile)

                    val editfile = MultipartBody.Part.createFormData("fileList", file.name, requestFile)
                    val editIdx = memoList?.let {
                        MultipartBody.Part.createFormData("imgIdxList", it) }

                    if(schedule.memoIdx==0){
                        addList.add(add) }
                    else{
                        editList.add(editfile)
                        editIdxList.add(editIdx) }

                    view.add(imageUri)
        } } }
      recyclerView()
    }

    private fun recyclerView() {

        val galleryViewRVAdapter = RecordViewRVAdapter(view, this)
        binding.recordGalleryRy.adapter = galleryViewRVAdapter
        binding.recordGalleryRy.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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

    private fun createMemo(){

        val content = binding.recordNoteEt.text
        val note = content?.toString()?.toRequestBody("text/plain".toMediaTypeOrNull())
        val scheduleIdx = schedule.scheduleIdx.toString().toRequestBody("text/plain".toMediaTypeOrNull())

        //서버 연동
        val memoService = MemoService()
        memoService.setMemoView(this)
        memoService.inputMemo(access,addList.filterNotNull(),scheduleIdx,note)   }

    private fun editMemo(){

        val content=binding.recordNoteEt.text
        val note = content.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        val memoIdx = schedule.memoIdx.toString().toRequestBody("text/plain".toMediaTypeOrNull())

        //서버 연동
        val memoEditService = MemoService()
        memoEditService.setMemoView(this)
        memoEditService.editMemo(access,note,editIdxList.filterNotNull(),editList.filterNotNull(),memoIdx)  }

    private fun getMemo(){

        val memoGetService = MemoService()
        memoGetService.getMemoView(this)
        memoGetService.getMemo(access,schedule.memoIdx)

    }

    fun bind(){

        //앨범 권한 확인 후 연결
        binding.openGalleryTv.setOnClickListener {
            getPermission()
        }
        if(schedule.memoIdx==0){
            //기록 저장하기 누르면 저장됨
            binding.recordSaveTv.setOnClickListener {
                createMemo()
                Toast.makeText(this,"저장되었습니다.",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            getMemo()

            //기록 저장하기 누르면 수정됨
            binding.recordSaveTv.setOnClickListener {
                editMemo()
                Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        binding.recordBackIv.setOnClickListener {
            val intent = Intent(this, RecordWriteActivity::class.java)
            intent.putExtra("schedule", schedule)
            startActivity(intent)
        }

        binding.recordTitleTv.text=schedule.name
        binding.recordInputDateTv.text=removeLastNchars(schedule.startDate, 3) //초 제거
        binding.recordInputPlaceTv.text=schedule.location
    }

    //끝 문자 제거하기
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }

    override fun onInputMemoSuccess(code: Int, result: Int) {

        when(code){
            1000-> {
                Log.d("inputMemo","success")

            }
        }
    }

    override fun onEditMemoSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("editMemo","success")
            }
        }
    }

    override fun onGetMemoSuccess(code: Int, result: GetMemoRes) {

        val urls=result.urls.filterNotNull()

        binding.recordNoteEt.setText(result.content)

        val galleryRVAdapter=RecordGalleryRVAdapter(urls,this)
        binding.recordGalleryRy.adapter = galleryRVAdapter
        binding.recordGalleryRy.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onDeleteMemoSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }

}


