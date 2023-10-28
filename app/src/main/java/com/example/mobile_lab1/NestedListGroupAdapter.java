package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NestedListGroupAdapter extends RecyclerView.Adapter<NestedListGroupAdapter.ViewHolder> {

    ArrayList<NestedListGroup> nestedListGroup;
    @NonNull
    @Override
    public NestedListGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View groupView = inflater.inflate(R.layout.nested_list_inner_item, parent, false);

        return new ViewHolder(groupView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NestedListGroup group = nestedListGroup.get(position);
        //отображение элементов во внутреннем списке
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        ImageView itemResource;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemResource = itemView.findViewById(R.id.itemResource);
        }
    }

    @Override
    public int getItemCount() {
        return nestedListGroup.size();
    }
}
