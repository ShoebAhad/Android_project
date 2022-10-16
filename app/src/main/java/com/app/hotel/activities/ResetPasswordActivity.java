package com.app.hotel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.hotel.R;

import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmailInReset;
    private ProgressBar progressBarInReset;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etEmailInReset = findViewById(R.id.etEmailInReset);

        Button resetPasswordButton = findViewById(R.id.resetPasswordButton);
        resetPasswordButton.setOnClickListener(this);

        progressBarInReset = findViewById(R.id.progressBarInReset);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        resetPassword();
    }

    private void resetPassword() {

        String email = etEmailInReset.getText().toString().trim();

        if (email.isEmpty()) {
            etEmailInReset.setError("Enter Your Email Address");
            etEmailInReset.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmailInReset.setError("Provide a Valid Email Address");
            etEmailInReset.requestFocus();
            return;
        }

        progressBarInReset.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {

            if(task.isSuccessful()){
                Toast.makeText(ResetPasswordActivity.this,"Check email to reset your password",Toast.LENGTH_LONG).show();
            }

            else{
                Toast.makeText(ResetPasswordActivity.this,"Something went wrong. Try again.",Toast.LENGTH_LONG).show();
            }

            progressBarInReset.setVisibility((View.GONE));

        });

    }
}