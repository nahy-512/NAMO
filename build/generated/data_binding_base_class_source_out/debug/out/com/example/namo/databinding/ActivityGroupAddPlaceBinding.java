// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGroupAddPlaceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout addPlaceLinearLayout;

  @NonNull
  public final ImageView bottomArrow;

  @NonNull
  public final ImageView groudPlaceAddIv;

  @NonNull
  public final TextView groudPlaceAddTv;

  @NonNull
  public final ImageView groupAddBackIv;

  @NonNull
  public final TextView groupAddDateTv;

  @NonNull
  public final RecyclerView groupAddGalleryRv;

  @NonNull
  public final TextView groupAddInputDateTv;

  @NonNull
  public final TextView groupAddInputPlaceTv;

  @NonNull
  public final AppCompatImageView groupAddIv;

  @NonNull
  public final RecyclerView groupAddPeopleRv;

  @NonNull
  public final TextView groupAddPeopleTv;

  @NonNull
  public final TextView groupAddPlaceTv;

  @NonNull
  public final TextView groupAddTitleTv;

  @NonNull
  public final ConstraintLayout groupAddTop;

  @NonNull
  public final LinearLayout groupGalleryLv;

  @NonNull
  public final ConstraintLayout groupLayout;

  @NonNull
  public final TextView groupPlaceSaveTv;

  @NonNull
  public final ImageView img1;

  @NonNull
  public final ImageView img2;

  @NonNull
  public final ImageView img3;

  @NonNull
  public final TextView itemPlaceMoneyTv;

  @NonNull
  public final EditText itemPlaceNameTv;

  @NonNull
  public final ConstraintLayout layout;

  @NonNull
  public final LinearLayout placeRightArrow;

  @NonNull
  public final ImageView upArrow;

  private ActivityGroupAddPlaceBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout addPlaceLinearLayout, @NonNull ImageView bottomArrow,
      @NonNull ImageView groudPlaceAddIv, @NonNull TextView groudPlaceAddTv,
      @NonNull ImageView groupAddBackIv, @NonNull TextView groupAddDateTv,
      @NonNull RecyclerView groupAddGalleryRv, @NonNull TextView groupAddInputDateTv,
      @NonNull TextView groupAddInputPlaceTv, @NonNull AppCompatImageView groupAddIv,
      @NonNull RecyclerView groupAddPeopleRv, @NonNull TextView groupAddPeopleTv,
      @NonNull TextView groupAddPlaceTv, @NonNull TextView groupAddTitleTv,
      @NonNull ConstraintLayout groupAddTop, @NonNull LinearLayout groupGalleryLv,
      @NonNull ConstraintLayout groupLayout, @NonNull TextView groupPlaceSaveTv,
      @NonNull ImageView img1, @NonNull ImageView img2, @NonNull ImageView img3,
      @NonNull TextView itemPlaceMoneyTv, @NonNull EditText itemPlaceNameTv,
      @NonNull ConstraintLayout layout, @NonNull LinearLayout placeRightArrow,
      @NonNull ImageView upArrow) {
    this.rootView = rootView;
    this.addPlaceLinearLayout = addPlaceLinearLayout;
    this.bottomArrow = bottomArrow;
    this.groudPlaceAddIv = groudPlaceAddIv;
    this.groudPlaceAddTv = groudPlaceAddTv;
    this.groupAddBackIv = groupAddBackIv;
    this.groupAddDateTv = groupAddDateTv;
    this.groupAddGalleryRv = groupAddGalleryRv;
    this.groupAddInputDateTv = groupAddInputDateTv;
    this.groupAddInputPlaceTv = groupAddInputPlaceTv;
    this.groupAddIv = groupAddIv;
    this.groupAddPeopleRv = groupAddPeopleRv;
    this.groupAddPeopleTv = groupAddPeopleTv;
    this.groupAddPlaceTv = groupAddPlaceTv;
    this.groupAddTitleTv = groupAddTitleTv;
    this.groupAddTop = groupAddTop;
    this.groupGalleryLv = groupGalleryLv;
    this.groupLayout = groupLayout;
    this.groupPlaceSaveTv = groupPlaceSaveTv;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.itemPlaceMoneyTv = itemPlaceMoneyTv;
    this.itemPlaceNameTv = itemPlaceNameTv;
    this.layout = layout;
    this.placeRightArrow = placeRightArrow;
    this.upArrow = upArrow;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGroupAddPlaceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGroupAddPlaceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_group_add_place, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGroupAddPlaceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_place_linear_layout;
      LinearLayout addPlaceLinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (addPlaceLinearLayout == null) {
        break missingId;
      }

      id = R.id.bottom_arrow;
      ImageView bottomArrow = ViewBindings.findChildViewById(rootView, id);
      if (bottomArrow == null) {
        break missingId;
      }

      id = R.id.groud_place_add_iv;
      ImageView groudPlaceAddIv = ViewBindings.findChildViewById(rootView, id);
      if (groudPlaceAddIv == null) {
        break missingId;
      }

      id = R.id.groud_place_add_tv;
      TextView groudPlaceAddTv = ViewBindings.findChildViewById(rootView, id);
      if (groudPlaceAddTv == null) {
        break missingId;
      }

      id = R.id.group_add_back_iv;
      ImageView groupAddBackIv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddBackIv == null) {
        break missingId;
      }

      id = R.id.group_add_date_tv;
      TextView groupAddDateTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddDateTv == null) {
        break missingId;
      }

      id = R.id.group_add_gallery_rv;
      RecyclerView groupAddGalleryRv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddGalleryRv == null) {
        break missingId;
      }

      id = R.id.group_add_input_date_tv;
      TextView groupAddInputDateTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddInputDateTv == null) {
        break missingId;
      }

      id = R.id.group_add_input_place_tv;
      TextView groupAddInputPlaceTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddInputPlaceTv == null) {
        break missingId;
      }

      id = R.id.group_add_iv;
      AppCompatImageView groupAddIv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddIv == null) {
        break missingId;
      }

      id = R.id.group_add_people_rv;
      RecyclerView groupAddPeopleRv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddPeopleRv == null) {
        break missingId;
      }

      id = R.id.group_add_people_tv;
      TextView groupAddPeopleTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddPeopleTv == null) {
        break missingId;
      }

      id = R.id.group_add_place_tv;
      TextView groupAddPlaceTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddPlaceTv == null) {
        break missingId;
      }

      id = R.id.group_add_title_tv;
      TextView groupAddTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddTitleTv == null) {
        break missingId;
      }

      id = R.id.group_add_top;
      ConstraintLayout groupAddTop = ViewBindings.findChildViewById(rootView, id);
      if (groupAddTop == null) {
        break missingId;
      }

      id = R.id.group_gallery_lv;
      LinearLayout groupGalleryLv = ViewBindings.findChildViewById(rootView, id);
      if (groupGalleryLv == null) {
        break missingId;
      }

      id = R.id.group_layout;
      ConstraintLayout groupLayout = ViewBindings.findChildViewById(rootView, id);
      if (groupLayout == null) {
        break missingId;
      }

      id = R.id.group_place_save_tv;
      TextView groupPlaceSaveTv = ViewBindings.findChildViewById(rootView, id);
      if (groupPlaceSaveTv == null) {
        break missingId;
      }

      id = R.id.img1;
      ImageView img1 = ViewBindings.findChildViewById(rootView, id);
      if (img1 == null) {
        break missingId;
      }

      id = R.id.img2;
      ImageView img2 = ViewBindings.findChildViewById(rootView, id);
      if (img2 == null) {
        break missingId;
      }

      id = R.id.img3;
      ImageView img3 = ViewBindings.findChildViewById(rootView, id);
      if (img3 == null) {
        break missingId;
      }

      id = R.id.item_place_money_tv;
      TextView itemPlaceMoneyTv = ViewBindings.findChildViewById(rootView, id);
      if (itemPlaceMoneyTv == null) {
        break missingId;
      }

      id = R.id.item_place_name_tv;
      EditText itemPlaceNameTv = ViewBindings.findChildViewById(rootView, id);
      if (itemPlaceNameTv == null) {
        break missingId;
      }

      id = R.id.layout;
      ConstraintLayout layout = ViewBindings.findChildViewById(rootView, id);
      if (layout == null) {
        break missingId;
      }

      id = R.id.place_right_arrow;
      LinearLayout placeRightArrow = ViewBindings.findChildViewById(rootView, id);
      if (placeRightArrow == null) {
        break missingId;
      }

      id = R.id.up_arrow;
      ImageView upArrow = ViewBindings.findChildViewById(rootView, id);
      if (upArrow == null) {
        break missingId;
      }

      return new ActivityGroupAddPlaceBinding((ConstraintLayout) rootView, addPlaceLinearLayout,
          bottomArrow, groudPlaceAddIv, groudPlaceAddTv, groupAddBackIv, groupAddDateTv,
          groupAddGalleryRv, groupAddInputDateTv, groupAddInputPlaceTv, groupAddIv,
          groupAddPeopleRv, groupAddPeopleTv, groupAddPlaceTv, groupAddTitleTv, groupAddTop,
          groupGalleryLv, groupLayout, groupPlaceSaveTv, img1, img2, img3, itemPlaceMoneyTv,
          itemPlaceNameTv, layout, placeRightArrow, upArrow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
