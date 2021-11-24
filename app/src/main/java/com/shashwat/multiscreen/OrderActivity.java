package com.shashwat.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MSG);

        // Set text inside textview to display this message
        TextView textView = findViewById(R.id.textView4);
        textView.setText(message);

    }
}