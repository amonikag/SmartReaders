package com.monika.smartreaders.MainUI.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.monika.smartreaders.MainUI.BookViewActivity;
import com.monika.smartreaders.ModelResponse.BookDisplay;
import com.monika.smartreaders.R;

import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.latestViewHolder> {
    List<BookDisplay> latestBooks;
    private static final String TAG = "LatestAdapter";
    public LatestAdapter(List<BookDisplay> latestBooks) {
        this.latestBooks = latestBooks;
    }

    @NonNull
    @Override
    public latestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_new_cardsingleview, parent, false);
        latestViewHolder latestViewHolder = new latestViewHolder(view);
        return latestViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LatestAdapter.latestViewHolder holder, int position) {
        BookDisplay latestrecds = latestBooks.get(position);
        holder.title.setText(latestrecds.getTitle());
        holder.desc.setText(latestrecds.getDescription());
        holder.author.setText(latestrecds.getAuthor());
        Log.d(TAG, "onBindViewHolder: "+latestBooks.size());
        Glide.with(holder.title.getContext())
                .load(latestrecds.getCover())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.image);
        holder.latestImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(holder.author.getContext());
                builder.setMessage("Book will be visible after ad.\nThis book will be unlocked for next 1 hour!! Enjoy ads free book reading!!");
                //builder.setTitle("Information!");
                LayoutInflater inflater = LayoutInflater.from(builder.getContext());
                View view = inflater.inflate(R.layout.tp, null);

                builder.setCustomTitle(view);
                builder.setCancelable(true);
                Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.tsp);
                builder.setPositiveButtonIcon(drawable);
                builder
                        .setPositiveButton(
                                "",
                                (dialog, which) -> {
                Intent i = new Intent(holder.title.getContext(), BookViewActivity.class);
                i.putExtra("filename", latestBooks.get(position).getTitle());
                i.putExtra("fileurl", latestBooks.get(position).getbUri());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.title.getContext().startActivity(i);});
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.efda);
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return latestBooks.size();
    }

    public static class latestViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc, author,infortext;
        LinearLayout latestImage;

        public latestViewHolder(@NonNull View itemView) {
            super(itemView);
            //Hooks
            latestImage=itemView.findViewById(R.id.latestImage);
            image = itemView.findViewById(R.id.latestbookcover);
            title = itemView.findViewById(R.id.latestbooktitle);
            desc = itemView.findViewById(R.id.latestdescription);
            author = itemView.findViewById(R.id.latestbauthor);
        }
    }
}
