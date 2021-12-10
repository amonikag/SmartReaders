package com.monika.smartreaders;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.monika.smartreaders.MainUI.RecyclerView.MessageRVAdapter;
import com.monika.smartreaders.ModelResponse.ChatbotModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatBot extends AppCompatActivity {

    // creating variables for our
    // widgets in xml file.
    private RecyclerView chatsRV;
    private ImageButton sendMsgIB;
    private EditText userMsgEdt;
    private final String USER_KEY = "user";
    private final String BOT_KEY = "bot";

    // creating a variable for
    // our volley request queue.
    private RequestQueue mRequestQueue;
    private static final String TAG = "ChatBot";

    // creating a variable for array list and adapter class.
    private ArrayList<ChatbotModel> messageModalArrayList;
    private MessageRVAdapter messageRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatbot);

        // on below line we are initializing all our views.
        chatsRV = findViewById(R.id.idRVChats);
        sendMsgIB = findViewById(R.id.idIBSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

        // below line is to initialize our request queue.
        mRequestQueue = Volley.newRequestQueue(ChatBot.this);
        mRequestQueue.getCache().clear();

        // creating a new array list
        messageModalArrayList = new ArrayList<>();

        /* Note QnAMakerManager.authenticate() does not set the baseUrl paramater value
         * as the value for QnAMakerClient.endpoint, so we still need to call withEndpoint().
         */
       /* QnAMakerClient authoring_client = QnAMakerManager.authenticate(authoring_key).withEndpoint(authoring_endpoint);
        Knowledgebases kb_client = authoring_client.knowledgebases();
        Operations ops_client = authoring_client.operations();
        EndpointKeys keys_client = authoring_client.endpointKeys();
*/
        // adding on click listener for send message button.
        sendMsgIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking if the message entered
                // by user is empty or not.
                if (userMsgEdt.getText().toString().isEmpty()) {
                    // if the edit text is empty display a toast message.
                    Toast.makeText(ChatBot.this, "Please enter your message..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // calling a method to send message
                // to our bot to get response.
                //sendMessage(userMsgEdt.getText().toString());
                RetrieveFeedTask task = new RetrieveFeedTask();
                task.execute();

                // below line we are setting text in our edit text as empty
                userMsgEdt.setText("");
            }
        });

        // on below line we are initialing our adapter class and passing our array list to it.
        messageRVAdapter = new MessageRVAdapter(messageModalArrayList, this);

        // below line we are creating a variable for our linear layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatBot.this, RecyclerView.VERTICAL, false);

        // below line is to set layout
        // manager to our recycler view.
        chatsRV.setLayoutManager(linearLayoutManager);

        // below line we are setting
        // adapter to our recycler view.
        chatsRV.setAdapter(messageRVAdapter);
    }

    public String[] GetText() throws UnsupportedEncodingException {

        String text = "";
        String question="";
        String[] answer = new String[2];
        BufferedReader reader = null;

        // Send data
        try {

            // Defined URL  where to send data
            URL url = new URL("https://chatbotsmartreaders.azurewebsites.net/qnamaker/knowledgebases/e39b0468-98eb-4f41-988e-39866f3e54de/generateAnswer");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestProperty("Authorization", "EndpointKey d7df6f36-f23d-4e61-a9d2-5a233d4a0af5");
            conn.setRequestProperty("Content-Type", "application/json");

            //Create JSONObject here
            JSONObject jsonParam = new JSONObject();
            question=userMsgEdt.getText().toString();
            jsonParam.put("question",question );


            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//            wr.write(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            wr.write(jsonParam.toString());
            wr.flush();
            Log.d("karma", "json is " + jsonParam);

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;


            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
            Log.d("karma ", "response is " + text);
            JSONObject obj = new JSONObject(text);
            JSONArray arr = obj.getJSONArray("answers");

            answer[0] =question;
            answer[1] = arr.getJSONObject(0).getString("answer");
            Log.d(TAG, "GetText: " +question);
        } catch (Exception ex) {
            Log.d("karma", "exception at last " + ex);
        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
            }
        }

        return answer;
    }


    class RetrieveFeedTask extends AsyncTask<Void, Void, String[]> {
        String answer[] = new String[2];

        @Override
        protected String[] doInBackground(Void... voids) {
            try {
                Log.d("karma", "called");
                answer = GetText();
                Log.d("karma", "after called" + Arrays.toString(answer));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Log.d("karma", "Exception occurred " + e);
            }
            return answer;
        }

        @Override
        protected void onPostExecute(String[] strings) {
            super.onPostExecute(strings);
            messageModalArrayList.add(new ChatbotModel(strings[0], USER_KEY));
            messageRVAdapter.notifyDataSetChanged();
            messageModalArrayList.add(new ChatbotModel(strings[1], BOT_KEY));
            messageRVAdapter.notifyDataSetChanged();
        }
    }

}


