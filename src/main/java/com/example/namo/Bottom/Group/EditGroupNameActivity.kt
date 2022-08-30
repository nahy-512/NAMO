package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.*
import com.example.namo.databinding.ActivityGroupEditNameBinding


//그룹 이름 수정
class EditGroupNameActivity : AppCompatActivity(), GroupView, GroupInfoView {

    lateinit var binding: ActivityGroupEditNameBinding

    var access : String = ""

    lateinit var group : GroupEdit
    var moimIdx : Int = 0
    var name : String? = ""
    var newName : String = ""
    var memberNum : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupEditNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //GroupFragment에서 넘어온 리사이클러뷰 idx 받기
        val spf = getSharedPreferences("Moim", Context.MODE_PRIVATE)
        val groupJson = spf.getString("groupJson", null)
        moimIdx = spf.getInt("moimIdx", 0)

        val profileImg = spf.getString("moimImg", "")
        Glide.with(this).load(profileImg).into(binding.editGroupCoverImgIv)

        name = spf.getString("moimName", "")

        binding.editGroupTitleEt.setText(name) //이름 가져오기

        newName = name.toString()

        getToken() //토큰 가져오기


    }

    override fun onStart() {
        super.onStart()

        onClickListener() //클릭 동작(뒤로가기, 저장, 클립보드 복사, 사진 가져오기 등)
    }


    fun onClickListener(){

        binding.editGroupBackTv.setOnClickListener {
            finish() //뒤로가기
        }

        binding.editGroupSaveTv.setOnClickListener {

            newName = binding.editGroupTitleEt.text.toString()
            group = GroupEdit(moimIdx, newName)
            Log.d("EditGroupName-ACT", "$moimIdx, $newName")

            if (newName == name )
                Toast.makeText(this, "변경 사항이 없습니다", Toast.LENGTH_SHORT).show()
            else {
                editGroupName() //그룹 이름 수정
                finish()
            }
        }

        binding.groupInfoLeaveBtn.setOnClickListener {

            inquiryGroupInfo()
            finish() // 탈퇴 or 삭제 완료

        }

    }

    private fun editGroupName(){ // 7.2 모임 수정

        val groupService = GroupService()
        groupService.setGroupView(this)

        groupService.editGroup(access, group)
        Log.d("EDIT_GROUP_DATA", "$group")
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


    //7.2 모임 수정
    override fun onEditGroupSuccess(code: Int, result: String) {
        //나중에 이름만 수정되게
        when(code){
            1000-> {
                Log.d("EDIT_GROUP_SUCCESS","SUCCESS, result : ${result}")

                Toast.makeText(this, "모임 이름을 수정했습니다", Toast.LENGTH_SHORT).show()

            }
        }

    }


    //7.5 모임 정보 조회
    override fun onGetGroupInfoSuccess(code: Int, result: InquiryGroupInfoResult) {
        when(code){
            1000-> {
                Log.d("INQUIRY_GROUP_INFO_SUCCESS","SUCCESS, result : ${result}")

                memberNum = result.friendsList.size     //인원수

                Log.d("EditGroupName-ACT", "현재 멤버수: ${memberNum}")

                if(memberNum == 1 ) {
                    deleteGroup()
                } else {
                    leaveGroup()
                }
//                binding.groupInfoTitleTv.text = result.name //모임 이름
//                binding.groupInfoPeopleNumTv.text = "${memberNum}명"

//                groupCode = result.code // 그룹 코드

//                Log.d("GroupCode", groupCode)
//                clipCopy() //그룹 코드 복사

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

    //실패시
    override fun onGetGroupFailure(code: Int, message: String) {
        Log.d("AddGroup-ACT/Group-RESPONSE", "${code}, ${message}")
    }



    //7.1 모임 생성
    override fun onCreateGroupSuccess(code: Int, result: CreateGroupResult) {
        //
    }

    private fun getToken(){
        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)
        access = spf!!.getString("access","")!!
    }

}