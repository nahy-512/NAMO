package com.example.namo.Floating.Category.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter$ViewHolder;", "todoCate", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Category/TodoCategory;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "gson", "Lcom/google/gson/Gson;", "mItemClickListener", "Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter$MyItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setsMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class TodoCateRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Floating.Category.Adapter.TodoCateRVAdapter.ViewHolder> {
    private final java.util.ArrayList<com.example.namo.Data.Category.TodoCategory> todoCate = null;
    private com.google.gson.Gson gson;
    private com.example.namo.Floating.Category.Adapter.TodoCateRVAdapter.MyItemClickListener mItemClickListener;
    
    public TodoCateRVAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Category.TodoCategory> todoCate) {
        super();
    }
    
    public final void setsMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Floating.Category.Adapter.TodoCateRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Floating.Category.Adapter.TodoCateRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Floating.Category.Adapter.TodoCateRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter$MyItemClickListener;", "", "onShowCategorytab", "", "todoCategory", "Lcom/example/namo/Data/Category/TodoCategory;", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onShowCategorytab(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Category.TodoCategory todoCategory);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemFloatingCategoryBinding;", "(Lcom/example/namo/Floating/Category/Adapter/TodoCateRVAdapter;Lcom/example/namo/databinding/ItemFloatingCategoryBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemFloatingCategoryBinding;", "bind", "", "todoCategory", "Lcom/example/namo/Data/Category/TodoCategory;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.namo.databinding.ItemFloatingCategoryBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.namo.databinding.ItemFloatingCategoryBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.namo.databinding.ItemFloatingCategoryBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Category.TodoCategory todoCategory) {
        }
    }
}