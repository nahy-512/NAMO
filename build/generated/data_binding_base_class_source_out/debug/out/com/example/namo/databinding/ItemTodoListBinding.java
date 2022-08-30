// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemTodoListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView itemTodoListCategoryColorIv;

  @NonNull
  public final ImageButton itemTodoListCheckIb;

  @NonNull
  public final TextView itemTodoListContentTv;

  @NonNull
  public final TextView itemTodoListDayTv;

  @NonNull
  public final LinearLayout itemTodoListOnly;

  @NonNull
  public final TextView itemTodoListTopTv;

  @NonNull
  public final LinearLayout scheduleListLayout;

  private ItemTodoListBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView itemTodoListCategoryColorIv, @NonNull ImageButton itemTodoListCheckIb,
      @NonNull TextView itemTodoListContentTv, @NonNull TextView itemTodoListDayTv,
      @NonNull LinearLayout itemTodoListOnly, @NonNull TextView itemTodoListTopTv,
      @NonNull LinearLayout scheduleListLayout) {
    this.rootView = rootView;
    this.itemTodoListCategoryColorIv = itemTodoListCategoryColorIv;
    this.itemTodoListCheckIb = itemTodoListCheckIb;
    this.itemTodoListContentTv = itemTodoListContentTv;
    this.itemTodoListDayTv = itemTodoListDayTv;
    this.itemTodoListOnly = itemTodoListOnly;
    this.itemTodoListTopTv = itemTodoListTopTv;
    this.scheduleListLayout = scheduleListLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTodoListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTodoListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_todo_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTodoListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.item_todo_list_category_color_iv;
      ImageView itemTodoListCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListCategoryColorIv == null) {
        break missingId;
      }

      id = R.id.item_todo_list_check_ib;
      ImageButton itemTodoListCheckIb = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListCheckIb == null) {
        break missingId;
      }

      id = R.id.item_todo_list_content_tv;
      TextView itemTodoListContentTv = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListContentTv == null) {
        break missingId;
      }

      id = R.id.item_todo_list_day_tv;
      TextView itemTodoListDayTv = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListDayTv == null) {
        break missingId;
      }

      id = R.id.item_todo_list_only;
      LinearLayout itemTodoListOnly = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListOnly == null) {
        break missingId;
      }

      id = R.id.item_todo_list_top_tv;
      TextView itemTodoListTopTv = ViewBindings.findChildViewById(rootView, id);
      if (itemTodoListTopTv == null) {
        break missingId;
      }

      id = R.id.schedule_list_layout;
      LinearLayout scheduleListLayout = ViewBindings.findChildViewById(rootView, id);
      if (scheduleListLayout == null) {
        break missingId;
      }

      return new ItemTodoListBinding((ConstraintLayout) rootView, itemTodoListCategoryColorIv,
          itemTodoListCheckIb, itemTodoListContentTv, itemTodoListDayTv, itemTodoListOnly,
          itemTodoListTopTv, scheduleListLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}