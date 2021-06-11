// Generated by view binder compiler. Do not edit!
package com.example.dotify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.dotify.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivProfilePic;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvEmail;

  @NonNull
  public final TextView tvIntro;

  @NonNull
  public final TextView tvJoinDate;

  @NonNull
  public final TextView tvUserName;

  private FragmentProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView ivProfilePic, @NonNull TextView tvAge, @NonNull TextView tvEmail,
      @NonNull TextView tvIntro, @NonNull TextView tvJoinDate, @NonNull TextView tvUserName) {
    this.rootView = rootView;
    this.ivProfilePic = ivProfilePic;
    this.tvAge = tvAge;
    this.tvEmail = tvEmail;
    this.tvIntro = tvIntro;
    this.tvJoinDate = tvJoinDate;
    this.tvUserName = tvUserName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivProfilePic;
      ImageView ivProfilePic = rootView.findViewById(id);
      if (ivProfilePic == null) {
        break missingId;
      }

      id = R.id.tvAge;
      TextView tvAge = rootView.findViewById(id);
      if (tvAge == null) {
        break missingId;
      }

      id = R.id.tvEmail;
      TextView tvEmail = rootView.findViewById(id);
      if (tvEmail == null) {
        break missingId;
      }

      id = R.id.tvIntro;
      TextView tvIntro = rootView.findViewById(id);
      if (tvIntro == null) {
        break missingId;
      }

      id = R.id.tvJoinDate;
      TextView tvJoinDate = rootView.findViewById(id);
      if (tvJoinDate == null) {
        break missingId;
      }

      id = R.id.tvUserName;
      TextView tvUserName = rootView.findViewById(id);
      if (tvUserName == null) {
        break missingId;
      }

      return new FragmentProfileBinding((ConstraintLayout) rootView, ivProfilePic, tvAge, tvEmail,
          tvIntro, tvJoinDate, tvUserName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
