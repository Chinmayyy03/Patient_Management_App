package com.example.patientmanagement.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create simple TextView for now
        TextView tv = new TextView(this);
        tv.setText("Login Screen\n\nComing Soon...");
        tv.setTextSize(20);
        tv.setGravity(android.view.Gravity.CENTER);
        tv.setPadding(50, 50, 50, 50);

        setContentView(tv);
    }
}