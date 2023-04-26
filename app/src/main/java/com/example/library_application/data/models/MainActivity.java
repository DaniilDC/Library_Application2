package com.example.library_application.data.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.library_application.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}