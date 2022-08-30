package com.example.namo.Data.Login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\bJ\u001e\u0010\r\u001a\u00020\u000b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/namo/Data/Login/GlobalApplication;", "Landroid/app/Application;", "()V", "groupSchedule", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/ScheduleRes;", "memberSchedule", "getGroupSchedule", "Lkotlin/collections/ArrayList;", "getMemberSchedule", "onCreate", "", "setGroupSchedule", "setMemberSchedule", "app_debug"})
public final class GlobalApplication extends android.app.Application {
    private java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> memberSchedule;
    private java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> groupSchedule;
    
    public GlobalApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> getMemberSchedule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> getGroupSchedule() {
        return null;
    }
    
    public final void setMemberSchedule(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> memberSchedule) {
    }
    
    public final void setGroupSchedule(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> groupSchedule) {
    }
}