package com.example.namo.Data.Schedule

import retrofit2.http.*

interface ScheduleRetroInterface {

    @POST("schedule")
    fun getSchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body schedule: Schedule
    ) : retrofit2.Call<ScheduleResponse>

    @PATCH("schedule/update")
    fun editSchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body schedule: EditSchedule
    ) : retrofit2.Call<EditScheduleResponse>

    @DELETE("schedule/{scheduleIdx}")
    fun deleteSchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("scheduleIdx") scheduleIdx : Int
    ) : retrofit2.Call<DeleteScheduleResponse>

    @GET("schedule/month/{month}")
    fun monthSchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path ("month") month : String // 2022-03

    ) : retrofit2.Call<MonthScheduleResponse>

    @GET("schedule/day/{date}")
    fun daySchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path ("date") date : String //2002-07-18 이런 식

    ) : retrofit2.Call<DayScheduleResponse>

//    @POST("moim/schedule")
//    fun getGroupSchedule(
//        @Header("ACCESS-TOKEN") accessToken: String,
//        @Body groupSchedule: GroupSchedule
//    ) : retrofit2.Call<GroupScheduleResponse>
////
//    @GET("schedule/{moimIdx}")
//    fun shareGroupSchedule(
//        @Header("ACCESS-TOKEN") accessToken: String,
//        @Path("moimIdx") moimIdx : Int
//    ) : retrofit2.Call<ShareGroupScheduleResponse>

}