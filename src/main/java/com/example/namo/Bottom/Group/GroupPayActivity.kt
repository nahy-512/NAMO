package com.example.namo.Bottom.Group

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.CheckPeople
import com.example.namo.Data.Group.ScheduleRes
import com.example.namo.Data.Group.moimAttendences
import com.example.namo.databinding.ActivityGroupPayBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.daum.mf.map.api.MapView
import java.lang.reflect.Type


//정산 페이지
class GroupPayActivity : Activity() {
    lateinit var binding : ActivityGroupPayBinding

    private var peopleCount : Int = 0
    private var totalPay : Int = 0
    private var eachPay : Int = 0
    private var moimIdx : Int = -1
    private var moimPeople :  ArrayList<moimAttendences> = arrayListOf()
    private var memberNames : ArrayList<String> = arrayListOf()
    private var memberIdx : ArrayList<Int> = arrayListOf()
//    private var checkedMemberIdx : ArrayList<Int> = arrayListOf()
    private var memberIsChecked : ArrayList<Boolean> = arrayListOf()
    var checkedMemberIdx = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        finishActivity()

        getGroupInfo()
        account()

    }

        private fun getGroupInfo(){

            val spf = getSharedPreferences("GroupMemo", Context.MODE_PRIVATE)

            val groupJsons : String = spf.getString("moimAttendences", "").toString()
            val listType: Type = object : TypeToken<ArrayList<moimAttendences>>() {}.type
            moimPeople = Gson().fromJson(groupJsons, listType)!! // userIdx, userName 들어가잇음

            moimIdx = spf.getInt("moimIdx",-1)

            memberNames.clear()
            memberNames.apply {
                for (i in moimPeople){
                    add(i.username)
                }
            }
            memberIdx.apply {
                for (i in moimPeople){
                    add(i.userIdx)
                }
            }
            memberIsChecked.apply {
                for (i in (0..moimPeople.size - 1)){
                    add(false)
                }
            }

            Log.d("MOIM_INFO", "멤버네임 : ${memberNames}")

        }

    private fun account(){
        val peopleRVAdapter = GroupPayActivityRVAdapter(moimPeople, memberIsChecked)
        binding.groupPayPersonRv.adapter = peopleRVAdapter
        binding.groupPayPersonRv.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)


        peopleRVAdapter.setPeopleItemClickListener(object : GroupPayActivityRVAdapter.PeopleItemClickListener{
            @SuppressLint("SetTextI18n")
            override fun onItemClick(peopleList: ArrayList<moimAttendences>, checkList : ArrayList<Boolean>) {

                Log.d("PAY_ACTIVITY", peopleList.toString())
                Log.d("PAY_ACTIVITY", checkList.toString())
               peopleCount = 0
                for (i in (0..peopleList.size - 1)){
                    if (checkList.get(i)) {
                        peopleCount++
                    }
                }
                binding.groupPayCountTv.setText("$peopleCount 명")

                if (!(binding.groupPayTotalEt.text.toString().equals("금액 입력"))){
                    totalPay = binding.groupPayTotalEt.text.toString().toInt()
                    eachPay = totalPay / peopleCount
                    binding.groupPayResultTv.setText("$eachPay")
                }

                for (i in (0..checkList.size - 1)){
                    if (checkList.get(i)){
                        checkedMemberIdx.add(memberIdx.get(i))
                    }
                }
            }

        })

    }

    private fun finishActivity() {
        binding.groupPayBackTv.setOnClickListener {
            finish() //뒤로가기
        }
        binding.groupPaySaveTv.setOnClickListener {

            val sharedPreference = getSharedPreferences("getPay", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putInt("eachPay",eachPay) //정산 금액
            editor.putString("memberIdx","$checkedMemberIdx") //체크한 사람 useridx 리스트
            editor.apply()
            finish()

//            val intent= Intent(this, GroupAddPlaceActivity::class.java)
//            intent.putExtra("eachPay",eachPay)
//            intent.putExtra("memberIdx","$memberIdx")
//            startActivity(intent)
//            finish()

        }
    }
}