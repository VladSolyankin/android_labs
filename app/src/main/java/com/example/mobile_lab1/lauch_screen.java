package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import android.os.Handler;

public class lauch_screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauch_screen);
        startTheTransitionAfterTheSplashScreen();
    }
    private void startTheTransitionAfterTheSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(lauch_screen.this, md_2.class));
                finish();
            }
        }, 2000);
    }
}