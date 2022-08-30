package com.example.namo.Bottom.Home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0019H\u0014J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/example/namo/Bottom/Home/EditScheduleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Bottom/Home/HomeView;", "()V", "access", "", "binding", "Lcom/example/namo/databinding/ActivityEditScheduleBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityEditScheduleBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityEditScheduleBinding;)V", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "getSchedule", "()Lcom/example/namo/Data/Schedule/GetScheduleRes;", "setSchedule", "(Lcom/example/namo/Data/Schedule/GetScheduleRes;)V", "tempSchedule", "Lcom/example/namo/Data/Schedule/TempSchedule;", "getTempSchedule", "()Lcom/example/namo/Data/Schedule/TempSchedule;", "setTempSchedule", "(Lcom/example/namo/Data/Schedule/TempSchedule;)V", "clearPref", "", "deleteScheduleData", "getToken", "loadPref", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteScheduleSuccess", "code", "", "result", "onDestroy", "onEditScheduleSuccess", "onInputScheduleSuccess", "Lcom/example/namo/Data/Schedule/ScheduleResult;", "Companion", "app_debug"})
public final class EditScheduleActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Bottom.Home.HomeView {
    public com.example.namo.databinding.ActivityEditScheduleBinding binding;
    public com.example.namo.Data.Schedule.GetScheduleRes schedule;
    private java.lang.String access = "";
    @org.jetbrains.annotations.NotNull()
    private com.example.namo.Data.Schedule.TempSchedule tempSchedule;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Bottom.Home.EditScheduleActivity.Companion Companion = null;
    private static final java.lang.String KEY_PREFS = "tempSchedule";
    private static final java.lang.String KEY_DATA = "tempData";
    private java.util.HashMap _$_findViewCache;
    
    public EditScheduleActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityEditScheduleBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityEditScheduleBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.GetScheduleRes getSchedule() {
        return null;
    }
    
    public final void setSchedule(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.GetScheduleRes p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.TempSchedule getTempSchedule() {
        return null;
    }
    
    public final void setTempSchedule(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.TempSchedule p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void deleteScheduleData() {
    }
    
    @java.lang.Override()
    public void onInputScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.ScheduleResult result) {
    }
    
    @java.lang.Override()
    public void onEditScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onDeleteScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    private final void getToken() {
    }
    
    private final void loadPref() {
    }
    
    private final void clearPref() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Home/EditScheduleActivity$Companion;", "", "()V", "KEY_DATA", "", "KEY_PREFS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}