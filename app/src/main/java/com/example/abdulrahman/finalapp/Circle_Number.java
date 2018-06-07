package com.example.abdulrahman.finalapp;

import android.content.Intent;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Circle_Number extends AppCompatActivity {

    private Button BackDashboard;
    private TextView CircleNumber;


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle__number);

        BackDashboard=findViewById(R.id.Back_Dashboard);
        CircleNumber=findViewById(R.id.circleNumber);

        final String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.child("users").child("admin").child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                    String circle = snapshot.child("CircleNumber").getValue(String.class);
                    CircleNumber.setText(circle);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        BackDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Circle_Number.this,A_Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
