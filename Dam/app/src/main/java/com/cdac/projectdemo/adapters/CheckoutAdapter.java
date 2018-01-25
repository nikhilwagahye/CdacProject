package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.Cart;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    Activity context;
    int size;

    List<Cart> list;

    public CheckoutAdapter(Activity context, List<Cart> list) {
        this.context = context;
        this.list = list;
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

        final Cart cart = list.get(position);

        viewHolder.textViewName.setText(cart.getBookName());
        viewHolder.textViewQty.setText(cart.getQty() + "");

        viewHolder.textViewPrice.setText(cart.getPrice() + "");
        double price = cart.getQty() * cart.getPrice();

        viewHolder.textViewPrice.setText(price+"");


        Picasso.with(context).load(cart.getImageURL()).placeholder(R.drawable.book_image_new)
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

        TextView textViewName;
        TextView textViewQty;
        TextView textViewPrice;
        LinearLayout linearLayoutRemove;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewQty = (TextView) itemView.findViewById(R.id.textViewQty);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            linearLayoutRemove = (LinearLayout) itemView.findViewById(R.id.linearLayoutRemove);
        }
    }

}

