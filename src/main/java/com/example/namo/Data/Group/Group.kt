package com.example.namo.Data.Group

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import java.io.Serializable

/*그룹 리스트 데이터(일단 더미) */

data class Group(

    var title : String = "", //그룹명
    var coverImg : Int? = null , //그룹 리스트 표지
    var num : Int? = null, //참여자 수
    var member : String = "" //멤버 이름

)

data class GroupInfo(

    var color : String = "" , //그룹원 색
    var name : String = "" //멤버 이름

)

data class GroupSchedule(

    var color : String = "" , //카테고리 색
    var date : String = "", //시간
    var name : String = "", //일정 이름
    var record : Int? = null //메모 아이콘
)

data class ForGroupSchedule(
    val scheduleIdx : Int,
    val userName : String,
    val color : String,
    val name : String,
    val startDate : String,
    val endDate : String,
    val categoryIdx : Int,
    val location : String,
    val locationX : String,
    val locationY : String,
    val memoIdx : Int
) : Serializable




data class moimMemoDto(
    var moimMemoIdx : Int,  //그룹 메모 식별자
    var moimMemoLocationDtoList: List<MoimMemoLocationDto>  //장소 추가 시 생기는 장소 추가 리스트
)

data class MoimMemoLocationDto(
    var location:String,
    var amount: Int,
    var attendances: List<Int>

)

data class GroupEdit(

    var moimIdx : Int = 0 ,
    var newName : String = ""
    )


data class NewGroupSchedule(
    var members : ArrayList<Int>,
    var name : String = "",
    var startDate : String = "",
    var endDate : String = "",
    var location : String = "",
    var locationX : String = "",
    var locationY : String = "",
    var moimIdx : Int = 0


)

