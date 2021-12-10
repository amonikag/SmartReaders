package com.monika.smartreaders.MainUI.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monika.smartreaders.MainUI.RecyclerView.BookAdapter;
import com.monika.smartreaders.ModelResponse.BookDisplay;
import com.monika.smartreaders.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Home extends Fragment {
    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;
    private List<BookDisplay> mdata;
    private static final String TAG = "Home";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard_fragment, container, false);

        mdata = new ArrayList<>();

        rvBooks = root.findViewById(R.id.rv_book);
        rvBooks.setLayoutManager(new LinearLayoutManager(getActivity()));
        bookAdapter = new BookAdapter(mdata);
        rvBooks.setAdapter(bookAdapter);
        rvBooks.setHasFixedSize(true);



        return root;
    }

}
