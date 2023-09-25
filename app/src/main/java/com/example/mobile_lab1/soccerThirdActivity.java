package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class soccerThirdActivity extends AppCompatActivity {

    TextView yourName, visitCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer_third);

        yourName = (TextView) findViewById(R.id.yourName3);
        yourName.setText(yourName.getText().toString() + " " +
                getIntent().getStringExtra("name"));

        visitCount = (TextView) findViewById(R.id.visitCount_tv);
        visitCount.setText(visitCount.getText().toString() +  " " +
                getIntent().getStringExtra("visitCount"));
    }
}