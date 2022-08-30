package com.example.namo.Data.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/example/namo/Data/Group/GroupView;", "", "onCreateGroupSuccess", "", "code", "", "result", "Lcom/example/namo/Data/Group/CreateGroupResult;", "onEditGroupSuccess", "", "onGetGroupFailure", "message", "app_debug"})
public abstract interface GroupView {
    
    public abstract void onCreateGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.CreateGroupResult result);
    
    public abstract void onEditGroupSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result);
    
    public abstract void onGetGroupFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}