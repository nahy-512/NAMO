package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\nj\b\u0012\u0004\u0012\u00020\u0016`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00190\nj\b\u0012\u0004\u0012\u00020\u0019`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupPayActivity;", "Landroid/app/Activity;", "()V", "binding", "Lcom/example/namo/databinding/ActivityGroupPayBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityGroupPayBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityGroupPayBinding;)V", "checkedMemberIdx", "Ljava/util/ArrayList;", "", "getCheckedMemberIdx", "()Ljava/util/ArrayList;", "setCheckedMemberIdx", "(Ljava/util/ArrayList;)V", "eachPay", "memberIdx", "Lkotlin/collections/ArrayList;", "memberIsChecked", "", "memberNames", "", "moimIdx", "moimPeople", "Lcom/example/namo/Data/Group/moimAttendences;", "peopleCount", "totalPay", "account", "", "finishActivity", "getGroupInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class GroupPayActivity extends android.app.Activity {
    public com.example.namo.databinding.ActivityGroupPayBinding binding;
    private int peopleCount = 0;
    private int totalPay = 0;
    private int eachPay = 0;
    private int moimIdx = -1;
    private java.util.ArrayList<com.example.namo.Data.Group.moimAttendences> moimPeople;
    private java.util.ArrayList<java.lang.String> memberNames;
    private java.util.ArrayList<java.lang.Integer> memberIdx;
    private java.util.ArrayList<java.lang.Boolean> memberIsChecked;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> checkedMemberIdx;
    private java.util.HashMap _$_findViewCache;
    
    public GroupPayActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityGroupPayBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityGroupPayBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getCheckedMemberIdx() {
        return null;
    }
    
    public final void setCheckedMemberIdx(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getGroupInfo() {
    }
    
    private final void account() {
    }
    
    private final void finishActivity() {
    }
}