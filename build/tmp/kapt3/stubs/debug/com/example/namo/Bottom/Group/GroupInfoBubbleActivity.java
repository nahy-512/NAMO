package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u001a\u001a\u00020\u001b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0005H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u001bH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016\u00a8\u00060"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupInfoBubbleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Data/Group/GroupInfoView;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "binding", "Lcom/example/namo/databinding/ActivityGroupInformationBubbleBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityGroupInformationBubbleBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityGroupInformationBubbleBinding;)V", "groupCode", "memberNum", "", "getMemberNum", "()I", "setMemberNum", "(I)V", "moimIdx", "getMoimIdx", "setMoimIdx", "InitRecyclerView", "", "result", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/FriendsList;", "Lkotlin/collections/ArrayList;", "clipCopy", "deleteGroup", "getToken", "inquiryGroupInfo", "leaveGroup", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteGroupSuccess", "code", "onGetGroupFailure", "message", "onGetGroupInfoSuccess", "Lcom/example/namo/Data/Group/InquiryGroupInfoResult;", "onLeaveGroupSuccess", "onStart", "app_debug"})
public final class GroupInfoBubbleActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Data.Group.GroupInfoView {
    public com.example.namo.databinding.ActivityGroupInformationBubbleBinding binding;
    private java.lang.String groupCode = "";
    private int moimIdx = 0;
    private int memberNum = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String access = "";
    private java.util.HashMap _$_findViewCache;
    
    public GroupInfoBubbleActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityGroupInformationBubbleBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityGroupInformationBubbleBinding p0) {
    }
    
    public final int getMoimIdx() {
        return 0;
    }
    
    public final void setMoimIdx(int p0) {
    }
    
    public final int getMemberNum() {
        return 0;
    }
    
    public final void setMemberNum(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccess() {
        return null;
    }
    
    public final void setAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void inquiryGroupInfo() {
    }
    
    private final void leaveGroup() {
    }
    
    private final void deleteGroup() {
    }
    
    private final void InitRecyclerView(java.util.ArrayList<com.example.namo.Data.Group.FriendsList> result) {
    }
    
    private final void clipCopy() {
    }
    
    @java.lang.Override()
    public void onGetGroupInfoSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.InquiryGroupInfoResult result) {
    }
    
    @java.lang.Override()
    public void onDeleteGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onLeaveGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onGetGroupFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void getToken() {
    }
}