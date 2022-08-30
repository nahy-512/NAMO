package com.example.namo.Data.Group

import com.example.namo.Data.Category.PostCategoryResult

interface GroupView { //AddGroupActivity와 연결
    fun onCreateGroupSuccess(code: Int, result: CreateGroupResult) //7.1 그룹 생성
    fun onEditGroupSuccess(code: Int, result: String) //7.2 그룹 수정
    fun onGetGroupFailure(code: Int, message: String)
}

interface GroupCodeView { //InputGroupCodeActivity와 연결
    fun onSearchGroupSuccess(code: Int, result: SearchGroupResult) //7.4 모임 검색
    fun onAddGroupMemberSuccess(code: Int, result: String) //7.7 모임원 추가
    fun onGetGroupFailure(code: Int, message: String)
}

interface GroupFragView { //GroupFragment와 연결
    fun onGetGroupListSuccess(code: Int, result: ArrayList<GroupListResult>) //7.6 모임 리스트
    fun onGetGroupFailure(code: Int, message: String)
}

interface GroupInfoView { //GroupInfoBubbleActivity와 연결
    fun onGetGroupInfoSuccess(code: Int, result: InquiryGroupInfoResult) //7.5 그룹 정보 조회
    fun onDeleteGroupSuccess(code: Int, result: String) // 7.3 그룹 삭제
    fun onLeaveGroupSuccess(code: Int, result: String) // 7.8 그룹 탈퇴
    fun onGetGroupFailure(code: Int, message: String)
}

interface GroupCalendarView {

}

interface GroupMemoView{

    fun onAddGroupMemoSuccess(code: Int, result: String)
    fun onGetGroupMemoSuccess(code: Int, result: moimMemoResult)
    fun onContentsGroupMemoSuccess(code: Int, result: String)

}