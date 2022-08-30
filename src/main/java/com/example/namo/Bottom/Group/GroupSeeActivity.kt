package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Diary.DiaryListRVAdapter
import com.example.namo.Bottom.Group.Adapter.GroupPeopleRVApater
import com.example.namo.Bottom.Group.Adapter.GroupSeeRVAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.*
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.databinding.ActivityGroupSeeBinding
import com.google.gson.Gson


//그룹 기록 보기, ui 기록 전 화면
class GroupSeeActivity : Activity(),GroupMemoView{
    lateinit var binding: ActivityGroupSeeBinding

    private var access : String = ""
    private var peopleList=ArrayList<moimAttendences>()
    private var placeList=ArrayList<getMoimMemoLocationRes>()

    lateinit var schedule : ScheduleRes
    lateinit var moimInPersonal : GetScheduleRes
    private var memoIdx = -1
    private var isFromGroup = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupSeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("schedules")){
            schedule = intent.getSerializableExtra("schedules") as ScheduleRes
            memoIdx = schedule.memoIdx
            isFromGroup = true
        }
        else if (intent.hasExtra("moimInPersonal")){
            moimInPersonal = intent.getSerializableExtra("moimInPersonal") as GetScheduleRes
            memoIdx = moimInPersonal.memoIdx
            isFromGroup = false
        }
        if (isFromGroup){
            binding.groupEditTv.visibility = View.VISIBLE
        } else {
            binding.groupEditTv.visibility = View.GONE
        }

        //헤더에 카카오 토큰 받기
        val spf =getSharedPreferences("token", MODE_PRIVATE)
        access = spf.getString("access","")!!

        getGroupMemo()
        onClickListener()

    }

    private fun getGroupMemo(){
        //서버 연동
        val groupMemoService = GroupService()
        groupMemoService.setGroupMemoView(this)
        groupMemoService.getGroupMemo(access,memoIdx)

        val moimPeople=getSharedPreferences("Moim", MODE_PRIVATE)
        val moimIdx=moimPeople.getInt("moimMemoIdx",0)

    }

    override fun onGetGroupMemoSuccess(code: Int, result: moimMemoResult) {
        when (code) {
            1000 -> {

                peopleList=ArrayList(result.moimAttendences)
                placeList=ArrayList(result.getMoimMemoLocationRes)


                binding.groupSeeTitleTv.text=result.name
                binding.groupSeeInputDateTv.text=removeLastNchars(result.startDate, 3)
                binding.groupSeeInputPlaceTv.text=result.location


                val groupViewRVAdapter= GroupPeopleRVApater(peopleList)
                binding.groupPeopleRv.adapter = groupViewRVAdapter
                binding.groupPeopleRv.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

                val groupSeeRVAdapter= GroupSeeRVAdapter(placeList)
                binding.groupAddPlaceRv.adapter = groupSeeRVAdapter
                binding.groupAddPlaceRv.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



                val spf = getSharedPreferences("GroupMemo", Context.MODE_PRIVATE)
                val editor = spf.edit()

                val attendencesJson=Gson().toJson(peopleList)
                editor.putString("moimAttendences",attendencesJson)
                editor.apply()
            }

            }
    }



    private fun setRecyclerView(isVisible: Boolean) {
        if (isVisible) {
            binding.groupPeopleRv.visibility = View.GONE
            binding.bottomArrow.visibility = View.VISIBLE
            binding.upArrow.visibility = View.GONE


        } else {
            binding.groupPeopleRv.visibility = View.VISIBLE
            binding.bottomArrow.visibility = View.GONE
            binding.upArrow.visibility = View.VISIBLE
        }

    }

    private fun onClickListener(){

        binding.bottomArrow.setOnClickListener {
            setRecyclerView(false)
        }
        binding.upArrow.setOnClickListener {
            setRecyclerView(true)
        }
        binding.groupEditTv.setOnClickListener {
            val intent= Intent(this,GroupAddPlaceActivity::class.java)
            intent.putExtra("schedules", schedule)
            startActivity(intent)
        }

        binding.groupSeeBackIv.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    //끝 문자 제거하기
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }


    override fun onAddGroupMemoSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }



    override fun onContentsGroupMemoSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }
}




