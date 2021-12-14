package com.example.dialapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private Person[] persons;
    public PersonAdapter(Context context, Person[] persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.length;
    }

    @Override
    public Object getItem(int position) {
        return persons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_person_item, null);

        ImageView iv = convertView.findViewById(R.id.custom_person_image);
        TextView tvName = convertView.findViewById(R.id.custom_person_tv_name);
        TextView tvNumber = convertView.findViewById(R.id.custom_person_tv_number);

        iv.setImageResource(persons[position].getImage());
        tvName.setText(persons[position].getName());
        tvNumber.setText(persons[position].getNumber());

        return convertView;
    }
}
