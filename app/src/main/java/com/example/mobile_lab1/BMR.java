package com.example.mobile_lab1;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;

public class BMR extends AppCompatActivity {
    EditText yourHeight;
    EditText yourWeight;
    EditText yourAge;
    ImageButton maleButton;
    ImageButton femaleButton;
    String yourGender = "male";
    TextView resultBMR;
    TextView type1result;
    TextView type2result;
    TextView type3result;
    TextView type4result;
    TextView type5result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_SplashScreen_SplashTheme);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_Mobile_lab1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        yourHeight = findViewById(R.id.yourHeight);
        yourWeight = findViewById(R.id.yourWeight);
        yourAge = findViewById(R.id.yourAge);
        maleButton = findViewById(R.id.maleButton);
        femaleButton = findViewById(R.id.femaleButton);

        resultBMR = findViewById(R.id.resultBMR);
        type1result = findViewById(R.id.type1result);
        type2result = findViewById(R.id.type2result);
        type3result = findViewById(R.id.type3result);
        type4result = findViewById(R.id.type4result);
        type5result = findViewById(R.id.type5result);
    }
    @SuppressLint({"UseCompatLoadingForDrawables", "NonConstantResourceId"})
    public void onClickGender(View v) {

        switch (v.getId()) {
            case R.id.femaleButton:
                yourGender = "female";
                if (!femaleButton.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.imagebutton_border).getConstantState()) &&
                    maleButton.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.imagebutton_border).getConstantState())
                ) {
                    femaleButton.setBackgroundResource(R.drawable.imagebutton_border);
                    maleButton.setBackgroundResource(R.drawable.ic_launcher_background);
                }
                break;
            case R.id.maleButton:
                if (!maleButton.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.imagebutton_border).getConstantState()) &&
                        femaleButton.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.imagebutton_border).getConstantState())
                ) {
                    maleButton.setBackgroundResource(R.drawable.imagebutton_border);
                    femaleButton.setBackgroundResource(R.drawable.ic_launcher_background);
                }
                yourGender = "male";
                break;
            default:
                break;
        }
    }
    public void onShowInfo(View v) {
        startActivity(new Intent(this, BMR_info.class));
    }
    public void onShowResult(View v) {
        if (yourHeight.getText().length() != 0 && yourWeight.getText().length() != 0 && yourAge.getText().length() != 0) {


            double weight = Double.parseDouble(yourWeight.getText().toString());
            double height = Double.parseDouble(yourHeight.getText().toString());
            double age = Double.parseDouble(yourAge.getText().toString());
            if (yourGender.equals("male")) {
                resultBMR.setText(660 + 13.7 * weight + 5 * height - 6.8 * age + "");
            } else {
                resultBMR.setText(655 + 9.6 * weight + 1.8 * height - 4.7 * age + "");
            }

            type1result.setText(Double.parseDouble(resultBMR.getText().toString()) * 1.2 + "");
            type2result.setText(Double.parseDouble(resultBMR.getText().toString()) * 1.375 + "");
            type3result.setText(Double.parseDouble(resultBMR.getText().toString()) * 1.55 + "");
            type4result.setText(Double.parseDouble(resultBMR.getText().toString()) * 1.725 + "");
            type5result.setText(Double.parseDouble(resultBMR.getText().toString()) * 1.9 + "");
        }
        else {
            Toast toast = Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void onClear(View v) {
        resultBMR.setText("");
        type1result.setText("");
        type2result.setText("");
        type3result.setText("");
        type4result.setText("");
        type5result.setText("");
        yourAge.setText("");
        yourWeight.setText("");
        yourHeight.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bmr_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView textView = findViewById(R.id.selectedMenuItem);
        switch (id) {
            case R.id.bmr_info:
                startActivity(new Intent(this, bmr_menu_activity.class));
                return true;
            case R.id.bmr_logs:
                Log.i(TAG, "BMR: " + resultBMR.getText());
                Log.i(TAG, "Gender: " + yourGender);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}