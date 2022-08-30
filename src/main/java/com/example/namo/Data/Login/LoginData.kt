package com.example.namo.Data.Login

import com.google.gson.annotations.SerializedName

//카카오 최초 로그인
data class KaKaoData(
    @SerializedName(value = "accessToken") val accessToken : String,
    @SerializedName(value = "refreshToken") val refreshToken : String
)

//네이버 최초 로그인
data class NaverData(
    @SerializedName(value = "accessToken") val accessToken : String,
    @SerializedName(value = "refreshToken") val refreshToken : String
)

//accessToken 재발급
data class Reissuance(
    @SerializedName(value = "accessToken") val accessToken : String,
    @SerializedName(value = "refreshToken") val refreshToken : String
)

