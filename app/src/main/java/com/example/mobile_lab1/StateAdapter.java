package com.example.mobile_lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {
    private LayoutInflater inflater;
    private int layout;
    private List<State> states;

    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView countryNameView = view.findViewById(R.id.textView_countryName);
        TextView countryCapitalView = view.findViewById(R.id.textView_capital);
        ImageView countryFlagView = view.findViewById(R.id.imageView_flag);

        State state = states.get(position);

        countryNameView.setText(state.getName());
        countryCapitalView.setText(state.getCapital());
        countryFlagView.setImageResource(state.getFlagResource());

        return view;
    }
}


