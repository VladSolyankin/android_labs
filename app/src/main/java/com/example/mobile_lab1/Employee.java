package com.example.mobile_lab1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Employee {
    private String name;
    private int resource;

    public Employee(String name, int resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    private static int lastEmployeeId = 0;

    public static ArrayList<Employee> createEmployeeList(int employeeCount) {
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.milkshake);
        images.add(R.drawable.cesar);
        images.add(R.drawable.borsch);
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeCount; i++) {
            employees.add(new Employee("Employee " + ++lastEmployeeId,
                    images.get(i % 3)));
        }
        return employees;
    }
}
