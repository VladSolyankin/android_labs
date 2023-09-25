package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class bmr_menu_activity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_menu);

        textView = findViewById(R.id.fileTextView);
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile() throws IOException {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            InputStream is = this.getAssets().open("file.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                try {
                    if ((string = reader.readLine()) == null) break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                stringBuilder.append(string).append("\n");
                textView.setText(stringBuilder);
            }
            is.close();
    }
}