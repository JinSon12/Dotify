// Generated by view binder compiler. Do not edit!
package com.example.dotify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.dotify.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAboutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvCreator;

  @NonNull
  public final TextView tvHelp;

  @NonNull
  public final TextView tvSchool;

  @NonNull
  public final TextView tvVersion;

  private FragmentAboutBinding(@NonNull ConstraintLayout rootView, @NonNull TextView tvCreator,
      @NonNull TextView tvHelp, @NonNull TextView tvSchool, @NonNull TextView tvVersion) {
    this.rootView = rootView;
    this.tvCreator = tvCreator;
    this.tvHelp = tvHelp;
    this.tvSchool = tvSchool;
    this.tvVersion = tvVersion;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvCreator;
      TextView tvCreator = rootView.findViewById(id);
      if (tvCreator == null) {
        break missingId;
      }

      id = R.id.tvHelp;
      TextView tvHelp = rootView.findViewById(id);
      if (tvHelp == null) {
        break missingId;
      }

      id = R.id.tvSchool;
      TextView tvSchool = rootView.findViewById(id);
      if (tvSchool == null) {
        break missingId;
      }

      id = R.id.tvVersion;
      TextView tvVersion = rootView.findViewById(id);
      if (tvVersion == null) {
        break missingId;
      }

      return new FragmentAboutBinding((ConstraintLayout) rootView, tvCreator, tvHelp, tvSchool,
          tvVersion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
