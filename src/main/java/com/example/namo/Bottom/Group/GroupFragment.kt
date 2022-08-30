package com.example.namo.Bottom.Group

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.namo.Bottom.Group.Adapter.GroupRVAdapter
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Category.CategoryService
import com.example.namo.Data.Group.*
import com.example.namo.R
import com.example.namo.databinding.FragmentGroupBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_group.*


//바텀네비 그룹
class GroupFragment : Fragment(), GroupFragView {

    lateinit var binding: FragmentGroupBinding

    private var gson: Gson = Gson()

    var access : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentGroupBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        getToken()

        onClickMenu()
    }

    override fun onResume() {
        super.onResume()

        getGroupList() //그룹 리스트 가져오기
    }


    //리사이클러뷰 어댑터 연결
    private fun initRecyclerView(result: ArrayList<GroupListResult>) {

        val groupRVAdapter = GroupRVAdapter(requireContext(), result)
        binding.groupListRv.adapter = groupRVAdapter
        binding.groupListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //아이템 없을 때
        group_list_empty_tv.visibility = (if(groupRVAdapter.itemCount == 0)View.VISIBLE else View.GONE)

        //전체 아이템 클릭
        groupRVAdapter.setMyItemClickListener(object : GroupRVAdapter.ItemClickListener{
            override fun onItemClick(group: GroupListResult, position: Int) {
                Log.d("Group-FRAG","그룹 리스트를 클릭했음")

                //여기서 가져올 수 있을 듯!
                Log.d("Group-FRAG-member", "$group , $position")

                val spf = requireActivity().getSharedPreferences("Moim", Context.MODE_PRIVATE)
                val editor = spf.edit()

                val groupJson = gson.toJson(group)
                val attendencesJson=gson.toJson(group.moimAttendences)

                editor.putString("groupJson", groupJson)
                editor.putInt("moimIdx", group.moimIdx)
                editor.putString("moimAttendences",attendencesJson)

                editor.apply()


                Log.d("Group-MoimIdx", group.moimIdx.toString())
                Log.d("SPF-Group-FRAG", "보내는 쪽 moimIdx = ${spf.getInt("moimIdx", 0)}")


                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, GroupCalendarWrapperFragment(group))
                    .commitAllowingStateLoss()
            }
        })
        //더보기 아이템 클릭
        groupRVAdapter.setInfoItemClickListener(object : GroupRVAdapter.ItemClickListener{
            override fun onItemClick(group: GroupListResult, position: Int) {

                Log.d("Group-FRAG","그룹 더보기 클릭했음")
                Log.d("Group-FRAG-member", "${group.name}, $position")

                val spf = requireActivity().getSharedPreferences("Moim", Context.MODE_PRIVATE)
                val editor = spf.edit()
                val groupJson = gson.toJson(group)

                editor.putString("groupJson", groupJson)
                editor.putInt("moimIdx", group.moimIdx)
                editor.putString("moimImg", group.profileImg)
                editor.putString("moimName", group.name)
                editor.apply()

                Log.d("Group-MoimIdx", group.moimIdx.toString())
                Log.d("SPF-Group-FRAG", "보내는 쪽 moimIdx = ${spf.getInt("moimIdx", 0)}")

                startActivity(Intent(activity, EditGroupNameActivity::class.java)) //이름 수정창으로

            }
        })

//        fun checkEmpty() {
//            group_list_empty_tv.visibility = (if(groupRVAdapter.itemCount == 0)View.VISIBLE else View.GONE)
//
//            }

//        fun submitList(items: List<GroupListResult>) {
//            group_list_empty_tv.isVisible = false
//            group_list_rv.isVisible = true
//            groupRVAdapter.setItems(items)
//
//            if (items.isEmpty()) {
//                    group_list_empty_tv.isVisible = true
//                    group_list_rv.isVisible = false
//            }
//        }
    }

    private fun getGroupList() {
        val groupService = GroupService()
        groupService.setGroupListView(this)

        groupService.getGroupList(access)

        Log.d("INQUIRY_GROUP_DATA",access)

    }

    // 7.7 그룹 리스트
    override fun onGetGroupListSuccess(code: Int, result: ArrayList<GroupListResult>) {
        when(code){
            1000-> {
                Log.d("GET_GROUP_LIST_SUCCESS","SUCCESS, result : ${result}")

                initRecyclerView(result)

//                finish()

            }
        }
    }

    //실패시 코드
    override fun onGetGroupFailure(code: Int, message: String) {
        Log.d("Group-FRAG/Group-RESPONSE", "${code}, ${message}")

    }

    //메뉴 클릭시
    private fun onClickMenu(){
        binding.groupMoreIv.setOnClickListener {
            var popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.group_search_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                if (menuItem.itemId === R.id.createGroup) {
                    Toast.makeText(activity, "그룹 생성", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(activity, AddGroupActivity::class.java))
                } else if (menuItem.itemId === R.id.inputGroupCode) {
                    Toast.makeText(activity, "그룹 코드 입력", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(activity, InputGroupCodeActivity::class.java))
                }
                false
            }
            popupMenu.show()
        }
    }

    private fun getToken() {

        val spf = requireActivity().getSharedPreferences("token", Activity.MODE_PRIVATE)

        access = spf!!.getString("access","")!!

        Log.d("Group-FRAG/TOKEN-ACC", access)
    }


}