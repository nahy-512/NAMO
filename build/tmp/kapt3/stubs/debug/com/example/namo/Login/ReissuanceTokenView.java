package com.example.namo.Login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/example/namo/Login/ReissuanceTokenView;", "", "onReissuanceFailure", "", "code", "", "message", "", "onReissuanceSuccess", "result", "Lcom/example/namo/Data/Login/ReissuanceResult;", "onResissuanceExpire", "app_debug"})
public abstract interface ReissuanceTokenView {
    
    public abstract void onReissuanceSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.ReissuanceResult result);
    
    public abstract void onResissuanceExpire(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Login.ReissuanceResult result);
    
    public abstract void onReissuanceFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}