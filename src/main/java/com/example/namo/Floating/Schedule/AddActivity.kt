package com.example.namo.Floating.Schedule

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Data.Schedule.TempSchedule
import com.example.namo.R
import com.example.namo.databinding.ActivityAddBinding
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.jakewharton.threetenabp.AndroidThreeTen


class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    var tempSchedule = TempSchedule()

    companion object {
        private const val KEY_PREFS = "tempSchedule"
        private const val KEY_DATA = "tempData"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ADD_LIFE","애드액티비티 온크리에이트")

        AndroidThreeTen.init(this)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val anim = TranslateAnimation(
//            TranslateAnimation.RELATIVE_TO_PARENT, -1.0f,
//            TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
//            TranslateAnimation.RELATIVE_TO_SELF, 0.0f,
//            TranslateAnimation.RELATIVE_TO_SELF, 0.0f
//        )
//        anim.duration = 500
//        anim.fillAfter = true
//        binding.addFrm.animation = anim
////        findViewById<View>(R.id.customdialogpanel).animation = anim
//        anim.start()

        supportFragmentManager.beginTransaction()
            .replace(R.id.add_frm, NewScheduleFragment())
            .commitAllowingStateLoss()


        binding.addDarkView.setOnClickListener {
            //닫기 전에 저장? 알리기?
            Log.d("FINISH_Dark_view", "FINISH")
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("ADD_LIFE","애드액티비티 온스타트")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ADD_LIFE","애드액티비티 온리줌")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ADD_LIFE","애드액티비티 온포즈")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ADD_LIFE","애드액티비티 온스탑")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ADD_LIFE","애드액티비티 온디스트로이")
        loadPref()
        clearPref()
        loadPref()
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
            Log.d("ADD_PREF", "clear already")
        }
    }

    private fun clearPref(){
        val sharedPreferences = getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().commit()

        Log.d("ADD_PREF", "clear doing")
    }

}