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
import android.widget.Toast;

import com.app.hotel.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_create_account, button_login;
    private ProgressBar loginProgressBar;
    private EditText etEmailInLoginLayout, etPasswordInLoginLayout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailInLoginLayout = findViewById(R.id.etEmailInLoginLayout);
        etPasswordInLoginLayout = findViewById(R.id.etPasswordInLoginLayout);

        loginProgressBar = findViewById((R.id.loginProgressBar));

        button_create_account = findViewById(R.id.button_create_account);
        button_create_account.setOnClickListener(this);

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_create_account:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.button_login:
                signIn();
                break;
        }
    }

    private void signIn() {

        String email = etEmailInLoginLayout.getText().toString().trim();
        String password = etPasswordInLoginLayout.getText().toString().trim();

        if(email.isEmpty()){
            etEmailInLoginLayout.setError("Enter your email address");
            etEmailInLoginLayout.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmailInLoginLayout.setError("Provide a valid email address");
            etEmailInLoginLayout.requestFocus();
            return;
        }

        if(password.isEmpty()){
            etPasswordInLoginLayout.setError("Enter your email address");
            etPasswordInLoginLayout.requestFocus();
            return;
        }

        loginProgressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Signed in successfully",Toast.LENGTH_SHORT).show();
                        //redirect to homeFragment
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else{
                        Toast.makeText(LoginActivity.this,
                                "Oops! The credentials are not connected to an account",
                                Toast.LENGTH_LONG).show();
                    }
                    loginProgressBar.setVisibility(View.GONE);
                });

    }
}