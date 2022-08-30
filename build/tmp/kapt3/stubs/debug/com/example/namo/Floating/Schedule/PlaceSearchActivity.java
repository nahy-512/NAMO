package com.example.namo.Floating.Schedule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0012\u0010&\u001a\u00020!2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020!H\u0002J\u0018\u0010*\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0014H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/namo/Floating/Schedule/PlaceSearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/namo/databinding/ActivityPlaceSearchBinding;", "getBinding", "()Lcom/example/namo/databinding/ActivityPlaceSearchBinding;", "setBinding", "(Lcom/example/namo/databinding/ActivityPlaceSearchBinding;)V", "id", "", "keyword", "mapView", "Lnet/daum/mf/map/api/MapView;", "getMapView", "()Lnet/daum/mf/map/api/MapView;", "setMapView", "(Lnet/daum/mf/map/api/MapView;)V", "name", "pageNum", "", "placeList", "Ljava/util/ArrayList;", "Lcom/example/namo/Data/Map/PlaceList;", "placeSearchRVAdapter", "Lcom/example/namo/Floating/Schedule/PlaceSearchRVAdapter;", "pos", "tempSchedule", "Lcom/example/namo/Data/Schedule/TempSchedule;", "x", "", "y", "addItemsAndMarkers", "", "searchResult", "Lcom/example/namo/Data/ResultSearchKeyword;", "finish", "loadPref", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "putPref", "searchKeyword", "page", "Companion", "app_debug"})
public final class PlaceSearchActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.namo.Data.Schedule.TempSchedule tempSchedule;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.namo.Floating.Schedule.PlaceSearchActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://dapi.kakao.com/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "KakaoAK 818de08ab952bb5274fa890b790f338d";
    private static final java.lang.String KEY_PREFS = "tempSchedule";
    private static final java.lang.String KEY_DATA = "tempData";
    public com.example.namo.databinding.ActivityPlaceSearchBinding binding;
    private final java.util.ArrayList<com.example.namo.Data.Map.PlaceList> placeList = null;
    private final com.example.namo.Floating.Schedule.PlaceSearchRVAdapter placeSearchRVAdapter = null;
    private int pageNum = 1;
    private java.lang.String keyword = "";
    private double x = 0.0;
    private double y = 0.0;
    private java.lang.String name = "";
    private java.lang.String id = "";
    private int pos = -1;
    public net.daum.mf.map.api.MapView mapView;
    private java.util.HashMap _$_findViewCache;
    
    public PlaceSearchActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.namo.databinding.ActivityPlaceSearchBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.namo.databinding.ActivityPlaceSearchBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.daum.mf.map.api.MapView getMapView() {
        return null;
    }
    
    public final void setMapView(@org.jetbrains.annotations.NotNull()
    net.daum.mf.map.api.MapView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void finish() {
    }
    
    private final void searchKeyword(java.lang.String keyword, int page) {
    }
    
    private final void addItemsAndMarkers(com.example.namo.Data.ResultSearchKeyword searchResult) {
    }
    
    private final void putPref() {
    }
    
    private final void loadPref() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/namo/Floating/Schedule/PlaceSearchActivity$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "KEY_DATA", "KEY_PREFS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}