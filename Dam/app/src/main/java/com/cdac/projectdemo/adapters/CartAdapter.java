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
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.BookTest;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.User;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;
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
    RecyclerView recyclerView;
    TextView textViewNoData;
    LinearLayout linearLayoutCheckout;


    public CartAdapter(Activity context, List<Cart> cartList, RecyclerView recyclerView, TextView textViewNoData, LinearLayout linearLayoutCheckout) {
        super();
        this.context = context;
        this.cartList = cartList;
        this.recyclerView = recyclerView;
        this.textViewNoData = textViewNoData;
        this.linearLayoutCheckout = linearLayoutCheckout;
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
        double price = cart.getQtyOrdered() * cart.getPrice();

        viewHolder.textViewPrice.setText(price + "");
        viewHolder.textViewQuanityAvailable.setText("Quantity Available : " + cart.getTotalQtyAvailable());
        viewHolder.textViewQty.setText(cart.getQtyOrdered() + "");

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

                final User user = SharedPreferenceManager.getUserObjectFromSharedPreference();

                if (user != null) {
                    String cartNode = user.getUserId() + "/cartlist";
                    database.child(cartNode).child(cart.getCartId()).removeValue();
                    cartList.remove(position);
                    updateView(cartList);
                }
            }
        });


        final double actualPrice = cart.getPrice();

        viewHolder.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(viewHolder.textViewQty.getText().toString());
                if (qty < cart.getTotalQtyAvailable()) {
                    qty = qty + 1;
                    viewHolder.textViewQty.setText(qty + "");
                    double price = qty * actualPrice;
                    viewHolder.textViewPrice.setText(price + "");
                    cart.setQtyOrdered(qty);
                    updateCartValueToFirebase(cart);
                } else {
                    Toast.makeText(context, "Maximum available quantity of books reached.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewHolder.imageViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(viewHolder.textViewQty.getText().toString());
                if (qty > 1) {
                    qty = qty - 1;
                    viewHolder.textViewQty.setText(qty + "");
                    double price = qty * actualPrice;
                    viewHolder.textViewPrice.setText(price + "");
                    cart.setQtyOrdered(qty);
                    updateCartValueToFirebase(cart);

                } else {
                    Toast.makeText(context, "Minimum 1 book should buy...", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void updateCartValueToFirebase(Cart cart) {


        final User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
        if (user != null) {
            String cartNode = user.getUserId() + "/cartlist";
            database.child(cartNode).child(cart.getCartId()).setValue(cart);
        }

    }


    public void updateView(List<Cart> list) {
        this.cartList = list;
        this.notifyDataSetChanged();
        if (list != null && list.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            linearLayoutCheckout.setVisibility(View.VISIBLE);
            textViewNoData.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.GONE);
            linearLayoutCheckout.setVisibility(View.GONE);
            textViewNoData.setVisibility(View.VISIBLE);

        }

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
        TextView textViewQuanityAvailable;
        ImageView imageViewMinus;
        ImageView imageViewPlus;
        TextView textViewQty;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayoutRemove = (LinearLayout) itemView.findViewById(R.id.linearLayoutRemove);
            textViewQuanityAvailable = (TextView) itemView.findViewById(R.id.textViewQuanityAvailable);

            imageViewMinus = (ImageView) itemView.findViewById(R.id.imageViewMinus);
            imageViewPlus = (ImageView) itemView.findViewById(R.id.imageViewPlus);
            textViewQty = (TextView) itemView.findViewById(R.id.textViewQty);
        }
    }

}

