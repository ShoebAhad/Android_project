package com.app.hotel;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.hotel.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

//    TextView textView;
//    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.notification:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.favourites:
                    replaceFragment(new FavouritesFragment());
            }
            return true;
        });

//        textView = findViewById(R.id.datepicker);
//        Calendar calender = Calendar.getInstance();
//        final int year = calender.get(Calendar.YEAR);
//        final int month = calender.get(Calendar.MONTH);
//        final int day = calender.get(Calendar.DAY_OF_MONTH);
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
//                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                datePickerDialog.show();
//            }
//        });
//
//        setListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
//                month = month + 1;
//                String date = day + "/" + month + "/" + year;
//                textView.setText(date);
//            }
//        };

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flLayout, fragment);
        fragmentTransaction.commit();
    }

}
