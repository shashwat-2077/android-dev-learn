package com.shashwat.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView = findViewById(R.id.imageView);
    Button button1 = findViewById(R.id.button);
    Button button2 = findViewById(R.id.button2);


    public void prevImage (View view){
        if(imageView.getResources(R.drawable.a)){

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView.setImageResource(R.drawable.a);
    }


}