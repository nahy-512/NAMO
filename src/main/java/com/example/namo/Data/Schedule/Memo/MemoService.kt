package com.example.namo.Data.Schedule.Memo

import android.content.SharedPreferences
import android.util.Log
import com.example.namo.Data.ApiClient.getRetrofit
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Part

class MemoService {

    private lateinit var memoView: MemoView
    private lateinit var getMemoView: GetMemoView
    private lateinit var getAllMemoView: GetAllMemoView

    fun setMemoView(memoView: MemoView) {
        this.memoView = memoView
    }
    fun getMemoView(getMemoView: GetMemoView) {
        this.getMemoView = getMemoView
    }
    fun getAllMemoView(getAllMemoView: GetAllMemoView) {
        this.getAllMemoView = getAllMemoView
    }
    //기록 입력
    fun inputMemo(
        accessToken: String,
        imgs: List<MultipartBody.Part?>?,
        scheduleIdx: RequestBody,
        content: RequestBody?
    ) {
        val inputMemoService = getRetrofit().create(MemoRetroInterface::class.java)

        inputMemoService.inputMemo(accessToken,imgs,scheduleIdx,content)
            .enqueue(object : Callback<MemoResponse> {
                override fun onResponse(
                    call: Call<MemoResponse>,
                    response: Response<MemoResponse>
                ) {
                    Log.d("InputMemo/success", response.toString())
                    val resp: MemoResponse = response.body()!!
                    when (val code = resp.code) {
                        1000 -> memoView.onInputMemoSuccess(code, resp.result)
                    }
                }

                override fun onFailure(call: Call<MemoResponse>, t: Throwable) {
                    Log.d("InputMemo/failure", t.message.toString())
                }

            })
        Log.d("Memo", "memoOk")
    }


    //기록 수정
    fun editMemo(accessToken: String,
                 content: RequestBody?, imgIdxList: List<MultipartBody.Part?>?, fileList: List<MultipartBody.Part?>?,memoIdx:RequestBody){
        val editMemoService= getRetrofit().create(MemoRetroInterface::class.java)
        editMemoService.editMemo(accessToken, content,imgIdxList,fileList,memoIdx).enqueue(object: Callback<EditMemoResponse> {
            override fun onResponse(call: Call<EditMemoResponse>, response: Response<EditMemoResponse>) {
                Log.d("editMemo/success",response.toString())
                val resp: EditMemoResponse =response.body()!!

                when(val code=resp.code){
                    1000-> memoView.onEditMemoSuccess(code,resp.result) }
            }
            override fun onFailure(call: Call<EditMemoResponse>, t: Throwable) {
                Log.d("editMemo/failure",t.message.toString())
            }

        })
        Log.d("Memo","memoOk")
    }


    //기록 상세조회
    fun getMemo(accessToken: String, memoIdx: Int) {
        val getMemoService = getRetrofit().create(MemoRetroInterface::class.java)

        getMemoService.getdetailMemo(accessToken, memoIdx)
            .enqueue(object : Callback<GetMemoResponse> {
                override fun onResponse(
                    call: Call<GetMemoResponse>,
                    response: Response<GetMemoResponse>
                ) {
                    Log.d("getMemo/success", response.toString())
                    val resp: GetMemoResponse = response.body()!!
                    Log.d("response.body","$resp")
                    when (val code = resp.code) {
                        1000 -> getMemoView.onGetMemoSuccess(code, resp.result)
                    }
                }
                override fun onFailure(call: Call<GetMemoResponse>, t: Throwable) {
                    Log.d("getMemo/failure", t.message.toString())
                }

            })
        Log.d("Memo", "memoOk")
    }


    //기록 삭제
    fun deleteMemo(accessToken: String,memoIdx: Int) {
        val deleteMemoService = getRetrofit().create(MemoRetroInterface::class.java)

        deleteMemoService.deleteMemo(accessToken,memoIdx)
            .enqueue(object : Callback<DeleteMemoResponse> {
                override fun onResponse(
                    call: Call<DeleteMemoResponse>,
                    response: Response<DeleteMemoResponse>
                ) {
                    Log.d("deleteMemo/success", response.toString())
                    val resp: DeleteMemoResponse = response.body()!!
                    when (val code = resp.code) {
                        1000 -> getMemoView.onDeleteMemoSuccess(code, resp.result)
                    }
                }
                override fun onFailure(call: Call<DeleteMemoResponse>, t: Throwable) {
                    Log.d("deleteMemo/failure", t.message.toString())
                }

            })
        Log.d("Memo", "memoOk")
    }

    //기록 전체조회
    fun getAllMemo(accessToken: String,month: String) {
        val getAllMemoService = getRetrofit().create(MemoRetroInterface::class.java)

        getAllMemoService.getAllMemo(accessToken,month)
            .enqueue(object : Callback <GetAllMemoResponse> {
                override fun onResponse(
                    call: Call <GetAllMemoResponse>,
                    response: Response <GetAllMemoResponse>
                ) {
                    Log.d("getAllMemo/success", response.toString())
                    val resp:  GetAllMemoResponse = response.body()!!
                    Log.d("response.body","$resp")
                    when (val code = resp.code) {
                        1000 -> getAllMemoView.onGetAllMemoSuccess(code,resp.result)
                    }
                }
                override fun onFailure(call: Call <GetAllMemoResponse>, t: Throwable) {
                    Log.d("getAllMemo/failure", t.message.toString())
                }

            })
        Log.d("Memo", "memoOk")
    }
}