package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;



public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    Activity context;
    int size;

    public OrdersAdapter(Activity context, int size) {
        super();
        this.context = context;
        this.size = size;
    }

    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_orders, viewGroup, false);
        OrdersAdapter.ViewHolder viewHolder = new OrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OrdersAdapter.ViewHolder viewHolder, final int position) {

        //


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

