package com.shashwat.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.shashwat.multiscreen.order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void placeOrder(View view){
        //We will handle the click on the button here
        // We will also get introduced to the concept of Intent here
        //Build an intent to open another activity

        Intent intent = new Intent (this, OrderActivity.class);
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);

        String message =    "Order for " + editText1.getText().toString() + ", " +
                            editText2.getText().toString() + ", " +
                            editText3.getText().toString() + ", " +
                         editText4.getText().toString() + " & " +
                        editText5.getText().toString() + " has been successfully placed. Thank You!";

        intent.putExtra(MSG, message);
        startActivity(intent);

    }
}