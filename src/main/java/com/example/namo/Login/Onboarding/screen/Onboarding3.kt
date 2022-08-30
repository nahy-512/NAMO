package com.example.namo.Login.Onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.R
import kotlinx.android.synthetic.main.fragment_onboarding2.view.*
import kotlinx.android.synthetic.main.fragment_onboarding3.view.*


class Onboarding3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_onboarding3, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager_onboarding)

        //skip
        view.onboarding3_skip_tv.setOnClickListener {
            viewPager?.currentItem = 4
        }

        //next
        view.onboarding3_next_btn.setOnClickListener {
            viewPager?.currentItem = 3
        }
        return view
    }

}