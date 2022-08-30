package com.example.namo.Data.Todo

interface TodoView {
    fun onInputTodoSuccess(code : Int, result : TodoResult)
    fun onEditTodoSuccess(code : Int, result : Int)
    fun onDeleteTodoSuccess(code : Int, result : String)
    fun onGetDayTodoSuccess(code : Int, result : List<DayTodoResult>)
    fun onGetMonthTodoSuccess(code : Int, result : List<DayTodoResult>)
    fun onGetCategoryTodoSuccess(code : Int, result : List<GetTodoRes>)

}