package com.example.namo.Floating.Category;

import java.lang.System;

/**
 * CategoryDetailFragment와 연결되는 부분
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/example/namo/Floating/Category/CategoryDetailView;", "", "onEditCategorySuccess", "", "code", "", "result", "", "onGetCategoryFailure", "message", "onGetCategorySuccess", "results", "Lcom/example/namo/Data/Category/InquiryCategoryResult;", "onInputCategorySuccess", "Lcom/example/namo/Data/Category/PostCategoryResult;", "app_debug"})
public abstract interface CategoryDetailView {
    
    public abstract void onInputCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Category.PostCategoryResult result);
    
    public abstract void onEditCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
    
    public abstract void onGetCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Category.InquiryCategoryResult results);
    
    public abstract void onGetCategoryFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}