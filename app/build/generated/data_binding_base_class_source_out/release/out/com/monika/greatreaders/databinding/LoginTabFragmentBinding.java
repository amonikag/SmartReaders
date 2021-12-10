// Generated by view binder compiler. Do not edit!
package com.monika.greatreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.hbb20.CountryCodePicker;
import com.monika.greatreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LoginTabFragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CountryCodePicker ccp;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final Button login;

  @NonNull
  public final EditText phoneno;

  private LoginTabFragmentBinding(@NonNull ConstraintLayout rootView,
      @NonNull CountryCodePicker ccp, @NonNull LinearLayout linearLayout, @NonNull Button login,
      @NonNull EditText phoneno) {
    this.rootView = rootView;
    this.ccp = ccp;
    this.linearLayout = linearLayout;
    this.login = login;
    this.phoneno = phoneno;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LoginTabFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LoginTabFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.login_tab_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LoginTabFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ccp;
      CountryCodePicker ccp = rootView.findViewById(id);
      if (ccp == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = rootView.findViewById(id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.login;
      Button login = rootView.findViewById(id);
      if (login == null) {
        break missingId;
      }

      id = R.id.phoneno;
      EditText phoneno = rootView.findViewById(id);
      if (phoneno == null) {
        break missingId;
      }

      return new LoginTabFragmentBinding((ConstraintLayout) rootView, ccp, linearLayout, login,
          phoneno);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
