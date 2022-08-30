// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public final class ItemDiaryListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView diaryAllEditIv;

  @NonNull
  public final TextView diaryAllEditTv;

  @NonNull
  public final RecyclerView diaryAllRv;

  @NonNull
  public final ConstraintLayout diaryDateLayout;

  @NonNull
  public final TextView diaryDayTv;

  @NonNull
  public final TextView itemDiartContentTv;

  @NonNull
  public final View itemDiaryCategoryColorIv;

  @NonNull
  public final TextView itemDiaryTitleTv;

  @NonNull
  public final ConstraintLayout layout;

  @NonNull
  public final LinearLayout linearCorner;

  @NonNull
  public final View view1;

  @NonNull
  public final View view2;

  private ItemDiaryListBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView diaryAllEditIv, @NonNull TextView diaryAllEditTv,
      @NonNull RecyclerView diaryAllRv, @NonNull ConstraintLayout diaryDateLayout,
      @NonNull TextView diaryDayTv, @NonNull TextView itemDiartContentTv,
      @NonNull View itemDiaryCategoryColorIv, @NonNull TextView itemDiaryTitleTv,
      @NonNull ConstraintLayout layout, @NonNull LinearLayout linearCorner, @NonNull View view1,
      @NonNull View view2) {
    this.rootView = rootView;
    this.diaryAllEditIv = diaryAllEditIv;
    this.diaryAllEditTv = diaryAllEditTv;
    this.diaryAllRv = diaryAllRv;
    this.diaryDateLayout = diaryDateLayout;
    this.diaryDayTv = diaryDayTv;
    this.itemDiartContentTv = itemDiartContentTv;
    this.itemDiaryCategoryColorIv = itemDiaryCategoryColorIv;
    this.itemDiaryTitleTv = itemDiaryTitleTv;
    this.layout = layout;
    this.linearCorner = linearCorner;
    this.view1 = view1;
    this.view2 = view2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemDiaryListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemDiaryListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_diary_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemDiaryListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.diary_all_edit_iv;
      ImageView diaryAllEditIv = ViewBindings.findChildViewById(rootView, id);
      if (diaryAllEditIv == null) {
        break missingId;
      }

      id = R.id.diary_all_edit_tv;
      TextView diaryAllEditTv = ViewBindings.findChildViewById(rootView, id);
      if (diaryAllEditTv == null) {
        break missingId;
      }

      id = R.id.diary_all_rv;
      RecyclerView diaryAllRv = ViewBindings.findChildViewById(rootView, id);
      if (diaryAllRv == null) {
        break missingId;
      }

      id = R.id.diary_date_layout;
      ConstraintLayout diaryDateLayout = ViewBindings.findChildViewById(rootView, id);
      if (diaryDateLayout == null) {
        break missingId;
      }

      id = R.id.diary_day_tv;
      TextView diaryDayTv = ViewBindings.findChildViewById(rootView, id);
      if (diaryDayTv == null) {
        break missingId;
      }

      id = R.id.item_diart_content_tv;
      TextView itemDiartContentTv = ViewBindings.findChildViewById(rootView, id);
      if (itemDiartContentTv == null) {
        break missingId;
      }

      id = R.id.item_diary_category_color_iv;
      View itemDiaryCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (itemDiaryCategoryColorIv == null) {
        break missingId;
      }

      id = R.id.item_diary_title_tv;
      TextView itemDiaryTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (itemDiaryTitleTv == null) {
        break missingId;
      }

      id = R.id.layout;
      ConstraintLayout layout = ViewBindings.findChildViewById(rootView, id);
      if (layout == null) {
        break missingId;
      }

      id = R.id.linear_corner;
      LinearLayout linearCorner = ViewBindings.findChildViewById(rootView, id);
      if (linearCorner == null) {
        break missingId;
      }

      id = R.id.view1;
      View view1 = ViewBindings.findChildViewById(rootView, id);
      if (view1 == null) {
        break missingId;
      }

      id = R.id.view2;
      View view2 = ViewBindings.findChildViewById(rootView, id);
      if (view2 == null) {
        break missingId;
      }

      return new ItemDiaryListBinding((ConstraintLayout) rootView, diaryAllEditIv, diaryAllEditTv,
          diaryAllRv, diaryDateLayout, diaryDayTv, itemDiartContentTv, itemDiaryCategoryColorIv,
          itemDiaryTitleTv, layout, linearCorner, view1, view2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}