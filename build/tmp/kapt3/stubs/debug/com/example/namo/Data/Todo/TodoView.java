package com.example.namo.Data.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\nH&J\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/example/namo/Data/Todo/TodoView;", "", "onDeleteTodoSuccess", "", "code", "", "result", "", "onEditTodoSuccess", "onGetCategoryTodoSuccess", "", "Lcom/example/namo/Data/Todo/GetTodoRes;", "onGetDayTodoSuccess", "Lcom/example/namo/Data/Todo/DayTodoResult;", "onGetMonthTodoSuccess", "onInputTodoSuccess", "Lcom/example/namo/Data/Todo/TodoResult;", "app_debug"})
public abstract interface TodoView {
    
    public abstract void onInputTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.TodoResult result);
    
    public abstract void onEditTodoSuccess(int code, int result);
    
    public abstract void onDeleteTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
    
    public abstract void onGetDayTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.DayTodoResult> result);
    
    public abstract void onGetMonthTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.DayTodoResult> result);
    
    public abstract void onGetCategoryTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.GetTodoRes> result);
}