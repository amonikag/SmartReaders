// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MostViewedCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView mostbauthor;

  @NonNull
  public final ImageView mostbookcover;

  @NonNull
  public final TextView mostdescription;

  @NonNull
  public final TextView mosttitle;

  @NonNull
  public final RatingBar ratingbar;

  @NonNull
  public final RelativeLayout recentlyImage;

  private MostViewedCardBinding(@NonNull CardView rootView, @NonNull TextView mostbauthor,
      @NonNull ImageView mostbookcover, @NonNull TextView mostdescription,
      @NonNull TextView mosttitle, @NonNull RatingBar ratingbar,
      @NonNull RelativeLayout recentlyImage) {
    this.rootView = rootView;
    this.mostbauthor = mostbauthor;
    this.mostbookcover = mostbookcover;
    this.mostdescription = mostdescription;
    this.mosttitle = mosttitle;
    this.ratingbar = ratingbar;
    this.recentlyImage = recentlyImage;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MostViewedCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MostViewedCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.most_viewed_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MostViewedCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mostbauthor;
      TextView mostbauthor = rootView.findViewById(id);
      if (mostbauthor == null) {
        break missingId;
      }

      id = R.id.mostbookcover;
      ImageView mostbookcover = rootView.findViewById(id);
      if (mostbookcover == null) {
        break missingId;
      }

      id = R.id.mostdescription;
      TextView mostdescription = rootView.findViewById(id);
      if (mostdescription == null) {
        break missingId;
      }

      id = R.id.mosttitle;
      TextView mosttitle = rootView.findViewById(id);
      if (mosttitle == null) {
        break missingId;
      }

      id = R.id.ratingbar;
      RatingBar ratingbar = rootView.findViewById(id);
      if (ratingbar == null) {
        break missingId;
      }

      id = R.id.recentlyImage;
      RelativeLayout recentlyImage = rootView.findViewById(id);
      if (recentlyImage == null) {
        break missingId;
      }

      return new MostViewedCardBinding((CardView) rootView, mostbauthor, mostbookcover,
          mostdescription, mosttitle, ratingbar, recentlyImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}