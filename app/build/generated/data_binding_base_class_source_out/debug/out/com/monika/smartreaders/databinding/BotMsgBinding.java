// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BotMsgBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView idTVBot;

  private BotMsgBinding(@NonNull CardView rootView, @NonNull TextView idTVBot) {
    this.rootView = rootView;
    this.idTVBot = idTVBot;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static BotMsgBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BotMsgBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.bot_msg, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BotMsgBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.idTVBot;
      TextView idTVBot = rootView.findViewById(id);
      if (idTVBot == null) {
        break missingId;
      }

      return new BotMsgBinding((CardView) rootView, idTVBot);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
