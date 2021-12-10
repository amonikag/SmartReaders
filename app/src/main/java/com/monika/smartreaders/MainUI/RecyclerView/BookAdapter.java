package com.monika.smartreaders.MainUI.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class

BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {

    List<BookDisplay> mdata;
    private static final String TAG = "BookAdapter";
    public BookAdapter(List<BookDisplay> mdata) {

        Log.d(TAG, "BookAdapter: yes im in here");
        if (mdata.size() > 0)
            Log.d(TAG, "BookAdapter: mdata in bookadap" + mdata.get(0).getAuthor());
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: in oncreate view ");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboardbook_oneitem, parent, false);
        return new bookviewholder(view);
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mdata.size());

        return mdata.size();
    }


    public void onBindViewHolder(@NonNull BookAdapter.bookviewholder holder, int position) {
        //bind book and all necessary data here
        //to display image
        Log.d(TAG, "onBindViewHolder: " + " yes");
        Glide.with(holder.title.getContext())
                .load(mdata.get(position).getCover())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.imgbook);

        holder.title.setText(mdata.get(position).getTitle());
        holder.description.setText(mdata.get(position).getDescription());
        holder.author.setText(mdata.get(position).getAuthor());
        holder.nop.setText(String.valueOf(mdata.get(position).getNop()));
        holder.nov.setText(String.valueOf(mdata.get(position).getNov()));

        holder.booksegment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(holder.author.getContext());
                builder.setMessage("Book will be visible now enjoy reading!!");
                //builder.setTitle("Information!");
                LayoutInflater inflater = LayoutInflater.from(builder.getContext());
                View view = inflater.inflate(R.layout.tp, null);

                builder.setCustomTitle(view);
                builder.setCancelable(true);
                Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.tsp);
                //Drawable alertbg = ContextCompat.getDrawable(holder.itemView.getContext(), R.layout.alert);
                builder.setPositiveButtonIcon(drawable);
                builder
                        .setPositiveButton(
                                "",
                                (dialog, which) -> {
                                    isOnline(holder.booksegment.getContext());
                                    Intent i = new Intent(holder.imgbook.getContext(), BookViewActivity.class);
                                    i.putExtra("filename", mdata.get(position).getTitle());
                                    i.putExtra("fileurl", mdata.get(position).getbUri());
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    holder.imgbook.getContext().startActivity(i);
                                    //Map<String, String> data = new HashMap<>();
                                 //   data.put(mdata.get(position).getBookID(), mdata.get(position).getbookPath());
                                });
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.efda);
                alertDialog.show();


            }
        });
    }

    private boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();


        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(context, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public class bookviewholder extends RecyclerView.ViewHolder {
        ImageView imgbook, booksegment;
        ImageButton imgfav;
        TextView title, description, author, nop, nov;
        RatingBar ratingBar;
        boolean isFav;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);
            imgbook = itemView.findViewById(R.id.bimg);
            booksegment = itemView.findViewById(R.id.booksegment);
            title = itemView.findViewById(R.id.btitle);
            description = itemView.findViewById(R.id.description);
            imgfav = itemView.findViewById(R.id.fav);
            author = itemView.findViewById(R.id.bauthor);
            nop = itemView.findViewById(R.id.nop);
            nov = itemView.findViewById(R.id.views);
        }
    }
}