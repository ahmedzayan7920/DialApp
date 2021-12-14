package com.example.dialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
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
        PersonAdapter adapter = new PersonAdapter(MainActivity.this, persons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "Item " + (position+1) + " Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("image", persons[position].getImage());
                intent.putExtra("name", persons[position].getName());
                intent.putExtra("number", persons[position].getNumber());
                startActivity(intent);
            }
        });
    }

    private void setViews() {
        listView = findViewById(R.id.main_lv);
    }
}