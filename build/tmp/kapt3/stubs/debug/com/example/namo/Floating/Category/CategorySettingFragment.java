package com.example.namo.Floating.Category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\u00132\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J(\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0016J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0005H\u0016J\b\u0010\'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/namo/Floating/Category/CategorySettingFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Floating/Category/CategoryView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/FragmentCategorySettingBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentCategorySettingBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentCategorySettingBinding;)V", "categoryListAdapter", "Lcom/example/namo/Floating/Category/Adapter/SetCategoryRVAdapter;", "gson", "Lcom/google/gson/Gson;", "refresh", "site", "getCategorys", "", "getToken", "initRecyclerView", "result", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Category/InquiryCategoryInfo;", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGetAllCategorySuccess", "code", "", "onGetCategoryFailure", "message", "onGetCategoryLoading", "onResume", "onStart", "app_debug"})
public final class CategorySettingFragment extends androidx.fragment.app.Fragment implements com.example.namo.Floating.Category.CategoryView {
    public com.example.namo.databinding.FragmentCategorySettingBinding binding;
    private com.example.namo.Floating.Category.Adapter.SetCategoryRVAdapter categoryListAdapter;
    private com.google.gson.Gson gson;
    private java.lang.String access = "";
    private java.lang.String refresh = "";
    private java.lang.String site = "";
    private java.util.HashMap _$_findViewCache;
    
    public CategorySettingFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentCategorySettingBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentCategorySettingBinding p0) {
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
    
    private final void getCategorys() {
    }
    
    @java.lang.Override()
    public void onGetCategoryLoading() {
    }
    
    @java.lang.Override()
    public void onGetAllCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Category.InquiryCategoryInfo> result) {
    }
    
    @java.lang.Override()
    public void onGetCategoryFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void getToken() {
    }
}