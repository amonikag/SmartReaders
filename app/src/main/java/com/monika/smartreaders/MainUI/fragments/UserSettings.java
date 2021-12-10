package com.monika.smartreaders.MainUI.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monika.smartreaders.MainUI.Dashboard;
import com.monika.smartreaders.ModelResponse.SettingsModel;
import com.monika.smartreaders.ModelResponse.SettingsViewModel;
import com.monika.smartreaders.R;

import java.util.ArrayList;




public class UserSettings extends Fragment {

    private SettingsViewModel settingsViewModel;
    RecyclerView recyclerView;
    String[] set = {"Account", "Help & Support ", "Rate us on Play Store", "Privacy policy", "Terms and conditions", "About us"};

    private Callbacks mCallback;

    public interface Callbacks {
        void onReplaceFragment(Integer fragment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Dashboard) {
            mCallback = (Callbacks) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        ArrayList<SettingsModel> list = new ArrayList<>();
        list.add(new SettingsModel(R.drawable.settings_account, set[0]));
        list.add(new SettingsModel(R.drawable.color_help, set[1]));
        list.add(new SettingsModel(R.drawable.color_rateus, set[2]));
        list.add(new SettingsModel(R.drawable.lock_y, set[3]));
        list.add(new SettingsModel(R.drawable.color_tnc, set[4]));
        list.add(new SettingsModel(R.drawable.color_aboutus, set[5]));


        SettingsAdapter adapter = new SettingsAdapter(list, getActivity());
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return root;
    }


    class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {
        ArrayList<SettingsModel> list;
        Context context;

        public SettingsAdapter(ArrayList<SettingsModel> list, FragmentActivity context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public SettingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_listview, parent, false);
            return new SettingsAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SettingsAdapter.ViewHolder holder, int position) {
            SettingsModel settingsModel = list.get(position);
            holder.imageView.setImageResource(settingsModel.getPic());
            holder.textView.setText(settingsModel.getText());
            switch (position) {
                case 0:
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCallback.onReplaceFragment(R.id.profile);

                        }

                        ;

                        //.beginTransaction().replace(R.id.profile, new tasks()).commit();
                    });


                    break;
                case 1:
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                            context.startActivity(intent);
                        }


                    });
                    break;
                case 2:
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse("https://github.com/amonikag/"));
                            context.startActivity(i);
                        }
                    });
                    break;
                case 3:
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.linkedin.com/in/monika-anabathula-29b58316a"));
                            context.startActivity(intent);
                        }
                    });
                    break;
                case 4:
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.microsoft.com/en-us/users/monikaanabathula-4364/"));
                            context.startActivity(intent);
                        }
                    });


                    break;
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.listImage);
                textView = itemView.findViewById(R.id.textView);
            }
        }

    }
}

