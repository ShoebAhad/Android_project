package com.app.hotel.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.app.hotel.R;
import com.app.hotel.viewModels.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

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

        if(email.isEmpty()){
            editTextemail.setError("Enter Your Email Address");
            editTextemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Provide a Valid Email Address");
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Enter a Password");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Password must contain at least 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        
        if(!confirmPassword.equals(password)){
            editTextConfirmPassword.setError("The password confirmation does not match");
            editTextConfirmPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if(task.isSuccessful()){
//                        User user= new User(fname, lname, mobile, email);
//                        FirebaseDatabase.getInstance().getReference("Users").child(Objects
//                                .requireNonNull(FirebaseAuth.getInstance().
//                                getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(
//                                task1 -> {
//                                    if(task1.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,
                                "User was registered successfully!",
                                Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);

                        //redirect to login page
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                });
        //                    }
//                    else{
//                        Toast.makeText(RegisterActivity.this,
//                                "There already exists an account registered with this email address",
//                                Toast.LENGTH_LONG).show();
//                        progressBar.setVisibility(View.GONE);
//                    }
    }

}