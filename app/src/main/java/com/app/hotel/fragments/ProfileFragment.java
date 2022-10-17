package com.app.hotel.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.app.hotel.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;

public class ProfileFragment extends Fragment {

    private TextView nameTextView, numberTextView, emailTextView;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseFirestore fstore = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        nameTextView = view.findViewById(R.id.nameTextView);
        numberTextView = view.findViewById(R.id.numberTextView);
        emailTextView = view.findViewById(R.id.emailTextView);

        String userID = mAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fstore.collection("users").document(userID);

        documentReference.addSnapshotListener((Executor) this, (documentSnapshot, error) -> {
            assert documentSnapshot != null;
            nameTextView.setText(documentSnapshot.getString("First_Name"));
            numberTextView.setText(documentSnapshot.getString("email"));
            emailTextView.setText(documentSnapshot.getString("phone"));
        });

    }
}