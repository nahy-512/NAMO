package com.example.namo.Data.Category

import com.google.gson.annotations.SerializedName

//3.1 스케줄 카테고리 생성
data class PostCategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: PostCategoryResult?,
)
data class PostCategoryResult(
    @SerializedName("categoryIdx") val categoryIdx: Int
)


//3.2 스케줄 카테고리 수정
data class EditCategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: String //String?
)


//3.3 스케줄 카테고리 삭제
data class DeleteCategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: String
)


//3.4 스케줄 카테고리 조회
data class InquiryCategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: InquiryCategoryResult?
)
data class InquiryCategoryResult(
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String,
    @SerializedName("share") val share: Int
)


//3.5 스케줄 카테고리 전체 조희
data class InquiryAllCategoryResponse(
    @SerializedName(value = "isSuccess") val inSuccess: Boolean,
    @SerializedName(value = "code") val code:Int,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: ArrayList<InquiryCategoryInfo>
)
data class InquiryCategoryInfo(
    @SerializedName("categoryIdx") val categoryIdx: Int,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String,
    @SerializedName("share") val share: Int
)