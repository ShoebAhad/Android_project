package com.app.hotel.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hotel.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;

public class ProfileFragment extends Fragment {

    private TextView nameTextView, numberTextView, emailTextView;
    private Button signOut;

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

        signOut = view.findViewById(R.id.signOut);

        String userID = mAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fstore.collection("users").document(userID);

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    nameTextView.setText(new StringBuilder().append(documentSnapshot.getString("First_Name")).append("  ").
                            append(documentSnapshot.getString("Last_Name")).toString());
                    numberTextView.setText(documentSnapshot.getString("phone"));
                    emailTextView.setText(documentSnapshot.getString("email"));
                }
                else{
                    Toast.makeText(getContext(),"Data not found",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
            }
        });

        if(mAuth.getCurrentUser() != null){
            signOut.setVisibility(View.VISIBLE);
        }
        else{
            signOut.setVisibility(View.GONE);
        }

    }
}