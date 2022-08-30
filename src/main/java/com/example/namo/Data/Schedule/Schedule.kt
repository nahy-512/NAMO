package com.example.namo.Data.Schedule

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class Schedule (
    var name: String = "",
    var startDate: String = "" ,
    var endDate: String = "",
    var location: String = "",
    var locationX: String = "",
    var locationY: String = "",
    var categoryIdx : Int = 0
) : Serializable{
    var position = 0

    fun toCalendar(str:String):Calendar {
        var formatter = SimpleDateFormat("yyyyMMdd")
        var date = formatter.parse(str)
        var cal = Calendar.getInstance()
        cal.set(date.year, date.month, date.date)

        return cal
    }

    fun toDate(str:String):Date{
        var formatter = SimpleDateFormat("yyyyMMdd")
        var date = formatter.parse(str)
        return date
    }

}

data class EditSchedule (
    var scheduleIdx : Int = 0,
    var name: String = "",
    var startDate: String = "" ,
    var endDate: String = "",
    var location: String = "",
    var locationX: String = "",
    var locationY: String = "",
    var categoryIdx : Int = 0
)

