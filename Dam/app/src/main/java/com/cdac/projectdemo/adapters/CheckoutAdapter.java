package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdac.projectdemo.R;

/**
 * Created by nikhilkumar.waghaye on 21-01-2018.
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    Activity context;
    int size;

    public CheckoutAdapter(Activity context, int size) {
        super();
        this.context = context;
        this.size = size;
    }

    @Override
    public CheckoutAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_checkout, viewGroup, false);
        CheckoutAdapter.ViewHolder viewHolder = new CheckoutAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CheckoutAdapter.ViewHolder viewHolder, final int position) {

    }


    @Override
    public int getItemCount() {
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

}
