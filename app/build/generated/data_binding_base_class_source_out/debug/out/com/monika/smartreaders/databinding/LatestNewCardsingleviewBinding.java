// Generated by view binder compiler. Do not edit!
package com.monika.smartreaders.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.monika.smartreaders.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LatestNewCardsingleviewBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LinearLayout latestImage;

  @NonNull
  public final TextView latestbauthor;

  @NonNull
  public final ImageView latestbookcover;

  @NonNull
  public final TextView latestbooktitle;

  @NonNull
  public final TextView latestdescription;

  @NonNull
  public final RatingBar ratingbar;

  private LatestNewCardsingleviewBinding(@NonNull CardView rootView,
      @NonNull LinearLayout latestImage, @NonNull TextView latestbauthor,
      @NonNull ImageView latestbookcover, @NonNull TextView latestbooktitle,
      @NonNull TextView latestdescription, @NonNull RatingBar ratingbar) {
    this.rootView = rootView;
    this.latestImage = latestImage;
    this.latestbauthor = latestbauthor;
    this.latestbookcover = latestbookcover;
    this.latestbooktitle = latestbooktitle;
    this.latestdescription = latestdescription;
    this.ratingbar = ratingbar;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LatestNewCardsingleviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LatestNewCardsingleviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.latest_new_cardsingleview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LatestNewCardsingleviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.latestImage;
      LinearLayout latestImage = rootView.findViewById(id);
      if (latestImage == null) {
        break missingId;
      }

      id = R.id.latestbauthor;
      TextView latestbauthor = rootView.findViewById(id);
      if (latestbauthor == null) {
        break missingId;
      }

      id = R.id.latestbookcover;
      ImageView latestbookcover = rootView.findViewById(id);
      if (latestbookcover == null) {
        break missingId;
      }

      id = R.id.latestbooktitle;
      TextView latestbooktitle = rootView.findViewById(id);
      if (latestbooktitle == null) {
        break missingId;
      }

      id = R.id.latestdescription;
      TextView latestdescription = rootView.findViewById(id);
      if (latestdescription == null) {
        break missingId;
      }

      id = R.id.ratingbar;
      RatingBar ratingbar = rootView.findViewById(id);
      if (ratingbar == null) {
        break missingId;
      }

      return new LatestNewCardsingleviewBinding((CardView) rootView, latestImage, latestbauthor,
          latestbookcover, latestbooktitle, latestdescription, ratingbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
