package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CookbookInfoAdapter extends ArrayAdapter<CookbookInfoItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<CookbookInfoItem> items;

    public CookbookInfoAdapter(Context context, int resource, List<CookbookInfoItem> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView itemName = view.findViewById(R.id.textView_itemName);
        TextView itemReceipt = view.findViewById(R.id.textView_description);
        ImageView itemIcon = view.findViewById(R.id.imageView_itemIcon);
        ImageView itemImage = view.findViewById(R.id.imageView_itemImage);

        CookbookInfoItem item = items.get(position);

        itemName.setText(item.getItemName());
        itemIcon.setImageResource(item.getItemIcon());
        itemImage.setImageResource(item.getItemImage());
        itemReceipt.setText(item.getItemReceipt());

        return view;
    }
}
