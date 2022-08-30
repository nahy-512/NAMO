package com.example.namo.Bottom.Group


import android.content.Intent

import android.content.Context

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter
import com.example.namo.Bottom.Group.Adapter.SeeGroupPersonScheduleRVAdapter
import com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter
import com.example.namo.Bottom.Home.EditScheduleActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.ForGroupSchedule
import com.example.namo.Data.Group.MemberSchedule
import com.example.namo.Data.Group.ScheduleRes
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.Data.Login.GlobalApplication
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.R
import com.example.namo.databinding.FragmentSeeGroupScheduleBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


//그룹 캘린더 날짜 클릭시 보여주는 일정 리스트
class SeeGroupScheduleFragment(val year : Int, month : Int, val date : Int, val member : ArrayList<MemberSchedule>, val group : ArrayList<ScheduleRes>, val moimColor : String) : Fragment() {
    lateinit var binding: FragmentSeeGroupScheduleBinding

    private var monthStr = ""
    private var dateStr = ""

    var month = month

    lateinit var mContext : Context

    lateinit var moimPeople : ArrayList<moimAttendences>
    private var gson : Gson = Gson()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeeGroupScheduleBinding.inflate(inflater, container, false)


        monthStr = if (month < 10) "0"+month else "$month"
        dateStr = if (date < 10) "0"+date else "$date"

        binding.seeGroupDateTv.text = "$year.$monthStr.$dateStr"

        binding.seeGroupCloseTv.setOnClickListener {
            activity?.finish()
        }

        var memberSchedule = ArrayList<ForGroupSchedule>()
        var userIdx = 0
        var color = ""
        for (i in member){
            userIdx = i.memberIdx
            color = i.memberColor
            for (j in i.scheduleRes){
                memberSchedule.add(
                    ForGroupSchedule(
                        j.scheduleIdx,
                        findName(userIdx),
                        color,
                        j.name,
                        j.startDate,
                        j.endDate,
                        j.categoryIdx,
                        j.location,
                        j.locationX,
                        j.locationY,
                        j.memoIdx
                    )
                )
            }
        }

        Log.d("MEMBER_SCHEDULE", memberSchedule.toString())
        val schedulePersonRVAdapter = SeeGroupPersonScheduleRVAdapter(mContext, memberSchedule)
        binding.seeGroupPersonScheduleRv.adapter = schedulePersonRVAdapter
        binding.seeGroupPersonScheduleRv.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)

        val scheduleGroupRVAdapter = SeeGroupGroupScheduleRVAdapter(mContext, group, moimColor)
        binding.seeGroupGroupScheduleRv.adapter = scheduleGroupRVAdapter
        binding.seeGroupGroupScheduleRv.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)

        binding.seeGroupAddScheduleLayout.setOnClickListener {
            (context as GroupScheduleActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.group_schedule_frm, NewGroupScheduleScheduleFragment())
                .commitAllowingStateLoss()
        }

        scheduleGroupRVAdapter.setsMyItemClickListener( object : SeeGroupGroupScheduleRVAdapter.GroupMemoClickListener {
            override fun onItemsClick(schedule : ScheduleRes,position:Int) {

                val intent = Intent(context, GroupSeeActivity()::class.java)
                intent.putExtra("schedules", schedule)
                startActivity(intent)
            }
        })


        return binding.root
    }

    fun findName(idx : Int) : String {
        var name = ""
        for (i in moimPeople){
            if (idx == i.userIdx) {
                name = i.username
                break
            }
        }
        if (name.equals("")){
            name = "이름없음"
        }
        return name
    }

    fun moimInfo() {
        val spf = requireActivity().getSharedPreferences("Moim", Context.MODE_PRIVATE)
        val editor = spf.edit()

        val groupJson : String = spf.getString("moimAttendences", "")!!
        val listType: Type = object : TypeToken<ArrayList<moimAttendences>>() {}.type
        moimPeople = gson.fromJson(groupJson, listType)

        Log.d("MOIM_INFO", moimPeople.toString())

//        memberNames.clear()
//        memberNames.apply {
//            for (i in 0..(moimPeople.size-1)){
//                add(moimPeople.get(i).username)
//            }
//        }
//        Log.d("MOIM_INFO", "멤버네임 : ${memberNames}")
    }
}