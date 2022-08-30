package com.example.namo.Data.Schedule.Memo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJD\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/namo/Data/Schedule/Memo/MemoService;", "", "()V", "getAllMemoView", "Lcom/example/namo/Data/Schedule/Memo/GetAllMemoView;", "getMemoView", "Lcom/example/namo/Data/Schedule/Memo/GetMemoView;", "memoView", "Lcom/example/namo/Data/Schedule/Memo/MemoView;", "deleteMemo", "", "accessToken", "", "memoIdx", "", "editMemo", "content", "Lokhttp3/RequestBody;", "imgIdxList", "", "Lokhttp3/MultipartBody$Part;", "fileList", "getAllMemo", "month", "getMemo", "inputMemo", "imgs", "scheduleIdx", "setMemoView", "app_debug"})
public final class MemoService {
    private com.example.namo.Data.Schedule.Memo.MemoView memoView;
    private com.example.namo.Data.Schedule.Memo.GetMemoView getMemoView;
    private com.example.namo.Data.Schedule.Memo.GetAllMemoView getAllMemoView;
    
    public MemoService() {
        super();
    }
    
    public final void setMemoView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Memo.MemoView memoView) {
    }
    
    public final void getMemoView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Memo.GetMemoView getMemoView) {
    }
    
    public final void getAllMemoView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Schedule.Memo.GetAllMemoView getAllMemoView) {
    }
    
    public final void inputMemo(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    java.util.List<okhttp3.MultipartBody.Part> imgs, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody scheduleIdx, @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody content) {
    }
    
    public final void editMemo(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody content, @org.jetbrains.annotations.Nullable()
    java.util.List<okhttp3.MultipartBody.Part> imgIdxList, @org.jetbrains.annotations.Nullable()
    java.util.List<okhttp3.MultipartBody.Part> fileList, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody memoIdx) {
    }
    
    public final void getMemo(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, int memoIdx) {
    }
    
    public final void deleteMemo(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, int memoIdx) {
    }
    
    public final void getAllMemo(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String month) {
    }
}