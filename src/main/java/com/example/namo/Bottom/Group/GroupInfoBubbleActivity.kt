package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import com.example.namo.Bottom.Group.Adapter.GroupInfoRVAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.*
import com.example.namo.databinding.ActivityGroupInformationBubbleBinding


//그룹 캘린더 안의 정보창
class GroupInfoBubbleActivity : AppCompatActivity(), GroupInfoView {

    lateinit var binding: ActivityGroupInformationBubbleBinding
//    private var groupInfoDatas = ArrayList<GroupInfo>()

    private var groupCode : String = "" //그룹 코드
    var moimIdx : Int = 0
    var memberNum : Int = 0
    var access : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupInformationBubbleBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        getToken()

        inquiryGroupInfo() // 그룹 정보 조회
//        InitRecyclerView() //리사이클러뷰

//        clipCopy() //그룹 코드 복사

        binding.groupInfoBackTv.setOnClickListener {
            finish() //뒤로가기
        }

        binding.groupInfoSaveTv.setOnClickListener {
            Toast.makeText(this, "생성 버튼 클릭", Toast.LENGTH_SHORT).show()
            finish() //저장
        }

        binding.groupInfoLeaveBtn.setOnClickListener {
//            Toast.makeText(this, "탈퇴 버튼 클릭", Toast.LENGTH_SHORT).show()

            Log.d("GroupInfoBubbble-ACT", "현재 멤버수: ${memberNum}")

            if(memberNum == 1 ) {
                deleteGroup()
            } else {
                leaveGroup()
            }
            finish() // 탈퇴 or 삭제 완료
            startActivity(Intent(this, MainActivity::class.java))
       }
    }


    private fun inquiryGroupInfo() { //7.5 모임 정보 조회

        //GroupFragment에서 넘어온 리사이클러뷰 idx 받기
        val spf = getSharedPreferences("Moim", Context.MODE_PRIVATE)
        moimIdx = spf.getInt("moimIdx", 0)
        Log.d("SPF-Group-Info_ACT", "넘어온 moimIdx = ${moimIdx}")


        //서버 연동
        val groupService = GroupService()
        groupService.setGroupInfoView(this)
        groupService.getGroupInfo(access, moimIdx)

    }

    private fun leaveGroup() { //7.8 모임 탈퇴

        Log.d("Leave-Group-Info_ACT", "moimIdx = ${moimIdx}")

        //서버 연동
        val groupService = GroupService()
        groupService.setGroupInfoView(this)
        groupService.leaveGroup(access, moimIdx)

        Log.d("leaveGroup", "모임 탈퇴함")

    }

    private fun deleteGroup() { //7.3 모임 삭제

        Log.d("Delete-Group-Info_ACT", "moimIdx = ${moimIdx}")

        //서버 연동
        val groupService = GroupService()
        groupService.setGroupInfoView(this)
        groupService.deleteGroup(access, moimIdx)

        Log.d("deleteGroup", "모임 삭제함")

    }


    //리사이클러뷰 어댑터 연결
    private fun InitRecyclerView(result: ArrayList<FriendsList>) {

        // 어댑터와 데이터리스트 연결
        val adapter = GroupInfoRVAdapter(this, result)
        binding.groupInfoPeopleRv.adapter = adapter
        binding.groupInfoPeopleRv.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)

    }

    private fun clipCopy() {

//        code = "0A0BOK"//그룹 코드 받아오기
        binding.groupInfoCodeTv.setText(groupCode)

        val clipboard: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", groupCode)


        // 클립보드 복사
        binding.groupInfoCodeCopyIv.setOnClickListener {
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }


    //7.5 모임 정보 조회
    override fun onGetGroupInfoSuccess(code: Int, result: InquiryGroupInfoResult) {
        when(code){
            1000-> {
                Log.d("INQUIRY_GROUP_INFO_SUCCESS","SUCCESS, result : ${result}")

                memberNum = result.friendsList.size     //인원수
                binding.groupInfoTitleTv.text = result.name //모임 이름
                binding.groupInfoPeopleNumTv.text = "${memberNum}명"

                InitRecyclerView(result.friendsList) //그룹 멤버 리사이클러뷰 연결

                groupCode = result.code // 그룹 코드

                Log.d("GroupCode", groupCode)
                clipCopy() //그룹 코드 복사


            }
        }
    }

    //7.3 모임 삭제
    override fun onDeleteGroupSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("DELETE_GROUP_SUCCESS","SUCCESS, result : ${result}")

                Toast.makeText(this, "모임을 삭제했습니다", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //7.8 모임 탈퇴
    override fun onLeaveGroupSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("LEAVE_GROUP_SUCCESS","SUCCESS, result : ${result}")

                Toast.makeText(this, "모임을 탈퇴했습니다", Toast.LENGTH_SHORT).show()

            }
        }
    }

    //실패시 코드
    override fun onGetGroupFailure(code: Int, message: String) {
        Log.d("GroupInfoBubble-ACT/Group-RESPONSE", "${code}, ${message}")
        when(code){
            5210 -> {
                Log.d("GroupInfoBubble-ACT/fail", "존재하지 않는 모임임")
            }
        }
    }

    private fun getToken() {

        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("GroupInfoBubble-ACT/TOKEN-ACC", access)
    }
}