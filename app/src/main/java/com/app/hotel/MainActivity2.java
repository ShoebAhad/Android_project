package com.app.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends MainActivity {
    private Button button5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        button5 =(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View view){
        openActivity3();
    }
    });
}

    public void openActivity3()
    {
        Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent);
    }
}

