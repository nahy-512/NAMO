package com.example.namo.Data.Group


import com.example.namo.Data.Schedule.GetMonthScheduleRes
import com.example.namo.Data.Schedule.GetScheduleRes
import com.example.namo.Data.Schedule.ScheduleResult
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter


//7.1 모임 생성 -> 완료
data class CreateGroupResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: CreateGroupResult?,
)
data class CreateGroupResult(
    @SerializedName("moimIdx") val moimIdx: Int,
    @SerializedName("moimCode") val moimCode: String
)


//7.2 모임 수정
data class EditGroupNameResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)


//7.3 모임 삭제 -> 완료
data class DeleteGroupResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)


//7.4 모임 검색 -> 완료
data class SearchGroupResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: SearchGroupResult?
)
data class SearchGroupResult(
    @SerializedName("moimIdx") val moimIdx: Int,
    @SerializedName("name") val name: String,
    @SerializedName("profileImg") val profileImg: String
)


//7.5 모임 정보 조회 -> 완료
data class InquiryGroupInfoResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: InquiryGroupInfoResult?
)
data class InquiryGroupInfoResult(
    @SerializedName("name") val name: String,
    @SerializedName("profileImg") val profileImg: String,
    @SerializedName("friendsList") val friendsList : ArrayList<FriendsList>,
    @SerializedName("code") val code: String //그룹 코드
)
data class FriendsList(
    @SerializedName("userIdx") val userIdx : Int,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String
)


//7.6 모임 리스트 -> 완료
data class GroupListResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: ArrayList<GroupListResult>?
)
data class GroupListResult(
    @SerializedName("moimIdx") val moimIdx: Int,
    @SerializedName("name") val name: String,
    @SerializedName("profileImg") val profileImg: String,
    @SerializedName("moimAttendences") val moimAttendences : ArrayList<moimAttendences>
)
//data class moimAttendences (
//    @SerializedName("userIdx") val userIdx: Int,
//    @SerializedName("username") val username : String
//)


//7.7 모임원 추가 -> 완료
data class AddGroupMemberResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)


//7.8 모임 탈퇴 -> 완료
data class LeaveGroupResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)


//7.9 모임 메모 수정

data class EditGroupMemoResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)

//7.10 모임 메모 조회

data class GetGroupMemoResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: moimMemoResult
)

data class moimMemoResult(
    @SerializedName("name") val name: String,
    @SerializedName("startDate") val startDate: String,
    @SerializedName("location") val location: String,
    @SerializedName("moimAttendences") val moimAttendences: List<moimAttendences>,
    @SerializedName("getMoimMemoLocationRes") val getMoimMemoLocationRes: List<getMoimMemoLocationRes>
)

data class moimAttendences(
    @SerializedName("userIdx") var userIdx: Int,
    @SerializedName("username") val username: String
) :Serializable

data class getMoimMemoLocationRes(
    @SerializedName("locationIdx") val locationIdx: Int,
    @SerializedName("location") val location: String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("attendences") val attendences: List<String>,
    @SerializedName("locationimg") val locationimg: List<String?>
)

//7.11 모임 메모 컨텐츠 추가
data class contentsGroupMemoResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: String
)

//7.12 그룹 스케줄 생성
data class GroupScheduleResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : GroupScheduleResult
)

data class GroupScheduleResult (
    @SerializedName("scheduleIdx")  val scheduleIdx : ArrayList<Int>
)

//7.13 그룹 스케줄 월별조회
data class GetGroupScheduleMonthResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : GetMoimScheduleRes
)

data class GetMoimScheduleRes(
    @SerializedName("moimIdx") val moimIdx : Int,
    @SerializedName("moimColor") val moimColor : String,
    @SerializedName("memberSchedule") val memberSchedule : List<MemberSchedule>,
    @SerializedName("moimSchedule") val moimSchedule : List<ScheduleRes>
)

data class MemberSchedule(
    @SerializedName("member") val memberIdx : Int,
    @SerializedName("color") val memberColor : String,
    @SerializedName("scheduleResList") val scheduleRes : List<ScheduleRes>
) : Serializable

data class ScheduleRes(
    @SerializedName("scheduleIdx") val scheduleIdx : Int,
    @SerializedName("name") val name : String,
    @SerializedName("startDate") val startDate : String,
    @SerializedName("endDate") val endDate : String,
    @SerializedName("categoryIdx") val categoryIdx : Int,
    @SerializedName("location") val location : String,
    @SerializedName("locationX") val locationX : String,
    @SerializedName("locationY") val locationY : String,
    @SerializedName("memoIdx") val memoIdx : Int
) : Serializable {
    var position = 0
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    private val sendDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val timeFormatter = DateTimeFormatter.ofPattern("hh : mm a")
    private val sendTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")


    fun toCalendar(str:String): Calendar {
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        var date = formatter.parse(str)
        var cal = Calendar.getInstance()
        cal.set(date.year + 1900, date.month , date.date, 0, 0)

//        Log.d("TOCALENDAR","startdate : $str, calendar : ${cal.get(Calendar.YEAR)} 월 ${cal.get(Calendar.MONTH)}월 ${cal.get(Calendar.DATE)}일 ${cal.get(Calendar.HOUR_OF_DAY)}시 ${cal.get(Calendar.MINUTE)}분")

        return cal
    }

    fun toDate(str:String): Date {
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        var date = formatter.parse(str)
        return date
    }

    fun toLocal(str:String) : LocalDate {
        val serverFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var date = LocalDate.parse(str, serverFormatter)
        return date
    }

    fun toHex(color : Int) : String {
        val hex = String.format("%x", color)
        return hex
    }
}

