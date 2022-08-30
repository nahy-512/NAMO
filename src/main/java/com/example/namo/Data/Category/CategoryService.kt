package com.example.namo.Data.Category

import android.util.Log
import com.example.namo.Data.ApiClient
import com.example.namo.Data.ApiClient.getRetrofit
import com.example.namo.Data.Schedule.*
import com.example.namo.Floating.Category.CategoryDeleteView
import com.example.namo.Floating.Category.CategoryDetailView
import com.example.namo.Floating.Category.CategoryView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryService {
    private lateinit var categoryView: CategoryView //CategorySettingFragment
    private lateinit var categoryDetailView : CategoryDetailView //CategoryDetailFragment
    private lateinit var categoryDeleteView : CategoryDeleteView //CategoryDetailFragment


    fun setCategoryView(categoryView: CategoryView) {
        this.categoryView = categoryView
    }

    fun setCategorySetView(categorySetView: CategoryDetailView) {
        this.categoryDetailView = categorySetView
    }

    fun setCategoryDeleteView(categoryDeleteView: CategoryDeleteView) {
        this.categoryDeleteView = categoryDeleteView
    }


    /** 3.5 카테고리 전체 조회*/
    fun getAllScheduleCategory(access:String) {
        val categoryService = getRetrofit().create(CategoryRetrofitInterface::class.java)

        categoryView.onGetCategoryLoading()

        categoryService.getAllScheduleCategory(access).enqueue(object : Callback<InquiryAllCategoryResponse> {
            override fun onResponse(call: Call<InquiryAllCategoryResponse>, response: Response<InquiryAllCategoryResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val resp: InquiryAllCategoryResponse = response.body()!!

                    Log.d("CATEGORY-INQUIRY-ALL-RESPONSE", resp.toString())

                    when (val code = resp.code) {
                        200 -> Log.d("GET_CATEGORY_200", response.errorBody()?.string()!!)
                        1000 -> { categoryView.onGetAllCategorySuccess(code,resp.result!!) }
                        else -> categoryView.onGetCategoryFailure(code, resp.message)
                    }
                }
            }
            override fun onFailure(call: Call<InquiryAllCategoryResponse>, t: Throwable) {
                categoryView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("inquiry/failure",t.message.toString())
            }
        })
        Log.d("inquiry-All","categoryOk")
    }

    /** 3.1 카테고리 생성 */
    fun postScheduleCategory(access:String, schedulecategory: ScheduleCategory){
        val categoryService= getRetrofit().create(CategoryRetrofitInterface::class.java)

        categoryService.postScheduleCategory(access, schedulecategory).enqueue(object: Callback<PostCategoryResponse> {
            override fun onResponse(call: Call<PostCategoryResponse>, response: Response<PostCategoryResponse>) {
                Log.d("CATEGORY-POST-RESPONSE",response.toString())
                val resp: PostCategoryResponse =response.body()!!

                when(val code=resp.code) {
                    200 -> Log.d("POST_CATEGORY_200", response.errorBody()?.string()!!)
                    1000 -> { categoryDetailView.onInputCategorySuccess(code, resp.result!!) }
                    else -> categoryDetailView.onGetCategoryFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<PostCategoryResponse>, t: Throwable) {
                categoryDetailView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("input/failure",t.message.toString())
            }

        })
        Log.d("input","categoryOk")

    }

    /** 3.2 카테고리 수정 */
    fun editScheduleCategory(access:String, schedulecategory: EditScheduleCategory){
        val categoryService= getRetrofit().create(CategoryRetrofitInterface::class.java)

        categoryService.patchScheduleCategory(access,schedulecategory).enqueue(object: Callback<EditCategoryResponse> {
            override fun onResponse(call: Call<EditCategoryResponse>, response: Response<EditCategoryResponse>) {
                Log.d("CATEGORY-EDIT-RESPONSE",response.toString())
                val resp: EditCategoryResponse =response.body()!!

                when(val code=resp.code) {
                    200 -> Log.d("EDIT_CATEGORY_200", response.errorBody()?.string()!!)
                    1000 -> { categoryDetailView.onEditCategorySuccess(code, resp.result!!) }
                    else -> categoryDetailView.onGetCategoryFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<EditCategoryResponse>, t: Throwable) {
                categoryDetailView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("edit/failure",t.message.toString())
            }

        })
        Log.d("edit","categoryOk")
    }

    /** 3.4 카테고리 조회 */
    fun getScheduleCategory(access:String, categoryIdx: Int){
        val categoryService= getRetrofit().create(CategoryRetrofitInterface::class.java)

        categoryService.getScheduleCategory(access,categoryIdx).enqueue(object: Callback<InquiryCategoryResponse> {
            override fun onResponse(call: Call<InquiryCategoryResponse>, response: Response<InquiryCategoryResponse>) {
                Log.d("CATEGORY-INQUIRY-RESPONSE",response.toString())
                val resp: InquiryCategoryResponse =response.body()!!

                when(val code=resp.code) {
                    200 -> Log.d("Inquiry_CATEGORY_200", response.errorBody()?.string()!!)
                    1000 -> { categoryDetailView.onGetCategorySuccess(code, resp.result!!) }
                    else -> categoryDetailView.onGetCategoryFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<InquiryCategoryResponse>, t: Throwable) {
                categoryDetailView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("inquiry/failure",t.message.toString())
            }

        })
        Log.d("inquiry","categoryOk")
    }

    /** 3.3 카테고리 삭제 */
    fun deleteScheduleCategory(access: String, categoryIdx: Int) {
        val categoryService= getRetrofit().create(CategoryRetrofitInterface::class.java)

        categoryService.deleteScheduleCategory(access,categoryIdx).enqueue(object: Callback<DeleteCategoryResponse> {
            override fun onResponse(call: Call<DeleteCategoryResponse>, response: Response<DeleteCategoryResponse>) {
                Log.d("CATEGORY-DELETE-RESPONSE",response.toString())
                val resp: DeleteCategoryResponse =response.body()!!

                when(val code=resp.code) {
                    200 -> Log.d("DELETE_CATEGORY_200", response.errorBody()?.string()!!)
                    1000 -> { categoryDeleteView.onDeleteCategorySuccess(code, resp.result!!) }
                    else -> categoryDeleteView.onGetCategoryFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<DeleteCategoryResponse>, t: Throwable) {
                categoryDeleteView.onGetCategoryFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("delete/failure",t.message.toString())
            }

        })
        Log.d("delete","categoryOk")
    }
}