package com.example.namo.Data.Todo

import android.util.Log
import com.example.namo.Data.ApiClient.getRetrofit
import com.example.namo.Data.Schedule.EditScheduleResponse
import retrofit2.Call
import retrofit2.Response

class TodoService {
    private lateinit var todoView : TodoView

    fun setTodoView(todoView : TodoView){
        this.todoView = todoView
    }

    fun getTodo(access : String, refresh : String, todo : Todo){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.getTodo(access, "kakao",todo).enqueue(object : retrofit2.Callback<TodoResponse>{
            override fun onResponse(call: Call<TodoResponse>, response: Response<TodoResponse>) {
                Log.d("inputTodo/success", response.toString())
                val resp : TodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onInputTodoSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
                Log.d("inputTodo/success", t.message.toString())
            }
        })
        Log.d("inputTodo", "inputOK")
    }

    fun editTodo(access : String, refresh : String, edit : EditTodo){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.editTodo(access, "kakao",edit).enqueue(object : retrofit2.Callback<EditTodoResponse>{
            override fun onResponse(
                call: Call<EditTodoResponse>,
                response: Response<EditTodoResponse>
            ) {
                Log.d("editTodo/success", response.toString())
                val resp : EditTodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onEditTodoSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<EditTodoResponse>, t: Throwable) {
                Log.d("editTodo/failure", t.message.toString())
            }
        })
        Log.d("editTodo","editFinish")
    }

    fun deleteTodo(access:String, refresh : String, todoIdx:Int){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.deleteTodo(access, "kakao", todoIdx).enqueue(object : retrofit2.Callback<DeleteTodoResponse>{
            override fun onResponse(
                call: Call<DeleteTodoResponse>,
                response: Response<DeleteTodoResponse>
            ) {
                Log.d("deleteTodo/success", response.toString())
                val resp : DeleteTodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onDeleteTodoSuccess(code,resp.result!!)
                }
            }

            override fun onFailure(call: Call<DeleteTodoResponse>, t: Throwable) {
                Log.d("deleteTodo/failure", t.message.toString())
            }
        })
        Log.d("deleteTodo", "deleteTodo finish")
    }

    fun dayTodo(access:String, refresh : String, date:String){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.dayTodo(access, "kakao",date).enqueue(object : retrofit2.Callback<DayTodoResponse>{
            override fun onResponse(
                call: Call<DayTodoResponse>,
                response: Response<DayTodoResponse>
            ) {
                Log.d("dayTodoGet/success", response.toString())
                val resp : DayTodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onGetDayTodoSuccess(code,resp.result!!)
                }
            }

            override fun onFailure(call: Call<DayTodoResponse>, t: Throwable) {
                Log.d("dayTodoGet/failure", t.message.toString())
            }
        })
        Log.d("dayTodoGet", "dayTodoGet finish")
    }

    fun monthTodo(access:String, refresh : String, date:String){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.monthTodo(access, "kakao",date).enqueue(object : retrofit2.Callback<DayTodoResponse>{
            override fun onResponse(
                call: Call<DayTodoResponse>,
                response: Response<DayTodoResponse>
            ) {
                Log.d("monthTodoGet/success", response.toString())
                val resp : DayTodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onGetMonthTodoSuccess(code,resp.result!!)
                }
            }

            override fun onFailure(call: Call<DayTodoResponse>, t: Throwable) {
                Log.d("monthTodoGet/failure", t.message.toString())
            }
        })
        Log.d("monthTodoGet", "monthTodoGet finish")
    }

    fun categoryTodo(access:String, refresh : String, categoryIdx : Int){
        val todoService = getRetrofit().create(TodoRetrofitInterface::class.java)

        todoService.categoryTodo(access, "kakao", categoryIdx).enqueue(object : retrofit2.Callback<CategoryTodoResponse>{
            override fun onResponse(
                call: Call<CategoryTodoResponse>,
                response: Response<CategoryTodoResponse>
            ) {
                Log.d("categoryTodoGet/success", response.toString())
                val resp : CategoryTodoResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> todoView.onGetCategoryTodoSuccess(code,resp.result!!)
                }
            }

            override fun onFailure(call: Call<CategoryTodoResponse>, t: Throwable) {
                Log.d("categoryTodoGet/failure", t.message.toString())
            }
        })
        Log.d("categoryTodoGet", "categoryTodoGet finish")
    }
}