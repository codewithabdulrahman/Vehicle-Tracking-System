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

public class D_Login extends AppCompatActivity {

    private Button sginup,login;
    private EditText email,password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d__login);

        sginup=findViewById(R.id.sginup);
        login=findViewById(R.id.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();

        sginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(D_Login.this,D_sginup.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String EMAIL=email.getText().toString();
               String PASSWORD=password.getText().toString();

               firebaseAuth.signInWithEmailAndPassword(EMAIL,PASSWORD).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Intent intent=new Intent(D_Login.this,D_Dashboard.class);
                           startActivity(intent);
                           finish();
                           Toast.makeText(D_Login.this,"Logged In",Toast.LENGTH_LONG).show();
                       }else{
                           Toast.makeText(D_Login.this,"Logged In UnSucessfull",Toast.LENGTH_LONG).show();
                       }
                   }
               });
            }
        });
    }
}
