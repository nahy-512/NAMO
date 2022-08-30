package com.example.namo.Bottom.Group.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B5\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter$ViewHolder;", "peopleList", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/moimAttendences;", "Lkotlin/collections/ArrayList;", "memberIsChecked", "", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "mItemClickListener", "Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter$PeopleItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPeopleItemClickListener", "itemClickListener", "PeopleItemClickListener", "ViewHolder", "app_debug"})
public final class GroupPayActivityRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter.ViewHolder> {
    private java.util.ArrayList<com.example.namo.Data.Group.moimAttendences> peopleList;
    private java.util.ArrayList<java.lang.Boolean> memberIsChecked;
    private com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter.PeopleItemClickListener mItemClickListener;
    
    public GroupPayActivityRVAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.moimAttendences> peopleList, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Boolean> memberIsChecked) {
        super();
    }
    
    public final void setPeopleItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter.PeopleItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.GroupPayActivityRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter$PeopleItemClickListener;", "", "onItemClick", "", "peopleList", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Group/moimAttendences;", "Lkotlin/collections/ArrayList;", "memberIsChecked", "", "app_debug"})
    public static abstract interface PeopleItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.example.namo.Data.Group.moimAttendences> peopleList, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.Boolean> memberIsChecked);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/namo/databinding/ItemGroupPayActivityBinding;", "(Lcom/example/namo/Bottom/Group/Adapter/GroupPayActivityRVAdapter;Lcom/example/namo/databinding/ItemGroupPayActivityBinding;)V", "getBinding", "()Lcom/example/namo/databinding/ItemGroupPayActivityBinding;", "bind", "", "attendences", "Lcom/example/namo/Data/Group/moimAttendences;", "isChecked", "", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.namo.databinding.ItemGroupPayActivityBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.namo.databinding.ItemGroupPayActivityBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.namo.databinding.ItemGroupPayActivityBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.namo.Data.Group.moimAttendences attendences, boolean isChecked) {
        }
    }
}