package com.example.namo.Data.Category

interface TodoCateView {
        fun onTodoCateSuccess(code: Int, result: CategoryResult)
}

interface TodoCatePatchView{
        fun onTodoCatePatchSuccess(code: Int, results: String)
}