package com.example.namo.Bottom.Group

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.Bottom.Group.Adapter.GroupCalendarPagerFragmentStateAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Group.Group
import com.example.namo.Data.Group.GroupListResult
import com.example.namo.R
import com.example.namo.databinding.FragmentGroupCalendarWrapperBinding
import kotlinx.android.synthetic.main.fragment_group_calendar_wrapper.view.*


//그룹 캘린더
class GroupCalendarWrapperFragment(val group : GroupListResult) : Fragment() {

    private val TAG = javaClass.simpleName
    lateinit var mContext : Context

    lateinit var groupCalendarViewPager : ViewPager2
    lateinit var groupCalendarTitle : TextView
    lateinit var groupCalendarMore : ImageView

    lateinit var binding : FragmentGroupCalendarWrapperBinding

    companion object {
        var instance : GroupCalendarWrapperFragment? = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity){
            mContext = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_group_calendar_wrapper, container, false)
        binding = FragmentGroupCalendarWrapperBinding.inflate(layoutInflater, container, false)

        groupCalendarViewPager = view.group_calendar_vp
        groupCalendarTitle = view.group_calendar_group_title_tv
        groupCalendarMore = view.group_calendar_group_more_iv

        groupCalendarTitle.setText(group.name) //8.17 코코아
        Log.d("GROUP_NAME", group.name) //8.17 코코아
//        binding.groupCalendarNameTv.text = group.title.toString()
//        Log.d("GROUP_NAME", group.title)

        groupCalendarMore.setOnClickListener {
            Toast.makeText(context as MainActivity, "그룹정보 터치", Toast.LENGTH_SHORT).show()

            startActivity(Intent(activity, GroupInfoBubbleActivity::class.java))
            
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        val groupCalendarPagerFragmentStateAdapter = GroupCalendarPagerFragmentStateAdapter(requireActivity())
        groupCalendarViewPager.adapter = groupCalendarPagerFragmentStateAdapter
        groupCalendarViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        groupCalendarPagerFragmentStateAdapter.apply {
            groupCalendarViewPager.setCurrentItem(this.groupFragmentPosition, false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
    }


}
