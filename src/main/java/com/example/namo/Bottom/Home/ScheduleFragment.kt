package com.example.namo.Bottom.Home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.GroupSeeActivity
import com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter
import com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter
import com.example.namo.Bottom.Home.Record.RecordWriteActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Schedule.DaySchedule
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Group.GroupSchedule
import com.example.namo.Data.Schedule.ScheduleService
import com.example.namo.R
import com.example.namo.databinding.FragmentScheduleBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.kakao.sdk.auth.AuthApiClient
import java.util.*
import kotlin.collections.ArrayList

class ScheduleFragment(val year : Int, month : Int, val date : Int) : Fragment(), DaySchedule {

    private lateinit var binding: FragmentScheduleBinding

    private var monthStr = ""
    private var dateStr = ""

    lateinit var scheduleList : List<GetScheduleRes>
    private var groupScheduleList = ArrayList<GroupSchedule>()

    lateinit var sendDate : String

    private var access : String = ""
    private var refresh : String = ""
    private var site : String = ""

    var month = month

    var groupShow = 1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {

        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온크리에이트뷰")

        Log.d("SCHEDULE_FRAGMENT","$month 월 $date 일")
        binding = FragmentScheduleBinding.inflate(inflater, container, false)

        monthStr = if (month < 10) "0"+month else "$month"
        dateStr = if (date < 10) "0"+date else "$date"

        binding.scheduleDateTv.text = "$year.$monthStr.$dateStr"
        sendDate = "$year-$monthStr-$dateStr"

        //뒤로가기
        binding.scheduleBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
            (context as MainActivity).supportFragmentManager.popBackStack()
        }

        getToken()

//        onInitGroupRecyclerview() //모임 일정 리사이클러뷰
        binding.groupScheduleShowIv.setOnClickListener {
            onGroupScheduleShow()
        }


        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온어태치")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온크리에이트")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온스타트")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온리줌")
        getDaySchedule()
    }

    override fun onPause() {
        super.onPause()
        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온포즈")
    }

    override fun onStop() {
        super.onStop()

        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온스탑")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온디스트로이뷰")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SCHEDULE_FRAGMENT_LIFE","스케줄프래그먼트 온디스트로이")
    }

    private fun getDaySchedule(){
        Log.d("RESUME_GETDAY","getdayschedule start")
        val scheduleService = ScheduleService()
        scheduleService.setDayScheduleView(this)

        scheduleService.daySchedule(access, sendDate)

        Log.d("DAY_SCHEDULE",access)
        Log.d("DAY_SCHEDULE",sendDate)
    }

    private fun getToken(){

        val spf = activity?.getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("TOKEN-ACC",access)

    }

    override fun onGetDayScheduleSuccess(code: Int, results: List<GetScheduleRes>) {
        when(code){
            1000 ->{
                Log.d("ONGET_DAY_SCHEDULE_SUCCESS","SUCCESS, result : ${results.toString()}")
                scheduleList = results

                var personalSchedule = ArrayList<GetScheduleRes>()
                var moimSchedule = ArrayList<GetScheduleRes>()

                for (i in results){
                    if (i.moimIdx > 0) {
                        moimSchedule.add(i)
                    }
                    else {
                        personalSchedule.add(i)
                    }
                }

                Log.d("PERSONAL_SCHEDULE_LIST",personalSchedule.toString())
                Log.d("MOIM_SCHEDULE_LIST",moimSchedule.toString())


                val perScheduleRVAdapter = ScheduleRVAdapter(context as MainActivity, personalSchedule)
                binding.scheduleRv.adapter = perScheduleRVAdapter
                binding.scheduleRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


                perScheduleRVAdapter.setMyItemClickListener( object : ScheduleRVAdapter.DayItemClickListener {
                    override fun onItemClick(schedule: GetScheduleRes) {

                        val intent = Intent(context as MainActivity, EditScheduleActivity()::class.java)
                        intent.putExtra("schedule", schedule)
                        startActivity(intent)
                    }
                })
                perScheduleRVAdapter.setsMyItemClickListener( object : ScheduleRVAdapter.MyItemClickListener {
                    override fun onItemsClick(schedule: GetScheduleRes,position:Int) {


                        val sharedPreference = requireActivity().getSharedPreferences("getschedule", AppCompatActivity.MODE_PRIVATE)

                        val scheduleString: String = Gson().toJson(schedule)
                        val editor = sharedPreference.edit()
                        editor.putString("GetScheduleRes",scheduleString)
                        editor.apply()

                        val intent = Intent(context as MainActivity, RecordWriteActivity()::class.java)
                        intent.putExtra("schedule", schedule)
                        startActivity(intent)
                    }
                })

                val moimScheduleAdapter = GroupScheduleRVAdapter(context as MainActivity, moimSchedule)
                binding.groupScheduleRv.adapter = moimScheduleAdapter
                binding.groupScheduleRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                moimScheduleAdapter.setMyItemClickListener(object : GroupScheduleRVAdapter.GroupDayItemClickListener {
                    override fun onItemClick(schedule: GetScheduleRes, position: Int) {
                        val intent = Intent(context, GroupSeeActivity()::class.java)
                        intent.putExtra("moimInPersonal", schedule)
                        startActivity(intent)
                    }
                })

            }
        }
    }


    private fun onGroupScheduleShow() {

        if (groupShow == 1) {

            binding.groupScheduleRv.visibility = View.GONE
            binding.groupScheduleShowIv.setImageResource(R.drawable.ic_arrow_top_gray)

            groupShow = 0

        } else if (groupShow == 0) {

            binding.groupScheduleRv.visibility = View.VISIBLE
            binding.groupScheduleShowIv.setImageResource(R.drawable.ic_arrow_row_gray)

            groupShow = 1
        }
    }
}