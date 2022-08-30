package com.example.namo.Bottom.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/namo/Bottom/Todo/TodoArrayDateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/namo/Bottom/Todo/Adapter/TodoCalendarWeekRVAdapter;", "binding", "Lcom/example/namo/databinding/FragmentTodoArrayDateBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentTodoArrayDateBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentTodoArrayDateBinding;)V", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "calendarList2", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Todo/CalendarDateModel;", "currentDate", "dates", "Ljava/util/Date;", "sdf", "Ljava/text/SimpleDateFormat;", "todoDDatas", "Lcom/example/namo/Data/Todo/Todo;", "applyTodoData", "", "checkTodo", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setUpAdapter", "setUpCalendar", "setUpClickListener", "app_debug"})
public final class TodoArrayDateFragment extends androidx.fragment.app.Fragment {
    private java.util.ArrayList<com.example.namo.Data.Todo.Todo> todoDDatas;
    public com.example.namo.databinding.FragmentTodoArrayDateBinding binding;
    private final java.text.SimpleDateFormat sdf = null;
    private final java.util.Calendar cal = null;
    private final java.util.Calendar currentDate = null;
    private final java.util.ArrayList<java.util.Date> dates = null;
    private com.example.namo.Bottom.Todo.Adapter.TodoCalendarWeekRVAdapter adapter;
    private final java.util.ArrayList<com.example.namo.Data.Todo.CalendarDateModel> calendarList2 = null;
    private java.util.HashMap _$_findViewCache;
    
    public TodoArrayDateFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentTodoArrayDateBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentTodoArrayDateBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * Set up click listener
     */
    private final void setUpClickListener() {
    }
    
    /**
     * Setting up adapter for recyclerview
     */
    private final void setUpAdapter() {
    }
    
    /**
     * Function to setup calendar for every month
     */
    private final void setUpCalendar() {
    }
    
    /**
     * 날짜별 To-do 리스트 리사이클러뷰(세로 스크롤)
     */
    private final void applyTodoData() {
    }
    
    private final void checkTodo() {
    }
}