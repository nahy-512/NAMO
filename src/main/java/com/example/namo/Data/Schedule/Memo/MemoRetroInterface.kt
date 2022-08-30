package com.example.namo.Data.Schedule.Memo

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File

interface MemoRetroInterface {

    //기록 생성
    @Multipart
    @POST("/schedule/memo")
    fun inputMemo(
        @Header ("ACCESS-TOKEN") accessToken : String,
        @Part imgs: List<MultipartBody.Part?>?,
        @Part("scheduleIdx") scheduleIdx:RequestBody,
        @Part("content") content: RequestBody?
        ): Call<MemoResponse>

    //기록 편집
    @Multipart
    @PATCH("/schedule/memo")
    fun editMemo(
        @Header ("ACCESS-TOKEN") accessToken : String,
        @Part("content") content:RequestBody?,
        @Part imgIdxList: List<MultipartBody.Part?>?,
        @Part fileList: List<MultipartBody.Part?>?,
        @Part("memoIdx") memoIdx: RequestBody,
        )
    : Call<EditMemoResponse>

    //기록 삭제
    @DELETE("/schedule/memo/{memoIdx}")
    fun deleteMemo(
        @Header ("ACCESS-TOKEN") accessToken : String,
        @Path ("memoIdx") memoIdx:Int
    )
    : Call<DeleteMemoResponse>

    //기록 상세조회
    @GET("/schedule/memo/{memoIdx}")
    fun getdetailMemo(
        @Header ("ACCESS-TOKEN") accessToken : String,
        @Path ("memoIdx") memoIdx:Int
        )
    : Call<GetMemoResponse>


    //기록 전체조회
    @GET("/schedule/memo/month/{month}")
    fun getAllMemo(
        @Header ("ACCESS-TOKEN") accessToken : String,
        @Path ("month") month :String
    )
    : Call<GetAllMemoResponse>
}