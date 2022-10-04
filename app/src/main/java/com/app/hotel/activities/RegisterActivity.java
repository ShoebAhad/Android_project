package com.app.hotel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.app.hotel.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    private EditText editTextfName,editTextlname,editTextMobile,editTextemail,editTextPassword,
        editTextConfirmPassword;
    private Spinner spinnerGender;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        editTextfName = (EditText) findViewById(R.id.editTextfName);
        editTextlname = (EditText) findViewById(R.id.editTextlName);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextemail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonSignUp:
                createAccount();
        }
    }

    private void createAccount() {
        String fname,lname,password,email,mobile,confirmPassword;
        fname = editTextfName.getText().toString().trim();
        lname = editTextlname.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        email = editTextemail.getText().toString().trim();
        mobile = editTextMobile.getText().toString().trim();
        confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if(fname.isEmpty()){
            editTextfName.setError("Enter a First Name");
            editTextfName.requestFocus();
            return;
        }
        if(lname.isEmpty()){
            editTextlname.setError("Enter a Last Name");
            editTextlname.requestFocus();
            return;
        }
        if(mobile.isEmpty()){
            editTextMobile.setError("Enter a Phone Number");
            editTextMobile.requestFocus();
            return;
        }
        if(mobile.length()<11){
            editTextMobile.setError("Enter a valid phone number");
            editTextMobile.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextemail.setError("Enter Your Email Address");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Provide a Valid Email Address");
        }
        if(password.isEmpty()){
            editTextPassword.setError("Enter a Password");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Password must contain at least 6 digits");
            editTextPassword.requestFocus();
            return;
        }
        if(!confirmPassword.equals(password)){
            editTextConfirmPassword.setError("The password confirmation does not match");
            editTextConfirmPassword.requestFocus();
            return;
        }
    }
}