package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\u00132\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0016J(\u0010\'\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Data/Group/GroupFragView;", "()V", "access", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "binding", "Lcom/example/namo/databinding/FragmentGroupBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentGroupBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentGroupBinding;)V", "gson", "Lcom/google/gson/Gson;", "getGroupList", "", "getToken", "initRecyclerView", "result", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/GroupListResult;", "Lkotlin/collections/ArrayList;", "onClickMenu", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGetGroupFailure", "code", "", "message", "onGetGroupListSuccess", "onResume", "onStart", "app_debug"})
public final class GroupFragment extends androidx.fragment.app.Fragment implements com.example.namo.Data.Group.GroupFragView {
    public com.example.namo.databinding.FragmentGroupBinding binding;
    private com.google.gson.Gson gson;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String access = "";
    private java.util.HashMap _$_findViewCache;
    
    public GroupFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentGroupBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentGroupBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccess() {
        return null;
    }
    
    public final void setAccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void initRecyclerView(java.util.ArrayList<com.example.namo.Data.Group.GroupListResult> result) {
    }
    
    private final void getGroupList() {
    }
    
    @java.lang.Override()
    public void onGetGroupListSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.GroupListResult> result) {
    }
    
    @java.lang.Override()
    public void onGetGroupFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void onClickMenu() {
    }
    
    private final void getToken() {
    }
}