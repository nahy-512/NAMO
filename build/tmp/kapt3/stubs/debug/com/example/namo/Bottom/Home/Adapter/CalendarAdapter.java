package com.example.namo.Bottom.Home.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002_`Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\fj\b\u0012\u0004\u0012\u00020\u0011`\r\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010I\u001a\u00020JJ\b\u0010K\u001a\u00020\bH\u0016J\u0018\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\nH\u0002J\u0018\u0010O\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\nH\u0002J\u0018\u0010P\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\nH\u0002J\u0018\u0010Q\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\nH\u0002J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u0011H\u0002J\u001c\u0010S\u001a\u00020J2\n\u0010T\u001a\u00060\u0002R\u00020\u00002\u0006\u0010U\u001a\u00020\bH\u0016J\u001c\u0010V\u001a\u00060\u0002R\u00020\u00002\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\bH\u0016J$\u0010Z\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00112\n\u0010T\u001a\u00060\u0002R\u00020\u00002\u0006\u0010[\u001a\u00020\bH\u0002J$\u0010\\\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00112\n\u0010T\u001a\u00060\u0002R\u00020\u00002\u0006\u0010[\u001a\u00020\bH\u0002J$\u0010]\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00112\n\u0010T\u001a\u00060\u0002R\u00020\u00002\u0006\u0010[\u001a\u00020\bH\u0003J$\u0010^\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u00112\n\u0010T\u001a\u00060\u0002R\u00020\u00002\u0006\u0010[\u001a\u00020\bH\u0002R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001a\u00101\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\u001a\u0010<\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\fj\b\u0012\u0004\u0012\u00020\u0011`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u001a\u0010B\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010,\"\u0004\bD\u0010.R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u001a\u0010F\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.\u00a8\u0006a"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$CalendarItemHolder;", "context", "Landroid/content/Context;", "calendarLayout", "Landroid/widget/LinearLayout;", "pageIndex", "", "date", "Ljava/util/Date;", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "prevTail", "nextHead", "monthEvent", "Lcom/example/namo/Data/Schedule/GetMonthScheduleRes;", "(Landroid/content/Context;Landroid/widget/LinearLayout;ILjava/util/Date;Ljava/util/ArrayList;IILjava/util/ArrayList;)V", "TAG", "", "kotlin.jvm.PlatformType", "after", "", "getAfter", "()Z", "setAfter", "(Z)V", "before", "getBefore", "setBefore", "getCalendarLayout", "()Landroid/widget/LinearLayout;", "getContext", "()Landroid/content/Context;", "dataList", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getDate", "()Ljava/util/Date;", "firstIndex", "getFirstIndex", "()I", "setFirstIndex", "(I)V", "isFirstMonth", "setFirstMonth", "isLastMonth", "setLastMonth", "itemClick", "Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$ItemClick;", "getItemClick", "()Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$ItemClick;", "setItemClick", "(Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$ItemClick;)V", "lastIndex", "getLastIndex", "setLastIndex", "month", "getMonth", "setMonth", "getMonthEvent", "getNextHead", "getPageIndex", "pos", "getPos", "setPos", "getPrevTail", "year", "getYear", "setYear", "changeDays", "", "getItemCount", "isBetweenStartEnd", "event", "day", "isSameAsEnd", "isSameAsStart", "isSameDay", "isSameStartEnd", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showingBetween", "color", "showingEnd", "showingSame", "showingStart", "CalendarItemHolder", "ItemClick", "app_debug"})
public final class CalendarAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.LinearLayout calendarLayout = null;
    private final int pageIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date date = null;
    private final int prevTail = 0;
    private final int nextHead = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.namo.Data.Schedule.GetMonthScheduleRes> monthEvent = null;
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> dataList;
    @org.jetbrains.annotations.Nullable()
    private com.example.namo.Bottom.Home.Adapter.CalendarAdapter.ItemClick itemClick;
    private boolean isFirstMonth = false;
    private boolean isLastMonth = false;
    private boolean before = false;
    private boolean after = false;
    private int year = 0;
    private int month = 0;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private int pos = 0;
    
    public CalendarAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout calendarLayout, int pageIndex, @org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> dateList, int prevTail, int nextHead, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.namo.Data.Schedule.GetMonthScheduleRes> monthEvent) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.LinearLayout getCalendarLayout() {
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
    public final java.util.ArrayList<com.example.namo.Data.Schedule.GetMonthScheduleRes> getMonthEvent() {
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
    public final com.example.namo.Bottom.Home.Adapter.CalendarAdapter.ItemClick getItemClick() {
        return null;
    }
    
    public final void setItemClick(@org.jetbrains.annotations.Nullable()
    com.example.namo.Bottom.Home.Adapter.CalendarAdapter.ItemClick p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void changeDays() {
    }
    
    private final boolean isSameStartEnd(com.example.namo.Data.Schedule.GetMonthScheduleRes event) {
        return false;
    }
    
    private final boolean isSameDay(com.example.namo.Data.Schedule.GetMonthScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isSameAsStart(com.example.namo.Data.Schedule.GetMonthScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isSameAsEnd(com.example.namo.Data.Schedule.GetMonthScheduleRes event, java.util.Date day) {
        return false;
    }
    
    private final boolean isBetweenStartEnd(com.example.namo.Data.Schedule.GetMonthScheduleRes event, java.util.Date day) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"ResourceType"})
    private final int showingSame(com.example.namo.Data.Schedule.GetMonthScheduleRes event, com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingStart(com.example.namo.Data.Schedule.GetMonthScheduleRes event, com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingBetween(com.example.namo.Data.Schedule.GetMonthScheduleRes event, com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder holder, int color) {
        return 0;
    }
    
    private final int showingEnd(com.example.namo.Data.Schedule.GetMonthScheduleRes event, com.example.namo.Bottom.Home.Adapter.CalendarAdapter.CalendarItemHolder holder, int color) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$ItemClick;", "", "onClick", "", "view", "Landroid/view/View;", "year", "", "month", "date", "first", "last", "position", "app_debug"})
    public static abstract interface ItemClick {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int year, int month, int date, int first, int last, int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter$CalendarItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/namo/Bottom/Home/Adapter/CalendarAdapter;Landroid/view/View;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "itemCalendarDateText", "Landroid/widget/TextView;", "getItemCalendarDateText", "()Landroid/widget/TextView;", "setItemCalendarDateText", "(Landroid/widget/TextView;)V", "bind", "", "data", "position", "context", "Landroid/content/Context;", "eventShow", "app_debug"})
    public final class CalendarItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView itemCalendarDateText;
        private int color = com.example.namo.R.color.MainOrange;
        
        public CalendarItemHolder(@org.jetbrains.annotations.Nullable()
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
        
        public final int getColor() {
            return 0;
        }
        
        public final void setColor(int p0) {
        }
        
        public final void bind(int data, int position, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void eventShow(int data, int position) {
        }
    }
}