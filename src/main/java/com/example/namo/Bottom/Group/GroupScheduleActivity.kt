package com.example.namo.Bottom.Group

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Data.Group.MemberSchedule
import com.example.namo.Data.Group.ScheduleRes
import com.example.namo.R
import com.example.namo.databinding.ActivityGroupScheduleBinding
import com.jakewharton.threetenabp.AndroidThreeTen


//그룹 공유 일정 추가하는 Activity
class GroupScheduleActivity : AppCompatActivity() {
    lateinit var binding : ActivityGroupScheduleBinding

    var year = 0
    var month = 0
    var date = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidThreeTen.init(this)

        binding = ActivityGroupScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        year = intent.getIntExtra("year",0)
        month = intent.getIntExtra("month",0)
        date = intent.getIntExtra("date",0)
        var member = intent.getSerializableExtra("member") as ArrayList<MemberSchedule>
        var moim = intent.getSerializableExtra("moim") as ArrayList<ScheduleRes>
        var moimColor = intent.getStringExtra("moimColor")

        supportFragmentManager.beginTransaction()
            .replace(R.id.group_schedule_frm, SeeGroupScheduleFragment(year, month, date, member, moim, moimColor!!))
            .commitAllowingStateLoss()

        binding.groupScheduleDarkView.setOnClickListener {
            finish()
        }
    }
}