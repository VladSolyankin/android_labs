package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView textView = findViewById(R.id.selectedMenuItem);
        switch (id) {
            case R.id.action_settings:
                textView.setText("Настройки");
                return true;
            case R.id.save_settings:
                textView.setText("Сохранить");
                return true;
            case R.id.open_settings:
                textView.setText("Открыть");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}