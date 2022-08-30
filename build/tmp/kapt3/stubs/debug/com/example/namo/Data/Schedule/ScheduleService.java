package com.example.namo.Data.Schedule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/namo/Data/Schedule/ScheduleService;", "", "()V", "dayScheduleView", "Lcom/example/namo/Data/Schedule/DaySchedule;", "groupScheduleView", "Lcom/example/namo/Data/Group/GroupScheduleView;", "homeView", "Lcom/example/namo/Bottom/Home/HomeView;", "monthScheduleView", "Lcom/example/namo/Data/Schedule/MonthSchedule;", "daySchedule", "", "access", "", "date", "deleteSchedule", "scheduleIdx", "", "editSchedule", "edit", "Lcom/example/namo/Data/Schedule/EditSchedule;", "getSchedule", "schedule", "Lcom/example/namo/Data/Schedule/Schedule;", "monthSchedule", "month", "setDayScheduleView", "setGroupView", "setHomeView", "setMonthScheduleView", "app_debug"})
public final class ScheduleService {
    private com.example.namo.Bottom.Home.HomeView homeView;
    private com.example.namo.Data.Schedule.MonthSchedule monthScheduleView;
    private com.example.namo.Data.Schedule.DaySchedule dayScheduleView;
    private com.example.namo.Data.Group.GroupScheduleView groupScheduleView;
    
    public ScheduleService() {
        super();
    }
    
    public final void setHomeView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.HomeView homeView) {
    }
    
    public final void setMonthScheduleView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.MonthSchedule monthScheduleView) {
    }
    
    public final void setDayScheduleView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.DaySchedule dayScheduleView) {
    }
    
    public final void setGroupView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.GroupScheduleView groupScheduleView) {
    }
    
    public final void getSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Schedule schedule) {
    }
    
    public final void editSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.EditSchedule edit) {
    }
    
    public final void monthSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String month) {
    }
    
    public final void daySchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void deleteSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String access, int scheduleIdx) {
    }
}