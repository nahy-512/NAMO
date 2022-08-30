package com.example.namo.Data.Schedule.Memo

interface MemoView {
   fun onInputMemoSuccess(code: Int, result: Int)
   fun onEditMemoSuccess(code: Int, result:String)
}

interface GetMemoView {
   fun onGetMemoSuccess(code: Int, result:GetMemoRes)
   fun onDeleteMemoSuccess(code: Int, result:String)
}

interface GetAllMemoView{
   fun onGetAllMemoSuccess(code: Int, result: List<MonthMemoDto>)
}