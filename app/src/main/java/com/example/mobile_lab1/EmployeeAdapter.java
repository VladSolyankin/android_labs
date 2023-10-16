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

public class EmployeeAdapter extends
        RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private ArrayList<Employee> employees;

    public EmployeeAdapter(ArrayList<Employee> employeesList) {
        employees = employeesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.employee_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee currentEmployee = employees.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(currentEmployee.getName());
        ImageView imageView = holder.imageImageView;
        imageView.setImageResource(currentEmployee.getResource());

        TextView ratingTextView = holder.ratingTextView;
        ratingTextView.setText(String.valueOf(currentEmployee.getRating()));
        TextView linesTextView = holder.linesTextView;
        linesTextView.setText(String.valueOf(currentEmployee.getLines()));
        TextView projectsTextView = holder.projectsTextView;
        projectsTextView.setText(String.valueOf(currentEmployee.getProjects()));
        TextView teamTextView = holder.teamTextView;
        teamTextView.setText(currentEmployee.getTeam());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public ImageView imageImageView;
        public TextView ratingTextView;
        public TextView linesTextView;
        public TextView projectsTextView;
        public TextView teamTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.employeeName);
            imageImageView = (ImageView) itemView.findViewById(R.id.employeeImage);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);
            linesTextView = (TextView) itemView.findViewById(R.id.linesTextView);
            projectsTextView = (TextView) itemView.findViewById(R.id.projectsTextView);
            teamTextView = (TextView) itemView.findViewById(R.id.teamTextView);
        }
    }
}
