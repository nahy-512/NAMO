package com.example.namo.Bottom.Home.Record;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/namo/Bottom/Home/Record/RecordWriteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Data/Schedule/Memo/GetMemoView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/ActivityRecordWriteBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityRecordWriteBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityRecordWriteBinding;)V", "gson", "Lcom/google/gson/Gson;", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "getMemo", "", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteMemoSuccess", "code", "", "result", "onGetMemoSuccess", "Lcom/example/namo/Data/Schedule/Memo/GetMemoRes;", "removeLastNchars", "str", "n", "app_debug"})
public final class RecordWriteActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Data.Schedule.Memo.GetMemoView {
    public com.example.namo.databinding.ActivityRecordWriteBinding binding;
    private java.lang.String access = "";
    private com.example.namo.Data.Schedule.GetScheduleRes schedule;
    private com.google.gson.Gson gson;
    private java.util.HashMap _$_findViewCache;
    
    public RecordWriteActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityRecordWriteBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityRecordWriteBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getMemo() {
    }
    
    @java.lang.Override()
    public void onGetMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Memo.GetMemoRes result) {
    }
    
    private final void onClickListener() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String removeLastNchars(@org.jetbrains.annotations.NotNull()
    java.lang.String str, int n) {
        return null;
    }
    
    @java.lang.Override()
    public void onDeleteMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
}