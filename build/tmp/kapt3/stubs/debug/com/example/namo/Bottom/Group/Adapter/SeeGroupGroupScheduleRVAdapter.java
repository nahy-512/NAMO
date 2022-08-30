package com.example.namo.Bottom.Group.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003%&\'B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\rH\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0016J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0015R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$ViewHolder;", "context", "Landroid/content/Context;", "schedule", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/ScheduleRes;", "Lkotlin/collections/ArrayList;", "moimColor", "", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "mItemClickListener", "Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$GroupItemClickListener;", "nItemClickListener", "Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$GroupMemoClickListener;", "findColor", "", "inputColor", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "setsMyItemClickListener", "itemsClickListener", "GroupItemClickListener", "GroupMemoClickListener", "ViewHolder", "app_debug"})
public final class SeeGroupGroupScheduleRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> schedule = null;
    private final java.lang.String moimColor = null;
    private int color = com.example.namo.R.color.MainOrange;
    private com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.GroupItemClickListener mItemClickListener;
    private com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.GroupMemoClickListener nItemClickListener;
    
    public SeeGroupGroupScheduleRVAdapter(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> schedule, @org.jetbrains.annotations.NotNull()
    java.lang.String moimColor) {
        super();
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.GroupItemClickListener itemClickListener) {
    }
    
    public final void setsMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.GroupMemoClickListener itemsClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.SeeGroupGroupScheduleRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void findColor(@org.jetbrains.annotations.NotNull()
    java.lang.String inputColor) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$GroupItemClickListener;", "", "onItemClick", "", "schedule", "Lcom/example/namo/Data/Group/ScheduleRes;", "app_debug"})
    public static abstract interface GroupItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Group.ScheduleRes schedule);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$GroupMemoClickListener;", "", "onItemsClick", "", "schedule", "Lcom/example/namo/Data/Group/ScheduleRes;", "position", "", "app_debug"})
    public static abstract interface GroupMemoClickListener {
        
        public abstract void onItemsClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Group.ScheduleRes schedule, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemScheduleListBinding;", "(Lcom/example/namo/Bottom/Group/Adapter/SeeGroupGroupScheduleRVAdapter;Lcom/example/namo/databinding/ItemScheduleListBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemScheduleListBinding;", "bind", "", "scheduleList", "Lcom/example/namo/Data/Group/ScheduleRes;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.namo.databinding.ItemScheduleListBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.namo.databinding.ItemScheduleListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.namo.databinding.ItemScheduleListBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Group.ScheduleRes scheduleList) {
        }
    }
}