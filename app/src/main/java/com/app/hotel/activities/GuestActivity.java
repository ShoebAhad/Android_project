package com.app.hotel.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hotel.R;

public class GuestActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView value1,value2,value3;
    Button increment1,increment2,increment3,decrement1,decrement2,decrement3;
    Button done;
    int count = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        value1 = (TextView) findViewById(R.id.val1);
        value2 = (TextView) findViewById(R.id.val2);
        value3 = (TextView) findViewById(R.id.val3);

        increment1 = findViewById(R.id.inc1);
        increment3=findViewById(R.id.inc3);
        increment2=findViewById(R.id.inc2);
        decrement1= findViewById(R.id.dec1);
        decrement2= findViewById(R.id.dec2);
        decrement3= findViewById(R.id.dec3);


        done = findViewById(R.id.apply);
        done.setOnClickListener(view ->
                startActivity(new Intent(GuestActivity.this, MainActivity.class)));

        increment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value1.setText("" + count);
            }


        });
        increment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value2.setText("" + count);
            }


        });
        increment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                value3.setText("" + count);
            }


        });

        decrement1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) {
                    count = 0;
                } else count--;
                value1.setText("" + count);
            }

        });
        decrement2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) {
                    count = 0;
                } else count--;
                value2.setText("" + count);
            }

        });
        decrement3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) {
                    count = 0;
                } else count--;
                value3.setText("" + count);
            }

        });





    }

    @Override
    public void onClick(View view) {

    }
}