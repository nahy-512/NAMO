// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAlertPopupBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView alert10MinAgo;

  @NonNull
  public final TextView alert15MinAgo;

  @NonNull
  public final TextView alert1HourAgo;

  @NonNull
  public final TextView alert30Ago;

  @NonNull
  public final TextView alert3HourAgo;

  @NonNull
  public final TextView alert5MinAgo;

  private ActivityAlertPopupBinding(@NonNull LinearLayout rootView, @NonNull TextView alert10MinAgo,
      @NonNull TextView alert15MinAgo, @NonNull TextView alert1HourAgo,
      @NonNull TextView alert30Ago, @NonNull TextView alert3HourAgo,
      @NonNull TextView alert5MinAgo) {
    this.rootView = rootView;
    this.alert10MinAgo = alert10MinAgo;
    this.alert15MinAgo = alert15MinAgo;
    this.alert1HourAgo = alert1HourAgo;
    this.alert30Ago = alert30Ago;
    this.alert3HourAgo = alert3HourAgo;
    this.alert5MinAgo = alert5MinAgo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAlertPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAlertPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_alert_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAlertPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alert_10_min_ago;
      TextView alert10MinAgo = ViewBindings.findChildViewById(rootView, id);
      if (alert10MinAgo == null) {
        break missingId;
      }

      id = R.id.alert_15_min_ago;
      TextView alert15MinAgo = ViewBindings.findChildViewById(rootView, id);
      if (alert15MinAgo == null) {
        break missingId;
      }

      id = R.id.alert_1_hour_ago;
      TextView alert1HourAgo = ViewBindings.findChildViewById(rootView, id);
      if (alert1HourAgo == null) {
        break missingId;
      }

      id = R.id.alert_30_ago;
      TextView alert30Ago = ViewBindings.findChildViewById(rootView, id);
      if (alert30Ago == null) {
        break missingId;
      }

      id = R.id.alert_3_hour_ago;
      TextView alert3HourAgo = ViewBindings.findChildViewById(rootView, id);
      if (alert3HourAgo == null) {
        break missingId;
      }

      id = R.id.alert_5_min_ago;
      TextView alert5MinAgo = ViewBindings.findChildViewById(rootView, id);
      if (alert5MinAgo == null) {
        break missingId;
      }

      return new ActivityAlertPopupBinding((LinearLayout) rootView, alert10MinAgo, alert15MinAgo,
          alert1HourAgo, alert30Ago, alert3HourAgo, alert5MinAgo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
