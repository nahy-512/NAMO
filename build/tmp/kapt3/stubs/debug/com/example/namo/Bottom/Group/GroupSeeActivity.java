package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\u0018\u0010\'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0018\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020,H\u0016J\u0016\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00062"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupSeeActivity;", "Landroid/app/Activity;", "Lcom/example/namo/Data/Group/GroupMemoView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/ActivityGroupSeeBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityGroupSeeBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityGroupSeeBinding;)V", "isFromGroup", "", "memoIdx", "", "moimInPersonal", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "getMoimInPersonal", "()Lcom/example/namo/Data/Schedule/GetScheduleRes;", "setMoimInPersonal", "(Lcom/example/namo/Data/Schedule/GetScheduleRes;)V", "peopleList", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/moimAttendences;", "placeList", "Lcom/example/namo/Data/Group/getMoimMemoLocationRes;", "schedule", "Lcom/example/namo/Data/Group/ScheduleRes;", "getSchedule", "()Lcom/example/namo/Data/Group/ScheduleRes;", "setSchedule", "(Lcom/example/namo/Data/Group/ScheduleRes;)V", "getGroupMemo", "", "onAddGroupMemoSuccess", "code", "result", "onClickListener", "onContentsGroupMemoSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGetGroupMemoSuccess", "Lcom/example/namo/Data/Group/moimMemoResult;", "removeLastNchars", "str", "n", "setRecyclerView", "isVisible", "app_debug"})
public final class GroupSeeActivity extends android.app.Activity implements com.example.namo.Data.Group.GroupMemoView {
    public com.example.namo.databinding.ActivityGroupSeeBinding binding;
    private java.lang.String access = "";
    private java.util.ArrayList<com.example.namo.Data.Group.moimAttendences> peopleList;
    private java.util.ArrayList<com.example.namo.Data.Group.getMoimMemoLocationRes> placeList;
    public com.example.namo.Data.Group.ScheduleRes schedule;
    public com.example.namo.Data.Schedule.GetScheduleRes moimInPersonal;
    private int memoIdx = -1;
    private boolean isFromGroup = false;
    private java.util.HashMap _$_findViewCache;
    
    public GroupSeeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityGroupSeeBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityGroupSeeBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Group.ScheduleRes getSchedule() {
        return null;
    }
    
    public final void setSchedule(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.ScheduleRes p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.GetScheduleRes getMoimInPersonal() {
        return null;
    }
    
    public final void setMoimInPersonal(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.GetScheduleRes p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getGroupMemo() {
    }
    
    @java.lang.Override()
    public void onGetGroupMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.moimMemoResult result) {
    }
    
    private final void setRecyclerView(boolean isVisible) {
    }
    
    private final void onClickListener() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String removeLastNchars(@org.jetbrains.annotations.NotNull()
    java.lang.String str, int n) {
        return null;
    }
    
    @java.lang.Override()
    public void onAddGroupMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onContentsGroupMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
}