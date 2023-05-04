package com.example.jsonarryobject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  JSONObject obj;
    private String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FindView Id
//        TextView textView = findViewById(R.id.text);
//        TextView textView1 = findViewById(R.id.text1);
//        TextView textView2 = findViewById(R.id.text2);
        ListView listView = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arrayList);

//        RequestQueue
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        obj = response.getJSONObject(i);
                        arrayList.add("UserId :- " + obj.getString("userId") + "\nId :- " + obj.getString("id") + "\nTitle :- " + obj.getString("title") + "\nCompleted :- " + obj.getString("completed"));
                        listView.setAdapter(adapter);
                    }
//                            textView.setText(response.getString("userId"));
//                            textView.setText(response.getString("id"));
//                            textView.setText(response.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

//    }
//});
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView) view).getText().toString();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",text);
               startActivity(intent);
//                Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    }
