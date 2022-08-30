package com.example.namo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/namo/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Login/ReissuanceTokenView;", "()V", "accessToken", "", "binding", "Lcom/example/namo/databinding/ActivitySplashBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivitySplashBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivitySplashBinding;)V", "refreshToken", "kakaoAutoLogin", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEveryTime", "onReissuanceFailure", "code", "", "message", "onReissuanceSuccess", "result", "Lcom/example/namo/Data/Login/ReissuanceResult;", "onResissuanceExpire", "app_debug"})
public final class SplashActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Login.ReissuanceTokenView {
    public com.example.namo.databinding.ActivitySplashBinding binding;
    private java.lang.String accessToken = "";
    private java.lang.String refreshToken = "";
    private java.util.HashMap _$_findViewCache;
    
    public SplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivitySplashBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivitySplashBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onEveryTime() {
    }
    
    @java.lang.Override()
    public void onReissuanceSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.ReissuanceResult result) {
    }
    
    @java.lang.Override()
    public void onResissuanceExpire(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.ReissuanceResult result) {
    }
    
    @java.lang.Override()
    public void onReissuanceFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void kakaoAutoLogin() {
    }
}