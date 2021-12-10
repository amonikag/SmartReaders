package com.monika.smartreaders.MainUI.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.monika.smartreaders.MainUI.BookViewActivity;
import com.monika.smartreaders.ModelResponse.BookDisplay;
import com.monika.smartreaders.R;

import java.util.List;

public class recentlyViewedAdapter extends RecyclerView.Adapter<recentlyViewedAdapter.recentholder> {
    private List<BookDisplay> mdata;

    public recentlyViewedAdapter(List<BookDisplay> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public recentlyViewedAdapter.recentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.most_viewed_card, parent, false);
        return new recentholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recentlyViewedAdapter.recentholder holder, int position) {
        BookDisplay latestrecds = mdata.get(position);
        holder.title.setText(latestrecds.getTitle());
        holder.desc.setText(latestrecds.getDescription());
        holder.author.setText(latestrecds.getAuthor());
        Glide.with(holder.title.getContext())
                .load(latestrecds.getCover())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.image);
        holder.recentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.title.getContext(), BookViewActivity.class);
                i.putExtra("filename", mdata.get(position).getTitle());
                i.putExtra("fileurl", mdata.get(position).getbUri());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.title.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class recentholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc, author;
        RelativeLayout recentImage;

        public recentholder(@NonNull View itemView) {
            super(itemView);
            //Hooks

            recentImage=itemView.findViewById(R.id.recentlyImage);
            image = itemView.findViewById(R.id.mostbookcover);
            title = itemView.findViewById(R.id.mosttitle);
            desc = itemView.findViewById(R.id.mostdescription);
            author = itemView.findViewById(R.id.mostbauthor);
        }


    }
}
