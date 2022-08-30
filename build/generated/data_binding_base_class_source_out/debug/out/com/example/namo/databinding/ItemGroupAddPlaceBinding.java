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

public final class ItemGroupAddPlaceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView groupAddGalleryRv;

  @NonNull
  public final AppCompatImageView groupAddIv;

  @NonNull
  public final LinearLayout groupGalleryLv;

  @NonNull
  public final ConstraintLayout groupLayout;

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
  public final LinearLayout rightArrow;

  private ItemGroupAddPlaceBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView groupAddGalleryRv, @NonNull AppCompatImageView groupAddIv,
      @NonNull LinearLayout groupGalleryLv, @NonNull ConstraintLayout groupLayout,
      @NonNull ImageView img1, @NonNull ImageView img2, @NonNull ImageView img3,
      @NonNull TextView itemPlaceMoneyTv, @NonNull EditText itemPlaceNameTv,
      @NonNull LinearLayout rightArrow) {
    this.rootView = rootView;
    this.groupAddGalleryRv = groupAddGalleryRv;
    this.groupAddIv = groupAddIv;
    this.groupGalleryLv = groupGalleryLv;
    this.groupLayout = groupLayout;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.itemPlaceMoneyTv = itemPlaceMoneyTv;
    this.itemPlaceNameTv = itemPlaceNameTv;
    this.rightArrow = rightArrow;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemGroupAddPlaceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemGroupAddPlaceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_group_add_place, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemGroupAddPlaceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.group_add_gallery_rv;
      RecyclerView groupAddGalleryRv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddGalleryRv == null) {
        break missingId;
      }

      id = R.id.group_add_iv;
      AppCompatImageView groupAddIv = ViewBindings.findChildViewById(rootView, id);
      if (groupAddIv == null) {
        break missingId;
      }

      id = R.id.group_gallery_lv;
      LinearLayout groupGalleryLv = ViewBindings.findChildViewById(rootView, id);
      if (groupGalleryLv == null) {
        break missingId;
      }

      ConstraintLayout groupLayout = (ConstraintLayout) rootView;

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

      id = R.id.right_arrow;
      LinearLayout rightArrow = ViewBindings.findChildViewById(rootView, id);
      if (rightArrow == null) {
        break missingId;
      }

      return new ItemGroupAddPlaceBinding((ConstraintLayout) rootView, groupAddGalleryRv,
          groupAddIv, groupGalleryLv, groupLayout, img1, img2, img3, itemPlaceMoneyTv,
          itemPlaceNameTv, rightArrow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}