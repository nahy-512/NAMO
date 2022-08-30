package com.example.namo.Data.Schedule

interface DaySchedule {
    fun onGetDayScheduleSuccess(code : Int, results : List<GetScheduleRes>)
}