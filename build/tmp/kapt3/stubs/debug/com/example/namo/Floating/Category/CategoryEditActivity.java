package com.example.namo.Floating.Category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\b\u0010\u001c\u001a\u00020\u0011H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/namo/Floating/Category/CategoryEditActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Floating/Category/CategoryDeleteView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/ActivityCategoryEditBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityCategoryEditBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityCategoryEditBinding;)V", "categoryIdx", "", "refresh", "site", "deleteCategory", "", "getToken", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteCategorySuccess", "code", "result", "onGetCategoryFailure", "message", "onPause", "onStart", "app_debug"})
public final class CategoryEditActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Floating.Category.CategoryDeleteView {
    public com.example.namo.databinding.ActivityCategoryEditBinding binding;
    private java.lang.String access = "";
    private java.lang.String refresh = "";
    private java.lang.String site = "";
    private int categoryIdx = 0;
    private java.util.HashMap _$_findViewCache;
    
    public CategoryEditActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityCategoryEditBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityCategoryEditBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onDeleteCategorySuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onGetCategoryFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void deleteCategory() {
    }
    
    private final void getToken() {
    }
}