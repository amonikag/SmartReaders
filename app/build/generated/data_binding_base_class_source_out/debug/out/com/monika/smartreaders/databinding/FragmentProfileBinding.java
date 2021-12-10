// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView editTextTextEmailAddress;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final LinearLayout profile;

  @NonNull
  public final TextView textView6;

  private FragmentProfileBinding(@NonNull LinearLayout rootView,
      @NonNull TextView editTextTextEmailAddress, @NonNull ImageView imageView4,
      @NonNull LinearLayout profile, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.editTextTextEmailAddress = editTextTextEmailAddress;
    this.imageView4 = imageView4;
    this.profile = profile;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
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
      id = R.id.editTextTextEmailAddress;
      TextView editTextTextEmailAddress = rootView.findViewById(id);
      if (editTextTextEmailAddress == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = rootView.findViewById(id);
      if (imageView4 == null) {
        break missingId;
      }

      LinearLayout profile = (LinearLayout) rootView;

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      return new FragmentProfileBinding((LinearLayout) rootView, editTextTextEmailAddress,
          imageView4, profile, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
