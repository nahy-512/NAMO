package com.example.namo.Bottom.Home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.ScheduleResult
import com.example.namo.Data.Schedule.ScheduleService
import com.example.namo.Data.Schedule.TempSchedule
import com.example.namo.Floating.Schedule.AddActivity
import com.example.namo.R
import com.example.namo.databinding.ActivityEditScheduleBinding
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.kakao.sdk.auth.AuthApiClient
import com.jakewharton.threetenabp.AndroidThreeTen

class EditScheduleActivity() : AppCompatActivity(), HomeView {
    lateinit var binding: ActivityEditScheduleBinding
    lateinit var schedule : GetScheduleRes

    private var access : String = ""

    var tempSchedule = TempSchedule()

    companion object {
        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("EDIT_ACTIVITY_LIFE","에딧스케줄액티비티 온크리에이트")

        AndroidThreeTen.init(this)

        binding = ActivityEditScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getToken()

        schedule = intent.getSerializableExtra("schedule") as GetScheduleRes

        supportFragmentManager.beginTransaction()
            .replace(R.id.edit_frm, SeeScheduleFragment(schedule))
            .commitAllowingStateLoss()

        binding.editDeleteIv.setOnClickListener {
            deleteScheduleData()
            finish()
        }

        binding.editDarkView.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("EDIT_ACTIVITY_LIFE","에딧스케줄액티비티 온디스트로이")
        loadPref()
        clearPref()
        loadPref()
    }

    private fun deleteScheduleData(){
        val scheduleService = ScheduleService()
        scheduleService.setHomeView(this)

        scheduleService.deleteSchedule(access, schedule.scheduleIdx)
        Log.d("DELETE_SCHEDULE_DATA",access)
        Log.d("DELETE_SCHEDULE_DATA",schedule.scheduleIdx.toString())
    }

    override fun onInputScheduleSuccess(code: Int, result: ScheduleResult) {
        TODO("Not yet implemented")
    }

    override fun onEditScheduleSuccess(code: Int, result: String) {
        TODO("Not yet implemented")
    }

    override fun onDeleteScheduleSuccess(code: Int, result: String) {
        when(code){
            1000 -> {
                Log.d("ONDELETE_SCHEDULE_SUCCESS","SUCCESS, result : ${result}")
                Toast.makeText(this, "일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getToken(){

        val spf = getSharedPreferences("token", MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)
    }

    private fun loadPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(KEY_DATA)){
            val gson = Gson()
            val json = sharedPreferences.getString(KEY_DATA, "")
            try {
                val typeToken = object : TypeToken<TempSchedule>(){}.type
                tempSchedule = gson.fromJson(json, typeToken)
                Log.d("ADD_PREF", tempSchedule.toString())
            } catch (e : JsonParseException){
                e.printStackTrace()
            }
        } else {
            Log.d("EDIT_ACT_PREF", "clear already")
        }
    }

    private fun clearPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()

        Log.d("EDIT_ACT_PREF", "clear doing")
    }
}