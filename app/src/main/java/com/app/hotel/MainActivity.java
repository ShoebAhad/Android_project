package com.app.hotel;

import android.os.Bundle;

public class MainActivity extends SplashActivity {
//    TextView textView;
//    DatePickerDialog.OnDateSetListener setListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.datepicker);
//        Calendar calender = Calendar.getInstance();
//        final int year = calender.get(Calendar.YEAR);
//        final int month = calender.get(Calendar.MONTH);
//        final int day = calender.get(Calendar.DAY_OF_MONTH);
//
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
//                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                datePickerDialog.show();
//            }
//        });
//        setListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
//                    month = month + 1;
//                 String date = day + "/" + month + "/" + year;
//                 textView.setText(date);
//
//            }
//        };
///*        public void openActivity2() {
//            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//        } */

    }
}

