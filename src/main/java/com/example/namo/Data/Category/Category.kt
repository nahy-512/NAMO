package com.example.namo.Data.Category

import com.google.gson.annotations.SerializedName

data class ScheduleCategory(
    @SerializedName("name") var name:String,
    @SerializedName("color") var color:String,
    @SerializedName("share") var share:Int
)
//    var name: String,
//    var color: Int,
//    var share: Int
data class EditScheduleCategory(
    var categoryIdx : Int = 0,
    var name: String,
    var color: String,
    var share: Int
)
