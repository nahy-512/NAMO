package com.example.namo.Data.Category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0013H\'\u00a8\u0006\u0014"}, d2 = {"Lcom/example/namo/Data/Category/CategoryRetrofitInterface;", "", "deleteScheduleCategory", "Lretrofit2/Call;", "Lcom/example/namo/Data/Category/DeleteCategoryResponse;", "accessToken", "", "categoryIdx", "", "getAllScheduleCategory", "Lcom/example/namo/Data/Category/InquiryAllCategoryResponse;", "getScheduleCategory", "Lcom/example/namo/Data/Category/InquiryCategoryResponse;", "patchScheduleCategory", "Lcom/example/namo/Data/Category/EditCategoryResponse;", "schedulecategory", "Lcom/example/namo/Data/Category/EditScheduleCategory;", "postScheduleCategory", "Lcom/example/namo/Data/Category/PostCategoryResponse;", "Lcom/example/namo/Data/Category/ScheduleCategory;", "app_debug"})
public abstract interface CategoryRetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/schedule/category")
    public abstract retrofit2.Call<com.example.namo.Data.Category.PostCategoryResponse> postScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Category.ScheduleCategory schedulecategory);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "/schedule/category/update")
    public abstract retrofit2.Call<com.example.namo.Data.Category.EditCategoryResponse> patchScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Category.EditScheduleCategory schedulecategory);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "/schedule/category/{categoryIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Category.DeleteCategoryResponse> deleteScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @retrofit2.http.Path(value = "categoryIdx")
    int categoryIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/schedule/category/{categoryIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Category.InquiryCategoryResponse> getScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @retrofit2.http.Path(value = "categoryIdx")
    int categoryIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "schedule/category/all")
    public abstract retrofit2.Call<com.example.namo.Data.Category.InquiryAllCategoryResponse> getAllScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken);
}