// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTodoCategoryDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView categoryBackIv;

  @NonNull
  public final ConstraintLayout categoryCalenderLl;

  @NonNull
  public final RecyclerView categoryNewPaletteRv;

  @NonNull
  public final TextView categoryNewTv;

  @NonNull
  public final EditText categoryPalettedNameEt;

  @NonNull
  public final TextView categorySaveTv;

  @NonNull
  public final EditText categoryTitleTv;

  @NonNull
  public final TextView defalutColor;

  @NonNull
  public final TextView palette;

  @NonNull
  public final CircleImageView scheduleCategoryColorIv;

  @NonNull
  public final CircleImageView scheduleGroupCategoryColorIv;

  @NonNull
  public final CircleImageView scheduleParttimeCategoryColorIv;

  @NonNull
  public final CircleImageView schedulePlanCategoryColorIv;

  private FragmentTodoCategoryDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView categoryBackIv, @NonNull ConstraintLayout categoryCalenderLl,
      @NonNull RecyclerView categoryNewPaletteRv, @NonNull TextView categoryNewTv,
      @NonNull EditText categoryPalettedNameEt, @NonNull TextView categorySaveTv,
      @NonNull EditText categoryTitleTv, @NonNull TextView defalutColor, @NonNull TextView palette,
      @NonNull CircleImageView scheduleCategoryColorIv,
      @NonNull CircleImageView scheduleGroupCategoryColorIv,
      @NonNull CircleImageView scheduleParttimeCategoryColorIv,
      @NonNull CircleImageView schedulePlanCategoryColorIv) {
    this.rootView = rootView;
    this.categoryBackIv = categoryBackIv;
    this.categoryCalenderLl = categoryCalenderLl;
    this.categoryNewPaletteRv = categoryNewPaletteRv;
    this.categoryNewTv = categoryNewTv;
    this.categoryPalettedNameEt = categoryPalettedNameEt;
    this.categorySaveTv = categorySaveTv;
    this.categoryTitleTv = categoryTitleTv;
    this.defalutColor = defalutColor;
    this.palette = palette;
    this.scheduleCategoryColorIv = scheduleCategoryColorIv;
    this.scheduleGroupCategoryColorIv = scheduleGroupCategoryColorIv;
    this.scheduleParttimeCategoryColorIv = scheduleParttimeCategoryColorIv;
    this.schedulePlanCategoryColorIv = schedulePlanCategoryColorIv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTodoCategoryDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTodoCategoryDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_todo_category_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTodoCategoryDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.category_back_iv;
      ImageView categoryBackIv = ViewBindings.findChildViewById(rootView, id);
      if (categoryBackIv == null) {
        break missingId;
      }

      id = R.id.category_calender_ll;
      ConstraintLayout categoryCalenderLl = ViewBindings.findChildViewById(rootView, id);
      if (categoryCalenderLl == null) {
        break missingId;
      }

      id = R.id.category_new_palette_rv;
      RecyclerView categoryNewPaletteRv = ViewBindings.findChildViewById(rootView, id);
      if (categoryNewPaletteRv == null) {
        break missingId;
      }

      id = R.id.category_new_tv;
      TextView categoryNewTv = ViewBindings.findChildViewById(rootView, id);
      if (categoryNewTv == null) {
        break missingId;
      }

      id = R.id.category_paletted_name_et;
      EditText categoryPalettedNameEt = ViewBindings.findChildViewById(rootView, id);
      if (categoryPalettedNameEt == null) {
        break missingId;
      }

      id = R.id.category_save_tv;
      TextView categorySaveTv = ViewBindings.findChildViewById(rootView, id);
      if (categorySaveTv == null) {
        break missingId;
      }

      id = R.id.category_title_tv;
      EditText categoryTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (categoryTitleTv == null) {
        break missingId;
      }

      id = R.id.defalut_color;
      TextView defalutColor = ViewBindings.findChildViewById(rootView, id);
      if (defalutColor == null) {
        break missingId;
      }

      id = R.id.palette;
      TextView palette = ViewBindings.findChildViewById(rootView, id);
      if (palette == null) {
        break missingId;
      }

      id = R.id.schedule_category_color_iv;
      CircleImageView scheduleCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (scheduleCategoryColorIv == null) {
        break missingId;
      }

      id = R.id.schedule_group_category_color_iv;
      CircleImageView scheduleGroupCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (scheduleGroupCategoryColorIv == null) {
        break missingId;
      }

      id = R.id.schedule_parttime_category_color_iv;
      CircleImageView scheduleParttimeCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (scheduleParttimeCategoryColorIv == null) {
        break missingId;
      }

      id = R.id.schedule_plan_category_color_iv;
      CircleImageView schedulePlanCategoryColorIv = ViewBindings.findChildViewById(rootView, id);
      if (schedulePlanCategoryColorIv == null) {
        break missingId;
      }

      return new FragmentTodoCategoryDetailBinding((ConstraintLayout) rootView, categoryBackIv,
          categoryCalenderLl, categoryNewPaletteRv, categoryNewTv, categoryPalettedNameEt,
          categorySaveTv, categoryTitleTv, defalutColor, palette, scheduleCategoryColorIv,
          scheduleGroupCategoryColorIv, scheduleParttimeCategoryColorIv,
          schedulePlanCategoryColorIv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
