// Generated by view binder compiler. Do not edit!
package com.folioreader.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.folioreader.R;
import com.folioreader.ui.view.DirectionalViewpager;
import com.folioreader.ui.view.FolioAppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FolioActivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FolioAppBarLayout appBarLayout;

  @NonNull
  public final DirectionalViewpager folioPageViewPager;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final Toolbar toolbar;

  private FolioActivityBinding(@NonNull ConstraintLayout rootView,
      @NonNull FolioAppBarLayout appBarLayout, @NonNull DirectionalViewpager folioPageViewPager,
      @NonNull ConstraintLayout main, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.folioPageViewPager = folioPageViewPager;
    this.main = main;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FolioActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FolioActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.folio_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FolioActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      FolioAppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.folioPageViewPager;
      DirectionalViewpager folioPageViewPager = ViewBindings.findChildViewById(rootView, id);
      if (folioPageViewPager == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FolioActivityBinding((ConstraintLayout) rootView, appBarLayout, folioPageViewPager,
          main, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
