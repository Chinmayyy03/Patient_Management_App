package com.example.patientmanagement.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.patientmanagement.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";
    private static final int SPLASH_DURATION = 2000; // 2 seconds

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Delay and check user status
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUserAndNavigate();
            }
        }, SPLASH_DURATION);
    }

    private void checkUserAndNavigate() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        Intent intent;
        if (currentUser != null) {
            // User is logged in, go to Dashboard
            Log.d(TAG, "User is logged in: " + currentUser.getEmail());
            intent = new Intent(SplashActivity.this, DashboardActivity.class);
        } else {
            // User not logged in, go to Login
            Log.d(TAG, "No user logged in, going to Login");
            intent = new Intent(SplashActivity.this, LoginActivity.class);
        }

        startActivity(intent);
        finish();
    }
}