package com.example.namo.Bottom.Home


import com.example.namo.Data.Schedule.GetMonthScheduleRes
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.ScheduleResult
import java.util.*

interface HomeView {

    fun onInputScheduleSuccess(code: Int, result: ScheduleResult)
    fun onEditScheduleSuccess(code : Int, result : String)
    fun onDeleteScheduleSuccess(code : Int, result : String)

}