package com.example.abdulrahman.finalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class A_Login extends AppCompatActivity {

    private Button sginup,login;
    private EditText email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__login);

        sginup=findViewById(R.id.sginup);
        login=findViewById(R.id.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();

        sginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(A_Login.this,A_sginup.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EMAIL=email.getText().toString();
                String PASSWORD=password.getText().toString();
                mAuth.signInWithEmailAndPassword(EMAIL,PASSWORD).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(A_Login.this,"Login Sucessfull",Toast.LENGTH_LONG).show();
                            Toast.makeText(A_Login.this,"Registered Sucessfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(A_Login.this,A_Dashboard.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(A_Login.this,"Login Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }
}
