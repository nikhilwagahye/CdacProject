package com.cdac.projectdemo.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.ui.ShopBooksActivity;

/**
 * Created by nikhilkumar.waghaye on 17-01-2018.
 */

public class TypesOfBoosAdapter extends RecyclerView.Adapter<TypesOfBoosAdapter.ViewHolder> {

    Activity context;
    int size;

    public TypesOfBoosAdapter(Activity context, int size) {
        super();
        this.context = context;
        this.size = size;
    }

    @Override
    public TypesOfBoosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_type_book, viewGroup, false);
        TypesOfBoosAdapter.ViewHolder viewHolder = new TypesOfBoosAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TypesOfBoosAdapter.ViewHolder viewHolder, final int position) {
       // viewHolder.textView.setText("Item " + position);
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ShopBooksActivity.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
