package com.example.namo.Floating.Category


import com.example.namo.Data.Category.InquiryCategoryInfo
import com.example.namo.Data.Category.InquiryCategoryResult
import com.example.namo.Data.Category.PostCategoryResult

/**CategorySettingFragment와 연결되는 부분 */
interface CategoryView {
    fun onGetAllCategorySuccess(code : Int, results : ArrayList<InquiryCategoryInfo>) //3.5 카테고리 전체 조회
    fun onGetCategoryLoading()
    fun onGetCategoryFailure(code: Int, message: String)
}

/** CategoryDetailFragment와 연결되는 부분 */
interface CategoryDetailView {
    fun onInputCategorySuccess(code: Int, result: PostCategoryResult) //3.1 카테고리 생성
    fun onEditCategorySuccess(code : Int, result : String) //3.2 카테고리 수정
    fun onGetCategorySuccess(code : Int, results : InquiryCategoryResult) //3.4 카테고리 하나 조회
    fun onGetCategoryFailure(code: Int, message: String)
}

/** CategoryEditActivity와 연결되는 부분 */
interface CategoryDeleteView {
    fun onDeleteCategorySuccess(code : Int, result : String) //3.3 카테고리 삭제
    fun onGetCategoryFailure(code: Int, message: String)
}