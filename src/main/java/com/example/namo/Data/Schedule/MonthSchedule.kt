package com.example.namo.Data.Schedule

import java.util.*

interface MonthSchedule {
    fun onGetMonthScheduleSuccess(code : Int, results : List<GetMonthScheduleRes>)
}