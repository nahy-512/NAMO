package com.example.namo.Data.Map;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/namo/Data/Map/KakaoMapAPI;", "", "getSearchKeyword", "Lretrofit2/Call;", "Lcom/example/namo/Data/ResultSearchKeyword;", "key", "", "query", "page", "", "app_debug"})
public abstract interface KakaoMapAPI {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v2/local/search/keyword.json")
    public abstract retrofit2.Call<com.example.namo.Data.ResultSearchKeyword> getSearchKeyword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page);
}