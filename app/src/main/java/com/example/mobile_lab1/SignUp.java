package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Room;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_lab1.databinding.ActivitySignUpBinding;

import java.util.List;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    final String LOG_TAG = "Logs: ";
    EditText currName, currEmail, currPass1, currPass2;
    DBHelper dbHelper;
    public static AppDatabase users_db;
    UsersDao usersDao;
    List<Users> users;
    private ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dbHelper = new DBHelper(this);
        users_db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "SoccerSkills_DB").allowMainThreadQueries().build();
        usersDao = users_db.usersDao();

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void onClick(View v) {
        users = usersDao.getAll();
        currName = binding.name;
        currEmail = binding.email;
        currPass1 = binding.password1;
        currPass2 = binding.password2;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


        if (!currPass1.getText().toString().equals(currPass2.getText().toString())) {
            Toast toast = Toast.makeText(this,
                    "Пароли должны совпадать", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        if (currName.getText().toString().length() == 0) {
            Toast toast = Toast.makeText(this,
                    "Имя не должно быть пустым", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        if (!Pattern.compile(regexPattern).matcher(currEmail.getText().toString()).matches()) {
            Toast toast = Toast.makeText(this,
                    "Неверный email", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (currPass1.getText().length() < 5 || currPass2.getText().length() < 5) {
            Toast toast = Toast.makeText(this,
                    "Пароль должен быть более 5 символов", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        String email = currEmail.getText().toString();
        String password = currPass1.getText().toString();
        String name = currName.getText().toString();
        if (usersDao.findByEmail(email).size() > 0) {
            Toast toast = Toast.makeText(this,
                    "Данный email уже занят.", Toast.LENGTH_LONG);
            toast.show();
            Log.d(LOG_TAG, usersDao.findByEmail(email).get(0).userName);
            return;
        }
        else {
            Users newUser = new Users();
            newUser.userId = usersDao.getAll().size() + 1;
            newUser.userEmail = email;
            newUser.userName = name;
            newUser.userPassword = password;
            newUser.userVisitCount = 0;
            usersDao.insertAll(newUser);
            Toast toast = Toast.makeText(this,
                    "Пользователь создан", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void onBackClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBackButton:
                Intent intent = new Intent(this, SignIn.class);
                startActivity(intent);
            default:
                break;
        }
    }
    public void onClearDatabase(View v) {
        usersDao.deleteData();
        Log.d(LOG_TAG, "database was cleared");
    }
}