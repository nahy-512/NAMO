package com.example.namo.Data.Schedule

import android.util.Log
import com.example.namo.Bottom.Home.HomeView
import com.example.namo.Data.ApiClient.getRetrofit
import com.example.namo.Data.Group.GroupScheduleView
import retrofit2.Call
import retrofit2.Response

class ScheduleService {
    private lateinit var homeView: HomeView
    private lateinit var monthScheduleView : MonthSchedule
    private lateinit var dayScheduleView : DaySchedule
    private lateinit var groupScheduleView : GroupScheduleView

    fun setHomeView(homeView : HomeView) {
        this.homeView = homeView
    }

    fun setMonthScheduleView(monthScheduleView : MonthSchedule){
        this.monthScheduleView = monthScheduleView
    }

    fun setDayScheduleView(dayScheduleView : DaySchedule){
        this.dayScheduleView = dayScheduleView
    }

    fun setGroupView(groupScheduleView : GroupScheduleView){
        this.groupScheduleView = groupScheduleView
    }

    //스케줄 입력
    fun getSchedule(access:String, schedule: Schedule){
        val scheduleService= getRetrofit().create(ScheduleRetroInterface::class.java)

        scheduleService.getSchedule(access,schedule).enqueue(object: retrofit2.Callback<ScheduleResponse> {
            override fun onResponse(call: Call<ScheduleResponse>, response: Response<ScheduleResponse>) {
                Log.d("input/success",response.toString())
                val resp: ScheduleResponse =response.body()!!

                when(val code=resp.code){
                    200 -> Log.d("GET_SCHEDULE_200", response.errorBody()?.string()!!)
                    1000-> homeView.onInputScheduleSuccess(code,resp.result!!) }
            }

            override fun onFailure(call: retrofit2.Call<ScheduleResponse>, t: Throwable) {
                Log.d("input/failure",t.message.toString())
            }

        })
        Log.d("input","inputOk")
    }

    //스케줄 편집
    fun editSchedule(access: String, edit : EditSchedule){
        val scheduleService = getRetrofit().create(ScheduleRetroInterface::class.java)

        scheduleService.editSchedule(access, edit).enqueue(object : retrofit2.Callback<EditScheduleResponse>{
            override fun onResponse(
                call: Call<EditScheduleResponse>,
                response: Response<EditScheduleResponse>
            ) {
                Log.d("edit/success", response.toString())
                val resp : EditScheduleResponse = response.body()!!
                Log.d("edit/test", resp.toString())

                when(val code = resp.code){
                    1000 -> homeView.onEditScheduleSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<EditScheduleResponse>, t: Throwable) {
                Log.d("edit/failure", t.message.toString())
            }
        })
        Log.d("edit","editFinish")
    }

    //스케줄 월별조회
    fun monthSchedule(access : String, month : String){
        val scheduleService = getRetrofit().create(ScheduleRetroInterface::class.java)

        scheduleService.monthSchedule(access,month).enqueue(object :retrofit2.Callback<MonthScheduleResponse>{
            override fun onResponse(
                call: Call<MonthScheduleResponse>,
                response: Response<MonthScheduleResponse>
            ) {
                Log.d("monthget/success",response.toString())
                val resp:MonthScheduleResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> {
                        Log.d("monthget/EVENTLIST",resp.result!!.toString())
                        monthScheduleView.onGetMonthScheduleSuccess(code, resp.result!!)
                    }
                }
            }

            override fun onFailure(call: Call<MonthScheduleResponse>, t: Throwable) {
                Log.d("monthget/failure", t.message.toString())
            }
        })
        Log.d("monthget", "monthget finish")
    }


    //스케줄 일별 조회 - 오류
    fun daySchedule(access:String, date:String){
        val scheduleService = getRetrofit().create(ScheduleRetroInterface::class.java)

        scheduleService.daySchedule(access,date).enqueue(object :retrofit2.Callback<DayScheduleResponse>{
            override fun onResponse(
                call: Call<DayScheduleResponse>,
                response: Response<DayScheduleResponse>
            ) {
                Log.d("dayget/success",response.toString())
                val resp:DayScheduleResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> dayScheduleView.onGetDayScheduleSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<DayScheduleResponse>, t: Throwable) {
                Log.d("dayget/failure",t.message.toString())
            }
        })
        Log.d("dayget","dayget finish")
    }


    //스케줄 삭제 - 오류
    fun deleteSchedule(access:String, scheduleIdx : Int){
        val scheduleService = getRetrofit().create(ScheduleRetroInterface::class.java)
        scheduleService.deleteSchedule(access, scheduleIdx).enqueue(object :retrofit2.Callback<DeleteScheduleResponse>{
            override fun onResponse(
                call: Call<DeleteScheduleResponse>,
                response: Response<DeleteScheduleResponse>
            ) {
                Log.d("delete/success",response.toString())
                val resp:DeleteScheduleResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> homeView.onDeleteScheduleSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<DeleteScheduleResponse>, t: Throwable) {
                Log.d("delete/failure", t.message.toString())
            }
        })
        Log.d("delete","delete finish")
    }

}



