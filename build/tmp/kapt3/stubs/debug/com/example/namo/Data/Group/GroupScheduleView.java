package com.example.namo.Data.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/namo/Data/Group/GroupScheduleView;", "", "onGetGroupScheduleSuccess", "", "code", "", "result", "Lcom/example/namo/Data/Group/GetMoimScheduleRes;", "onInputGroupScheduleSuccess", "Lcom/example/namo/Data/Group/GroupScheduleResult;", "app_debug"})
public abstract interface GroupScheduleView {
    
    public abstract void onInputGroupScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.GroupScheduleResult result);
    
    public abstract void onGetGroupScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.GetMoimScheduleRes result);
}