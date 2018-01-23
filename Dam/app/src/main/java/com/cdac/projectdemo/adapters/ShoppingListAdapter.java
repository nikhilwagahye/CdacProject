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
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.model.BookTest;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    Activity context;
    List<BookList> list = new ArrayList<BookList>();

    public ShoppingListAdapter(Activity context, List<BookList> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public ShoppingListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_book, viewGroup, false);
        ShoppingListAdapter.ViewHolder viewHolder = new ShoppingListAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingListAdapter.ViewHolder viewHolder, final int position) {
        // viewHolder.textView.setText("Item " + position);

        final BookList bookList = list.get(position);

        viewHolder.textViewName.setText(bookList.getName());
        viewHolder.textViewPrice.setText(bookList.getPrice()+"");
        viewHolder.textViewAuthor.setText(bookList.getAuthor());

        Picasso.with(context).load(bookList.getImageUrl().get(0)).placeholder(R.drawable.book_image_new)
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

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShoppingBoookDetailsActivity.class);
                Gson gson = new Gson();
                String objJSON = gson.toJson(list.get(position));
                intent.putExtra("BookObject", objJSON);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewName;
        TextView textViewAuthor;
        TextView textViewPrice;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewAuthor = (TextView) itemView.findViewById(R.id.textViewAuthor);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
        }
    }

}

