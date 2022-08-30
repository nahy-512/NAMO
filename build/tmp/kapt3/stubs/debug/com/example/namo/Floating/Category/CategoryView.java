package com.example.namo.Floating.Category;

import java.lang.System;

/**
 * CategorySettingFragment와 연결되는 부분
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/namo/Floating/Category/CategoryView;", "", "onGetAllCategorySuccess", "", "code", "", "results", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Category/InquiryCategoryInfo;", "Lkotlin/collections/ArrayList;", "onGetCategoryFailure", "message", "", "onGetCategoryLoading", "app_debug"})
public abstract interface CategoryView {
    
    public abstract void onGetAllCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Category.InquiryCategoryInfo> results);
    
    public abstract void onGetCategoryLoading();
    
    public abstract void onGetCategoryFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}