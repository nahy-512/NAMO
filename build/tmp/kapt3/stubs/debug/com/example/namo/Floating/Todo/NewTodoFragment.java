package com.example.namo.Floating.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0018\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u0005H\u0016J\u0018\u00107\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0016J\u001e\u00108\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00020:09H\u0016J\u001e\u0010;\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00020<09H\u0016J\u001e\u0010=\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00020<09H\u0016J\u0018\u0010>\u001a\u00020&2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020&H\u0016J\b\u0010A\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/example/namo/Floating/Todo/NewTodoFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Data/Todo/TodoView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/FragmentNewTodoBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentNewTodoBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentNewTodoBinding;)V", "categoryIdx", "", "complete", "", "deadLine", "editTodo", "Lcom/example/namo/Data/Todo/EditTodo;", "getEditTodo", "()Lcom/example/namo/Data/Todo/EditTodo;", "setEditTodo", "(Lcom/example/namo/Data/Todo/EditTodo;)V", "endDate", "endTime", "isDateOpen", "isTimeOpen", "memo", "name", "refresh", "todo", "Lcom/example/namo/Data/Todo/Todo;", "getTodo", "()Lcom/example/namo/Data/Todo/Todo;", "setTodo", "(Lcom/example/namo/Data/Todo/Todo;)V", "todoTitle", "dateData", "", "datePicker", "editTodoData", "getTodoData", "getToken", "initText", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteTodoSuccess", "code", "result", "onEditTodoSuccess", "onGetCategoryTodoSuccess", "", "Lcom/example/namo/Data/Todo/GetTodoRes;", "onGetDayTodoSuccess", "Lcom/example/namo/Data/Todo/DayTodoResult;", "onGetMonthTodoSuccess", "onInputTodoSuccess", "Lcom/example/namo/Data/Todo/TodoResult;", "onStart", "timeData", "timePicker", "app_debug"})
public final class NewTodoFragment extends androidx.fragment.app.Fragment implements com.example.namo.Data.Todo.TodoView {
    public com.example.namo.databinding.FragmentNewTodoBinding binding;
    private java.lang.String access = "";
    private java.lang.String refresh = "";
    private boolean isDateOpen = false;
    private boolean isTimeOpen = false;
    public com.example.namo.Data.Todo.Todo todo;
    public com.example.namo.Data.Todo.EditTodo editTodo;
    private java.lang.String name = "";
    private int categoryIdx = 0;
    private java.lang.String deadLine = "";
    private java.lang.String memo = "";
    private boolean complete = false;
    private java.lang.String endDate = "";
    private java.lang.String endTime = "";
    private java.lang.String todoTitle = "";
    private java.util.HashMap _$_findViewCache;
    
    public NewTodoFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentNewTodoBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentNewTodoBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Todo.Todo getTodo() {
        return null;
    }
    
    public final void setTodo(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.Todo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Todo.EditTodo getEditTodo() {
        return null;
    }
    
    public final void setEditTodo(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.EditTodo p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void getTodoData() {
    }
    
    private final void editTodoData() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void getToken() {
    }
    
    private final void initText() {
    }
    
    private final void timePicker() {
    }
    
    private final void datePicker() {
    }
    
    private final void dateData() {
    }
    
    private final void timeData() {
    }
    
    @java.lang.Override()
    public void onInputTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.TodoResult result) {
    }
    
    @java.lang.Override()
    public void onEditTodoSuccess(int code, int result) {
    }
    
    @java.lang.Override()
    public void onDeleteTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onGetDayTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.DayTodoResult> result) {
    }
    
    @java.lang.Override()
    public void onGetMonthTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.DayTodoResult> result) {
    }
    
    @java.lang.Override()
    public void onGetCategoryTodoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Todo.GetTodoRes> result) {
    }
}