package com.example.namo.Data.Login

import com.google.gson.annotations.SerializedName

//1.1 카카오 최초 로그인
data class KakaoResponse(
    @SerializedName(value = "isSuccess") val isSuccess : Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "result") val result : KakaoResult?
)
data class KakaoResult(
    @SerializedName(value = "accessToken") var accessToken : String,
    @SerializedName(value = "refreshToken") var refreshToken : String
)


//1.2 네이버 최초 로그인
data class NaverResponse(
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "result") val result : NaverResult?
)
data class NaverResult(
    @SerializedName(value = "accessToken") var accessToken : String,
    @SerializedName(value = "refreshToken") var refreshToken : String
)


//1.3 accessToken 재발급
data class ReissuanceResponse(
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "result") val result : ReissuanceResult?
)
data class ReissuanceResult(
    @SerializedName(value = "accessToken") var accessToken : String,
    @SerializedName(value = "refreshToken") var refreshToken : String
)