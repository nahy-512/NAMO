package com.example.namo.Data.Category.todo

import android.util.Log
import com.example.namo.Data.ApiClient
import com.example.namo.Data.Category.*
import retrofit2.Call
import retrofit2.Response

class TodoCategoryService {
    private lateinit var todocateView: TodoCateView
    private lateinit var todoCatePatchView: TodoCatePatchView

    fun setCateView(todocateView: TodoCateView) {
        this.todocateView = todocateView
    }

    fun setCatePatchView(todoCatePatchView: TodoCatePatchView) {
        this.todoCatePatchView =todoCatePatchView
    }

    //투두 카테고리 생성
    fun putTodoCategory(access: String, refresh: String, todoCategory: TodoCategory) {
        val catogoryService = ApiClient.getRetrofit().create(TodoCategoryInterface::class.java)

        catogoryService.putTodoCategory(access, "kakao", todoCategory)
            .enqueue(object : retrofit2.Callback<CategoryResponse> {
                override fun onResponse(
                    call: Call<CategoryResponse>,
                    response: Response<CategoryResponse>
                ) {
                    Log.d("input/success", response.toString())
                    val resp: CategoryResponse = response.body()!!

                    when (val code = resp.code) {
                        200 -> Log.d("put_200", response.errorBody()?.string()!!)
                        1000 -> todocateView.onTodoCateSuccess(code, resp.result!!)
                    }
                }

                override fun onFailure(call: retrofit2.Call<CategoryResponse>, t: Throwable) {
                    Log.d("input/failure", t.message.toString())
                }

            })
        Log.d("input", "inputOk")
    }

    //투두 카테고리 수정
    fun patchTodoCategory(access: String, refresh: String, todoCategoryPatch: TodoCategoryPatch) {
        val catogoryPatchService = ApiClient.getRetrofit().create(TodoCategoryInterface::class.java)

        catogoryPatchService.patchTodoCategory(access, "kakao", todoCategoryPatch)
            .enqueue(object : retrofit2.Callback<CategoryPatchResponse> {
                override fun onResponse(
                    call: Call<CategoryPatchResponse>,
                    response: Response<CategoryPatchResponse>
                ) {
                    Log.d("patch/success", response.toString())
                    val resp: CategoryPatchResponse = response.body()!!

                    when (val code = resp.code ) {
                        200 -> Log.d("patch_200", response.errorBody()?.string()!!)
                        1000 -> todoCatePatchView.onTodoCatePatchSuccess(code, resp.results!!)
                    }
                }

                override fun onFailure(call: retrofit2.Call<CategoryPatchResponse>, t: Throwable) {
                    Log.d("patch/failure", t.message.toString())
                }

            })
        Log.d("patch", "inputOk")
    }


    //투두 카테고리 삭제
    fun deleteTodoCategory(access: String, refresh: String, categoryIdx:Int) {
        val catogoryDeleteService = ApiClient.getRetrofit().create(TodoCategoryInterface::class.java)

        catogoryDeleteService.deleteScheduleCategory(access, "kakao",categoryIdx)
            .enqueue(object : retrofit2.Callback<CategoryPatchResponse> {
                override fun onResponse(
                    call: Call<CategoryPatchResponse>,
                    response: Response<CategoryPatchResponse>
                ) {
                    Log.d("delete/success", response.toString())
                    val resp: CategoryPatchResponse = response.body()!!

                    when (val code = resp.code ) {
                        200 -> Log.d("delete_200", response.errorBody()?.string()!!)
                        1000 -> todoCatePatchView.onTodoCatePatchSuccess(code, resp.results!!)
                    }
                }

                override fun onFailure(call: retrofit2.Call<CategoryPatchResponse>, t: Throwable) {
                    Log.d("delete/failure", t.message.toString())
                }

            })
        Log.d("delete", "deleteOk")
    }
















}