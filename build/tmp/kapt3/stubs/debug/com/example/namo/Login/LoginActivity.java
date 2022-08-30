package com.example.namo.Login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/namo/Login/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/namo/Login/KakaoLoginView;", "Lcom/example/namo/Login/NaverLoginView;", "()V", "accessToken", "", "autoLogin", "", "binding", "Lcom/example/namo/databinding/ActivityLoginBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityLoginBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityLoginBinding;)V", "refreshToken", "kakaoLogin", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKakaoLoginSuccess", "code", "result", "Lcom/example/namo/Data/Login/KakaoResult;", "onNaverLoginSuccess", "Lcom/example/namo/Data/Login/NaverResult;", "startNaverLogin", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.namo.Login.KakaoLoginView, com.example.namo.Login.NaverLoginView {
    public com.example.namo.databinding.ActivityLoginBinding binding;
    private java.lang.String accessToken = "";
    private java.lang.String refreshToken = "";
    private int autoLogin = 0;
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityLoginBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityLoginBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void kakaoLogin() {
    }
    
    private final void startNaverLogin() {
    }
    
    @java.lang.Override()
    public void onKakaoLoginSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.KakaoResult result) {
    }
    
    @java.lang.Override()
    public void onNaverLoginSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.NaverResult result) {
    }
}