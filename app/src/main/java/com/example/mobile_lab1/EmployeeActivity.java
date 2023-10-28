package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    public void onViewClick(View view) {
        Intent intent = new Intent(this, EmployeeInfo.class);
        TextView name = findViewById(R.id.employeeName);
        TextView rating = findViewById(R.id.ratingTextView);
        TextView projects = findViewById(R.id.projectsTextView);
        TextView lines = findViewById(R.id.linesTextView);
        TextView team = findViewById(R.id.teamTextView);

        String information = "";
        information += "Сотрудик: " + name.getText() + "\n";
        information += "Рейтинг: " + rating.getText() + "\n";
        information += "Проекты: " + projects.getText() + "\n";
        information += "Строки кода: " + lines.getText() + "\n";
        information += "Команда: " + team.getText() + "\n";

        intent.putExtra("information", information);
        intent.putExtra("id", name.getText());
        startActivity(intent);
    }
}