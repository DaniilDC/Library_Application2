package com.example.library_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    @SuppressLint("NotConstructor")
    public void SignUp(View view)
    {
        Intent intent = new Intent(this, HelloPage.class);
        startActivity(intent);
    }
}