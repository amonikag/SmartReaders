package com.monika.smartreaders.MainUI;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import com.monika.smartreaders.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookViewActivity extends AppCompatActivity {
    PDFView pdfView;
    TextView email;
    private static final String TAG = "BookViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);  email=findViewById(R.id.yourmail);
       pdfView = findViewById(R.id.viewpdf);

        String filename = getIntent().getStringExtra("filename");
        String fileuri = getIntent().getStringExtra("fileurl");

        //DocumentReference c =   db.collection("USERS").document(s);

        /*c.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
           

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                       // Log.i("document data33343", "DocumentSnapshot data: " + document.getData());
                         userPhone = (String) document.get("phonenum");
                         Name=(String) document.get("name");
                    }
                }
            }
        });*/

        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle(filename);
        pd.setTitle("Opening..... !!!");

        new pdfView().execute(fileuri);
    }

    class pdfView extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream)
                    .swipeHorizontal(true)
                    .enableAnnotationRendering(true)
                    .enableDoubletap(true)
                    .load();
        }
    }

}