package com.app.hotel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.hotel.R;

public class GuestActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView value;
    ImageButton increment, decrement;
    int count = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        value = (TextView) findViewById(R.id.adult);
        increment = findViewById(R.id.plus);
        decrement = findViewById(R.id.minus);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value.setText("" + count);
            }


        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) {
                    count = 0;
                } else count--;
                value.setText("" + count);
            }

        });


    }

    @Override
    public void onClick(View view) {

    }
}