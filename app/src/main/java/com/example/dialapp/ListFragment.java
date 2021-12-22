package com.example.dialapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class ListFragment extends Fragment {
    private ListView listView;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listView = view.findViewById(R.id.main_lv);
        Person[] persons = {
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
                new Person("ronaldo", "01554239987", R.drawable.ronaldo),
                new Person("salah", "01554239987", R.drawable.salah),
                new Person("neymar", "01554239987", R.drawable.neymar),
        };
        PersonAdapter adapter = new PersonAdapter(getActivity(), persons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavDirections dir = ListFragmentDirections.actionListFragmentToDetailsFragment(persons[position].getName(), persons[position].getNumber(), persons[position].getImage());

                NavController controller = Navigation.findNavController(getActivity(),R.id.fragment_container);
                controller.navigate(dir);
            }
        });

        return view;
    }
}