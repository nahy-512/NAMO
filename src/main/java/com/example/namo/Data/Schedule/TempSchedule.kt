package com.example.namo.Data.Schedule

data class TempSchedule(
    var name : String = "",
    var categoryName : String = "",
    var categoryColor : Int = -1,
    var categoryIdx : Int = -1,
    var isDateWasOpen : Boolean = false,
    var startDay : String = "",
    var endDay : String = "",
    var startTime : String = "",
    var endTime : String = "",
    var x : Double = 0.0,
    var y : Double = 0.0,
    var place : String = ""
)
