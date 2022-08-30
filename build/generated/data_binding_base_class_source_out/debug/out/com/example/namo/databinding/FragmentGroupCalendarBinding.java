// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGroupCalendarBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout groupCalendarLayout;

  @NonNull
  public final RecyclerView groupCalendarView;

  @NonNull
  public final TextView groupCalendarYearMonthText;

  private FragmentGroupCalendarBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout groupCalendarLayout, @NonNull RecyclerView groupCalendarView,
      @NonNull TextView groupCalendarYearMonthText) {
    this.rootView = rootView;
    this.groupCalendarLayout = groupCalendarLayout;
    this.groupCalendarView = groupCalendarView;
    this.groupCalendarYearMonthText = groupCalendarYearMonthText;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGroupCalendarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGroupCalendarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_group_calendar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGroupCalendarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.group_calendar_layout;
      LinearLayout groupCalendarLayout = ViewBindings.findChildViewById(rootView, id);
      if (groupCalendarLayout == null) {
        break missingId;
      }

      id = R.id.group_calendar_view;
      RecyclerView groupCalendarView = ViewBindings.findChildViewById(rootView, id);
      if (groupCalendarView == null) {
        break missingId;
      }

      id = R.id.group_calendar_year_month_text;
      TextView groupCalendarYearMonthText = ViewBindings.findChildViewById(rootView, id);
      if (groupCalendarYearMonthText == null) {
        break missingId;
      }

      return new FragmentGroupCalendarBinding((LinearLayout) rootView, groupCalendarLayout,
          groupCalendarView, groupCalendarYearMonthText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
