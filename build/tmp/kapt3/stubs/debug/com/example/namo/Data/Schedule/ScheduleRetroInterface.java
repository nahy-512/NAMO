package com.example.namo.Data.Schedule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0012H\'J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u0006H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/example/namo/Data/Schedule/ScheduleRetroInterface;", "", "daySchedule", "Lretrofit2/Call;", "Lcom/example/namo/Data/Schedule/DayScheduleResponse;", "accessToken", "", "date", "deleteSchedule", "Lcom/example/namo/Data/Schedule/DeleteScheduleResponse;", "scheduleIdx", "", "editSchedule", "Lcom/example/namo/Data/Schedule/EditScheduleResponse;", "schedule", "Lcom/example/namo/Data/Schedule/EditSchedule;", "getSchedule", "Lcom/example/namo/Data/Schedule/ScheduleResponse;", "Lcom/example/namo/Data/Schedule/Schedule;", "monthSchedule", "Lcom/example/namo/Data/Schedule/MonthScheduleResponse;", "month", "app_debug"})
public abstract interface ScheduleRetroInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "schedule")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.ScheduleResponse> getSchedule(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Schedule.Schedule schedule);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "schedule/update")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.EditScheduleResponse> editSchedule(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Schedule.EditSchedule schedule);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "schedule/{scheduleIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.DeleteScheduleResponse> deleteSchedule(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @retrofit2.http.Path(value = "scheduleIdx")
    int scheduleIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "schedule/month/{month}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.MonthScheduleResponse> monthSchedule(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "month")
    java.lang.String month);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "schedule/day/{date}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.DayScheduleResponse> daySchedule(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "date")
    java.lang.String date);
}