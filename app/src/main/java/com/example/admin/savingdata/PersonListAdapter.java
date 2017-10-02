package com.example.admin.savingdata;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 10/2/2017.
 */

public class PersonListAdapter extends ArrayAdapter<Person> {
    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, List<Person> personList) {
        super(context, resource, personList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null);
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvAge = (TextView) view.findViewById(R.id.tvAge);
        TextView tvGender = (TextView) view.findViewById(R.id.tvGender);

        Person person = getItem(position);
        tvName.setText(person.getName());
        tvAge.setText(person.getAge());
        tvGender.setText(person.getGender());

        return view;
    }
}
