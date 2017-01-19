package com.example.morpheus.floatingbuttonsandrecyclerviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by morpheus on 09.07.16.
 */
public class MeinAdapter extends RecyclerView.Adapter<MeinAdapter.ViewHolder> {
    private List<String> items;

    public MeinAdapter(List<String> items)
    {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = items.get(position);
        holder.item.setText(s);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item;

        public ViewHolder(View itemView)
        {
            super(itemView);
            item = (TextView)itemView.findViewById(R.id.item);
        }
    }
}
