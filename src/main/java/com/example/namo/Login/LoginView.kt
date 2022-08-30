package com.example.namo.Login

import com.example.namo.Data.Login.KakaoResult
import com.example.namo.Data.Login.NaverResult
import com.example.namo.Data.Login.ReissuanceResult


interface KakaoLoginView {

    fun onKakaoLoginSuccess(code: Int, result: KakaoResult)

}

interface ReissuanceTokenView {

    fun onReissuanceSuccess(code: Int, result: ReissuanceResult) //refresh로 재발급 성공하면 access 새로 받음
    fun onResissuanceExpire(code: Int, result: ReissuanceResult) //refresh 만료시 소셜 로그인 화면으로 넘어감
    fun onReissuanceFailure(code: Int, message: String)
}


interface NaverLoginView {

    fun onNaverLoginSuccess(code: Int, result: NaverResult)
}