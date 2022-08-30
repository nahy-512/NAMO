// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSeeScheduleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageView recordBackground;

  @NonNull
  public final AppCompatImageView recordImg;

  @NonNull
  public final TextView recordText;

  @NonNull
  public final TextView seeAlarmContentTv;

  @NonNull
  public final ImageView seeAlarmIv;

  @NonNull
  public final ConstraintLayout seeAlarmLayout;

  @NonNull
  public final TextView seeAlarmTv;

  @NonNull
  public final CircleImageView seeCategoryContentColorCiv;

  @NonNull
  public final LinearLayout seeCategoryContentLayout;

  @NonNull
  public final TextView seeCategoryContentNameTv;

  @NonNull
  public final ImageView seeCategoryIv;

  @NonNull
  public final ConstraintLayout seeCategoryLayout;

  @NonNull
  public final TextView seeCategoryTv;

  @NonNull
  public final LinearLayout seeChooseLinearLayout;

  @NonNull
  public final TextView seeCloseTv;

  @NonNull
  public final DatePicker seeDatepickerDp;

  @NonNull
  public final TextView seeEditTv;

  @NonNull
  public final View seeEndBarView;

  @NonNull
  public final TextView seeEndDateTv;

  @NonNull
  public final ConstraintLayout seeEndLayout;

  @NonNull
  public final TextView seeEndTimeTv;

  @NonNull
  public final TextView seeEndTv;

  @NonNull
  public final Button seeMapOpenKakaomapBtn;

  @NonNull
  public final RelativeLayout seeMapView;

  @NonNull
  public final TextView seePlaceContentTv;

  @NonNull
  public final ImageView seePlaceIv;

  @NonNull
  public final ConstraintLayout seePlaceLayout;

  @NonNull
  public final TextView seePlaceTv;

  @NonNull
  public final TextView seeSeeTv;

  @NonNull
  public final View seeStartBarView;

  @NonNull
  public final TextView seeStartDateTv;

  @NonNull
  public final ConstraintLayout seeStartLayout;

  @NonNull
  public final TextView seeStartTimeTv;

  @NonNull
  public final TextView seeStartTv;

  @NonNull
  public final TimePicker seeTimepickerTp;

  @NonNull
  public final TextView seeTitleTv;

  private FragmentSeeScheduleBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageView recordBackground, @NonNull AppCompatImageView recordImg,
      @NonNull TextView recordText, @NonNull TextView seeAlarmContentTv,
      @NonNull ImageView seeAlarmIv, @NonNull ConstraintLayout seeAlarmLayout,
      @NonNull TextView seeAlarmTv, @NonNull CircleImageView seeCategoryContentColorCiv,
      @NonNull LinearLayout seeCategoryContentLayout, @NonNull TextView seeCategoryContentNameTv,
      @NonNull ImageView seeCategoryIv, @NonNull ConstraintLayout seeCategoryLayout,
      @NonNull TextView seeCategoryTv, @NonNull LinearLayout seeChooseLinearLayout,
      @NonNull TextView seeCloseTv, @NonNull DatePicker seeDatepickerDp,
      @NonNull TextView seeEditTv, @NonNull View seeEndBarView, @NonNull TextView seeEndDateTv,
      @NonNull ConstraintLayout seeEndLayout, @NonNull TextView seeEndTimeTv,
      @NonNull TextView seeEndTv, @NonNull Button seeMapOpenKakaomapBtn,
      @NonNull RelativeLayout seeMapView, @NonNull TextView seePlaceContentTv,
      @NonNull ImageView seePlaceIv, @NonNull ConstraintLayout seePlaceLayout,
      @NonNull TextView seePlaceTv, @NonNull TextView seeSeeTv, @NonNull View seeStartBarView,
      @NonNull TextView seeStartDateTv, @NonNull ConstraintLayout seeStartLayout,
      @NonNull TextView seeStartTimeTv, @NonNull TextView seeStartTv,
      @NonNull TimePicker seeTimepickerTp, @NonNull TextView seeTitleTv) {
    this.rootView = rootView;
    this.recordBackground = recordBackground;
    this.recordImg = recordImg;
    this.recordText = recordText;
    this.seeAlarmContentTv = seeAlarmContentTv;
    this.seeAlarmIv = seeAlarmIv;
    this.seeAlarmLayout = seeAlarmLayout;
    this.seeAlarmTv = seeAlarmTv;
    this.seeCategoryContentColorCiv = seeCategoryContentColorCiv;
    this.seeCategoryContentLayout = seeCategoryContentLayout;
    this.seeCategoryContentNameTv = seeCategoryContentNameTv;
    this.seeCategoryIv = seeCategoryIv;
    this.seeCategoryLayout = seeCategoryLayout;
    this.seeCategoryTv = seeCategoryTv;
    this.seeChooseLinearLayout = seeChooseLinearLayout;
    this.seeCloseTv = seeCloseTv;
    this.seeDatepickerDp = seeDatepickerDp;
    this.seeEditTv = seeEditTv;
    this.seeEndBarView = seeEndBarView;
    this.seeEndDateTv = seeEndDateTv;
    this.seeEndLayout = seeEndLayout;
    this.seeEndTimeTv = seeEndTimeTv;
    this.seeEndTv = seeEndTv;
    this.seeMapOpenKakaomapBtn = seeMapOpenKakaomapBtn;
    this.seeMapView = seeMapView;
    this.seePlaceContentTv = seePlaceContentTv;
    this.seePlaceIv = seePlaceIv;
    this.seePlaceLayout = seePlaceLayout;
    this.seePlaceTv = seePlaceTv;
    this.seeSeeTv = seeSeeTv;
    this.seeStartBarView = seeStartBarView;
    this.seeStartDateTv = seeStartDateTv;
    this.seeStartLayout = seeStartLayout;
    this.seeStartTimeTv = seeStartTimeTv;
    this.seeStartTv = seeStartTv;
    this.seeTimepickerTp = seeTimepickerTp;
    this.seeTitleTv = seeTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSeeScheduleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSeeScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_see_schedule, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSeeScheduleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.record_background;
      AppCompatImageView recordBackground = ViewBindings.findChildViewById(rootView, id);
      if (recordBackground == null) {
        break missingId;
      }

      id = R.id.record_img;
      AppCompatImageView recordImg = ViewBindings.findChildViewById(rootView, id);
      if (recordImg == null) {
        break missingId;
      }

      id = R.id.record_text;
      TextView recordText = ViewBindings.findChildViewById(rootView, id);
      if (recordText == null) {
        break missingId;
      }

      id = R.id.see_alarm_content_tv;
      TextView seeAlarmContentTv = ViewBindings.findChildViewById(rootView, id);
      if (seeAlarmContentTv == null) {
        break missingId;
      }

      id = R.id.see_alarm_iv;
      ImageView seeAlarmIv = ViewBindings.findChildViewById(rootView, id);
      if (seeAlarmIv == null) {
        break missingId;
      }

      id = R.id.see_alarm_layout;
      ConstraintLayout seeAlarmLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeAlarmLayout == null) {
        break missingId;
      }

      id = R.id.see_alarm_tv;
      TextView seeAlarmTv = ViewBindings.findChildViewById(rootView, id);
      if (seeAlarmTv == null) {
        break missingId;
      }

      id = R.id.see_category_content_color_civ;
      CircleImageView seeCategoryContentColorCiv = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryContentColorCiv == null) {
        break missingId;
      }

      id = R.id.see_category_content_layout;
      LinearLayout seeCategoryContentLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryContentLayout == null) {
        break missingId;
      }

      id = R.id.see_category_content_name_tv;
      TextView seeCategoryContentNameTv = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryContentNameTv == null) {
        break missingId;
      }

      id = R.id.see_category_iv;
      ImageView seeCategoryIv = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryIv == null) {
        break missingId;
      }

      id = R.id.see_category_layout;
      ConstraintLayout seeCategoryLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryLayout == null) {
        break missingId;
      }

      id = R.id.see_category_tv;
      TextView seeCategoryTv = ViewBindings.findChildViewById(rootView, id);
      if (seeCategoryTv == null) {
        break missingId;
      }

      id = R.id.see_choose_linear_layout;
      LinearLayout seeChooseLinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeChooseLinearLayout == null) {
        break missingId;
      }

      id = R.id.see_close_tv;
      TextView seeCloseTv = ViewBindings.findChildViewById(rootView, id);
      if (seeCloseTv == null) {
        break missingId;
      }

      id = R.id.see_datepicker_dp;
      DatePicker seeDatepickerDp = ViewBindings.findChildViewById(rootView, id);
      if (seeDatepickerDp == null) {
        break missingId;
      }

      id = R.id.see_edit_tv;
      TextView seeEditTv = ViewBindings.findChildViewById(rootView, id);
      if (seeEditTv == null) {
        break missingId;
      }

      id = R.id.see_end_bar_view;
      View seeEndBarView = ViewBindings.findChildViewById(rootView, id);
      if (seeEndBarView == null) {
        break missingId;
      }

      id = R.id.see_end_date_tv;
      TextView seeEndDateTv = ViewBindings.findChildViewById(rootView, id);
      if (seeEndDateTv == null) {
        break missingId;
      }

      id = R.id.see_end_layout;
      ConstraintLayout seeEndLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeEndLayout == null) {
        break missingId;
      }

      id = R.id.see_end_time_tv;
      TextView seeEndTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (seeEndTimeTv == null) {
        break missingId;
      }

      id = R.id.see_end_tv;
      TextView seeEndTv = ViewBindings.findChildViewById(rootView, id);
      if (seeEndTv == null) {
        break missingId;
      }

      id = R.id.see_map_open_kakaomap_btn;
      Button seeMapOpenKakaomapBtn = ViewBindings.findChildViewById(rootView, id);
      if (seeMapOpenKakaomapBtn == null) {
        break missingId;
      }

      id = R.id.see_map_view;
      RelativeLayout seeMapView = ViewBindings.findChildViewById(rootView, id);
      if (seeMapView == null) {
        break missingId;
      }

      id = R.id.see_place_content_tv;
      TextView seePlaceContentTv = ViewBindings.findChildViewById(rootView, id);
      if (seePlaceContentTv == null) {
        break missingId;
      }

      id = R.id.see_place_iv;
      ImageView seePlaceIv = ViewBindings.findChildViewById(rootView, id);
      if (seePlaceIv == null) {
        break missingId;
      }

      id = R.id.see_place_layout;
      ConstraintLayout seePlaceLayout = ViewBindings.findChildViewById(rootView, id);
      if (seePlaceLayout == null) {
        break missingId;
      }

      id = R.id.see_place_tv;
      TextView seePlaceTv = ViewBindings.findChildViewById(rootView, id);
      if (seePlaceTv == null) {
        break missingId;
      }

      id = R.id.see_see_tv;
      TextView seeSeeTv = ViewBindings.findChildViewById(rootView, id);
      if (seeSeeTv == null) {
        break missingId;
      }

      id = R.id.see_start_bar_view;
      View seeStartBarView = ViewBindings.findChildViewById(rootView, id);
      if (seeStartBarView == null) {
        break missingId;
      }

      id = R.id.see_start_date_tv;
      TextView seeStartDateTv = ViewBindings.findChildViewById(rootView, id);
      if (seeStartDateTv == null) {
        break missingId;
      }

      id = R.id.see_start_layout;
      ConstraintLayout seeStartLayout = ViewBindings.findChildViewById(rootView, id);
      if (seeStartLayout == null) {
        break missingId;
      }

      id = R.id.see_start_time_tv;
      TextView seeStartTimeTv = ViewBindings.findChildViewById(rootView, id);
      if (seeStartTimeTv == null) {
        break missingId;
      }

      id = R.id.see_start_tv;
      TextView seeStartTv = ViewBindings.findChildViewById(rootView, id);
      if (seeStartTv == null) {
        break missingId;
      }

      id = R.id.see_timepicker_tp;
      TimePicker seeTimepickerTp = ViewBindings.findChildViewById(rootView, id);
      if (seeTimepickerTp == null) {
        break missingId;
      }

      id = R.id.see_title_tv;
      TextView seeTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (seeTitleTv == null) {
        break missingId;
      }

      return new FragmentSeeScheduleBinding((ConstraintLayout) rootView, recordBackground,
          recordImg, recordText, seeAlarmContentTv, seeAlarmIv, seeAlarmLayout, seeAlarmTv,
          seeCategoryContentColorCiv, seeCategoryContentLayout, seeCategoryContentNameTv,
          seeCategoryIv, seeCategoryLayout, seeCategoryTv, seeChooseLinearLayout, seeCloseTv,
          seeDatepickerDp, seeEditTv, seeEndBarView, seeEndDateTv, seeEndLayout, seeEndTimeTv,
          seeEndTv, seeMapOpenKakaomapBtn, seeMapView, seePlaceContentTv, seePlaceIv,
          seePlaceLayout, seePlaceTv, seeSeeTv, seeStartBarView, seeStartDateTv, seeStartLayout,
          seeStartTimeTv, seeStartTv, seeTimepickerTp, seeTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}