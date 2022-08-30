package com.example.namo.Data.Schedule.Memo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'JV\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\u0001\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0012\b\u0001\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\b\b\u0001\u0010\u0007\u001a\u00020\fH\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\'J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'JB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0012\b\u0001\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\f2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\fH\'\u00a8\u0006\u001a"}, d2 = {"Lcom/example/namo/Data/Schedule/Memo/MemoRetroInterface;", "", "deleteMemo", "Lretrofit2/Call;", "Lcom/example/namo/Data/Schedule/Memo/DeleteMemoResponse;", "accessToken", "", "memoIdx", "", "editMemo", "Lcom/example/namo/Data/Schedule/Memo/EditMemoResponse;", "content", "Lokhttp3/RequestBody;", "imgIdxList", "", "Lokhttp3/MultipartBody$Part;", "fileList", "getAllMemo", "Lcom/example/namo/Data/Schedule/Memo/GetAllMemoResponse;", "month", "getdetailMemo", "Lcom/example/namo/Data/Schedule/Memo/GetMemoResponse;", "inputMemo", "Lcom/example/namo/Data/Schedule/Memo/MemoResponse;", "imgs", "scheduleIdx", "app_debug"})
public abstract interface MemoRetroInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/schedule/memo")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.Memo.MemoResponse> inputMemo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part()
    java.util.List<okhttp3.MultipartBody.Part> imgs, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "scheduleIdx")
    okhttp3.RequestBody scheduleIdx, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part(value = "content")
    okhttp3.RequestBody content);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.PATCH(value = "/schedule/memo")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.Memo.EditMemoResponse> editMemo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part(value = "content")
    okhttp3.RequestBody content, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part()
    java.util.List<okhttp3.MultipartBody.Part> imgIdxList, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Part()
    java.util.List<okhttp3.MultipartBody.Part> fileList, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "memoIdx")
    okhttp3.RequestBody memoIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "/schedule/memo/{memoIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.Memo.DeleteMemoResponse> deleteMemo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @retrofit2.http.Path(value = "memoIdx")
    int memoIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/schedule/memo/{memoIdx}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.Memo.GetMemoResponse> getdetailMemo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @retrofit2.http.Path(value = "memoIdx")
    int memoIdx);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/schedule/memo/month/{month}")
    public abstract retrofit2.Call<com.example.namo.Data.Schedule.Memo.GetAllMemoResponse> getAllMemo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "ACCESS-TOKEN")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "month")
    java.lang.String month);
}