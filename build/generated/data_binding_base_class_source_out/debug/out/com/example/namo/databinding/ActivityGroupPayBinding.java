// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class ActivityGroupPayBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView groupPayBackTv;

  @NonNull
  public final TextView groupPayCountTv;

  @NonNull
  public final View groupPayDarkView;

  @NonNull
  public final ConstraintLayout groupPayHeaderLayout;

  @NonNull
  public final RecyclerView groupPayPersonRv;

  @NonNull
  public final TextView groupPayResultTv;

  @NonNull
  public final TextView groupPaySaveTv;

  @NonNull
  public final EditText groupPayTotalEt;

  private ActivityGroupPayBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView groupPayBackTv, @NonNull TextView groupPayCountTv,
      @NonNull View groupPayDarkView, @NonNull ConstraintLayout groupPayHeaderLayout,
      @NonNull RecyclerView groupPayPersonRv, @NonNull TextView groupPayResultTv,
      @NonNull TextView groupPaySaveTv, @NonNull EditText groupPayTotalEt) {
    this.rootView = rootView;
    this.groupPayBackTv = groupPayBackTv;
    this.groupPayCountTv = groupPayCountTv;
    this.groupPayDarkView = groupPayDarkView;
    this.groupPayHeaderLayout = groupPayHeaderLayout;
    this.groupPayPersonRv = groupPayPersonRv;
    this.groupPayResultTv = groupPayResultTv;
    this.groupPaySaveTv = groupPaySaveTv;
    this.groupPayTotalEt = groupPayTotalEt;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGroupPayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGroupPayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_group_pay, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGroupPayBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.group_pay_back_tv;
      TextView groupPayBackTv = ViewBindings.findChildViewById(rootView, id);
      if (groupPayBackTv == null) {
        break missingId;
      }

      id = R.id.group_pay_count_tv;
      TextView groupPayCountTv = ViewBindings.findChildViewById(rootView, id);
      if (groupPayCountTv == null) {
        break missingId;
      }

      id = R.id.group_pay_dark_view;
      View groupPayDarkView = ViewBindings.findChildViewById(rootView, id);
      if (groupPayDarkView == null) {
        break missingId;
      }

      id = R.id.group_pay_header_layout;
      ConstraintLayout groupPayHeaderLayout = ViewBindings.findChildViewById(rootView, id);
      if (groupPayHeaderLayout == null) {
        break missingId;
      }

      id = R.id.group_pay_person_rv;
      RecyclerView groupPayPersonRv = ViewBindings.findChildViewById(rootView, id);
      if (groupPayPersonRv == null) {
        break missingId;
      }

      id = R.id.group_pay_result_tv;
      TextView groupPayResultTv = ViewBindings.findChildViewById(rootView, id);
      if (groupPayResultTv == null) {
        break missingId;
      }

      id = R.id.group_pay_save_tv;
      TextView groupPaySaveTv = ViewBindings.findChildViewById(rootView, id);
      if (groupPaySaveTv == null) {
        break missingId;
      }

      id = R.id.group_pay_total_et;
      EditText groupPayTotalEt = ViewBindings.findChildViewById(rootView, id);
      if (groupPayTotalEt == null) {
        break missingId;
      }

      return new ActivityGroupPayBinding((ConstraintLayout) rootView, groupPayBackTv,
          groupPayCountTv, groupPayDarkView, groupPayHeaderLayout, groupPayPersonRv,
          groupPayResultTv, groupPaySaveTv, groupPayTotalEt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}