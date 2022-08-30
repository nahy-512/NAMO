package com.example.namo.Data.Map

import com.example.namo.Data.ResultSearchKeyword
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoMapAPI {
    @GET("v2/local/search/keyword.json")
    fun getSearchKeyword(
        @Header("Authorization") key : String,
        @Query("query") query : String,
        @Query("page") page : Int
    ) : Call<ResultSearchKeyword>
}