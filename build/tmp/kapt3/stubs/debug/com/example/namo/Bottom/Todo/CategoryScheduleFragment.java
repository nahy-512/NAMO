package com.example.namo.Bottom.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001d\u001a\u00020\u001b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J(\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/example/namo/Bottom/Todo/CategoryScheduleFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Floating/Category/CategoryView;", "pos", "", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "tempSchedule", "Lcom/example/namo/Data/Schedule/TempSchedule;", "(ILcom/example/namo/Data/Schedule/GetScheduleRes;Lcom/example/namo/Data/Schedule/TempSchedule;)V", "access", "", "binding", "Lcom/example/namo/databinding/FragmentCategoryScheduleBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentCategoryScheduleBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentCategoryScheduleBinding;)V", "global", "Lcom/example/namo/Data/Login/GlobalApplication;", "gson", "Lcom/google/gson/Gson;", "getPos", "()I", "getSchedule", "()Lcom/example/namo/Data/Schedule/GetScheduleRes;", "getCategorys", "", "getToken", "initRecyclerView", "result", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Category/InquiryCategoryInfo;", "Lkotlin/collections/ArrayList;", "moveToCategoryEdit", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGetAllCategorySuccess", "code", "results", "onGetCategoryFailure", "message", "onGetCategoryLoading", "onResume", "onStart", "putPref", "Companion", "app_debug"})
public final class CategoryScheduleFragment extends androidx.fragment.app.Fragment implements com.example.namo.Floating.Category.CategoryView {
    private final int pos = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.namo.Data.Schedule.GetScheduleRes schedule = null;
    private final com.example.namo.Data.Login.GlobalApplication global = null;
    public com.example.namo.databinding.FragmentCategoryScheduleBinding binding;
    private com.google.gson.Gson gson;
    private java.lang.String access = "";
    private com.example.namo.Data.Schedule.TempSchedule tempSchedule;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Bottom.Todo.CategoryScheduleFragment.Companion Companion = null;
    private static final java.lang.String KEY_PREFS = "tempSchedule";
    private static final java.lang.String KEY_DATA = "tempData";
    private java.util.HashMap _$_findViewCache;
    
    public CategoryScheduleFragment(int pos, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.GetScheduleRes schedule, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.TempSchedule tempSchedule) {
        super();
    }
    
    public final int getPos() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.GetScheduleRes getSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentCategoryScheduleBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentCategoryScheduleBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void initRecyclerView(java.util.ArrayList<com.example.namo.Data.Category.InquiryCategoryInfo> result) {
    }
    
    private final void moveToCategoryEdit() {
    }
    
    private final void putPref() {
    }
    
    private final void getCategorys() {
    }
    
    /**
     * 3.5 카테고리 리스트 전체 조회
     */
    @java.lang.Override()
    public void onGetAllCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Category.InquiryCategoryInfo> results) {
    }
    
    @java.lang.Override()
    public void onGetCategoryLoading() {
    }
    
    @java.lang.Override()
    public void onGetCategoryFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void getToken() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Todo/CategoryScheduleFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_PREFS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}