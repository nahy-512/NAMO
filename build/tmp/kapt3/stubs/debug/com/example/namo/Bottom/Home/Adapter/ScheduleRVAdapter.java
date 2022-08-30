package com.example.namo.Bottom.Home.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001e\u001f B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u00102\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$ViewHolder;", "context", "Landroid/content/Context;", "schedule", "", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "(Landroid/content/Context;Ljava/util/List;)V", "color", "", "mDayItemClickListener", "Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$DayItemClickListener;", "mItemClickListener", "Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$MyItemClickListener;", "findColor", "", "inputColor", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "setsMyItemClickListener", "DayItemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class ScheduleRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.example.namo.Data.Schedule.GetScheduleRes> schedule = null;
    private com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.DayItemClickListener mDayItemClickListener;
    private com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.MyItemClickListener mItemClickListener;
    private int color = com.example.namo.R.color.MainOrange;
    
    public ScheduleRVAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.namo.Data.Schedule.GetScheduleRes> schedule) {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.DayItemClickListener itemClickListener) {
    }
    
    public final void setsMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.ScheduleRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void findColor(@org.jetbrains.annotations.NotNull()
    java.lang.String inputColor) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$DayItemClickListener;", "", "onItemClick", "", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "app_debug"})
    public static abstract interface DayItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.GetScheduleRes schedule);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$MyItemClickListener;", "", "onItemsClick", "", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "position", "", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onItemsClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.GetScheduleRes schedule, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemScheduleListBinding;", "(Lcom/example/namo/Bottom/Home/Adapter/ScheduleRVAdapter;Lcom/example/namo/databinding/ItemScheduleListBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemScheduleListBinding;", "view", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "bind", "", "scheduleList", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.namo.databinding.ItemScheduleListBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.constraintlayout.widget.ConstraintLayout view = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.namo.databinding.ItemScheduleListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.namo.databinding.ItemScheduleListBinding getBinding() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.constraintlayout.widget.ConstraintLayout getView() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.GetScheduleRes scheduleList) {
        }
    }
}