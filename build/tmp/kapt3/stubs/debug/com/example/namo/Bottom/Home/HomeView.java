package com.example.namo.Bottom.Home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/namo/Bottom/Home/HomeView;", "", "onDeleteScheduleSuccess", "", "code", "", "result", "", "onEditScheduleSuccess", "onInputScheduleSuccess", "Lcom/example/namo/Data/Schedule/ScheduleResult;", "app_debug"})
public abstract interface HomeView {
    
    public abstract void onInputScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.ScheduleResult result);
    
    public abstract void onEditScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
    
    public abstract void onDeleteScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
}