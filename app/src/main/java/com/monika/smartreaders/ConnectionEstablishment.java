package com.monika.smartreaders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.monika.smartreaders.ModelResponse.BookDisplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionEstablishment extends AppCompatActivity {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private String ConnectionUrl;
    private List<BookDisplay> newData;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newData = new ArrayList<>();
        Connect();
        table_load();


    }

    private void table_load() {
        try
        {
            pst = con.prepareStatement("select * from booktable");//to pass statement to sql db
            //to display all rows from table booktable
            rs = pst.executeQuery();//storing result

            //Stores properties of a ResultSet object, including column count
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                newData.add(new BookDisplay(rs.getString("author"),
                        rs.getString("bCover"),
                        rs.getString("bUri"),
                        rs.getString("description"),
                        rs.getString("title"),
                        rs.getInt("nop"),
                        rs.getInt("nov")
                        )
                );

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    private void Connect() {

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");//invoking the class
            ConnectionUrl="jdbc:jtds:sqlserver://sqlfrtdb.database.windows.net:1433;DatabaseName=frtsqldb;user=frtgreatreaders@sqlfrtdb;password={azurefrt123@};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            con = DriverManager.getConnection(ConnectionUrl);//establishing connection
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

}
