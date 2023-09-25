package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextViewClick extends AppCompatActivity {
    TextView clickTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_click);

        clickTextView = (TextView) findViewById(R.id.clickTextView);
        Button clickButton = (Button) findViewById(R.id.clickButton);
    }
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.clickButton:
                clickTextView.setText("Обработка нажатия на кнопку ");
                break;

            case R.id.clickTextView:
                clickTextView.setText("Нажали на TextView ");
                break;
        }
    }


}