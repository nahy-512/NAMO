package com.example.namo.Data.Schedule.Memo

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.Serializable


//기록 생성
data class MemoResponse  (
@SerializedName("isSuccess") val isSuccess : Boolean,
@SerializedName("code") val code : Int,
@SerializedName("message") val message : String,
@SerializedName("result") val result : Int
)

//기록 수정
data class EditMemoResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result : String
)

//기록 삭제
data class DeleteMemoResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result : String
)

//기록 상세조회
data class GetMemoResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : GetMemoRes
)

data class GetMemoRes(
    @SerializedName("content") val content: String,
    @SerializedName("urls") val urls: List<String?>,
    @SerializedName("imgIdx") var imgIdx : List<Int>
) : Serializable

//기록 전체조회
data class GetAllMemoResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result :List<MonthMemoDto>
)

data class MonthMemoDto(
    @SerializedName("memoIdx") val memoIdx: Int,
    @SerializedName("content") val content: String,
    @SerializedName("urls") var urls: List<String?>,
    @SerializedName("date") val date: String,
    @SerializedName("name") val name: String,
    @SerializedName("color") var color : String,
    @SerializedName("group") var group : Int,

) : Serializable