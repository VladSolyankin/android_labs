package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobile_lab1.databinding.ActivityAuthorBinding;
import com.example.mobile_lab1.databinding.ActivityMainBinding;
import com.example.mobile_lab1.databinding.ActivitySignUpBinding;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
    }
}