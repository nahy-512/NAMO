package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.namo.Data.Group.CreateGroupResult
import com.example.namo.Data.Group.GroupService
import com.example.namo.Data.Group.GroupView
import com.example.namo.R
import com.example.namo.databinding.ActivityAddGroupBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Multipart
import java.io.File


//바텀 그룹에서 메뉴 클릭시 나오는 그룹 생성창
class AddGroupActivity : AppCompatActivity(), GroupView {

    lateinit var binding: ActivityAddGroupBinding

    var access : String = ""


    lateinit var profileImg : MultipartBody.Part //생성 이미지
    var view = ArrayList<Uri>() //glide로 이미지 보기

    var groupCode : String = "" //그룹 생성시 받아온 그룹 코드


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getToken() //토큰 가져오기


    }

    override fun onStart() {
        super.onStart()


        onClickListener() //클릭 동작(뒤로가기, 저장, 클립보드 복사, 사진 가져오기 등)
    }


    fun onClickListener(){

        binding.addGroupBackTv.setOnClickListener {
            finish() //뒤로가기
        }

        //앨범 권한 확인 후 연결
        binding.addGroupCoverImgIv.setOnClickListener {
            getPermission()
        }

        binding.addGroupSaveTv.setOnClickListener {
            Toast.makeText(this, "생성 버튼 클릭", Toast.LENGTH_SHORT).show()

            createGroup() //API 연동

            binding.addGroupSaveTv.setText(R.string.save) //생성 -> 저장으로 텍스트 바꿔주기

            binding.addGroupCodeCopyIv.visibility = View.VISIBLE

            binding.addGroupSaveTv.setOnClickListener { //저장
                Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show()
                finish() //한 번 더 버튼 누르면 종료
            }

        }

    }

    private fun clipCopy() {

        val clipboard: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", groupCode)

        // 클립보드 복사
        binding.addGroupCodeCopyIv.setOnClickListener {
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }



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
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)   //이미지 가져오기
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, 200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //이미지 선택 후 파일로 변환해서 이미지 리스트에 추가
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == 200) {

            if (data?.clipData != null) { // 사진 선택
                data?.data?.let {
                    val imageUri: Uri? = data.data
                    if (imageUri != null) {

                        val file = File(absolutelyPath(imageUri, this))
                        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                        profileImg = MultipartBody.Part.createFormData("profileImg", file.name, requestFile)

                        binding.addGroupCoverImgIv.setImageURI(imageUri) //가지고 온 사진으로 이미지 바인딩

//                        profileImg.add(add)
//                        addImg.filterNotNull()

                        view.add(imageUri)


            } } }
        }
    }

    // 절대경로 변환
    fun absolutelyPath(path: Uri, context: Context): String {

        var proj: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        var c: Cursor? = context.contentResolver.query(path, proj, null, null, null)
        var index = c?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        c?.moveToFirst()

        var result = c?.getString(index!!)

        return result!!
    }

    //그룹 생성
    private fun createGroup(){
        val content=binding.addGroupTitleEt.text
        val name = content.toString().toRequestBody("text/plain".toMediaTypeOrNull())

        //서버 연동
        val groupService = GroupService()
        groupService.setGroupView(this)
        groupService.createGroup(access, name, profileImg)

        Log.d("AddGroup-ACT", "access: $access, name: $name, profileImg: $profileImg")
    }


    //7.1 모임 생성
    override fun onCreateGroupSuccess(code: Int, result: CreateGroupResult) {
        when(code){
            1000-> {
                Log.d("INPUT_GROUP_SUCCESS","SUCCESS, code: ${code}, result : ${result}")
                Log.d("inputGroup","success")

                groupCode = result.moimCode
                Log.d("GroupCode",groupCode)

                binding.addGroupCodeTv.text = groupCode //그룹 코드 받아오기

                clipCopy() //클립보드 복사
            }
        }
    }

    //7.2 모임 수정
    override fun onEditGroupSuccess(code: Int, result: String) {
        //나중에 이름만 수정되게
    }

    //실패시
    override fun onGetGroupFailure(code: Int, message: String) {
        Log.d("AddGroup-ACT/Group-RESPONSE", "${code}, ${message}")
    }

    private fun getToken(){

        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

    }

}