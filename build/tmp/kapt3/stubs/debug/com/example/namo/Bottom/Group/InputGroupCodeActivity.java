package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0014J\b\u0010$\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/example/namo/Bottom/Group/InputGroupCodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Data/Group/GroupCodeView;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "binding", "Lcom/example/namo/databinding/ActivityGroupCodeBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityGroupCodeBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityGroupCodeBinding;)V", "moimIdx", "", "getMoimIdx", "()I", "setMoimIdx", "(I)V", "addMember", "", "getToken", "onAddGroupMemberSuccess", "code", "result", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGetGroupFailure", "message", "onSearchGroupSuccess", "Lcom/example/namo/Data/Group/SearchGroupResult;", "onStart", "searchGroup", "app_debug"})
public final class InputGroupCodeActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Data.Group.GroupCodeView {
    public com.example.namo.databinding.ActivityGroupCodeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String access = "";
    private int moimIdx = 0;
    private java.util.HashMap _$_findViewCache;
    
    public InputGroupCodeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityGroupCodeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityGroupCodeBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccess() {
        return null;
    }
    
    public final void setAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getMoimIdx() {
        return 0;
    }
    
    public final void setMoimIdx(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    /**
     * API 연동 함수
     */
    private final void searchGroup() {
    }
    
    private final void addMember() {
    }
    
    @java.lang.Override()
    public void onSearchGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.SearchGroupResult result) {
    }
    
    @java.lang.Override()
    public void onAddGroupMemberSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onGetGroupFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void getToken() {
    }
}