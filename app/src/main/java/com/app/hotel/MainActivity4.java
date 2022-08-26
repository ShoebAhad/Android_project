package com.app.hotel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity4 extends MainActivity3 {

    ListView listView;
    String[] cities={"Dhaka","Chittagong","Barishal","Khulna","Mymensingh","Sylhet","Rangpur","Jamalpur","Kumilla","Bogra","Rajshahi","Gazipur","ChapaiNawabGanj"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listView=findViewById(R.id.listview1);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_dropdown_item_1line,cities);
        listView.setAdapter(adapter);

      /*  Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent,View view,int position, long l) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { */

    }
}