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

public final class FragmentStatisticsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivAlbumCover;

  @NonNull
  public final TextView tvSongCount;

  @NonNull
  public final TextView tvSongStat;

  @NonNull
  public final TextView tvSongTitle;

  private FragmentStatisticsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView ivAlbumCover, @NonNull TextView tvSongCount, @NonNull TextView tvSongStat,
      @NonNull TextView tvSongTitle) {
    this.rootView = rootView;
    this.ivAlbumCover = ivAlbumCover;
    this.tvSongCount = tvSongCount;
    this.tvSongStat = tvSongStat;
    this.tvSongTitle = tvSongTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentStatisticsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentStatisticsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_statistics, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentStatisticsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivAlbumCover;
      ImageView ivAlbumCover = rootView.findViewById(id);
      if (ivAlbumCover == null) {
        break missingId;
      }

      id = R.id.tvSongCount;
      TextView tvSongCount = rootView.findViewById(id);
      if (tvSongCount == null) {
        break missingId;
      }

      id = R.id.tvSongStat;
      TextView tvSongStat = rootView.findViewById(id);
      if (tvSongStat == null) {
        break missingId;
      }

      id = R.id.tvSongTitle;
      TextView tvSongTitle = rootView.findViewById(id);
      if (tvSongTitle == null) {
        break missingId;
      }

      return new FragmentStatisticsBinding((ConstraintLayout) rootView, ivAlbumCover, tvSongCount,
          tvSongStat, tvSongTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
