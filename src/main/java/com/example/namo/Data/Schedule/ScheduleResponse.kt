package com.example.namo.Data.Schedule

import android.util.Log
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

//스케줄 생성
data class ScheduleResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : ScheduleResult
)

data class ScheduleResult (
    @SerializedName("scheduleIdx")  val scheduleIdx : Int
)


//스케줄 수정
data class EditScheduleResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : String
)



//스케줄 삭제
data class DeleteScheduleResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : String
)



//스케줄 월별 조회
data class MonthScheduleResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : List<GetMonthScheduleRes>
)

data class GetMonthScheduleRes(
    @SerializedName("scheduleIdx") val scheduleIdx : Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("startDate") val startDate: String = "" ,
    @SerializedName("endDate") val endDate: String = "",
    @SerializedName("location") val location: String = "",
    @SerializedName("locationx") val locationX: String = "",
    @SerializedName("locationy") val locationY: String = "",
    @SerializedName("categoryIdx") val categoryIdx : Int = 0,
    @SerializedName("categoryName") val categoryName : String = "",
    @SerializedName("categoryColor") val categoryColor : String = "",
    @SerializedName("memoIdx") val memoIdx : Int = 0,
    @SerializedName("moimIdx") val moimIdx : Int = 0
) : Serializable{
    var position = 0

    fun toCalendar(str:String): Calendar {
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        var date = formatter.parse(str)
        var cal = Calendar.getInstance()
        cal.set(date.year + 1900, date.month , date.date, 0, 0)

//        Log.d("TOCALENDAR","startdate : $str, calendar : ${cal.get(Calendar.YEAR)} 월 ${cal.get(Calendar.MONTH)}월 ${cal.get(Calendar.DATE)}일 ${cal.get(Calendar.HOUR_OF_DAY)}시 ${cal.get(Calendar.MINUTE)}분")

        return cal
    }

    fun toDate(str:String): Date {
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        var date = formatter.parse(str)
        return date
    }

    fun toHex(color : Int) : String {
        val hex = String.format("%x", color)
        return hex
    }
}



//스케줄 일별 조회
data class DayScheduleResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : List<GetScheduleRes>
)

data class GetScheduleRes(
    @SerializedName("scheduleIdx") val scheduleIdx : Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("startDate") val startDate: String = "",
    @SerializedName("endDate") val endDate: String = "",
    @SerializedName("location") val location: String = "",
    @SerializedName("locationX") val locationX: String = "",
    @SerializedName("locationY") val locationY: String = "",
    @SerializedName("categoryIdx") val categoryIdx : Int = 0,
    @SerializedName("memoIdx") var memoIdx : Int = 0,
    @SerializedName("categoryName") val categoryName: String = "",
    @SerializedName("categoryColor") val categoryColor: String = "",
    @SerializedName("share") val share : Int = 0,
    @SerializedName("moimIdx") val moimIdx : Int = 0
) : Serializable

