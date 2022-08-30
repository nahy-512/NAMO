package com.example.namo.Login.Onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.R
import kotlinx.android.synthetic.main.fragment_onboarding1.view.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class Onboarding1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_onboarding1, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager_onboarding)

        //skip
        view.onboarding1_skip_tv.setOnClickListener {
            viewPager?.currentItem = 4
        }

        //next
        view.onboarding1_next_btn.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }
}