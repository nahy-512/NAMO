package com.example.namo.Bottom.Diary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001a\u001b\u001cB\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0017J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$ViewHolder;", "items", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Schedule/Memo/MonthMemoDto;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "diaryItemClickListeners", "Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$DiaryItemClickListener;", "groupItemClickListeners", "Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$GroupItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setItemsClickListener", "diaryItemClickListener", "setItemssClickListener", "groupItemClickListener", "DiaryItemClickListener", "GroupItemClickListener", "ViewHolder", "app_debug"})
public final class DiaryListRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Diary.DiaryListRVAdapter.ViewHolder> {
    private java.util.ArrayList<com.example.namo.Data.Schedule.Memo.MonthMemoDto> items;
    private com.example.namo.Bottom.Diary.DiaryListRVAdapter.DiaryItemClickListener diaryItemClickListeners;
    private com.example.namo.Bottom.Diary.DiaryListRVAdapter.GroupItemClickListener groupItemClickListeners;
    
    public DiaryListRVAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Schedule.Memo.MonthMemoDto> items) {
        super();
    }
    
    public final void setItemsClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Diary.DiaryListRVAdapter.DiaryItemClickListener diaryItemClickListener) {
    }
    
    public final void setItemssClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Diary.DiaryListRVAdapter.GroupItemClickListener groupItemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Diary.DiaryListRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Diary.DiaryListRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$DiaryItemClickListener;", "", "onDiaryClick", "", "monthMemoDto", "Lcom/example/namo/Data/Schedule/Memo/MonthMemoDto;", "app_debug"})
    public static abstract interface DiaryItemClickListener {
        
        public abstract void onDiaryClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.Memo.MonthMemoDto monthMemoDto);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$GroupItemClickListener;", "", "onGroupClick", "", "monthMemoDto", "Lcom/example/namo/Data/Schedule/Memo/MonthMemoDto;", "app_debug"})
    public static abstract interface GroupItemClickListener {
        
        public abstract void onGroupClick(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.Memo.MonthMemoDto monthMemoDto);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemDiaryListBinding;", "(Lcom/example/namo/Bottom/Diary/DiaryListRVAdapter;Lcom/example/namo/databinding/ItemDiaryListBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemDiaryListBinding;", "view", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getView", "()Landroid/content/Context;", "setView", "(Landroid/content/Context;)V", "bind", "", "data", "Lcom/example/namo/Data/Schedule/Memo/MonthMemoDto;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.namo.databinding.ItemDiaryListBinding binding = null;
        private android.content.Context view;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.namo.databinding.ItemDiaryListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.namo.databinding.ItemDiaryListBinding getBinding() {
            return null;
        }
        
        public final android.content.Context getView() {
            return null;
        }
        
        public final void setView(android.content.Context p0) {
        }
        
        @android.annotation.SuppressLint(value = {"ResourceType"})
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Schedule.Memo.MonthMemoDto data) {
        }
    }
}