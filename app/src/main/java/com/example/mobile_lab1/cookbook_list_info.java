package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cookbook_list_info extends AppCompatActivity {

    ArrayList<CookbookInfoItem> cookbookInfoItems = new ArrayList<>();
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook_list_info);

        setActivityData();
        ListView itemsListView = findViewById(R.id.cookbookItemsInfoList);
        CookbookInfoAdapter adapter = new CookbookInfoAdapter(this,
                R.layout.activity_cookbook_info_item, cookbookInfoItems);

        itemsListView.setAdapter(adapter);
    }

    private void setActivityData() {
        position = getIntent().getIntExtra("elementNumber", 0);
        Log.d("Value claimed: ", String.valueOf(position));
        cookbookInfoItems.clear();
        switch (position) {
            case 0:
                cookbookInfoItems.add(new CookbookInfoItem(R.drawable.ic_borsch, "Борщ",
                        R.drawable.borsch, ""));
                break;
            case 1:
                cookbookInfoItems.add(new CookbookInfoItem(R.drawable.ic_cesar, "Цезарь",
                        R.drawable.cesar, ""));
                break;
            case 2:
                cookbookInfoItems.add(new CookbookInfoItem(R.drawable.ic_blinchik,
                        "Блинчики", R.drawable.blinchik, ""));
                break;
            case 3:
                cookbookInfoItems.add(new CookbookInfoItem(R.drawable.ic_milkshake,
                        "Мол. коктейль", R.drawable.milkshake, ""));
                break;
            case 4:
                cookbookInfoItems.add(new CookbookInfoItem(R.drawable.ic_spagetti,
                        "Спагетти", R.drawable.spagetti, ""));
                break;

        }
    }
}