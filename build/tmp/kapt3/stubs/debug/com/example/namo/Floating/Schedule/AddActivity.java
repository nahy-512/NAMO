package com.example.namo.Floating.Schedule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/example/namo/Floating/Schedule/AddActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/namo/databinding/ActivityAddBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityAddBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityAddBinding;)V", "tempSchedule", "Lcom/example/namo/Data/Schedule/TempSchedule;", "getTempSchedule", "()Lcom/example/namo/Data/Schedule/TempSchedule;", "setTempSchedule", "(Lcom/example/namo/Data/Schedule/TempSchedule;)V", "clearPref", "", "loadPref", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "Companion", "app_debug"})
public final class AddActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.namo.databinding.ActivityAddBinding binding;
    @org.jetbrains.annotations.NotNull()
    private com.example.namo.Data.Schedule.TempSchedule tempSchedule;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Floating.Schedule.AddActivity.Companion Companion = null;
    private static final java.lang.String KEY_PREFS = "tempSchedule";
    private static final java.lang.String KEY_DATA = "tempData";
    private java.util.HashMap _$_findViewCache;
    
    public AddActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityAddBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityAddBinding p0) {
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
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void loadPref() {
    }
    
    private final void clearPref() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Floating/Schedule/AddActivity$Companion;", "", "()V", "KEY_DATA", "", "KEY_PREFS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}