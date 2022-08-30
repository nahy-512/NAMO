package com.example.namo.Data.Login

import android.app.Application
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.namo.Data.Group.ScheduleRes
import com.example.namo.Floating.Schedule.NewScheduleFragment
import com.example.namo.R
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {


    private var memberSchedule = ArrayList<ScheduleRes>()
    private var groupSchedule = ArrayList<ScheduleRes>()

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this,getString(R.string.kakao_app_key))
    }

    fun getMemberSchedule() : ArrayList<ScheduleRes> {
        return memberSchedule
    }

    fun getGroupSchedule() : ArrayList<ScheduleRes>{
        return groupSchedule
    }

    fun setMemberSchedule(memberSchedule : ArrayList<ScheduleRes>){
        this.memberSchedule = memberSchedule
        Log.d("LOCAL_DATA_MEMBER_STORE",this.memberSchedule.toString())
    }

    fun setGroupSchedule(groupSchedule : ArrayList<ScheduleRes>){
        this.groupSchedule = groupSchedule
        Log.d("LOCAL_DATA_GROUP_STORE",this.groupSchedule.toString())
    }


}
//kakao login, Native App Key로 초기화