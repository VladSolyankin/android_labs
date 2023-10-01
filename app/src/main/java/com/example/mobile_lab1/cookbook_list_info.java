package com.example.mobile_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile_lab1.databinding.ActivityCookbookListInfoBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class cookbook_list_info extends AppCompatActivity {

    private ActivityCookbookListInfoBinding binding;
    TextView itemName, itemReceipt;
    ImageView itemIcon, itemInfoImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook_list_info);

        binding = ActivityCookbookListInfoBinding.inflate(getLayoutInflater());
//        itemName = binding.textViewItemName;
//        itemDescription = binding.textViewDescription;
//        itemIcon = binding.imageViewItemIcon;
//        itemInfoImage = binding.imageViewItemImage;

        itemName = findViewById(R.id.textView_itemName);
        itemReceipt = findViewById(R.id.textView_itemReceipt);
        itemIcon = findViewById(R.id.imageView_itemIcon);
        itemInfoImage = findViewById(R.id.imageView_itemImage);

        itemName.setText(getIntent().getStringExtra("itemName"));
        itemIcon.setImageResource(getIntent().getIntExtra("itemIcon", 0));
        itemInfoImage.setImageResource(getIntent().getIntExtra("itemInfoImage", 0));

        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        try {
            is = getAssets().open(getIntent().getStringExtra("itemDescription"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String str;
        while (true) {
            try {
                if ((str = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append(str);
            sb.append("\n");
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemReceipt.setText("" + sb);
    }
}