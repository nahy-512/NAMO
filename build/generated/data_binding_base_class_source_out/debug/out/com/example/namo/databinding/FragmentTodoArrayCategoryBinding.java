// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTodoArrayCategoryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView todoCategoryCategoryRv;

  @NonNull
  public final ConstraintLayout todoCategoryHi;

  @NonNull
  public final RecyclerView todoCategoryTodolistRv;

  @NonNull
  public final View todoCategoryUnderbar;

  private FragmentTodoArrayCategoryBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView todoCategoryCategoryRv, @NonNull ConstraintLayout todoCategoryHi,
      @NonNull RecyclerView todoCategoryTodolistRv, @NonNull View todoCategoryUnderbar) {
    this.rootView = rootView;
    this.todoCategoryCategoryRv = todoCategoryCategoryRv;
    this.todoCategoryHi = todoCategoryHi;
    this.todoCategoryTodolistRv = todoCategoryTodolistRv;
    this.todoCategoryUnderbar = todoCategoryUnderbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTodoArrayCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTodoArrayCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_todo_array_category, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTodoArrayCategoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.todo_category_category_rv;
      RecyclerView todoCategoryCategoryRv = ViewBindings.findChildViewById(rootView, id);
      if (todoCategoryCategoryRv == null) {
        break missingId;
      }

      ConstraintLayout todoCategoryHi = (ConstraintLayout) rootView;

      id = R.id.todo_category_todolist_rv;
      RecyclerView todoCategoryTodolistRv = ViewBindings.findChildViewById(rootView, id);
      if (todoCategoryTodolistRv == null) {
        break missingId;
      }

      id = R.id.todo_category_underbar;
      View todoCategoryUnderbar = ViewBindings.findChildViewById(rootView, id);
      if (todoCategoryUnderbar == null) {
        break missingId;
      }

      return new FragmentTodoArrayCategoryBinding((ConstraintLayout) rootView,
          todoCategoryCategoryRv, todoCategoryHi, todoCategoryTodolistRv, todoCategoryUnderbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
