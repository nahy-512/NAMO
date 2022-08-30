// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public final class ActivityGroupInformationBubbleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView groupInfoBackTv;

  @NonNull
  public final View groupInfoBbDarkView;

  @NonNull
  public final FrameLayout groupInfoBbFrm;

  @NonNull
  public final ImageView groupInfoCodeCopyIv;

  @NonNull
  public final LinearLayout groupInfoCodeLl;

  @NonNull
  public final TextView groupInfoCodeTv;

  @NonNull
  public final TextView groupInfoLeaveBtn;

  @NonNull
  public final TextView groupInfoPeople;

  @NonNull
  public final TextView groupInfoPeopleNumTv;

  @NonNull
  public final RecyclerView groupInfoPeopleRv;

  @NonNull
  public final TextView groupInfoSaveTv;

  @NonNull
  public final ConstraintLayout groupInfoTb;

  @NonNull
  public final TextView groupInfoTitle;

  @NonNull
  public final TextView groupInfoTitleTv;

  private ActivityGroupInformationBubbleBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView groupInfoBackTv, @NonNull View groupInfoBbDarkView,
      @NonNull FrameLayout groupInfoBbFrm, @NonNull ImageView groupInfoCodeCopyIv,
      @NonNull LinearLayout groupInfoCodeLl, @NonNull TextView groupInfoCodeTv,
      @NonNull TextView groupInfoLeaveBtn, @NonNull TextView groupInfoPeople,
      @NonNull TextView groupInfoPeopleNumTv, @NonNull RecyclerView groupInfoPeopleRv,
      @NonNull TextView groupInfoSaveTv, @NonNull ConstraintLayout groupInfoTb,
      @NonNull TextView groupInfoTitle, @NonNull TextView groupInfoTitleTv) {
    this.rootView = rootView;
    this.groupInfoBackTv = groupInfoBackTv;
    this.groupInfoBbDarkView = groupInfoBbDarkView;
    this.groupInfoBbFrm = groupInfoBbFrm;
    this.groupInfoCodeCopyIv = groupInfoCodeCopyIv;
    this.groupInfoCodeLl = groupInfoCodeLl;
    this.groupInfoCodeTv = groupInfoCodeTv;
    this.groupInfoLeaveBtn = groupInfoLeaveBtn;
    this.groupInfoPeople = groupInfoPeople;
    this.groupInfoPeopleNumTv = groupInfoPeopleNumTv;
    this.groupInfoPeopleRv = groupInfoPeopleRv;
    this.groupInfoSaveTv = groupInfoSaveTv;
    this.groupInfoTb = groupInfoTb;
    this.groupInfoTitle = groupInfoTitle;
    this.groupInfoTitleTv = groupInfoTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGroupInformationBubbleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGroupInformationBubbleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_group_information_bubble, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGroupInformationBubbleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.group_info_back_tv;
      TextView groupInfoBackTv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoBackTv == null) {
        break missingId;
      }

      id = R.id.group_info_bb_dark_view;
      View groupInfoBbDarkView = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoBbDarkView == null) {
        break missingId;
      }

      id = R.id.group_info_bb_frm;
      FrameLayout groupInfoBbFrm = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoBbFrm == null) {
        break missingId;
      }

      id = R.id.group_info_code_copy_iv;
      ImageView groupInfoCodeCopyIv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoCodeCopyIv == null) {
        break missingId;
      }

      id = R.id.group_info_code_ll;
      LinearLayout groupInfoCodeLl = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoCodeLl == null) {
        break missingId;
      }

      id = R.id.group_info_code_tv;
      TextView groupInfoCodeTv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoCodeTv == null) {
        break missingId;
      }

      id = R.id.group_info_leave_btn;
      TextView groupInfoLeaveBtn = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoLeaveBtn == null) {
        break missingId;
      }

      id = R.id.group_info_people;
      TextView groupInfoPeople = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoPeople == null) {
        break missingId;
      }

      id = R.id.group_info_people_num_tv;
      TextView groupInfoPeopleNumTv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoPeopleNumTv == null) {
        break missingId;
      }

      id = R.id.group_info_people_rv;
      RecyclerView groupInfoPeopleRv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoPeopleRv == null) {
        break missingId;
      }

      id = R.id.group_info_save_tv;
      TextView groupInfoSaveTv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoSaveTv == null) {
        break missingId;
      }

      id = R.id.group_info_tb;
      ConstraintLayout groupInfoTb = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoTb == null) {
        break missingId;
      }

      id = R.id.group_info_title;
      TextView groupInfoTitle = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoTitle == null) {
        break missingId;
      }

      id = R.id.group_info_title_tv;
      TextView groupInfoTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (groupInfoTitleTv == null) {
        break missingId;
      }

      return new ActivityGroupInformationBubbleBinding((ConstraintLayout) rootView, groupInfoBackTv,
          groupInfoBbDarkView, groupInfoBbFrm, groupInfoCodeCopyIv, groupInfoCodeLl,
          groupInfoCodeTv, groupInfoLeaveBtn, groupInfoPeople, groupInfoPeopleNumTv,
          groupInfoPeopleRv, groupInfoSaveTv, groupInfoTb, groupInfoTitle, groupInfoTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}