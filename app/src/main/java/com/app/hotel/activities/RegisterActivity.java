package com.app.hotel.activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.hotel.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    private EditText editTextfName,editTextlname,editTextMobile,editTextemail,editTextPassword,
        editTextConfirmPassword;
    private Button buttonSignUp, loginButtonFromRegisterLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        editTextfName = findViewById(R.id.editTextfName);
        editTextlname = findViewById(R.id.editTextlName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextemail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);

        progressBar = findViewById(R.id.progressBar);

        loginButtonFromRegisterLayout = findViewById(R.id.loginButtonFromRegisterLayout);
        loginButtonFromRegisterLayout.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonSignUp:
                createAccount();
                return;
            case R.id.loginButtonFromRegisterLayout:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    }

    private void createAccount() {

        String fname, lname, password, email, mobile, confirmPassword;

        fname = editTextfName.getText().toString().trim();
        lname = editTextlname.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        email = editTextemail.getText().toString().trim();
        mobile = editTextMobile.getText().toString().trim();
        confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (fname.isEmpty()) {
            editTextfName.setError("Enter a First Name");
            editTextfName.requestFocus();
            return;
        }

        if (lname.isEmpty()) {
            editTextlname.setError("Enter a Last Name");
            editTextlname.requestFocus();
            return;
        }

        if (mobile.isEmpty()) {
            editTextMobile.setError("Enter a Phone Number");
            editTextMobile.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextemail.setError("Enter Your Email Address");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextemail.setError("Provide a Valid Email Address");
            editTextemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Enter a Password");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password must contain at least 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        if (!confirmPassword.equals(password)) {
            editTextConfirmPassword.setError("The password confirmation does not match");
            editTextConfirmPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        assert user != null;

                        user.sendEmailVerification().addOnSuccessListener(unused ->
                                Toast.makeText(RegisterActivity.this, "Check email to verify your account", Toast.LENGTH_LONG).show())
                                .addOnFailureListener(e -> Log.d(TAG, e.getMessage()));
                        progressBar.setVisibility(View.GONE);

                        //redirect to login page
//                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                });
    }

}