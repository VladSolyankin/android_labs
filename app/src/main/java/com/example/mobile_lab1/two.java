package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class two extends AppCompatActivity {

    TextView yourName;
    TextView yourSurname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");

        yourName = (TextView) findViewById(R.id.yourName);
        yourSurname = (TextView) findViewById(R.id.yourSurname);

        yourName.setText(yourName.getText().toString() + " " + name);
        yourSurname.setText(yourSurname.getText().toString() + " " + surname);
    }
    public void onLastActivity(View v) {
        Toast toast = Toast.makeText(this, "Уведомление",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0,160);
        toast.show();

        switch (v.getId()) {
            case R.id.twoButton:
                Intent intent = new Intent(this, one.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}