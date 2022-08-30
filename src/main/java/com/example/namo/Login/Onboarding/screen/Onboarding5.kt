package com.example.namo.Login.Onboarding.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Login.*
import com.example.namo.Login.LoginActivity
import com.example.namo.Login.Onboarding.TermsActivity
import com.example.namo.R
import com.example.namo.databinding.FragmentCategoryDetailBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import kotlinx.android.synthetic.main.fragment_onboarding5.view.*


class Onboarding5 : Fragment() {

//    lateinit var binding: FragmentCategoryDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_onboarding5, container, false)

//        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager_onboarding)
        view.onboarding5_start_btn.setOnClickListener {
            startActivity(Intent(activity, TermsActivity::class.java)) //시작하기 누르면 이용약관 먼저
            onBoardingFinished()
        }

        return view
    }

    private fun onBoardingFinished() {
        val spf = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = spf.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}