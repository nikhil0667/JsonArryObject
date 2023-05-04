package com.example.jsonarryobject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
           @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.text2);
        Intent intent1 = getIntent();
        textView.setText(intent1.getStringExtra("data"));
        Intent in = new Intent(MainActivity2.this, MainActivity.class);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(in);


            }

        }, 4000);
    }
}