package com.example.namo.Bottom.Group.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002hiBg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u0014J\b\u0010U\u001a\u00020\bH\u0016J\u0018\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\nH\u0002J\u0018\u0010Y\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\nH\u0002J\u0018\u0010Z\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\nH\u0002J\u0018\u0010[\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00122\u0006\u0010X\u001a\u00020\nH\u0002J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u0012H\u0002J\u001c\u0010]\u001a\u00020R2\n\u0010^\u001a\u00060\u0002R\u00020\u00002\u0006\u0010_\u001a\u00020\bH\u0016J\u001c\u0010`\u001a\u00060\u0002R\u00020\u00002\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\bH\u0016J$\u0010d\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u00122\n\u0010^\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\bH\u0002J$\u0010e\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u00122\n\u0010^\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\bH\u0002J$\u0010f\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u00122\n\u0010^\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\bH\u0003J$\u0010g\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u00122\n\u0010^\u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\bH\u0002R\u0016\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R \u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u001a\u0010D\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010#R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010#R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010*R\u001a\u0010J\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010#R\u001a\u0010N\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%\u00a8\u0006j"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$GroupCalendarItemHolder;", "context", "Landroid/content/Context;", "groupCalendarLayout", "Landroid/widget/LinearLayout;", "pageIndex", "", "date", "Ljava/util/Date;", "dateList", "Ljava/util/ArrayList;", "prevTail", "nextHead", "paletteEvent", "Lcom/example/namo/Data/Group/MemberSchedule;", "moimEvent", "Lcom/example/namo/Data/Group/ScheduleRes;", "moimColor", "", "(Landroid/content/Context;Landroid/widget/LinearLayout;ILjava/util/Date;Ljava/util/ArrayList;IILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "TAG", "kotlin.jvm.PlatformType", "after", "", "getAfter", "()Z", "setAfter", "(Z)V", "before", "getBefore", "setBefore", "color", "getColor", "()I", "setColor", "(I)V", "getContext", "()Landroid/content/Context;", "dataList", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getDate", "()Ljava/util/Date;", "firstIndex", "getFirstIndex", "setFirstIndex", "getGroupCalendarLayout", "()Landroid/widget/LinearLayout;", "isFirstMonth", "setFirstMonth", "isLastMonth", "setLastMonth", "itemClick", "Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$ItemClick;", "getItemClick", "()Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$ItemClick;", "setItemClick", "(Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$ItemClick;)V", "lastIndex", "getLastIndex", "setLastIndex", "getMoimColor", "()Ljava/lang/String;", "getMoimEvent", "month", "getMonth", "setMonth", "getNextHead", "getPageIndex", "getPaletteEvent", "pos", "getPos", "setPos", "getPrevTail", "year", "getYear", "setYear", "changeDays", "", "findColor", "inputColor", "getItemCount", "isBetweenStartEnd", "event", "day", "isSameAsEnd", "isSameAsStart", "isSameDay", "isSameStartEnd", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showingBetween", "showingEnd", "showingSame", "showingStart", "GroupCalendarItemHolder", "ItemClick", "app_debug"})
public final class GroupCalendarAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.LinearLayout groupCalendarLayout = null;
    private final int pageIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date date = null;
    private final int prevTail = 0;
    private final int nextHead = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.namo.Data.Group.MemberSchedule> paletteEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> moimEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String moimColor = null;
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> dataList;
    @org.jetbrains.annotations.Nullable()
    private com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.ItemClick itemClick;
    private boolean isFirstMonth = false;
    private boolean isLastMonth = false;
    private boolean before = false;
    private boolean after = false;
    private int year = 0;
    private int month = 0;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private int pos = 0;
    private int color = com.example.namo.R.color.MainOrange;
    
    public GroupCalendarAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout groupCalendarLayout, int pageIndex, @org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> dateList, int prevTail, int nextHead, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.MemberSchedule> paletteEvent, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> moimEvent, @org.jetbrains.annotations.NotNull()
    java.lang.String moimColor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.LinearLayout getGroupCalendarLayout() {
        return null;
    }
    
    public final int getPageIndex() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getDate() {
        return null;
    }
    
    public final int getPrevTail() {
        return 0;
    }
    
    public final int getNextHead() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.namo.Data.Group.MemberSchedule> getPaletteEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.namo.Data.Group.ScheduleRes> getMoimEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMoimColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getDataList() {
        return null;
    }
    
    public final void setDataList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.ItemClick getItemClick() {
        return null;
    }
    
    public final void setItemClick(@org.jetbrains.annotations.Nullable()
    com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.ItemClick p0) {
    }
    
    public final boolean isFirstMonth() {
        return false;
    }
    
    public final void setFirstMonth(boolean p0) {
    }
    
    public final boolean isLastMonth() {
        return false;
    }
    
    public final void setLastMonth(boolean p0) {
    }
    
    public final boolean getBefore() {
        return false;
    }
    
    public final void setBefore(boolean p0) {
    }
    
    public final boolean getAfter() {
        return false;
    }
    
    public final void setAfter(boolean p0) {
    }
    
    public final int getYear() {
        return 0;
    }
    
    public final void setYear(int p0) {
    }
    
    public final int getMonth() {
        return 0;
    }
    
    public final void setMonth(int p0) {
    }
    
    public final int getFirstIndex() {
        return 0;
    }
    
    public final void setFirstIndex(int p0) {
    }
    
    public final int getLastIndex() {
        return 0;
    }
    
    public final void setLastIndex(int p0) {
    }
    
    public final int getPos() {
        return 0;
    }
    
    public final void setPos(int p0) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void findColor(@org.jetbrains.annotations.NotNull()
    java.lang.String inputColor) {
    }
    
    public final void changeDays() {
    }
    
    private final boolean isSameStartEnd(com.example.namo.Data.Group.ScheduleRes event) {
        return false;
    }
    
    private final boolean isSameDay(com.example.namo.Data.Group.ScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isSameAsStart(com.example.namo.Data.Group.ScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isSameAsEnd(com.example.namo.Data.Group.ScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isBetweenStartEnd(com.example.namo.Data.Group.ScheduleRes event, java.util.Date day) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"ResourceType"})
    private final int showingSame(com.example.namo.Data.Group.ScheduleRes event, com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingStart(com.example.namo.Data.Group.ScheduleRes event, com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingBetween(com.example.namo.Data.Group.ScheduleRes event, com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingEnd(com.example.namo.Data.Group.ScheduleRes event, com.example.namo.Bottom.Group.Adapter.GroupCalendarAdapter.GroupCalendarItemHolder holder, int color) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$ItemClick;", "", "onClick", "", "view", "Landroid/view/View;", "year", "", "month", "date", "first", "last", "position", "app_debug"})
    public static abstract interface ItemClick {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int year, int month, int date, int first, int last, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter$GroupCalendarItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/namo/Bottom/Group/Adapter/GroupCalendarAdapter;Landroid/view/View;)V", "itemCalendarDateText", "Landroid/widget/TextView;", "getItemCalendarDateText", "()Landroid/widget/TextView;", "setItemCalendarDateText", "(Landroid/widget/TextView;)V", "bind", "", "data", "", "position", "context", "Landroid/content/Context;", "eventShow", "app_debug"})
    public final class GroupCalendarItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemCalendarDateText;
        
        public GroupCalendarItemHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getItemCalendarDateText() {
            return null;
        }
        
        public final void setItemCalendarDateText(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        public final void bind(int data, int position, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void eventShow(int data, int position) {
        }
    }
}