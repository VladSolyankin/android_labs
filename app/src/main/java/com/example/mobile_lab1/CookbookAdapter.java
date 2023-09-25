package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CookbookAdapter extends ArrayAdapter<CookbookItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<CookbookItem> items;

    public CookbookAdapter(Context context, int resource, List<CookbookItem> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView itemName = view.findViewById(R.id.textView_itemName);
        ImageView itemResource = view.findViewById(R.id.imageView_item);

        CookbookItem item = items.get(position);

        itemName.setText(item.getItemName());
        itemResource.setImageResource(item.getItemResource());

        return view;
    }
}
