package com.example.namo.Data.Group


import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable
import retrofit2.http.PartMap as PartMap


interface GroupRetrofitInterface {
    //7.1 모임 생성 -> 확인
    @Multipart
    @POST("/moim/create")
    fun createGroup(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Part("name") name:  RequestBody,
        @Part profileImg: MultipartBody.Part
    ) : Call<CreateGroupResponse>

    //7.2 모임 수정
    @PATCH("/moim/update")
    fun editGroupName(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body editGroup : GroupEdit
    ) : Call<EditGroupNameResponse>

    //7.3 모임 삭제
    @DELETE("/moim/{moimIdx}")
    fun deleteGroup(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("moimIdx") moimIdx: Int
    ) : Call<DeleteGroupResponse>

    //7.4 모임 검색
    @GET("/moim/code/{code}")
    fun searchGroup(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("code") code: String
    ) : Call<SearchGroupResponse>

    //7.5 모임 정보 조회
    @GET("/moim/each/{moimIdx}")
    fun inquiryEachGroup(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("moimIdx") moimIdx: Int
    ) : Call<InquiryGroupInfoResponse>

   //7.6 모임 리스트
   @GET("/moim/list")
   fun inquiryGroupList(
       @Header("ACCESS-TOKEN") accessToken: String
   ) : Call<GroupListResponse>

    //7.7 모임원 추가
    @POST("/moim/register/{moimIdx}")
    fun addGroupMember(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("moimIdx") moimIdx: Int
    ) : Call<AddGroupMemberResponse>

    //7.8 모임 탈퇴
    @DELETE("/moim/secession/{moimIdx}")
    fun leaveGroup(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("moimIdx") moimIdx: Int
    ) : Call<LeaveGroupResponse>

    //7.9 모임 메모 수정하기
    @PATCH("/moim/memo/update")
    fun addGroupMemo(
        @Header("ACCESS-TOKEN") accessToken: String,

        @Body moimMemoDto: moimMemoDto
    ) :Call<EditGroupMemoResponse>

    //7.9-2 모임 메모 이미지 보내주기
    @Multipart
    @PATCH("/moim/memo/update/image")
    fun addGroupPhoto(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Part ("moimMemoIdx") moimMemoIdx:RequestBody,
        @Part fileList1: List<MultipartBody.Part?>?,
        @Part fileList2: List<MultipartBody.Part?>?,
        @Part fileList3: List<MultipartBody.Part?>?
    ):Call<EditGroupMemoResponse>


    //7.10 모임 메모 조회하기
    @GET("/moim/memo/{moimMemoIdx}")
    fun getGroupMemo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Path("moimMemoIdx") moimMemoIdx:Int
    ) :Call<GetGroupMemoResponse>

    //7.11 모임 메모 컨텐츠 추가
    @PATCH("/memo/update/contents")
    fun addContentGroupMemo(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body contents: String,
        @Body memoIdx:Int
    ) :Call<contentsGroupMemoResponse>

    //7.12 그룹 스케줄 생성
    @POST("/moim/schedule")
    fun inputGroupSchedule(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body groupSchedule : NewGroupSchedule
    ) : Call<GroupScheduleResponse>

    //그룹 스케줄
    @POST("/moim/schedules/month")
    fun getGroupScheduleMonth(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Body groupMonth : GroupMonth
    ) : Call<GetGroupScheduleMonthResponse>
}





