package com.example.namo.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.Bottom.MainActivity
import com.example.namo.Data.Login.*
import com.example.namo.Data.ApiClient
import com.example.namo.R
import com.example.namo.databinding.ActivityLoginBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.ramotion.paperonboarding.PaperOnboardingPage


class LoginActivity: AppCompatActivity(), KakaoLoginView, NaverLoginView  {

    lateinit var binding: ActivityLoginBinding

    private var accessToken : String = ""
    private var refreshToken : String = ""
    private var autoLogin : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NaMo)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


       /** 네이버 최초 로그인 */
        binding.loginNaverBt.setOnClickListener {
            startNaverLogin() //네이버 로그인 시작
        }

        kakaoLogin()

        }

        private fun kakaoLogin() {

            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {  //토큰 에러
                    when {
                        error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                            Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                            Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                            Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT)
                                .show()
                        }
                        error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                            Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                            Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                            Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT)
                                .show()
                        }
                        error.toString() == AuthErrorCause.ServerError.toString() -> {
                            Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                        }
                        error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                            Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                        }
                        else -> { // Unknown
                            Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else if (token != null) {
                    Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()

                    //토큰 저장
                    val spf = getSharedPreferences("token" , MODE_PRIVATE)

                    spf.edit().putString("access",token.accessToken).apply()
                    val accessToken=spf.getString("access","")

                    spf.edit().putString("refresh",token.refreshToken).apply()
                    val refreshToken=spf.getString("refresh","")

                    val kakaoService = LoginService()
                    kakaoService.setKakaoLoginView(this)
                    kakaoService.kakaologin(KaKaoData("$accessToken", "$refreshToken"))

                    Log.d("kakao_access_token", "$accessToken")
                    Log.d("kakao_refresh_token","$refreshToken")

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

        }

    }
    //로그인 버튼 클릭시 로그인(카카오톡/카카오 계정)
    binding.loginKakaoBt.setOnClickListener {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

}

    private fun startNaverLogin() {
        var naverToken: String? = ""

        /** Naver Login Module Initialize */
        val naverClientId = getString(R.string.social_login_info_naver_client_id)
        val naverClientSecret = getString(R.string.social_login_info_naver_client_secret)
        val naverClientName = getString(R.string.social_login_info_naver_client_name)
        NaverIdLoginSDK.initialize(
            this, naverClientId, naverClientSecret, naverClientName
        ) //네아로 객체 초기화

        /** OAuthLoginCallback을 authenticate() 메서드 호출 시 파라미터로 전달하거나 NidOAuthLoginButton 객체에 등록하면 인증이 종료되는 것을 확인할 수 있습니다. */
        val oauthLoginCallback = object : OAuthLoginCallback {
            override fun onSuccess() {
                naverToken = NaverIdLoginSDK.getAccessToken().toString()
                var naverRefreshToken = NaverIdLoginSDK.getRefreshToken().toString()



                //토큰 저장
                val spf = getSharedPreferences("token" , MODE_PRIVATE)

                spf.edit().putString("access",naverToken).apply()
                val getAccessToken = spf.getString("access",naverToken)

                spf.edit().putString("refresh",naverRefreshToken).apply()
                val getRefreshToken = spf.getString("refresh",naverRefreshToken)

                val naverService = LoginService()

                naverService.setNaverLoginView(this@LoginActivity)
                naverService.naverlogin(NaverData("$getAccessToken", "$getRefreshToken"))

                Log.d("naver_access_token", "$getAccessToken")
                Log.d("naver_refresh_token","$getRefreshToken")

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)

            }
            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(this@LoginActivity, "errorCode: $errorCode, errorDesc: $errorDescription", Toast.LENGTH_SHORT).show()
            }
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
    }
        NaverIdLoginSDK.authenticate(this, oauthLoginCallback)

    }

    override fun onKakaoLoginSuccess(code: Int, result: KakaoResult) {
        when(code){
            1000-> {  //로그인 성공

                Log.d("KAKAO_LOGIN_SUCCESS","SUCCESS, code: ${code}, result : ${result}")

                accessToken = result.accessToken
                refreshToken = result.refreshToken

                val spf = getSharedPreferences("token" , MODE_PRIVATE)

                spf.edit().putString("access",accessToken).apply()
                spf.edit().putString("refresh",refreshToken).apply()
                spf.edit().putInt("autoLogin",1).apply()
                spf.edit().putString("site","kakao").apply()

                Log.d("login-check-token", "access = ${spf.getString("access","")}, refresh = ${spf.getString("refresh","")}, auto-Login = ${spf.getInt("autoLogin",0)},  site = ${spf.getString("site", "")}")
                Toast.makeText(this, "카카오 로그인 성공!", Toast.LENGTH_SHORT).show()

                val moveActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(moveActivityIntent)

                Log.d("login","success")

            }
        }
    }

    override fun onNaverLoginSuccess(code: Int, result: NaverResult) {
        when(code){
            1000-> {

                Log.d("NAVER_LOGIN_SUCCESS","SUCCESS, code: ${code}, result : ${result}")

                accessToken = result.accessToken
                refreshToken = result.refreshToken

                val spf = getSharedPreferences("token" , MODE_PRIVATE)

                spf.edit().putString("access",accessToken).apply()
                spf.edit().putString("refresh",refreshToken).apply()
                spf.edit().putInt("autoLogin",1).apply()
                spf.edit().putString("site","naver").apply()

                Log.d("login-check-token", "access = ${spf.getString("access","")}, refresh = ${spf.getString("refresh","")}, auto-Login = ${spf.getInt("autoLogin",0)}, site = ${spf.getString("site", "")}")
                Toast.makeText(this, "네이버 로그인 성공!", Toast.LENGTH_SHORT).show()

                val moveActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(moveActivityIntent)

                Log.d("login","success")
            }
        }
    }



//    //MainActivity 이동
//    private fun setLayoutState(login: Boolean) {
//        if (login) {
//            startActivity(Intent(this, MainActivity::class.java)) //로그인됐으면 MainActivity로
//        }
//    }

}