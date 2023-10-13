package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {
    ArrayList<Employee> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvEmployee);

        employees = Employee.createEmployeeList(10);
        EmployeeAdapter adapter = new EmployeeAdapter(employees);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }
}