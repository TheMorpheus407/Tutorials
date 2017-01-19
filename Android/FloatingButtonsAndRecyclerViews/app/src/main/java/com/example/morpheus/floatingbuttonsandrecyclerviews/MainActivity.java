package com.example.morpheus.floatingbuttonsandrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> liste = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MeinAdapter adapter = new MeinAdapter(liste);
        recyclerView.setAdapter(adapter);

        liste.add("Java");
        liste.add("Python");
        liste.add("Rust");
        liste.add("C");
        liste.add("JavaScript");
        liste.add("PHP");
        liste.add("Haskell");
        liste.add("HTML");
        liste.add("CSS");
        liste.add("C#");
        adapter.notifyDataSetChanged();
    }
}
