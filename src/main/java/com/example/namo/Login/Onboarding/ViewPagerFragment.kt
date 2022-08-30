package com.example.namo.Login.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.Login.Onboarding.screen.*
import com.example.namo.R
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*



class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)


        val fragmentList = arrayListOf<Fragment>(
            Onboarding1(),
            Onboarding2(),
            Onboarding3(),
            Onboarding4(),
            Onboarding5()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        view.viewPager_onboarding.adapter = adapter



        //  indicator
        view.viewPager_onboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                indicator0_iv.setImageResource(R.drawable.shape_circle_gray)
                indicator1_iv.setImageResource(R.drawable.shape_circle_gray)
                indicator2_iv.setImageResource(R.drawable.shape_circle_gray)
                indicator3_iv.setImageResource(R.drawable.shape_circle_gray)
                indicator4_iv.setImageResource(R.drawable.shape_circle_gray)

                when(p0){
                    0 -> indicator0_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    1 -> indicator1_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    2 -> indicator2_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    3 -> indicator3_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    4 -> indicator4_iv.setImageResource(R.drawable.shape_circle_mainorange)
                }

                when(p0){
                    0 -> indicator0_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    1 -> indicator1_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    2 -> indicator2_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    3 -> indicator3_iv.setImageResource(R.drawable.shape_circle_mainorange)
                    4 -> indicator4_iv.setImageResource(R.drawable.shape_circle_mainorange)
                }
            }
        })

        return view
    }


}