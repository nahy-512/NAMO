package com.example.namo.Data.Category.todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\'J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\'J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'\u00a8\u0006\u0011"}, d2 = {"Lcom/example/namo/Data/Category/todo/TodoCategoryInterface;", "", "deleteScheduleCategory", "Lretrofit2/Call;", "Lcom/example/namo/Data/Category/CategoryPatchResponse;", "accessToken", "", "kakao", "categoryIdx", "", "patchTodoCategory", "todoCategoryPatch", "Lcom/example/namo/Data/Category/TodoCategoryPatch;", "putTodoCategory", "Lcom/example/namo/Data/Category/CategoryResponse;", "todoCategory", "Lcom/example/namo/Data/Category/TodoCategory;", "app_debug"})
public abstract interface TodoCategoryInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/todo/category")
    public abstract retrofit2.Call<com.example.namo.Data.Category.CategoryResponse> putTodoCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Category.TodoCategory todoCategory);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "/todo/category/update")
    public abstract retrofit2.Call<com.example.namo.Data.Category.CategoryPatchResponse> patchTodoCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Category.TodoCategoryPatch todoCategoryPatch);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "/todo/category/{categoryIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Category.CategoryPatchResponse> deleteScheduleCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @retrofit2.http.Path(value = "categoryIdx")
    int categoryIdx);
}