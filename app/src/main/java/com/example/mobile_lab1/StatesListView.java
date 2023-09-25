package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StatesListView extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_list_view);

        setInitialData();
        ListView countriesListView = findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.activity_state, states);

        countriesListView.setAdapter(stateAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                State selectedState = (State) adapterView.getItemAtPosition(pos);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " +
                        selectedState.getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void setInitialData() {
        states.add(new State("Россия", "Москва", R.drawable.ru));
        states.add(new State("США", "Вашингтон", R.drawable.us));
        states.add(new State("Япония", "Токио", R.drawable.jp));
        states.add(new State("Вьетнам", "Ханой", R.drawable.vn));
        states.add(new State("Австралия", "Сидней", R.drawable.au));
    }
}