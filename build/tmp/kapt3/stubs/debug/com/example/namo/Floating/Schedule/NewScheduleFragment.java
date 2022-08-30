package com.example.namo.Floating.Schedule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0002\u0095\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010g\u001a\u00020hH\u0002J\b\u0010i\u001a\u00020hH\u0002J\b\u0010j\u001a\u00020hH\u0002J\b\u0010k\u001a\u00020hH\u0002J\b\u0010l\u001a\u00020hH\u0002J\b\u0010m\u001a\u00020hH\u0002J\b\u0010n\u001a\u00020hH\u0002J\b\u0010o\u001a\u00020hH\u0002J\b\u0010p\u001a\u00020hH\u0002J\b\u0010q\u001a\u00020hH\u0002J\b\u0010r\u001a\u00020hH\u0002J\b\u0010s\u001a\u00020hH\u0002J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\"\u0010v\u001a\u00020h2\u0006\u0010w\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020\u000e2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010{\u001a\u00020h2\u0006\u0010|\u001a\u00020\u0012H\u0016J+\u0010}\u001a\u0004\u0018\u00010~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\u001b\u0010\u0085\u0001\u001a\u00020h2\u0007\u0010\u0086\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020\u0005H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020h2\u0007\u0010\u0086\u0001\u001a\u00020\u000e2\u0007\u0010\u0087\u0001\u001a\u00020\u0005H\u0016J\u001c\u0010\u0089\u0001\u001a\u00020h2\u0007\u0010\u0086\u0001\u001a\u00020\u000e2\b\u0010\u0087\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010\u008b\u0001\u001a\u00020hH\u0016J\t\u0010\u008c\u0001\u001a\u00020hH\u0016J\t\u0010\u008d\u0001\u001a\u00020hH\u0002J\t\u0010\u008e\u0001\u001a\u00020hH\u0002J\t\u0010\u008f\u0001\u001a\u00020hH\u0002J\t\u0010\u0090\u0001\u001a\u00020hH\u0002J\t\u0010\u0091\u0001\u001a\u00020hH\u0002J\t\u0010\u0092\u0001\u001a\u00020hH\u0002J\t\u0010\u0093\u0001\u001a\u00020hH\u0002J\t\u0010\u0094\u0001\u001a\u00020hH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR\u001a\u0010M\u001a\u00020@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010B\"\u0004\bO\u0010DR\u001a\u0010P\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010G\"\u0004\bR\u0010IR\u001a\u0010S\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010G\"\u0004\bU\u0010IR\u0016\u0010V\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010[\u001a\n \u0019*\u0004\u0018\u00010\u001f0\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020^X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/example/namo/Floating/Schedule/NewScheduleFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/namo/Bottom/Home/HomeView;", "()V", "access", "", "alert", "binding", "Lcom/example/namo/databinding/FragmentNewScheduleBinding;", "getBinding", "()Lcom/example/namo/databinding/FragmentNewScheduleBinding;", "setBinding", "(Lcom/example/namo/databinding/FragmentNewScheduleBinding;)V", "categoryColor", "", "categoryIdx", "categoryName", "contextActivity", "Landroid/content/Context;", "getContextActivity", "()Landroid/content/Context;", "setContextActivity", "(Landroid/content/Context;)V", "dateFormatter", "Lorg/threeten/bp/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "endDate", "endDay", "endLocalDate", "Lorg/threeten/bp/LocalDate;", "endLocalTime", "Lorg/threeten/bp/LocalTime;", "endTime", "id", "isDateOpen", "", "isDateWasOpen", "isEndTimeOpen", "isStartDate", "isStartTimeOpen", "location", "locationX", "locationY", "mapView", "Lnet/daum/mf/map/api/MapView;", "getMapView", "()Lnet/daum/mf/map/api/MapView;", "setMapView", "(Lnet/daum/mf/map/api/MapView;)V", "mapViewContainer", "Landroid/widget/RelativeLayout;", "getMapViewContainer", "()Landroid/widget/RelativeLayout;", "setMapViewContainer", "(Landroid/widget/RelativeLayout;)V", "name", "place", "schedule", "Lcom/example/namo/Data/Schedule/Schedule;", "getSchedule", "()Lcom/example/namo/Data/Schedule/Schedule;", "setSchedule", "(Lcom/example/namo/Data/Schedule/Schedule;)V", "selectEndDay", "Ljava/util/Calendar;", "getSelectEndDay", "()Ljava/util/Calendar;", "setSelectEndDay", "(Ljava/util/Calendar;)V", "selectEndHour", "getSelectEndHour", "()I", "setSelectEndHour", "(I)V", "selectEndMin", "getSelectEndMin", "setSelectEndMin", "selectStartDay", "getSelectStartDay", "setSelectStartDay", "selectStartHour", "getSelectStartHour", "setSelectStartHour", "selectStartMin", "getSelectStartMin", "setSelectStartMin", "sendDateFormatter", "sendTimeFormatter", "startDate", "startDay", "startLocalDate", "startLocalTime", "startTime", "tempSchedule", "Lcom/example/namo/Data/Schedule/TempSchedule;", "getTempSchedule", "()Lcom/example/namo/Data/Schedule/TempSchedule;", "setTempSchedule", "(Lcom/example/namo/Data/Schedule/TempSchedule;)V", "timeFormatter", "x", "", "y", "clickEvent", "", "datePicker", "editText", "endDateData", "endTimeData", "endTimePicker", "finishActivity", "getScheduleData", "getSendDate", "getToken", "initMapView", "initText", "initTime", "loadPref", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteScheduleSuccess", "code", "result", "onEditScheduleSuccess", "onInputScheduleSuccess", "Lcom/example/namo/Data/Schedule/ScheduleResult;", "onResume", "onStop", "putPref", "setAlert", "setDataFromTempSchedule", "showingMapContent", "startDateData", "startTimeData", "startTimePicker", "storeTemp", "Companion", "app_debug"})
public final class NewScheduleFragment extends androidx.fragment.app.Fragment implements com.example.namo.Bottom.Home.HomeView {
    public android.content.Context contextActivity;
    public com.example.namo.databinding.FragmentNewScheduleBinding binding;
    private boolean isDateOpen = false;
    private boolean isStartTimeOpen = false;
    private boolean isEndTimeOpen = false;
    private boolean isStartDate = true;
    private boolean isDateWasOpen = false;
    public com.example.namo.Data.Schedule.Schedule schedule;
    private java.lang.String access = "";
    private java.lang.String categoryName = "";
    private int categoryColor;
    private java.lang.String name = "";
    private java.lang.String startDate = "";
    private java.lang.String endDate = "";
    private java.lang.String location = "";
    private java.lang.String locationX = "";
    private java.lang.String locationY = "";
    private int categoryIdx = 103;
    private org.threeten.bp.LocalDate startLocalDate;
    private org.threeten.bp.LocalDate endLocalDate;
    private org.threeten.bp.LocalTime startLocalTime;
    private org.threeten.bp.LocalTime endLocalTime;
    private java.lang.String startDay = "";
    private java.lang.String endDay = "";
    private java.lang.String startTime = "";
    private java.lang.String endTime = "";
    private java.lang.String alert;
    private final org.threeten.bp.format.DateTimeFormatter dateFormatter = null;
    private final org.threeten.bp.format.DateTimeFormatter sendDateFormatter = null;
    private final org.threeten.bp.format.DateTimeFormatter timeFormatter = null;
    private final org.threeten.bp.format.DateTimeFormatter sendTimeFormatter = null;
    public net.daum.mf.map.api.MapView mapView;
    @org.jetbrains.annotations.Nullable()
    private android.widget.RelativeLayout mapViewContainer;
    private double x = 0.0;
    private double y = 0.0;
    private java.lang.String id = "";
    private java.lang.String place = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.Calendar selectStartDay;
    @org.jetbrains.annotations.NotNull()
    private java.util.Calendar selectEndDay;
    private int selectStartHour = 0;
    private int selectEndHour = 0;
    private int selectStartMin = 0;
    private int selectEndMin = 0;
    @org.jetbrains.annotations.NotNull()
    private com.example.namo.Data.Schedule.TempSchedule tempSchedule;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Floating.Schedule.NewScheduleFragment.Companion Companion = null;
    private static final java.lang.String KEY_PREFS = "tempSchedule";
    private static final java.lang.String KEY_DATA = "tempData";
    private java.util.HashMap _$_findViewCache;
    
