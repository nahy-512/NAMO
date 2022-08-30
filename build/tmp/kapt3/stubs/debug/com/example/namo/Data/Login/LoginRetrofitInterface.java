package com.example.namo.Data.Login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/namo/Data/Login/LoginRetrofitInterface;", "", "kakaologin", "Lretrofit2/Call;", "Lcom/example/namo/Data/Login/KakaoResponse;", "kaKaoData", "Lcom/example/namo/Data/Login/KaKaoData;", "naverlogin", "Lcom/example/namo/Data/Login/NaverResponse;", "naverData", "Lcom/example/namo/Data/Login/NaverData;", "tokenReissuance", "Lcom/example/namo/Data/Login/ReissuanceResponse;", "reissuance", "Lcom/example/namo/Data/Login/Reissuance;", "app_debug"})
public abstract interface LoginRetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/auth/kakao/signup")
    public abstract retrofit2.Call<com.example.namo.Data.Login.KakaoResponse> kakaologin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Login.KaKaoData kaKaoData);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/auth/naver/signup")
    public abstract retrofit2.Call<com.example.namo.Data.Login.NaverResponse> naverlogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Login.NaverData naverData);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/auth/reissuance")
    public abstract retrofit2.Call<com.example.namo.Data.Login.ReissuanceResponse> tokenReissuance(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.namo.Data.Login.Reissuance reissuance);
}