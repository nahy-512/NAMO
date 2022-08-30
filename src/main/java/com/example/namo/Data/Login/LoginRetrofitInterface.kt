package com.example.namo.Data.Login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {

    //1.1 카카오 최초 로그인
    @POST("/auth/kakao/signup")
    fun kakaologin(@Body kaKaoData: KaKaoData): Call<KakaoResponse>

    //1.2 네이버 최초 로그인
    @POST("/auth/naver/signup")
    fun naverlogin(@Body naverData: NaverData): Call<NaverResponse>

    //1.3 accessToken 재발급
    @POST("/auth/reissuance")
    fun tokenReissuance(@Body reissuance: Reissuance): Call<ReissuanceResponse>
}