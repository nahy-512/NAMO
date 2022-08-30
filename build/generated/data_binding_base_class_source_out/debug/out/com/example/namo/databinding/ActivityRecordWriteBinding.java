// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class ActivityRecordWriteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageView recordBackIv;

  @NonNull
  public final TextView recordDateTv;

  @NonNull
  public final ImageView recordDeleteTv;

  @NonNull
  public final TextView recordEditTv;

  @NonNull
  public final RecyclerView recordGallerySavedRy;

  @NonNull
  public final TextView recordInputDateTv;

  @NonNull
  public final TextView recordInputPlaceTv;

  @NonNull
  public final TextView recordNoteEt;

  @NonNull
  public final TextView recordPlaceTv;

  @NonNull
  public final TextView recordTitleTv;

  @NonNull
  public final ConstraintLayout recordTop;

  private ActivityRecordWriteBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageView recordBackIv, @NonNull TextView recordDateTv,
      @NonNull ImageView recordDeleteTv, @NonNull TextView recordEditTv,
      @NonNull RecyclerView recordGallerySavedRy, @NonNull TextView recordInputDateTv,
      @NonNull TextView recordInputPlaceTv, @NonNull TextView recordNoteEt,
      @NonNull TextView recordPlaceTv, @NonNull TextView recordTitleTv,
      @NonNull ConstraintLayout recordTop) {
    this.rootView = rootView;
    this.recordBackIv = recordBackIv;
    this.recordDateTv = recordDateTv;
    this.recordDeleteTv = recordDeleteTv;
    this.recordEditTv = recordEditTv;
    this.recordGallerySavedRy = recordGallerySavedRy;
    this.recordInputDateTv = recordInputDateTv;
    this.recordInputPlaceTv = recordInputPlaceTv;
    this.recordNoteEt = recordNoteEt;
    this.recordPlaceTv = recordPlaceTv;
    this.recordTitleTv = recordTitleTv;
    this.recordTop = recordTop;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRecordWriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRecordWriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_record_write, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRecordWriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.record_back_iv;
      AppCompatImageView recordBackIv = ViewBindings.findChildViewById(rootView, id);
      if (recordBackIv == null) {
        break missingId;
      }

      id = R.id.record_date_tv;
      TextView recordDateTv = ViewBindings.findChildViewById(rootView, id);
      if (recordDateTv == null) {
        break missingId;
      }

      id = R.id.record_delete_tv;
      ImageView recordDeleteTv = ViewBindings.findChildViewById(rootView, id);
      if (recordDeleteTv == null) {
        break missingId;
      }

      id = R.id.record_edit_tv;
      TextView recordEditTv = ViewBindings.findChildViewById(rootView, id);
      if (recordEditTv == null) {
        break missingId;
      }

      id = R.id.record_gallery_saved_ry;
      RecyclerView recordGallerySavedRy = ViewBindings.findChildViewById(rootView, id);
      if (recordGallerySavedRy == null) {
        break missingId;
      }

      id = R.id.record_input_date_tv;
      TextView recordInputDateTv = ViewBindings.findChildViewById(rootView, id);
      if (recordInputDateTv == null) {
        break missingId;
      }

      id = R.id.record_input_place_tv;
      TextView recordInputPlaceTv = ViewBindings.findChildViewById(rootView, id);
      if (recordInputPlaceTv == null) {
        break missingId;
      }

      id = R.id.record_note_et;
      TextView recordNoteEt = ViewBindings.findChildViewById(rootView, id);
      if (recordNoteEt == null) {
        break missingId;
      }

      id = R.id.record_place_tv;
      TextView recordPlaceTv = ViewBindings.findChildViewById(rootView, id);
      if (recordPlaceTv == null) {
        break missingId;
      }

      id = R.id.record_title_tv;
      TextView recordTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (recordTitleTv == null) {
        break missingId;
      }

      id = R.id.record_top;
      ConstraintLayout recordTop = ViewBindings.findChildViewById(rootView, id);
      if (recordTop == null) {
        break missingId;
      }

      return new ActivityRecordWriteBinding((ConstraintLayout) rootView, recordBackIv, recordDateTv,
          recordDeleteTv, recordEditTv, recordGallerySavedRy, recordInputDateTv, recordInputPlaceTv,
          recordNoteEt, recordPlaceTv, recordTitleTv, recordTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
