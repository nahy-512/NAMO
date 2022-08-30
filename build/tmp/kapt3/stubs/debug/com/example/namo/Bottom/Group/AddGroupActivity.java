package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\"\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0006\u0010/\u001a\u00020%J\u0012\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0018\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020%2\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u0005H\u0016J\u0018\u00108\u001a\u00020%2\u0006\u00104\u001a\u00020+2\u0006\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020%H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006;"}, d2 = {"Lcom/example/namo/Bottom/Group/AddGroupActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Data/Group/GroupView;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "binding", "Lcom/example/namo/databinding/ActivityAddGroupBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityAddGroupBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityAddGroupBinding;)V", "groupCode", "getGroupCode", "setGroupCode", "profileImg", "Lokhttp3/MultipartBody$Part;", "getProfileImg", "()Lokhttp3/MultipartBody$Part;", "setProfileImg", "(Lokhttp3/MultipartBody$Part;)V", "view", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "getView", "()Ljava/util/ArrayList;", "setView", "(Ljava/util/ArrayList;)V", "absolutelyPath", "path", "context", "Landroid/content/Context;", "clipCopy", "", "createGroup", "getPermission", "getToken", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateGroupSuccess", "code", "result", "Lcom/example/namo/Data/Group/CreateGroupResult;", "onEditGroupSuccess", "onGetGroupFailure", "message", "onStart", "app_debug"})
public final class AddGroupActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Data.Group.GroupView {
    public com.example.namo.databinding.ActivityAddGroupBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String access = "";
    public okhttp3.MultipartBody.Part profileImg;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<android.net.Uri> view;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String groupCode = "";
    private java.util.HashMap _$_findViewCache;
    
    public AddGroupActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityAddGroupBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityAddGroupBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccess() {
        return null;
    }
    
    public final void setAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.MultipartBody.Part getProfileImg() {
        return null;
    }
    
    public final void setProfileImg(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<android.net.Uri> getView() {
        return null;
    }
    
    public final void setView(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.net.Uri> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGroupCode() {
        return null;
    }
    
    public final void setGroupCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void onClickListener() {
    }
    
    private final void clipCopy() {
    }
    
    private final void getPermission() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String absolutelyPath(@org.jetbrains.annotations.NotNull()
    android.net.Uri path, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final void createGroup() {
    }
    
    @java.lang.Override()
    public void onCreateGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.CreateGroupResult result) {
    }
    
    @java.lang.Override()
    public void onEditGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onGetGroupFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void getToken() {
    }
}