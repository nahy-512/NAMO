// Generated by view binder compiler. Do not edit!
package com.example.namo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.example.namo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentViewPagerBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout indicator;

  @NonNull
  public final ImageView indicator0Iv;

  @NonNull
  public final ImageView indicator1Iv;

  @NonNull
  public final ImageView indicator2Iv;

  @NonNull
  public final ImageView indicator3Iv;

  @NonNull
  public final ImageView indicator4Iv;

  @NonNull
  public final ViewPager2 viewPagerOnboarding;

  private FragmentViewPagerBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout indicator,
      @NonNull ImageView indicator0Iv, @NonNull ImageView indicator1Iv,
      @NonNull ImageView indicator2Iv, @NonNull ImageView indicator3Iv,
      @NonNull ImageView indicator4Iv, @NonNull ViewPager2 viewPagerOnboarding) {
    this.rootView = rootView;
    this.indicator = indicator;
    this.indicator0Iv = indicator0Iv;
    this.indicator1Iv = indicator1Iv;
    this.indicator2Iv = indicator2Iv;
    this.indicator3Iv = indicator3Iv;
    this.indicator4Iv = indicator4Iv;
    this.viewPagerOnboarding = viewPagerOnboarding;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentViewPagerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentViewPagerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_view_pager, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentViewPagerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.indicator;
      LinearLayout indicator = ViewBindings.findChildViewById(rootView, id);
      if (indicator == null) {
        break missingId;
      }

      id = R.id.indicator0_iv;
      ImageView indicator0Iv = ViewBindings.findChildViewById(rootView, id);
      if (indicator0Iv == null) {
        break missingId;
      }

      id = R.id.indicator1_iv;
      ImageView indicator1Iv = ViewBindings.findChildViewById(rootView, id);
      if (indicator1Iv == null) {
        break missingId;
      }

      id = R.id.indicator2_iv;
      ImageView indicator2Iv = ViewBindings.findChildViewById(rootView, id);
      if (indicator2Iv == null) {
        break missingId;
      }

      id = R.id.indicator3_iv;
      ImageView indicator3Iv = ViewBindings.findChildViewById(rootView, id);
      if (indicator3Iv == null) {
        break missingId;
      }

      id = R.id.indicator4_iv;
      ImageView indicator4Iv = ViewBindings.findChildViewById(rootView, id);
      if (indicator4Iv == null) {
        break missingId;
      }

      id = R.id.viewPager_onboarding;
      ViewPager2 viewPagerOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (viewPagerOnboarding == null) {
        break missingId;
      }

      return new FragmentViewPagerBinding((FrameLayout) rootView, indicator, indicator0Iv,
          indicator1Iv, indicator2Iv, indicator3Iv, indicator4Iv, viewPagerOnboarding);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
