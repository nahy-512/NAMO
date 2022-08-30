package com.example.namo.Data.Schedule.Memo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/example/namo/Data/Schedule/Memo/GetAllMemoView;", "", "onGetAllMemoSuccess", "", "code", "", "result", "", "Lcom/example/namo/Data/Schedule/Memo/MonthMemoDto;", "app_debug"})
public abstract interface GetAllMemoView {
    
    public abstract void onGetAllMemoSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Schedule.Memo.MonthMemoDto> result);
}