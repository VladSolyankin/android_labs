package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobile_lab1.databinding.ActivityOneBinding;

public class one extends AppCompatActivity {
    ActivityOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_one);
        User user = new User("Vlad", "Solyankin");
        binding.setUser(user);

        binding.setClicker(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFirstName("Ivan");
                user.setLastName("Ivanov");
            }
        });
    }
}