package com.example.namo.Data.Group

import android.util.Log
import com.example.namo.Data.ApiClient
import com.example.namo.Data.Category.CategoryRetrofitInterface
import com.example.namo.Data.Category.PostCategoryResponse
import com.example.namo.Data.Category.ScheduleCategory
import com.example.namo.Data.Schedule.ScheduleRetroInterface
import com.example.namo.Floating.Category.CategoryView
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Part

class GroupService {
    private lateinit var groupView: GroupView //AddGroupActivity

    private lateinit var groupCodeView : GroupCodeView //InputGroupCodeActivity
    private lateinit var groupListView : GroupFragView //GroupFragment
    private lateinit var groupInfoView : GroupInfoView //GroupInfoBubbleActivity
    private lateinit var groupScheduleView : GroupScheduleView

    private lateinit var groupMemoView: GroupMemoView  //7.9 ~ 7.10 모임 메모


    fun setGroupView(groupView: GroupView) {
        this.groupView = groupView
    }

    fun setGroupCodeView(groupCodeView: GroupCodeView) {
        this.groupCodeView = groupCodeView
    }

    fun setGroupListView(groupListView: GroupFragView) {
        this.groupListView = groupListView
    }

    fun setGroupInfoView(groupInfoView: GroupInfoView) {
        this.groupInfoView = groupInfoView
    }

    fun setGroupMemoView(groupMemoView: GroupMemoView) {
        this.groupMemoView = groupMemoView

    }

    fun setGroupScheduleView(groupScheduleView : GroupScheduleView){
        this.groupScheduleView = groupScheduleView
    }

    /** 7.1 모임 생성 */
    fun createGroup(access: String, name: RequestBody, profileImg: MultipartBody.Part) {
        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.createGroup(access, name, profileImg)
            .enqueue(object : Callback<CreateGroupResponse> {
                override fun onResponse(
                    call: Call<CreateGroupResponse>,
                    response: Response<CreateGroupResponse>
                ) {
                    Log.d("GROUP-POST-RESPONSE", response.toString())
                    val resp: CreateGroupResponse? = response.body()

                    if (resp != null) {
                        when (val code = resp.code) {
                            1000 -> {
                                groupView.onCreateGroupSuccess(code, resp.result!!)
                            }
                        }
                    } else {
                        groupView.onGetGroupFailure(response.code(), response.message())
                    }
                }

                override fun onFailure(call: Call<CreateGroupResponse>, t: Throwable) {
                    groupView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                    Log.d("groupInput/failure", t.message.toString())
                }

            })
        Log.d("input", "groupOk")
    }

