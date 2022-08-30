package com.example.namo.Data.Todo

import com.example.namo.Data.Schedule.ScheduleResult
import com.google.gson.annotations.SerializedName

data class TodoResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : TodoResult
)

data class TodoResult (
    @SerializedName("todoIdx")  val todoIdx : Int
)

data class EditTodoResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : Int
)

data class DeleteTodoResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : String
)

data class DayTodoResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : List<DayTodoResult>
)

data class DayTodoResult(
    @SerializedName("todoIdx") val todoIdx : Int,
    @SerializedName("name") val name : String,
    @SerializedName("categoryIdx") val categoryIdx : Int,
    @SerializedName("deadline") val deadline : String
)

data class CategoryTodoResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : List<GetTodoRes>
)

data class GetTodoRes(
    @SerializedName("todoIdx") val todoIdx : Int,
    @SerializedName("name") val name : String,
    @SerializedName("categoryIdx") val categoryIdx : Int,
    @SerializedName("categoryName") val categoryName : String,
    @SerializedName("categoryColor") val categoryColor : String,
    @SerializedName("deadline") val deadline : String,
    @SerializedName("memo") val memo : String,
    @SerializedName("complete") val complete : Int
)