// Generated by view binder compiler. Do not edit!
package com.folioreader.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.folioreader.R;
import com.folioreader.ui.view.LoadingView;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ItemSearchLoadingBinding implements ViewBinding {
  @NonNull
  private final LoadingView rootView;

  private ItemSearchLoadingBinding(@NonNull LoadingView rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public LoadingView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemSearchLoadingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemSearchLoadingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_search_loading, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemSearchLoadingBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ItemSearchLoadingBinding((LoadingView) rootView);
  }
}
