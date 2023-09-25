package com.example.mobile_lab1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users {
    @PrimaryKey
    int userId;
    @ColumnInfo(name = "name")
    public String userName;
    @ColumnInfo(name = "email")
    public String userEmail;
    @ColumnInfo(name = "password")
    public String userPassword;
    @ColumnInfo(name = "visit_count")
    public int userVisitCount;
}
