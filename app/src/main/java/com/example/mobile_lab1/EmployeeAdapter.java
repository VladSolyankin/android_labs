package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.employee_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee currentEmployee = employees.get(position);
//        TextView textView = holder.nameTextView;
//        textView.setText(currentEmployee.getName());
//        Button button = holder.messageButton;
//        button.setText(currentEmployee.isOnline() ? "Message" : "Offline");
//        button.setEnabled(contact.isOnline());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView nameTextView;
//        public Button messageButton;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            messageButton = (Button) itemView.findViewById(R.id.message_button);
//        }
    }
}
