package com.example.namo.Data.Todo

import com.example.namo.Data.Schedule.EditSchedule
import com.example.namo.Data.Schedule.MonthScheduleResponse
import com.example.namo.Data.Schedule.Schedule
import retrofit2.http.*

interface TodoRetrofitInterface {

    @POST("todo")
    fun getTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Body todo: Todo
    ) : retrofit2.Call<TodoResponse>

    @PATCH("todo")
    fun editTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Body todo: EditTodo
    ) : retrofit2.Call<EditTodoResponse>

    @DELETE("todo/{todoIdx}")
    fun deleteTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Path("todoIdx") todoIdx : Int
    ) : retrofit2.Call<DeleteTodoResponse>

    @GET("todo/day/{day}")
    fun dayTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Path ("day") day : String // 2022-03-27

    ) : retrofit2.Call<DayTodoResponse>

    @GET("todo/month/{month}")
    fun monthTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Path ("month") month : String // 2022-03

    ) : retrofit2.Call<DayTodoResponse>

    @GET("todo/category/{categoryIdx}")
    fun categoryTodo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao : String,
        @Path ("categoryIdx") categoryIdx : Int

    ) : retrofit2.Call<CategoryTodoResponse>

}