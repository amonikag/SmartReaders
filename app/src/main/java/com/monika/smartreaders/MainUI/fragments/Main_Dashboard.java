package com.monika.smartreaders.MainUI.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monika.smartreaders.ChatBot;
import com.monika.smartreaders.MainUI.RecyclerView.LatestAdapter;
import com.monika.smartreaders.MainUI.RecyclerView.recentlyViewedAdapter;
import com.monika.smartreaders.MainUI.innerBooks.BookListDisplay;
import com.monika.smartreaders.MainUI.innerBooks.NewSection;
import com.monika.smartreaders.ModelResponse.BookDisplay;
import com.monika.smartreaders.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main_Dashboard extends Fragment {

    private RecyclerView recentlyViewed;
    private RecyclerView toprated;
    private RecyclerView latestRecycler;
    ImageView CE, bsection, novels;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private static final String TAG = "CustomDashboard";
    private recentlyViewedAdapter recentlyAdapter;
    private LatestAdapter latestAdapter;
    ImageView chatbot;
    private String ConnectionUrl;

    private List<BookDisplay> recentlyRecordsListt;
    //private List<topRatedRecords> topRatedRecordsList;
    private List<com.monika.smartreaders.ModelResponse.BookDisplay> latestlist;
    String email;
    TextView recntText;



    private void table_load() {

        try {
            pst = con.prepareStatement("select * from latestdetails");//to pass statement to sql db
            //to display all rows from table booktable
            rs = pst.executeQuery();
            System.out.println(rs);//storing result

            //Stores properties of a ResultSet object, including column count
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                latestlist.add(new BookDisplay(rs.getString("author"),
                                rs.getString("bCover"),
                                rs.getString("bUri"),
                                rs.getString("description"),
                                rs.getString("title"),
                                rs.getInt("nop"),
                                rs.getInt("nov")
                        )
                );
            }
            latestAdapter.notifyDataSetChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_custom_dashboard, container, false);



        //Hooks
        latestRecycler = root.findViewById(R.id.latest_recycler);
        recentlyViewed = root.findViewById(R.id.recentlyViewed);
        bsection = root.findViewById(R.id.bsection);
        novels = root.findViewById(R.id.news);
        CE = root.findViewById(R.id.CE);
        chatbot = root.findViewById(R.id.chatbot);



        recentlyRecordsListt = new ArrayList<>();
        latestlist = new ArrayList<>();

        recntText = root.findViewById(R.id.recenttext);
        recentlyViewed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        recentlyAdapter = new recentlyViewedAdapter(recentlyRecordsListt);
        recentlyViewed.setAdapter(recentlyAdapter);
        recentlyViewed.setHasFixedSize(true);


        latestRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true));
        latestAdapter = new LatestAdapter(latestlist);
        latestRecycler.setAdapter(latestAdapter);
        latestRecycler.setHasFixedSize(true);


        //Methods of onclick for image buttons
        bsection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "booksSection";
                Intent intent = new Intent(getContext(), BookListDisplay .class);
                startActivity(intent);
            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ChatBot.class);
                startActivity(i);
            }
        });


        novels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewSection.class);
                intent.putExtra("info", "newssection");
                startActivity(intent);
            }
        });

        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "CE";
                Intent intent = new Intent(getContext(), BookListDisplay.class);
                intent.putExtra("info", s);
                startActivity(intent);
            }
        });

        Log.d(TAG, "onCreate: "+"1s s");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Log.d(TAG, "doInBackground: "+"insidethis" +
                    "jjfdsjjds");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");//invoking the class
            ConnectionUrl="jdbc:jtds:sqlserver://sqlfrtdb.database.windows.net:1433;DatabaseName=frtsqldb;user=frtgreatreaders@sqlfrtdb;password=azurefrt123@;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;ssl=require";
            con= DriverManager.getConnection(ConnectionUrl);
            Log.d(TAG, "doInBackground: "+"successfulllllllllllllllll");
            table_load();
            table_load_toprated();
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }

        Log.d(TAG, "onCreate: "+"huh");


        return root;
    }

    private void table_load_toprated() {

            try {
                pst = con.prepareStatement("select * from noveldetails");//to pass statement to sql db
                //to display all rows from table booktable
                rs = pst.executeQuery();
                System.out.println(rs);//storing result

                //Stores properties of a ResultSet object, including column count
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                while (rs.next()) {
                    recentlyRecordsListt.add(new BookDisplay(rs.getString("author"),
                                    rs.getString("bCover"),
                                    rs.getString("bUri"),
                                    rs.getString("description"),
                                    rs.getString("title"),
                                    rs.getInt("nop"),
                                    rs.getInt("nov")
                            )
                    );
                }
                recentlyAdapter.notifyDataSetChanged();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: " + "inside neg_branch");

        super.onDestroy();
        requireActivity().finish();
    }
}

