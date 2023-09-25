package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_lab1.databinding.ActivityMainBinding;
import com.example.mobile_lab1.databinding.ActivityPasswordChangeBinding;

import java.util.List;

public class passwordChange extends AppCompatActivity {

    public static AppDatabase users_db;
    UsersDao usersDao;
    private ActivityPasswordChangeBinding binding;
    EditText newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users_db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "SoccerSkills_DB").allowMainThreadQueries().build();
        usersDao = users_db.usersDao();

        binding = ActivityPasswordChangeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
    public void onPasswordChangeClick(View view) {
        newPassword = binding.newPassword;
        String currentUserEmail = getIntent().getStringExtra("email");
        List<Users> currentUser = usersDao.findByEmail(currentUserEmail);
        currentUser.get(0).userPassword = newPassword.getText().toString();
        usersDao.updatePassword(currentUser.get(0));
        Toast toast = Toast.makeText(this,
                "Пароль изменён", Toast.LENGTH_LONG);
        toast.show();
    }
}