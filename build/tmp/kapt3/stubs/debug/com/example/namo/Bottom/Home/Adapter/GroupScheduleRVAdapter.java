package com.example.namo.Bottom.Home.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter$ViewHolder;", "context", "Landroid/content/Context;", "groupScheduleList", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "mItemClickListener", "Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter$GroupDayItemClickListener;", "findColor", "", "inputColor", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "GroupDayItemClickListener", "ViewHolder", "app_debug"})
public final class GroupScheduleRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.example.namo.Data.Schedule.GetScheduleRes> groupScheduleList = null;
    private com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter.GroupDayItemClickListener mItemClickListener;
    private int color = com.example.namo.R.color.MainOrange;
    
    public GroupScheduleRVAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Schedule.GetScheduleRes> groupScheduleList) {
        super();
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter.GroupDayItemClickListener itemClickListener) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.GroupScheduleRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void findColor(@org.jetbrains.annotations.NotNull()
    java.lang.String inputColor) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter$GroupDayItemClickListener;", "", "onItemClick", "", "schedule", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "position", "", "app_debug"})
    public static abstract interface GroupDayItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.GetScheduleRes schedule, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemScheduleListBinding;", "(Lcom/example/namo/Bottom/Home/Adapter/GroupScheduleRVAdapter;Lcom/example/namo/databinding/ItemScheduleListBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemScheduleListBinding;", "bind", "", "group", "Lcom/example/namo/Data/Schedule/GetScheduleRes;", "app_debug"})
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
        com.example.namo.Data.Schedule.GetScheduleRes group) {
        }
    }
}