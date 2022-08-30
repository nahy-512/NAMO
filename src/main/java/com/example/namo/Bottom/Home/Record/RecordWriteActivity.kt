package com.example.namo.Bottom.Home.Record

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.Memo.GetMemoRes
import com.example.namo.Data.Schedule.Memo.GetMemoView
import com.example.namo.Data.Schedule.Memo.MemoService
import com.example.namo.R
import com.example.namo.databinding.ActivityRecordWriteBinding
import com.google.gson.Gson


class RecordWriteActivity : AppCompatActivity() ,GetMemoView {
    lateinit var binding: ActivityRecordWriteBinding

    private var access : String = ""
    private lateinit var schedule : GetScheduleRes
//  private var scheduleIdx:Int=0
//    private var memoIdx:Int=0
//    private var name:String=""
//    private var startDate:String=""
//    private var location:String=""

    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)

        binding = ActivityRecordWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

       schedule = intent.getSerializableExtra("schedule") as GetScheduleRes
//        if(intent.hasExtra("schedule")){
//            schedule = intent.getSerializableExtra("schedule") as GetScheduleRes
//        }

        val spf =getSharedPreferences("token", MODE_PRIVATE)
        access = spf.getString("access","")!!

//
//        val spf2 =getSharedPreferences("getschedule", MODE_PRIVATE)
//        scheduleIdx = spf2.getInt("scheduleIdx",0)
//        memoIdx = spf2.getInt("memoIdx",0)
//        name = spf2.getString("name","")!!
//        startDate = spf2.getString("startDate","")!!
//        location = spf2.getString("location","")!!

        binding.recordTitleTv.text=schedule.name
        binding.recordInputDateTv.text=removeLastNchars(schedule.startDate, 3) //초 제거
        binding.recordInputPlaceTv.text=schedule.location


        onClickListener()
        getMemo()
      }

    //상세기록 조회
    private fun getMemo(){

        val getmemoService = MemoService()
        getmemoService.getMemoView(this)
        getmemoService.getMemo(access,schedule.memoIdx)
    }

    override fun onGetMemoSuccess(code: Int, result:GetMemoRes) {

        when(code){
            1000-> {

                val urls= result?.urls.filterNotNull()

                Log.d("urlList","$urls")
                Log.d("resultUrl","${result.urls}")

                binding.recordNoteEt.text=result.content

                val galleryRVAdapter=RecordGalleryRVAdapter(urls,this)
                binding.recordGallerySavedRy.adapter = galleryRVAdapter
                binding.recordGallerySavedRy.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

                val jsn=gson.toJson(result.imgIdx)
                val sharedPreference = getSharedPreferences("getMemoRes", MODE_PRIVATE)
                val editor = sharedPreference.edit()
                editor.putString("idx",jsn) //이미지 idx
                editor.apply()


                Log.d("getMemo","success")
            }
        }
    }



    private fun onClickListener(){

        //편집 누르면 생성/편집 화면으로 이동
        binding.recordEditTv.setOnClickListener {
            val intent = Intent(this, RecordEditActivity::class.java)
            intent.putExtra("schedule", schedule)
            startActivity(intent)
        }

        binding.recordBackIv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //휴지통 누르면 메모 삭제, 임시
        binding.recordDeleteTv.setOnClickListener {

            val deleteMemoService = MemoService()
            deleteMemoService.getMemoView(this)
            deleteMemoService.deleteMemo(access,schedule.memoIdx)

            Toast.makeText(this,"삭제되었습니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if(schedule.memoIdx==0){
            binding.recordDeleteTv.visibility=GONE
        }
        else{
            binding.recordDeleteTv.visibility= VISIBLE
        }

    }

    //끝 문자 제거하기
    fun removeLastNchars(str: String, n: Int): String {
        return str.substring(0, str.length - n)
    }

    override fun onDeleteMemoSuccess(code: Int, result: String) {

        when(code){
            1000-> {
                Log.d("deleteMemo","success")
            }
        }
    }

}

