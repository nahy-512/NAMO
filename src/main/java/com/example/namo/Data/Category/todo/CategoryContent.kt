package com.example.namo.Data.Category.todo

import android.graphics.Color
import android.graphics.drawable.Drawable

data class CategoryContent(
    var name:String = "",
    var color:Int? = null,
    var background: Int? = null //카테고리 추가는 점선
)
