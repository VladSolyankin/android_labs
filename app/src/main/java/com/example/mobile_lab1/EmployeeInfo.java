package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmployeeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);

        String info = getIntent().getStringExtra("information");
        TextView employeeInfo = findViewById(R.id.employeeInfo);
        employeeInfo.setText(info);
    }

    public void onBackClick_2(View view) {
        Intent intent = new Intent(this, EmployeeActivity.class);
        startActivity(intent);
    }
}