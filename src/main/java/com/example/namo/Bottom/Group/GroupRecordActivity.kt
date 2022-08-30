package com.example.namo.Bottom.Group

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.Adapter.GroupRecordEventRVAdapter
import com.example.namo.Bottom.Group.Adapter.GroupRecordMemberRVAdapter
import com.example.namo.Data.GroupPlace
import com.example.namo.R
import com.example.namo.databinding.ActivityGroupRecordBinding


//GroupAddPlaceActivity랑 중복인 거 같은데 쓰는건가?
class GroupRecordActivity : AppCompatActivity() {

    lateinit var binding : ActivityGroupRecordBinding
    var memberNames = ArrayList<String>()
    var groupPlaceList = ArrayList<GroupPlace>()

    private var isMemberOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val groupRecordMemberRVAdapter = GroupRecordMemberRVAdapter(memberNames)
        binding.groupRecordMemberRv.adapter = groupRecordMemberRVAdapter
        binding.groupRecordMemberRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val groupRecordEventRVAdapter = GroupRecordEventRVAdapter(groupPlaceList)
        binding.groupRecordEventRv.adapter = groupRecordEventRVAdapter
        binding.groupRecordEventRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.groupRecordBackIv.setOnClickListener {
            finish()
        }

        binding.groupRecordMemberHeaderLayout.setOnClickListener {
            if (!isMemberOpen){
                binding.groupRecordMemberMoreIv.setImageResource(R.drawable.ic_arrow_row_gray)
                binding.groupRecordMemberRv.visibility = View.VISIBLE
            }
            else {
                binding.groupRecordMemberMoreIv.setImageResource(R.drawable.ic_arrow_top_gray)
                binding.groupRecordMemberRv.visibility = View.GONE
            }

            isMemberOpen = !isMemberOpen
        }

        binding.groupRecordAddPlace.setOnClickListener {

        }

    }
}