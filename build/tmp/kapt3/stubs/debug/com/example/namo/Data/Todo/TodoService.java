package com.example.namo.Data.Todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/namo/Data/Todo/TodoService;", "", "()V", "todoView", "Lcom/example/namo/Data/Todo/TodoView;", "categoryTodo", "", "access", "", "refresh", "categoryIdx", "", "dayTodo", "date", "deleteTodo", "todoIdx", "editTodo", "edit", "Lcom/example/namo/Data/Todo/EditTodo;", "getTodo", "todo", "Lcom/example/namo/Data/Todo/Todo;", "monthTodo", "setTodoView", "app_debug"})
public final class TodoService {
    private com.example.namo.Data.Todo.TodoView todoView;
    
    public TodoService() {
        super();
    }
    
    public final void setTodoView(@org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.TodoView todoView) {
    }
    
    public final void getTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.Todo todo) {
    }
    
    public final void editTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, @org.jetbrains.annotations.NotNull()
    com.example.namo.Data.Todo.EditTodo edit) {
    }
    
    public final void deleteTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, int todoIdx) {
    }
    
    public final void dayTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void monthTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void categoryTodo(@org.jetbrains.annotations.NotNull()
    java.lang.String access, @org.jetbrains.annotations.NotNull()
    java.lang.String refresh, int categoryIdx) {
    }
}