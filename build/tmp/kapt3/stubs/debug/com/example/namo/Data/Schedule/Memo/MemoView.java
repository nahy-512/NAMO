package com.example.namo.Data.Schedule.Memo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/example/namo/Data/Schedule/Memo/MemoView;", "", "onEditMemoSuccess", "", "code", "", "result", "", "onInputMemoSuccess", "app_debug"})
public abstract interface MemoView {
    
    public abstract void onInputMemoSuccess(int code, int result);
    
    public abstract void onEditMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
}