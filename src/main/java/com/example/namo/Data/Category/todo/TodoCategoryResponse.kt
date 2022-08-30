package com.example.namo.Data.Category

import com.google.gson.annotations.SerializedName

//투두 카테고리 생성
data class CategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: CategoryResult?,
)
data class CategoryResult(
    @SerializedName("categoryIdx") val categoryIdx: Int
)

//투두 카테고리 수정, 삭제
data class CategoryPatchResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val results: String
)
