package com.example.namo.Bottom.Group

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Diary.DiaryGroupRVAdapter
import com.example.namo.Bottom.Diary.DiaryListRVAdapter
import com.example.namo.Bottom.Home.Record.RecordViewRVAdapter
import com.example.namo.Data.Group.GroupMemoView
import com.example.namo.Data.Group.GroupService
import com.example.namo.Data.Group.moimMemoDto
import com.example.namo.Data.Group.moimMemoResult
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.Memo.MonthMemoDto
import com.example.namo.databinding.ActivityGroupMemoEditBinding

class GroupMemoEditActivity : AppCompatActivity() , GroupMemoView {
    lateinit var binding : ActivityGroupMemoEditBinding

    private var access : String = ""
    lateinit var schedule : GetScheduleRes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupMemoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spf =getSharedPreferences("token", MODE_PRIVATE)
        access = spf.getString("access","")!!

        schedule = intent.getSerializableExtra("schedule") as GetScheduleRes

        bind()

    }

    //상세기록 조회
    private fun contentMemo(){

        val content=binding.recordNoteEt.text.toString()

        val moimPeople=getSharedPreferences("Moim", MODE_PRIVATE)
        val moimIdx=moimPeople.getInt("moimMemoIdx",0)

        val getmemoService = GroupService()
        getmemoService.setGroupMemoView(this)
        getmemoService.contentsGroupMemo(access,content,moimIdx)
    }

    private fun bind(){

        binding.recordTitleTv.text=schedule.name
        binding.recordInputDateTv.text=schedule.startDate
        binding.recordInputPlaceTv.text=schedule.location

        binding.recordSaveTv.setOnClickListener {
            contentMemo()
        }


        val memo=getSharedPreferences("getMemoRes", MODE_PRIVATE)
        val imgList=memo.getString("urls","")

        val galleryViewRVAdapter = DiaryGroupRVAdapter(listOf(imgList),this)
        binding.groupGallerySaveRy.adapter = galleryViewRVAdapter
        binding.groupGallerySaveRy.layoutManager =
            GridLayoutManager(this,3)

    }

    override fun onAddGroupMemoSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }

    override fun onGetGroupMemoSuccess(code: Int, result: moimMemoResult) {
        TODO("Not yet implemented")
    }

    override fun onContentsGroupMemoSuccess(code: Int, result: String) {
        when(code){
            1000->
                Log.d("addcontent","Success")
        }

    }
}