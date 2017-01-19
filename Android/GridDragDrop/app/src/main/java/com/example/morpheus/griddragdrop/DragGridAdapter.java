package com.example.morpheus.griddragdrop;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class DragGridAdapter extends BaseAdapter {
    private Context context;
    private List<Button> items;

    public DragGridAdapter(List<Button> items, Context context) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Button getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItem(i);
    }

    public List<Button> getItems() {
        return items;
    }
}