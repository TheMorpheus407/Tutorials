package com.example.morpheus.floatingbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<String>();
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.lvToDoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);

        prepareData();
    }

    private void prepareData() {
        list.add("Java");
        list.add("Python");
        list.add("Rust");
        list.add("C");
        list.add("JavaScript");
        list.add("PHP");
        list.add("Haskell");
        list.add("HTML");
        list.add("CSS");
        list.add("C#");
        adapter.notifyDataSetChanged();
    }
}
