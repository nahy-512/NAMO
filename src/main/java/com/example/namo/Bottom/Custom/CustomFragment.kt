package com.example.namo.Bottom.Custom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.namo.Bottom.Custom.Adapter.CustomVPAdapter
import com.example.namo.Bottom.Home.MenuFragment
import com.example.namo.Bottom.MainActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentCustomBinding
import com.google.android.material.tabs.TabLayoutMediator

class CustomFragment : Fragment() {

    lateinit var binding: FragmentCustomBinding

    private val information = arrayListOf("팔레트", "폰트", "MY") //스티커 삭제

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCustomBinding.inflate(inflater, container, false)

        //메뉴
        binding.testListIv.setOnClickListener {
            Log.d("CLICK","click")
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MenuFragment()).commitAllowingStateLoss()
        }

        val customAdapter = CustomVPAdapter(this)
        binding.customContentVp.adapter = customAdapter

        TabLayoutMediator(binding.customContentTb, binding.customContentVp){
                tab, position->
            tab.text= information[position]  //포지션에 따른 텍스트
        }.attach()  //탭레이아웃과 뷰페이저를 붙여주는 기능

        return binding.root
    }
}