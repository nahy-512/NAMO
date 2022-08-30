package com.example.namo.Bottom.Diary


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ContentInfoCompat
import androidx.databinding.adapters.AdapterViewBindingAdapter.setSelection
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.GroupMemoEditActivity
import com.example.namo.Bottom.Group.GroupSeeActivity
import com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter
import com.example.namo.Bottom.Home.Record.RecordEditActivity
import com.example.namo.Bottom.Home.Record.RecordWriteActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.Data.Schedule.DaySchedule
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.Memo.*
import com.example.namo.Data.Schedule.ScheduleService
import com.example.namo.R
import com.example.namo.databinding.FragmentDiaryBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*
import kotlin.collections.ArrayList

//bottom 전체 메모 보여주는 화면
class DiaryFragment: Fragment(),GetAllMemoView  {

    lateinit var binding: FragmentDiaryBinding
    private var access: String = ""
    private lateinit var diaryList: ArrayList<MonthMemoDto>
    lateinit var dates : String
    private var sendDate = Date()
    private lateinit var spinner: Spinner
    private lateinit var dateTime:String

    lateinit var scheduleList :GetScheduleRes


    lateinit var mContext: Context
    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity){
            mContext = context
            mActivity = activity as MainActivity
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)


        //헤더에 카카오 토큰 받기
        val spf = activity?.getSharedPreferences("token", AppCompatActivity.MODE_PRIVATE)
        access = spf?.getString("access", "")!!

        dateTime= SimpleDateFormat(
            "yyyy-MM",
            Locale.KOREA
        ).format(sendDate)


//        val shared =mContext.getSharedPreferences("getschedule", Context.MODE_PRIVATE)
//        val groupJson : String = shared?.getString("GetScheduleRes", "")!!
//        val listType: Type = object : TypeToken<GetScheduleRes>() {}.type
//
//        scheduleList = Gson().fromJson(groupJson, listType)!!
//        Log.d("GetScheduleRes","$scheduleList")


        spinner()

        return binding.root
    }

    private fun getMonth() {

        //메모 달별 조회
        val getAllMemoService = MemoService()
        getAllMemoService.getAllMemoView(this)
        getAllMemoService.getAllMemo(access, dateTime)
    }

    override fun onResume() {
        super.onResume()
        spinner.setSelection(7)
    }

    private fun onClickListener(){

        val diaryListRVAdapter= DiaryListRVAdapter(diaryList)
        binding.diaryListRv.adapter = diaryListRVAdapter
        diaryListRVAdapter.setItemsClickListener( object :DiaryListRVAdapter.DiaryItemClickListener {

            override fun onDiaryClick(monthMemoDto: MonthMemoDto) {

                //수정 누르면 메모 편집화면으로 이동, 스케줄 메모
               val intent = Intent(context as MainActivity, RecordEditActivity()::class.java)
               // intent.putExtra("schedule", scheduleList)

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        })

        diaryListRVAdapter.setItemssClickListener( object :DiaryListRVAdapter.GroupItemClickListener {
            override fun onGroupClick(monthMemoDto: MonthMemoDto) {

                //수정 누르면 메모 편집화면으로 이동 , 그룹 메모
                val intent = Intent(context as MainActivity, RecordEditActivity()::class.java)

               // intent.putExtra("schedule", scheduleList)

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        })

    }

    private fun spinner() {

        //month 리스트 스피너 연결
        spinner = binding.monthSpinner
        spinner.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.itemList,
            R.layout.item_spinner
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter

            }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onNothingSelected(parent: AdapterView<*>?) {

              //바꾸기
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){  //나중에 고치기
                    0->
                    {dateTime="2022-01"
                    getMonth()}
                    1->{dateTime="2022-02"
                        getMonth()}
                    2->{dateTime="2022-03"
                        getMonth()}
                    3->{dateTime="2022-04"
                        getMonth()}
                    4->{dateTime="2022-05"
                        getMonth()}
                    5->{dateTime="2022-06"
                        getMonth()}
                    6->{dateTime="2022-07"
                        getMonth()}
                    7->{dateTime="2022-08"
                        getMonth()
                        }
                    8->{dateTime="2022-09"
                        getMonth()}
                    9->{dateTime="2022-10"
                        getMonth()}
                    10->{dateTime="2022-11"
                        getMonth()}
                    11->{dateTime="2022-12"
                        getMonth()}

                }
            }
        }
    }


    override fun onGetAllMemoSuccess(code: Int, result: List<MonthMemoDto>) {

        when (code) {
            1000 -> {
                diaryList = ArrayList(result)

                binding.diaryListRv.run {
                    adapter = DiaryListRVAdapter(diaryList)
                    layoutManager = LinearLayoutManager(context).apply {
                        orientation = LinearLayoutManager.VERTICAL
                    }
                }
                onClickListener()


            }
        }
    }



}





