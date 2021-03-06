// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DrawerMenuBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final RecyclerView drawerList;

  private DrawerMenuBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull RecyclerView drawerList) {
    this.rootView = rootView;
    this.drawerList = drawerList;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static DrawerMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DrawerMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.drawer_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DrawerMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.drawer_list;
      RecyclerView drawerList = rootView.findViewById(id);
      if (drawerList == null) {
        break missingId;
      }

      return new DrawerMenuBinding((LinearLayoutCompat) rootView, drawerList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