    /** 7.2 모임 수정 */
    fun editGroup(access: String, editGroup : GroupEdit) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.editGroupName(access, editGroup)
            .enqueue(object : Callback<EditGroupNameResponse> {
                override fun onResponse(
                    call: Call<EditGroupNameResponse>,
                    response: Response<EditGroupNameResponse>
                ) {
                    Log.d("GROUP-EDIT-RESPONSE", response.toString())
                    val resp: EditGroupNameResponse = response.body()!!

                    when (val code = resp.code) {
                        1000 -> {
                            groupView.onEditGroupSuccess(code, resp.result!!)
                        }
                        else -> groupView.onGetGroupFailure(code, resp.message)
                    }
                }

                override fun onFailure(call: Call<EditGroupNameResponse>, t: Throwable) {
                    groupView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                    Log.d("groupEdit/failure", t.message.toString())
                }

            })
        Log.d("edit", "groupOk")
    }


    /** 7.3 모임 삭제 */
    fun deleteGroup(access: String, moimIdx: Int) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.deleteGroup(access, moimIdx)
            .enqueue(object : Callback<DeleteGroupResponse> {
                override fun onResponse(
                    call: Call<DeleteGroupResponse>,
                    response: Response<DeleteGroupResponse>
                ) {
                    Log.d("GROUP-DELETE-RESPONSE", response.toString())
                    val resp: DeleteGroupResponse = response.body()!!

                    when (val code = resp.code) {
                        1000 -> {
                            groupInfoView.onDeleteGroupSuccess(code, resp.result!!)
                        }
                        else -> groupInfoView.onGetGroupFailure(code, resp.message)
                    }
                }

                override fun onFailure(call: Call<DeleteGroupResponse>, t: Throwable) {
                    groupInfoView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                    Log.d("groupDelete/failure", t.message.toString())
                }

            })
        Log.d("delete", "groupOk")
    }

    /** 7.4 모임 검색 */
    fun searchGroup(access: String, code: String) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.searchGroup(access, code).enqueue(object : Callback<SearchGroupResponse> {
            override fun onResponse(
                call: Call<SearchGroupResponse>,
                response: Response<SearchGroupResponse>
            ) {
                Log.d("GROUP-SEARCH-RESPONSE", response.toString())
                val resp: SearchGroupResponse = response.body()!!

                when (val code = resp.code) {
                    1000 -> {
                        groupCodeView.onSearchGroupSuccess(code, resp.result!!)
                    }
                    else -> groupCodeView.onGetGroupFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<SearchGroupResponse>, t: Throwable) {
                groupCodeView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("groupSearch/failure", t.message.toString())
            }

        })
        Log.d("search", "groupOk")
    }

    /** 7.5 모임 정보 조회 */
    fun getGroupInfo(access: String, moimIdx: Int) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.inquiryEachGroup(access, moimIdx)
            .enqueue(object : Callback<InquiryGroupInfoResponse> {
                override fun onResponse(
                    call: Call<InquiryGroupInfoResponse>,
                    response: Response<InquiryGroupInfoResponse>
                ) {
                    Log.d("GROUP-INFO-RESPONSE", response.toString())
                    val resp: InquiryGroupInfoResponse = response.body()!!

                    when (val code = resp.code) {
                        1000 -> {
                            groupInfoView.onGetGroupInfoSuccess(code, resp.result!!)
                        }
                        else -> groupInfoView.onGetGroupFailure(code, resp.message)
                    }
                }

                override fun onFailure(call: Call<InquiryGroupInfoResponse>, t: Throwable) {
                    groupInfoView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                    Log.d("groupInfo/failure", t.message.toString())
                }

            })
        Log.d("inquiry", "groupOk")
    }

    /** 7.6 모임 리스트 */
    fun getGroupList(access: String) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.inquiryGroupList(access).enqueue(object : Callback<GroupListResponse> {
            override fun onResponse(
                call: Call<GroupListResponse>,
                response: Response<GroupListResponse>
            ) {
                Log.d("GROUP-LIST-RESPONSE", response.toString())
                val resp: GroupListResponse = response.body()!!

                when (val code = resp.code) {
                    1000 -> {
                        groupListView.onGetGroupListSuccess(code, resp.result!!)
                    }
                    else -> groupListView.onGetGroupFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<GroupListResponse>, t: Throwable) {
                groupListView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("groupList/failure", t.message.toString())
            }

        })
        Log.d("getAll", "groupOk")
    }

    /** 7.7 모임원 추가 */
    fun addGroupMember(access: String, moimIdx: Int) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.addGroupMember(access, moimIdx)
            .enqueue(object : Callback<AddGroupMemberResponse> {
                override fun onResponse(
                    call: Call<AddGroupMemberResponse>,
                    response: Response<AddGroupMemberResponse>
                ) {
                    Log.d("GROUP-ADD-MEMBER-RESPONSE", response.toString())
                    val resp: AddGroupMemberResponse = response.body()!!

                    when (val code = resp.code) {
                        1000 -> {
                            groupCodeView.onAddGroupMemberSuccess(code, resp.result!!)
                        }
                        else -> groupCodeView.onGetGroupFailure(code, resp.message)
                    }
                }

                override fun onFailure(call: Call<AddGroupMemberResponse>, t: Throwable) {
                    groupCodeView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                    Log.d("addGroupMember/failure", t.message.toString())
                }

            })
        Log.d("addMember", "groupOk")
    }

    /** 7.8 모임 탈퇴 */
    fun leaveGroup(access: String, moimIdx: Int) {

        val groupService = ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupService.leaveGroup(access, moimIdx).enqueue(object : Callback<LeaveGroupResponse> {
            override fun onResponse(
                call: Call<LeaveGroupResponse>,
                response: Response<LeaveGroupResponse>
            ) {
                Log.d("GROUP-LEAVE-RESPONSE", response.toString())
                val resp: LeaveGroupResponse = response.body()!!

                when (val code = resp.code) {
                    1000 -> {
                        groupInfoView.onLeaveGroupSuccess(code, resp.result!!)
                    }
                    else -> groupInfoView.onGetGroupFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<LeaveGroupResponse>, t: Throwable) {
                groupInfoView.onGetGroupFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("groupLeave/failure", t.message.toString())
            }

        })
        Log.d("leave", "groupOk")
    }





















    //7.9 모임 메모 수정

    fun addGroupMemo(access:String,moimMemoDto: moimMemoDto){

        val groupMemoService= ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupMemoService.addGroupMemo(access, moimMemoDto).enqueue(object: Callback<EditGroupMemoResponse> {
            override fun onResponse(call: Call<EditGroupMemoResponse>, response: Response<EditGroupMemoResponse>) {
                Log.d("AddGroupMemo/success",response.toString())
                val resp: EditGroupMemoResponse =response.body()!!
                Log.d("addGroupmemo","$resp")
                when(val code=resp.code) {
                    1000 -> groupMemoView.onAddGroupMemoSuccess(code, resp.result!!)
                }
            }
            override fun onFailure(call: Call<EditGroupMemoResponse>, t: Throwable) {
                Log.d("AddGroupMemo/failure",t.message.toString())
            }

        })
        Log.d("groupmemo","groupOk")
    }

    //7.9-2 모임 메모 이미지수정

    fun addGroupPhoto(access:String, moimMemoIdx:RequestBody, fileList1: List<MultipartBody.Part?>?,
                      fileList2: List<MultipartBody.Part?>?, fileList3: List<MultipartBody.Part?>?,){

        val groupMemoService= ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupMemoService.addGroupPhoto(access,moimMemoIdx,fileList1,fileList2,fileList3 ).enqueue(object: Callback<EditGroupMemoResponse> {
            override fun onResponse(call: Call<EditGroupMemoResponse>, response: Response<EditGroupMemoResponse>) {
                Log.d("AddGroupPhoto/success",response.toString())
                val resp: EditGroupMemoResponse =response.body()!!
                Log.d("addGroupPhoto","$resp")
                when(val code=resp.code) {
                    1000 -> groupMemoView.onAddGroupMemoSuccess(code, resp.result!!)
                }
            }
            override fun onFailure(call: Call<EditGroupMemoResponse>, t: Throwable) {
                Log.d("AddGroupPhoto/failure",t.message.toString())
            }

        })
        Log.d("groupphoto","groupOk")
    }

    //7.10 모임 메모 조회

    fun getGroupMemo(access: String, moimMemoIdx: Int) {

        val groupGetMemoService =
            ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupGetMemoService.getGroupMemo(access, moimMemoIdx)
            .enqueue(object : Callback<GetGroupMemoResponse> {
                override fun onResponse(
                    call: Call<GetGroupMemoResponse>,
                    response: Response<GetGroupMemoResponse>
                ) {
                    Log.d("GetGroupMemo/sucess", response.toString())
                    val resp: GetGroupMemoResponse = response.body()!!
                    Log.d("getGroupmemo", "$resp")
                    when (val code = resp.code) {
                        1000 -> groupMemoView.onGetGroupMemoSuccess(code, resp.result!!)
                    }
                }

                override fun onFailure(call: Call<GetGroupMemoResponse>, t: Throwable) {
                    Log.d("GetGroupMemo/failure", t.message.toString())
                }

            })
        Log.d("groupmemo", "groupOk")
    }

    //7.11 모임 메모 콘텐츠 추가

    fun contentsGroupMemo(access: String, contents: String, memoIdx: Int) {

        val groupContentsMemoService =
            ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupContentsMemoService.addContentGroupMemo(access, contents, memoIdx)
            .enqueue(object : Callback<contentsGroupMemoResponse> {
                override fun onResponse(
                    call: Call<contentsGroupMemoResponse>,
                    response: Response<contentsGroupMemoResponse>
                ) {
                    Log.d("ContentsGroupMemo/sucess", response.toString())
                    val resp: contentsGroupMemoResponse = response.body()!!

                    when (val code = resp.code) {
                        1000 -> groupMemoView.onContentsGroupMemoSuccess(code, resp.result!!)
                    }
                }

                override fun onFailure(call: Call<contentsGroupMemoResponse>, t: Throwable) {
                    Log.d("ContentsGroupMemo/failure", t.message.toString())
                }

            })
        Log.d("groupmemo", "groupOk")
    }


    fun inputGroupSchedule(access:String, groupSchedule: NewGroupSchedule){
        val groupScheduleService= ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupScheduleService.inputGroupSchedule(access,groupSchedule).enqueue(object: Callback<GroupScheduleResponse> {
            override fun onResponse(call: Call<GroupScheduleResponse>, response: Response<GroupScheduleResponse>) {
                Log.d("groupinput/success",response.toString())
                val resp: GroupScheduleResponse =response.body()!!

                when(val code=resp.code){
                    1000-> groupScheduleView.onInputGroupScheduleSuccess(code,resp.result!!) }
            }

            override fun onFailure(call: Call<GroupScheduleResponse>, t: Throwable) {
                Log.d("groupinput/failure",t.message.toString())
            }

        })
        Log.d("groupinput","inputOk")
    }

    fun getGroupScheduleMonth(access:String, groupMonth : GroupMonth){
        val groupScheduleService= ApiClient.getRetrofit().create(GroupRetrofitInterface::class.java)

        groupScheduleService.getGroupScheduleMonth(access, groupMonth).enqueue(object : Callback<GetGroupScheduleMonthResponse>{
            override fun onResponse(
                call: Call<GetGroupScheduleMonthResponse>,
                response: Response<GetGroupScheduleMonthResponse>
            ) {
                Log.d("groupGet/success",response.toString())
                val resp:GetGroupScheduleMonthResponse = response.body()!!

                when(val code = resp.code){
                    1000 -> groupScheduleView.onGetGroupScheduleSuccess(code, resp.result!!)
                }
            }

            override fun onFailure(call: Call<GetGroupScheduleMonthResponse>, t: Throwable) {
                Log.d("groupGet/failure",t.message.toString())
            }
        })
        Log.d("groupGet","groupGet finish")
    }
}