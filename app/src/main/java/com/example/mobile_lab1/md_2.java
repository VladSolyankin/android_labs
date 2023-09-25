package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.regex.Pattern;

public class md_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md2);
    }

    public void onClick(View v) {
        TextView email = findViewById(R.id.editTextTextEmailAddress);
        TextView password = findViewById(R.id.editTextTextPassword);
        switch (v.getId()) {
            case R.id.md2_button1:
                String regex = "[a-z0-9]+@[a-z0-9]+.[a-z]{1,3}";
                if (patternMatches(email.getText().toString().toLowerCase(Locale.ROOT), regex) && password.length() != 0) {
                    startActivity(new Intent(this, md_3.class));
                }
                else if (password.length() == 0) {
                    password.setHintTextColor(Color.parseColor("#FF0000"));
                    password.setHint("Заполните данное поле");
                }
                else if (email.length() == 0) {
                    email.setHintTextColor(Color.parseColor("#FF0000"));
                    email.setHint("Заполните данное поле");
                }
                else {
                    email.setText("");
                    email.setHintTextColor(Color.parseColor("#FF0000"));
                    email.setHint("Неверный формат email");
                }
                break;
            case R.id.md2_button2:
                startActivity(new Intent(this, md_3.class));
                break;
        }
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}