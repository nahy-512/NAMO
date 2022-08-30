package com.example.namo.Floating.Category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/namo/Floating/Category/TodoCategoryDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Data/Category/TodoCateView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/FragmentTodoCategoryDetailBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentTodoCategoryDetailBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentTodoCategoryDetailBinding;)V", "gson", "Lcom/google/gson/Gson;", "refresh", "todoCate", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Category/TodoCategory;", "getToken", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTodoCateSuccess", "code", "", "result", "Lcom/example/namo/Data/Category/CategoryResult;", "putCategory", "app_debug"})
public final class TodoCategoryDetailFragment extends androidx.fragment.app.Fragment implements com.example.namo.Data.Category.TodoCateView {
    public com.example.namo.databinding.FragmentTodoCategoryDetailBinding binding;
    private com.google.gson.Gson gson;
    private java.lang.String access = "";
    private java.lang.String refresh = "";
    private final java.util.ArrayList<com.example.namo.Data.Category.TodoCategory> todoCate = null;
    private java.util.HashMap _$_findViewCache;
    
    public TodoCategoryDetailFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentTodoCategoryDetailBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentTodoCategoryDetailBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void putCategory() {
    }
    
    private final void getToken() {
    }
    
    @java.lang.Override()
    public void onTodoCateSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Category.CategoryResult result) {
    }
}