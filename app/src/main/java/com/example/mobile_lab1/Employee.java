package com.example.mobile_lab1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
    private String name;
    private int resource;

    private String team;

    private double rating;
    private int lines;
    private int projects;
    public Employee(String name, int resource, String team, double rating, int lines, int projects) {
        this.name = name;
        this.resource = resource;
        this.team = team;
        this.rating = rating;
        this.lines = lines;
        this.projects = projects;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
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
        ArrayList<String> teams = new ArrayList<>();
        images.add(R.drawable.milkshake);
        images.add(R.drawable.cesar);
        images.add(R.drawable.borsch);

        teams.add("команда 1");
        teams.add("команда 2");
        teams.add("команда 3");

        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeCount; i++) {
            employees.add(new Employee("Employee " + ++lastEmployeeId,
                    images.get(i % 3), teams.get(i % 3), i,
                    i, i));
        }
        return employees;
    }
}
