package com.example.mobile_lab1;

import android.content.ContentValues;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UsersDao {
    @Query("select * from users")
    List<Users> getAll();
    @Query("select * from users where email = :currEmail")
    List<Users> findByEmail(String currEmail);
    @Query("select * from users where name = :currName")
    List<Users> findByName(String currName);
    @Query("update users set visit_count = visit_count + 1 where email = :currEmail")
    void updateVisitCount(String currEmail);
    @Query("select * from users where visit_count = (select max(visit_count) from users)")
    List<Users> maxCountUsers();
    @Insert
    void insertAll(Users users);
    @Query("delete from users")
    void deleteData();
    @Update
    void updatePassword(Users user);
}

