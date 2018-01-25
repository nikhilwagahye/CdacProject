package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.model.Orders;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    Activity context;
    List<Orders> list;

    public OrdersAdapter(Activity context, List<Orders> list) {
        super();
        this.context = context;
        this.list = list;
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

        Orders orders = list.get(position);
        viewHolder.textViewName.setText(orders.getName());
        viewHolder.textViewPrice.setText(orders.getPrice() + "");
        viewHolder.textViewPaymentType.setText(orders.getModeOfPayment() + "");
        viewHolder.textViewQty.setText(orders.getQuantity() + "");
        viewHolder.orderDate.setText(orders.getOrderDate() + "");
        viewHolder.orderId.setText(orders.getOrderId());

        Picasso.with(context).load(orders.getImageURL()).placeholder(R.drawable.book_image_new)
                .into(viewHolder.imageView, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        viewHolder.imageView.setImageResource(R.drawable.book_image_new);
                    }
                });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName;
        TextView textViewQty;
        TextView textViewPrice;
        TextView textViewPaymentType;
        TextView orderDate;
        TextView orderId;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewQty = (TextView) itemView.findViewById(R.id.textViewQty);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            textViewPaymentType = (TextView) itemView.findViewById(R.id.textViewPaymentType);
            orderDate = (TextView) itemView.findViewById(R.id.orderDate);
            orderId = (TextView) itemView.findViewById(R.id.orderId);
        }
    }

}

