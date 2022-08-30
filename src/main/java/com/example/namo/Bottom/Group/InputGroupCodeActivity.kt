package com.example.namo.Bottom.Group

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Data.Group.GroupCodeView
import com.example.namo.Data.Group.GroupService
import com.example.namo.Data.Group.SearchGroupResult
import com.example.namo.databinding.ActivityGroupCodeBinding


//바텀 그룹에서 메뉴 클릭시 나오는 그룹 코드 입력창
class InputGroupCodeActivity : AppCompatActivity(), GroupCodeView {

    lateinit var binding: ActivityGroupCodeBinding

    var access : String = ""
    var moimIdx : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getToken()
    }

    override fun onStart() {
        super.onStart()

        binding.groupCodeBackTv.setOnClickListener {
            finish() //뒤로가기
        }

        binding.groupCodeSaveTv.setOnClickListener {
            searchGroup() //모임 검색 -> moimIdx 반환
//            addMember() //모임원 추가
//            finish() //저장
        }
    }


    /** API 연동 함수 */

    private fun searchGroup() { // 7.4 모임 검색

        var code = binding.addGroupCodeEt.text.toString()

        //서버 연동
        val groupService = GroupService()
        groupService.setGroupCodeView(this)
        groupService.searchGroup(access, code)

//        addMember()
    }

    private fun addMember() { // 7.6 모임원 추가

        //서버 연동
        val groupService = GroupService()
        groupService.setGroupCodeView(this)
        groupService.addGroupMember(access, moimIdx)

        Log.d("group-moimIdx", "모임원 추가하는 moimIdx = $moimIdx")
    }


    //7.4 모임 검색
    override fun onSearchGroupSuccess(code: Int, result: SearchGroupResult) {
        when(code){
            1000-> {
                Log.d("SEARCH_GROUP_SUCCESS","SUCCESS, result : ${result}")

//                Log.d("searchGroupCode","success")
                moimIdx = result.moimIdx
                Log.d("group-moimIdx", moimIdx.toString())

                addMember() //모임원 추가
            }
        }
    }


    //7.6 모임원 추가
    override fun onAddGroupMemberSuccess(code: Int, result: String) {
        when(code){
            1000-> {
                Log.d("ADD_GROUP_CODE_SUCCESS","SUCCESS, code: ${code}, result : ${result}")

                Log.d("addGroupCode","success")
                Toast.makeText(this, "모임에 추가되었습니다", Toast.LENGTH_SHORT).show()

                finish()

            }
        }
    }

    //실패시 코드
    override fun onGetGroupFailure(code: Int, message: String) {
        Log.d("Input-GroupCode-ACT/Group-RESPONSE", "${code}, ${message}")
        when(code){
            5355 -> {
                Log.d("Input-GroupCode-ACT/fail", "존재하지 않는 그룹 코드임")
                Toast.makeText(this, "존재하지 않는 그룹 코드입니다", Toast.LENGTH_SHORT).show()
            }
            5022 -> {
                Log.d("Input-GroupCode-ACT/fail", "이미 참여한 모임임")
                Toast.makeText(this, "이미 참여한 모임입니다", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

    private fun getToken() {

        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("Input-GroupCode-ACT/TOKEN-ACC", access)
    }
}