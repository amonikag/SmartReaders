package com.monika.smartreaders.MainUI.innerBooks;

import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monika.smartreaders.MainUI.RecyclerView.BookAdapter;
import com.monika.smartreaders.ModelResponse.BookDisplay;
import com.monika.smartreaders.R;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookListDisplay extends AppCompatActivity{

    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;
    private List<BookDisplay> mdata;
    private static final String TAG = "Home";

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private String ConnectionUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_fragment);
        mdata = new ArrayList<>();

        rvBooks =findViewById(R.id.rv_book);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        bookAdapter = new BookAdapter(mdata);
        rvBooks.setAdapter(bookAdapter);
        rvBooks.setHasFixedSize(true);

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
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }

        Log.d(TAG, "onCreate: "+"huh");
    }


    private void table_load() {

        try {
            pst = con.prepareStatement("select * from noveldetails");//to pass statement to sql db
            //to display all rows from table booktable
            rs = pst.executeQuery();
            System.out.println(rs);//storing result

            //Stores properties of a ResultSet object, including column count
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                mdata.add(new BookDisplay(rs.getString("author"),
                                rs.getString("bCover"),
                                rs.getString("bUri"),
                                rs.getString("description"),
                                rs.getString("title"),
                                rs.getInt("nop"),
                                rs.getInt("nov")
                        )
                );
            }
            bookAdapter.notifyDataSetChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
