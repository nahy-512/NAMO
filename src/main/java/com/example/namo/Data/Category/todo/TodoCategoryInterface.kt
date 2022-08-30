package com.example.namo.Data.Category.todo

import com.example.namo.Data.Category.CategoryPatchResponse
import com.example.namo.Data.Category.CategoryResponse
import com.example.namo.Data.Category.TodoCategory
import com.example.namo.Data.Category.TodoCategoryPatch
import retrofit2.http.*

interface TodoCategoryInterface {

    //to-do 카테고리 생성
    @POST("/todo/category")
    fun putTodoCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao: String,
        @Body todoCategory: TodoCategory
    ): retrofit2.Call<CategoryResponse>

    //to-do 카테고리 수정
    @PATCH("/todo/category/update")
    fun patchTodoCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao: String,
        @Body todoCategoryPatch: TodoCategoryPatch
    ): retrofit2.Call<CategoryPatchResponse>

    //to-do 카테고리 삭제
    @DELETE("/todo/category/{categoryIdx}")
    fun deleteScheduleCategory(
        @Header("ACCESS-TOKEN") accessToken: String,
        @Header("AUTH-SITE") kakao: String,
        @Path("categoryIdx") categoryIdx:Int
    ): retrofit2.Call<CategoryPatchResponse>




}