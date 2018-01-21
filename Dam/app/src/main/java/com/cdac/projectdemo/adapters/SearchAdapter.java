package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.cdac.projectdemo.R;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhilkumar.waghaye on 18-01-2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Activity context;
    List<String> list = new ArrayList<>();
    int selectedPosition = 0;

    public SearchAdapter(Activity context, List<String> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false);
        SearchAdapter.ViewHolder viewHolder = new SearchAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SearchAdapter.ViewHolder viewHolder, int position) {

        viewHolder.textView.setText(list.get(position));

        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShoppingBoookDetailsActivity.class);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

