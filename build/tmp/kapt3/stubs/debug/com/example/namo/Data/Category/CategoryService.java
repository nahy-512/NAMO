package com.example.namo.Data.Category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/namo/Data/Category/CategoryService;", "", "()V", "categoryDeleteView", "Lcom/example/namo/Floating/Category/CategoryDeleteView;", "categoryDetailView", "Lcom/example/namo/Floating/Category/CategoryDetailView;", "categoryView", "Lcom/example/namo/Floating/Category/CategoryView;", "deleteScheduleCategory", "", "access", "", "categoryIdx", "", "editScheduleCategory", "schedulecategory", "Lcom/example/namo/Data/Category/EditScheduleCategory;", "getAllScheduleCategory", "getScheduleCategory", "postScheduleCategory", "Lcom/example/namo/Data/Category/ScheduleCategory;", "setCategoryDeleteView", "setCategorySetView", "categorySetView", "setCategoryView", "app_debug"})
public final class CategoryService {
    private com.example.namo.Floating.Category.CategoryView categoryView;
    private com.example.namo.Floating.Category.CategoryDetailView categoryDetailView;
    private com.example.namo.Floating.Category.CategoryDeleteView categoryDeleteView;
    
    public CategoryService() {
        super();
    }
    
    public final void setCategoryView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Floating.Category.CategoryView categoryView) {
    }
    
    public final void setCategorySetView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Floating.Category.CategoryDetailView categorySetView) {
    }
    
    public final void setCategoryDeleteView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Floating.Category.CategoryDeleteView categoryDeleteView) {
    }
    
    /**
     * 3.5 카테고리 전체 조회
     */
    public final void getAllScheduleCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String access) {
    }
    
    /**
     * 3.1 카테고리 생성
     */
    public final void postScheduleCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Category.ScheduleCategory schedulecategory) {
    }
    
    /**
     * 3.2 카테고리 수정
     */
    public final void editScheduleCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Category.EditScheduleCategory schedulecategory) {
    }
    
    /**
     * 3.4 카테고리 조회
     */
    public final void getScheduleCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String access, int categoryIdx) {
    }
    
    /**
     * 3.3 카테고리 삭제
     */
    public final void deleteScheduleCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String access, int categoryIdx) {
    }
}