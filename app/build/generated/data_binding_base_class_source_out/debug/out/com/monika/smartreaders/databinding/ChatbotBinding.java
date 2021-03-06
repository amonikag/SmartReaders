// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ChatbotBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText idEdtMessage;

  @NonNull
  public final ImageButton idIBSend;

  @NonNull
  public final LinearLayout idLLMessage;

  @NonNull
  public final RecyclerView idRVChats;

  private ChatbotBinding(@NonNull RelativeLayout rootView, @NonNull EditText idEdtMessage,
      @NonNull ImageButton idIBSend, @NonNull LinearLayout idLLMessage,
      @NonNull RecyclerView idRVChats) {
    this.rootView = rootView;
    this.idEdtMessage = idEdtMessage;
    this.idIBSend = idIBSend;
    this.idLLMessage = idLLMessage;
    this.idRVChats = idRVChats;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ChatbotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChatbotBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.chatbot, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChatbotBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.idEdtMessage;
      EditText idEdtMessage = rootView.findViewById(id);
      if (idEdtMessage == null) {
        break missingId;
      }

      id = R.id.idIBSend;
      ImageButton idIBSend = rootView.findViewById(id);
      if (idIBSend == null) {
        break missingId;
      }

      id = R.id.idLLMessage;
      LinearLayout idLLMessage = rootView.findViewById(id);
      if (idLLMessage == null) {
        break missingId;
      }

      id = R.id.idRVChats;
      RecyclerView idRVChats = rootView.findViewById(id);
      if (idRVChats == null) {
        break missingId;
      }

      return new ChatbotBinding((RelativeLayout) rootView, idEdtMessage, idIBSend, idLLMessage,
          idRVChats);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
