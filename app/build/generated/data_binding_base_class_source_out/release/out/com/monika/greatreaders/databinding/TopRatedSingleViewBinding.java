// Generated by view binder compiler. Do not edit!
package com.monika.greatreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.monika.greatreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TopRatedSingleViewBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView bauthor;

  @NonNull
  public final ImageView bookcover;

  @NonNull
  public final RatingBar ratingbar;

  @NonNull
  public final TextView title;

  private TopRatedSingleViewBinding(@NonNull CardView rootView, @NonNull TextView bauthor,
      @NonNull ImageView bookcover, @NonNull RatingBar ratingbar, @NonNull TextView title) {
    this.rootView = rootView;
    this.bauthor = bauthor;
    this.bookcover = bookcover;
    this.ratingbar = ratingbar;
    this.title = title;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static TopRatedSingleViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TopRatedSingleViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.top_rated_single_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TopRatedSingleViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bauthor;
      TextView bauthor = rootView.findViewById(id);
      if (bauthor == null) {
        break missingId;
      }

      id = R.id.bookcover;
      ImageView bookcover = rootView.findViewById(id);
      if (bookcover == null) {
        break missingId;
      }

      id = R.id.ratingbar;
      RatingBar ratingbar = rootView.findViewById(id);
      if (ratingbar == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = rootView.findViewById(id);
      if (title == null) {
        break missingId;
      }

      return new TopRatedSingleViewBinding((CardView) rootView, bauthor, bookcover, ratingbar,
          title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
