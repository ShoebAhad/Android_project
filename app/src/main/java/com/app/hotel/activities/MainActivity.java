package com.app.hotel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.hotel.R;
import com.app.hotel.databinding.ActivityMainBinding;
import com.app.hotel.fragments.FavouritesFragment;
import com.app.hotel.fragments.HomeFragment;
import com.app.hotel.fragments.NotificationFragment;
import com.app.hotel.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding binding;
    private Button button_login_register;


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

//        button_login_register = findViewById(R.id.button_login_register);
//        button_login_register.setOnClickListener(this);



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

//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.button_login_register:
//                startActivity(new Intent(this,LoginActivity.class));
//                break;
//        }
    }
