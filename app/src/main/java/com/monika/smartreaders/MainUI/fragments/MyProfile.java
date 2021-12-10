package com.monika.smartreaders.MainUI.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.monika.smartreaders.MainUI.Dashboard;
import com.monika.smartreaders.ModelResponse.ProfileViewModel;
import com.monika.smartreaders.R;


public class MyProfile extends Fragment {
    private static final String TAG = "MyProfile";
    private ProfileViewModel profileViewModel;
    TextView email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        email= root.findViewById(R.id.editTextTextEmailAddress);
        Dashboard dashboard=(Dashboard) getActivity();

        email.setText(dashboard.getData());
        return root;
    }




}
