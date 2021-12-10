package com.monika.smartreaders.MainUI;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.monika.smartreaders.DrawerAdapter;
import com.monika.smartreaders.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder> {

    private int selectedItemIcon_int;
    private int selectedItemText_int;

    private int normalItemIcon_int;
    private int normalItemText_int;

    private Drawable icon;
    private String title;

    public SimpleItem(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_option, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.title.setText(title);
        holder.icon.setImageDrawable(icon);
        holder.title.setTextColor(isChecked ? selectedItemText_int : normalItemText_int);
        holder.icon.setColorFilter(isChecked ? selectedItemIcon_int : normalItemIcon_int);
    }

    public SimpleItem withSelectedIconInt(int selectedIconInt) {
        this.selectedItemIcon_int = selectedIconInt;
        return this;
    }

    public SimpleItem withSelectedTextInt(int selectedItemTextInt) {
        this.selectedItemText_int = selectedItemTextInt;
        return this;
    }

    public SimpleItem withIconInt(int normalItemIconInt) {
        this.normalItemIcon_int = normalItemIconInt;
        return this;
    }

    public SimpleItem withTextInt(int normalItemTextInt) {
        this.normalItemText_int = normalItemTextInt;
        return this;
    }

    static class ViewHolder extends DrawerAdapter.ViewHolder {

        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }
}
