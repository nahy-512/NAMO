package com.example.namo.Data.Category

import com.example.namo.Data.Schedule.Schedule
import com.example.namo.Data.Schedule.ScheduleResponse
import retrofit2.http.*

interface CategoryRetrofitInterface {
    //3.1 스케줄 카테고리 생성 -> 7/30 확인
    @POST("/schedule/category")
    fun postScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
//        @Header("AUTH-SITE") kakao : String,
        @Body schedulecategory: ScheduleCategory
    ) : retrofit2.Call<PostCategoryResponse>

    //3.2 스케줄 카테고리 수정 -> 8/1 확인
    @PATCH("/schedule/category/update")
    fun patchScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body schedulecategory: EditScheduleCategory
    ) : retrofit2.Call<EditCategoryResponse>

    //3.3 스케줄 카테고리 삭제 -> 7/30 확인
    @DELETE("/schedule/category/{categoryIdx}")
    fun deleteScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("categoryIdx") categoryIdx : Int
    ) : retrofit2.Call<DeleteCategoryResponse>

    //3.4 스케줄 카테고리 조회 -> 8/1 확인
    @GET("/schedule/category/{categoryIdx}")
    fun getScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("categoryIdx") categoryIdx : Int
    ) : retrofit2.Call<InquiryCategoryResponse>

    //3.5 스케줄 카테고리 전체 조회 -> 8/1 확인
    @GET("schedule/category/all")
    fun getAllScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
    ): retrofit2.Call<InquiryAllCategoryResponse>
}
