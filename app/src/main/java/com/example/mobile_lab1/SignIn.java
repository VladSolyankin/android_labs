package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_lab1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SignIn extends AppCompatActivity {
    final String LOG_TAG = "Logs: ";
    EditText login, pass;
    DBHelper dbHelper;
    UsersDao usersDao;
    List<Users> currentUser;
    public static AppDatabase users_db;
    private ActivityMainBinding binding;
    private static final String MY_SETTINGS = "my_settings";
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users_db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "SoccerSkills_DB").allowMainThreadQueries().build();
        usersDao = users_db.usersDao();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sp = getSharedPreferences(MY_SETTINGS, Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasVisited", false);
        if (!hasVisited) {
            Intent intent = new Intent(this, AuthorActivity.class);
            startActivity(intent);
            editor = sp.edit();
            editor.putBoolean("hasVisited", true);
            editor.apply();
            editor.putString("maxCountUsername", usersDao.maxCountUsers().get(0).userName);
            editor.apply();
        }
    }

    public void onClick(View v) {
        login = binding.login;
        pass = binding.editTextPassword;
        currentUser = usersDao.findByName(login.getText().toString());

        switch (v.getId()) {
            case R.id.signUpButton:
                Intent intent1 = new Intent(this, SignUp.class);
                startActivity(intent1);
                break;
            case R.id.signInButton:
                try {
                    if (Objects.equals(currentUser.get(0).userPassword, pass.getText().toString())) {
                        Log.d(LOG_TAG,  currentUser.get(0).userName + " signed in");
                        usersDao.updateVisitCount(login.getText().toString());
                        Intent intent2 = new Intent(this, soccerThirdActivity.class);
                        intent2.putExtra("name", currentUser.get(0).userName);
                        usersDao.updateVisitCount(currentUser.get(0).userEmail);
                        intent2.putExtra("visitCount",
                                String.valueOf(currentUser.get(0).userVisitCount + 1));
                        startActivity(intent2);
                    }
                    else {
                        Toast toast = Toast.makeText(this,
                                "Неверный пароль для данного пользователя", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                catch (IndexOutOfBoundsException exception) {
                    Toast toast = Toast.makeText(this,
                            "Такого пользователя не существует", Toast.LENGTH_LONG);
                    toast.show();
                }

                break;
            case R.id.changePasswordButton:
                Intent changeIntent = new Intent(this, passwordChange.class);
                changeIntent.putExtra("email", currentUser.get(0).userEmail);
                startActivity(changeIntent);
            default:
                break;
        }
    }
}