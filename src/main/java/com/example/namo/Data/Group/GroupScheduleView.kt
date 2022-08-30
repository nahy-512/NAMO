package com.example.namo.Data.Group

import com.example.namo.Data.Schedule.GetScheduleRes

interface GroupScheduleView {
    fun onInputGroupScheduleSuccess(code : Int, result : GroupScheduleResult)
    fun onGetGroupScheduleSuccess(code : Int, result : GetMoimScheduleRes)
}