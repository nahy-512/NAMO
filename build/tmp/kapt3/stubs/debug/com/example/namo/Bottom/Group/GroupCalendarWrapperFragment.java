package com.example.namo.Bottom.Group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u00018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020#H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020)H\u0016J\u001a\u00106\u001a\u00020)2\u0006\u00107\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00069"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupCalendarWrapperFragment;", "Landroidx/fragment/app/Fragment;", "group", "Lcom/example/namo/Data/Group/GroupListResult;", "(Lcom/example/namo/Data/Group/GroupListResult;)V", "TAG", "", "kotlin.jvm.PlatformType", "binding", "Lcom/example/namo/databinding/FragmentGroupCalendarWrapperBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentGroupCalendarWrapperBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentGroupCalendarWrapperBinding;)V", "getGroup", "()Lcom/example/namo/Data/Group/GroupListResult;", "groupCalendarMore", "Landroid/widget/ImageView;", "getGroupCalendarMore", "()Landroid/widget/ImageView;", "setGroupCalendarMore", "(Landroid/widget/ImageView;)V", "groupCalendarTitle", "Landroid/widget/TextView;", "getGroupCalendarTitle", "()Landroid/widget/TextView;", "setGroupCalendarTitle", "(Landroid/widget/TextView;)V", "groupCalendarViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getGroupCalendarViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "setGroupCalendarViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "initView", "", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", "view", "Companion", "app_debug"})
public final class GroupCalendarWrapperFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.example.namo.Data.Group.GroupListResult group = null;
    private final java.lang.String TAG = null;
    public android.content.Context mContext;
    public androidx.viewpager2.widget.ViewPager2 groupCalendarViewPager;
    public android.widget.TextView groupCalendarTitle;
    public android.widget.ImageView groupCalendarMore;
    public com.example.namo.databinding.FragmentGroupCalendarWrapperBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Bottom.Group.GroupCalendarWrapperFragment.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.example.namo.Bottom.Group.GroupCalendarWrapperFragment instance;
    private java.util.HashMap _$_findViewCache;
    
    public GroupCalendarWrapperFragment(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Group.GroupListResult group) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Group.GroupListResult getGroup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.viewpager2.widget.ViewPager2 getGroupCalendarViewPager() {
        return null;
    }
    
    public final void setGroupCalendarViewPager(@org.jetbrains.annotations.NotNull()
    androidx.viewpager2.widget.ViewPager2 p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getGroupCalendarTitle() {
        return null;
    }
    
    public final void setGroupCalendarTitle(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getGroupCalendarMore() {
        return null;
    }
    
    public final void setGroupCalendarMore(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentGroupCalendarWrapperBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentGroupCalendarWrapperBinding p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/namo/Bottom/Group/GroupCalendarWrapperFragment$Companion;", "", "()V", "instance", "Lcom/example/namo/Bottom/Group/GroupCalendarWrapperFragment;", "getInstance", "()Lcom/example/namo/Bottom/Group/GroupCalendarWrapperFragment;", "setInstance", "(Lcom/example/namo/Bottom/Group/GroupCalendarWrapperFragment;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.namo.Bottom.Group.GroupCalendarWrapperFragment getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.example.namo.Bottom.Group.GroupCalendarWrapperFragment p0) {
        }
    }
}