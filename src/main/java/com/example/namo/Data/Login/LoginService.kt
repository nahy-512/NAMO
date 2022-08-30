package com.example.namo.Data.Login

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.namo.Data.ApiClient.getRetrofit
import com.example.namo.Login.KakaoLoginView
import com.example.namo.Login.LoginActivity
import com.example.namo.Login.NaverLoginView
import com.example.namo.Login.ReissuanceTokenView
import com.navercorp.nid.oauth.NidOAuthPreferencesManager.code
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService {
    private lateinit var kakaoLoginView: KakaoLoginView
    private lateinit var naverLoginView: NaverLoginView
    private lateinit var reissuanceView: ReissuanceTokenView


    fun setKakaoLoginView(kakaoLoginView: KakaoLoginView){
        this.kakaoLoginView=kakaoLoginView
    }

    fun setNaverLoginView(naverLoginView: NaverLoginView){
        this.naverLoginView=naverLoginView
    }

    fun setReissuanceTokenView(reissuanceView: ReissuanceTokenView){
        this.reissuanceView=reissuanceView
    }


    //카카오 로그인 입력
    fun kakaologin(kaKaoData: KaKaoData){
        val kakaoLoginService= getRetrofit().create(LoginRetrofitInterface::class.java)
        kakaoLoginService.kakaologin(kaKaoData).enqueue(object: Callback<KakaoResponse> {
            override fun onResponse(call: Call<KakaoResponse>, response: Response<KakaoResponse>) {
                Log.d("KakaoLogin/success",response.toString())
                val resp: KakaoResponse =response.body()!!

                when(val code=resp.code){
                    1000-> kakaoLoginView.onKakaoLoginSuccess(code,resp.result!!)
                }
            }

            override fun onFailure(call: Call<KakaoResponse>, t: Throwable) {
                Log.d("KakaoLogin/failure",t.message.toString())
            }

        })
        Log.d("KakaoLogin","loginOk")
    }

    //네이버 로그인 입력
    fun naverlogin(naverData: NaverData){
        val naverLoginService= getRetrofit().create(LoginRetrofitInterface::class.java)
        naverLoginService.naverlogin(naverData).enqueue(object: Callback<NaverResponse> {
            override fun onResponse(call: Call<NaverResponse>, response: Response<NaverResponse>) {
                Log.d("NaverLogin/success",response.toString())
                val resp: NaverResponse=response.body()!!

                when(val code=resp.code){
                    1000-> naverLoginView.onNaverLoginSuccess(code,resp.result!!) }
            }

            override fun onFailure(call: Call<NaverResponse>, t: Throwable) {
                Log.d("NaverLogin/failure",t.message.toString())
            }

        })
        Log.d("NaverLogin","loginOk")
    }

    //accesssToken 재발급 -> reissuance
    fun reissuanceLogin(reissuance: Reissuance){
        val reissuanceTokenService= getRetrofit().create(LoginRetrofitInterface::class.java)
        reissuanceTokenService.tokenReissuance(reissuance).enqueue(object: Callback<ReissuanceResponse> {
            override fun onResponse(call: Call<ReissuanceResponse>, response: Response<ReissuanceResponse>) {
                Log.d("Reissuance-Login-Token/success",response.toString())
                val resp: ReissuanceResponse? = response.body()

                if (resp != null) {
                    when(val code=resp.code) {

                        1000 -> { reissuanceView.onReissuanceSuccess(code, resp.result!!) } //access 재발급 성공
                        3017 -> { reissuanceView.onResissuanceExpire(code, resp.result!!) } //refresh 만료 -> 소셜 로그인
//                    else -> reissuanceView.onReissuanceFailure(code, resp.message)
                     }
                } else {
                        reissuanceView.onReissuanceFailure(response.code(), response.message())
                }
            }

            override fun onFailure(call: Call<ReissuanceResponse>, t: Throwable) {
                reissuanceView.onReissuanceFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("Reissuance-Login-Token/failure",t.message.toString())
            }

        })
        Log.d("Reissuance-Login-Token","loginOk")
    }
}