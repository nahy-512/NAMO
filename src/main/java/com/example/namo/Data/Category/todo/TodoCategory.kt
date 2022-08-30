package com.example.namo.Data.Category


//생성
data class TodoCategory (
    var name:String,
    var color:String?,
    )

//수정
data class TodoCategoryPatch(
    var categoryIdx:Int,
    var name:String,
    var color:String,
)
