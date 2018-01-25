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
import com.cdac.projectdemo.model.BookTest;
import com.cdac.projectdemo.model.Cart;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private final DatabaseReference database;
    Activity context;

    List<Cart> cartList;

    public CartAdapter(Activity context, List<Cart> cartList) {
        super();
        this.context = context;
        this.cartList = cartList;
        database = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_cart, viewGroup, false);
        CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CartAdapter.ViewHolder viewHolder, final int position) {

        final Cart cart = cartList.get(position);

        viewHolder.textViewName.setText(cart.getBookName());
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


        viewHolder.linearLayoutRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).child(cart.getCartId()).removeValue();
                //cartList.remove(cart);
              //  notifyDataSetChanged();
//                updateView(position);

            }
        });
    }


    public void updateView(int position, List<Cart> list) {

     /*   List<Cart> newList = this.cartList;
        newList.remove(cart);
        this.cartList = newList;
        this.notifyDataSetChanged();*/

     this.cartList = list;
     this.notifyDataSetChanged();

       /* this.cartList.remove(position);
        this.notifyItemRemoved(position);
        notifyItemRangeChanged(position, cartList.size());*/

    }


    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewName;
        TextView textViewPrice;
        ImageView imageView;
        LinearLayout linearLayoutRemove;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayoutRemove = (LinearLayout) itemView.findViewById(R.id.linearLayoutRemove);
        }
    }

}

