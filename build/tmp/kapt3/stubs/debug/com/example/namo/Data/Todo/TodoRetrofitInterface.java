package com.example.namo.Data.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\'J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H\'J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\tH\'J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\'J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0016H\'J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u0006H\'\u00a8\u0006\u0019"}, d2 = {"Lcom/example/namo/Data/Todo/TodoRetrofitInterface;", "", "categoryTodo", "Lretrofit2/Call;", "Lcom/example/namo/Data/Todo/CategoryTodoResponse;", "accessToken", "", "kakao", "categoryIdx", "", "dayTodo", "Lcom/example/namo/Data/Todo/DayTodoResponse;", "day", "deleteTodo", "Lcom/example/namo/Data/Todo/DeleteTodoResponse;", "todoIdx", "editTodo", "Lcom/example/namo/Data/Todo/EditTodoResponse;", "todo", "Lcom/example/namo/Data/Todo/EditTodo;", "getTodo", "Lcom/example/namo/Data/Todo/TodoResponse;", "Lcom/example/namo/Data/Todo/Todo;", "monthTodo", "month", "app_debug"})
public abstract interface TodoRetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "todo")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.TodoResponse> getTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Todo.Todo todo);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "todo")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.EditTodoResponse> editTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Todo.EditTodo todo);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "todo/{todoIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.DeleteTodoResponse> deleteTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @retrofit2.http.Path(value = "todoIdx")
    int todoIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "todo/day/{day}")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.DayTodoResponse> dayTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "day")
    java.lang.String day);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "todo/month/{month}")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.DayTodoResponse> monthTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "month")
    java.lang.String month);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "todo/category/{categoryIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Todo.CategoryTodoResponse> categoryTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "AUTH-SITE")
    java.lang.String kakao, @retrofit2.http.Path(value = "categoryIdx")
    int categoryIdx);
}