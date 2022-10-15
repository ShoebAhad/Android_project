package com.app.hotel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
=======
import android.os.Bundle;
import android.view.View;
>>>>>>> refs/remotes/origin/master
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.hotel.R;

public class GuestActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView value;
    ImageButton increment, decrement;
<<<<<<< HEAD
    Button done;
=======
>>>>>>> refs/remotes/origin/master
    int count = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        value = (TextView) findViewById(R.id.adult);
        increment = findViewById(R.id.plus);
        decrement = findViewById(R.id.minus);
<<<<<<< HEAD

        done = findViewById(R.id.done);
        done.setOnClickListener(view ->
                startActivity(new Intent(GuestActivity.this, MainActivity.class)));

        increment.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
=======
        increment.setOnClickListener(new View.OnClickListener() {
>>>>>>> refs/remotes/origin/master
            @Override
            public void onClick(View view) {
                count++;
                value.setText("" + count);
            }


        });
<<<<<<< HEAD

        decrement.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
=======
        decrement.setOnClickListener(new View.OnClickListener() {
>>>>>>> refs/remotes/origin/master
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