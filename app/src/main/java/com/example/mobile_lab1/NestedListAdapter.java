package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NestedListAdapter extends RecyclerView.Adapter<NestedListAdapter.ViewHolder> {

    private ArrayList<NestedList> groups;

    public NestedListAdapter(ArrayList<NestedList> groupList) {
        groups = groupList;
    }

    @NonNull
    @Override
    public NestedListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View groupView = inflater.inflate(R.layout.nested_list_group_item, parent, false);

        return new ViewHolder(groupView);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedListAdapter.ViewHolder holder, int position) {
        NestedList currentList = groups.get(position);
        TextView groupName = holder.groupName;
        groupName.setText(currentList.getGroupName());
        RecyclerView groupElements = holder.groupElements;
        //groupElements.setAdapter(new NestedListGroupAdapter(new NestedListGroup()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView groupName;
        RecyclerView groupElements;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.groupName);
            groupElements = new RecyclerView(itemView.getContext());
        }
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }
}
