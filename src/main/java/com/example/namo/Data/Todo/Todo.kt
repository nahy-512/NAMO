package com.example.namo.Data.Todo

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Todo(
    var name : String = "",
    var categoryIdx : Int = 0,
    var deadline : String = "",
    var memo : String = "",
    var complete : Boolean = false
//    var categoryColor: Int? = null,
//    var categoryName: String? = "",
//    var categoryItemSize: String? = "",
//
//    var todoTop: String? = "",
//    var todoContent: String? = "",
//    var tododDay: String = ""
) : Serializable {
    var position = 0

    fun toCalendar(str:String): Calendar {
        var formatter = SimpleDateFormat("yyyyMMdd")
        var date = formatter.parse(str)
        var cal = Calendar.getInstance()
        cal.set(date.year, date.month, date.date)

        return cal
    }

}

data class EditTodo(
    var todoIdx : Int = 0,
    var name : String? = "",
    var categoryIdx : Int = 0,
    var deadline : String? = "",
    var memo : String? = "",
    var complete : Boolean = false
)