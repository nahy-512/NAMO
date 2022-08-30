package com.example.namo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Login.LoginService
import com.example.namo.Data.Login.NaverData
import com.example.namo.Data.Login.Reissuance
import com.example.namo.Data.Login.ReissuanceResult
import com.example.namo.Login.LoginActivity
import com.example.namo.Login.ReissuanceTokenView
import com.example.namo.databinding.ActivitySplashBinding
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient

class SplashActivity: AppCompatActivity(), ReissuanceTokenView  {
    lateinit var binding: ActivitySplashBinding

    private var accessToken : String = ""
    private var refreshToken : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val spf = getSharedPreferences("token", Activity.MODE_PRIVATE)
        val auto = spf!!.getInt("autoLogin", 0)!!

        accessToken = spf!!.getString("access","")!!
        refreshToken = spf!!.getString("refresh","")!!

        val site = spf!!.getString("site", "")!!


        /** 자동 로그인 */
        if(auto == 1) {

            Log.d("SPF-LOGIN-SPLASH-TOKEN","access: $accessToken, refresh: $refreshToken") //토큰 상태 체크
            Log.d("SPF-LOGIN-SPLASH-TOKEN","site: $site") //어디서 건너 온 토큰인가


            onEveryTime() //자동 로그인, 토큰 갱신

        } else {
            Log.d("SPLASH-ACT-Login-Failure", "자동 로그인 실패")
//            Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
//            val moveActivityIntent = Intent(this, LoginActivity::class.java)
//            startActivity(moveActivityIntent)
//            finish()
        }

    }

    private fun onEveryTime() {

        val loginService = LoginService()
        loginService.setReissuanceTokenView(this@SplashActivity)
        loginService.reissuanceLogin(Reissuance(accessToken, refreshToken))

        Log.d("LOGIN-SPLASH-TOKEN","access: $accessToken, refresh: $refreshToken")

    }

    //1.3 access 재발급 성공 -> 자동 로그인
    override fun onReissuanceSuccess(code: Int, result: ReissuanceResult) {
        when(code){
            1000-> {
                Log.d("reissuance-auto-login","success")
                Log.d("REISSUANCE_LOGIN_SUCCESS","SUCCESS, code: ${code}, result : ${result}")

                accessToken = result.accessToken
                refreshToken = result.refreshToken

                val spf = getSharedPreferences("token" , MODE_PRIVATE)

                spf.edit().putString("access",accessToken).apply()

                spf.edit().putString("refresh",refreshToken).apply()

                Log.d("reissuance-check-token", "access = ${spf.getString("access","")}, refresh = ${spf.getString("refresh","")}")
//                Toast.makeText(this, "자동 로그인 성공!", Toast.LENGTH_SHORT).show()

                //바로 메인 화면으로 넘어감
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
    }

    //1.3 refresh 만료 -> 로그인 화면
    override fun onResissuanceExpire(code: Int, result: ReissuanceResult) {
        when(code){
            3017-> {
                Log.d("reissuance-login-expire","refreshToken 만료")
                Log.d("REISSUANCE_LOGIN_SUCCESS","SUCCESS, code: ${code}, result : ${result}")

                Toast.makeText(this, "refresh 토큰 만료!", Toast.LENGTH_SHORT).show()

                //로그인 화면으로 넘어감
                val moveActivityIntent = Intent(this, LoginActivity::class.java)
                startActivity(moveActivityIntent)
                finish()
            }
        }
    }

    //실패시 로그인 화면으로 넘어감
    override fun onReissuanceFailure(code: Int, message: String) {
        Log.d("SPLASH-ACT/Login-Reissuance-RESPONSE", "${code}, ${message}")

        //auto-login -> 0
        val spf = getSharedPreferences("token" , MODE_PRIVATE)
        spf.edit().putInt("autoLogin",0).apply()

        val moveActivityIntent = Intent(this, LoginActivity::class.java)
        startActivity(moveActivityIntent)
        finish()
    }


    //앨리가 했던 부분
    private fun kakaoAutoLogin() {
        if (AuthApiClient.instance.hasToken()) {  //발급받은 토큰이 있는 지 확인
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    if (error is KakaoSdkError && error.isInvalidTokenError()) {  //유효하지 않은 토큰
                        val moveActivityIntent = Intent(this, LoginActivity::class.java)
                        startActivity(moveActivityIntent)
                    }
                } else if (tokenInfo != null) {  // 바로 메인화면으로 넘어감
                    Toast.makeText(this, "카카오 토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                    Log.d("tokenInfo", "SUCCESS" + "\n회원 번호: ${tokenInfo.id}")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
        }
        else { //발급받은 토큰이 없으면 로그인 화면
            Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            val moveActivityIntent = Intent(this, LoginActivity::class.java)
            startActivity(moveActivityIntent)
            finish();
        }
    }
}