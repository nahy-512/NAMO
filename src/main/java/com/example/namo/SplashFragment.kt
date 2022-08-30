package com.example.namo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.namo.Login.LoginActivity

//온보딩 뷰페이저용
class SplashFragment : Fragment() {

    lateinit var mContext: Context
    lateinit var mActivity: SplashActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SplashActivity){
            mContext = context
            mActivity = activity as SplashActivity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val spf = mActivity.getSharedPreferences("token", Activity.MODE_PRIVATE)
        val auto = spf!!.getInt("autoLogin", 0)!!



        Handler(Looper.getMainLooper()).postDelayed({

            if (onBoardingFinished()) { //true면 이동
                Log.d("SPLASH-Onboarding-True", "이미 온보딩했음")
                /** 자동 로그인 */
                if(auto == 1) {
                    //SplashActivity에서 처리. 바로 MainActivity로
                } else { //자동로그인 아닐 시
//                    Toast.makeText(mContext, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
                    Log.d("SPLASH-FRAG-Login-Failure", "자동 로그인 실패")
                    startActivity(Intent(mActivity, LoginActivity::class.java))
                }

            }else { //false면 온보딩
                Log.d("SPLASH-Onboarding-False", "첫 온보딩")
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }


        }, 1000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished() : Boolean {
        val spf = mActivity.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return spf.getBoolean("Finished", false)
    }
}