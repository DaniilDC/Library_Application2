package com.example.library_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HelloPage.class);
                startActivity(intent);
                Log.w(TAG, "LOG W");
                Log.e(TAG, "LOG E");
            }
        });
    }
    public void Register(View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}