    public NewScheduleFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContextActivity() {
        return null;
    }
    
    public final void setContextActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.FragmentNewScheduleBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.FragmentNewScheduleBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.Schedule getSchedule() {
        return null;
    }
    
    public final void setSchedule(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Schedule p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.daum.mf.map.api.MapView getMapView() {
        return null;
    }
    
    public final void setMapView(@org.jetbrains.annotations.NotNull()
    net.daum.mf.map.api.MapView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.RelativeLayout getMapViewContainer() {
        return null;
    }
    
    public final void setMapViewContainer(@org.jetbrains.annotations.Nullable()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getSelectStartDay() {
        return null;
    }
    
    public final void setSelectStartDay(@org.jetbrains.annotations.NotNull()
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getSelectEndDay() {
        return null;
    }
    
    public final void setSelectEndDay(@org.jetbrains.annotations.NotNull()
    java.util.Calendar p0) {
    }
    
    public final int getSelectStartHour() {
        return 0;
    }
    
    public final void setSelectStartHour(int p0) {
    }
    
    public final int getSelectEndHour() {
        return 0;
    }
    
    public final void setSelectEndHour(int p0) {
    }
    
    public final int getSelectStartMin() {
        return 0;
    }
    
    public final void setSelectStartMin(int p0) {
    }
    
    public final int getSelectEndMin() {
        return 0;
    }
    
    public final void setSelectEndMin(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.Data.Schedule.TempSchedule getTempSchedule() {
        return null;
    }
    
    public final void setTempSchedule(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.TempSchedule p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void clickEvent() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void setDataFromTempSchedule() {
    }
    
    private final void putPref() {
    }
    
    private final void loadPref() {
    }
    
    private final void storeTemp() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    private final void initMapView() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void showingMapContent() {
    }
    
    private final void editText() {
    }
    
    private final void getScheduleData() {
    }
    
    private final void getToken() {
    }
    
    private final void setAlert() {
    }
    
    @java.lang.Override()
    public void onInputScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.ScheduleResult result) {
    }
    
    @java.lang.Override()
    public void onEditScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    @java.lang.Override()
    public void onDeleteScheduleSuccess(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    private final void initText() {
    }
    
    private final void initTime() {
    }
    
    private final void startTimePicker() {
    }
    
    private final void endTimePicker() {
    }
    
    private final void datePicker() {
    }
    
    private final void startDateData() {
    }
    
    private final void endDateData() {
    }
    
    private final void startTimeData() {
    }
    
    private final void endTimeData() {
    }
    
    private final void getSendDate() {
    }
    
    private final void finishActivity() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/namo/Floating/Schedule/NewScheduleFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_PREFS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}