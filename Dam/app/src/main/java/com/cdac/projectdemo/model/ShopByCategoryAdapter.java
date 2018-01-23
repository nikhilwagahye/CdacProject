package com.cdac.projectdemo.model;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdac.projectdemo.R;


public class ShopByCategoryAdapter extends RecyclerView.Adapter<ShopByCategoryAdapter.ViewHolder> {

    Activity context;
    int size;

    public ShopByCategoryAdapter(Activity context, int size) {
        super();
        this.context = context;
        this.size = size;
    }

    @Override
    public ShopByCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_shop_by_category, viewGroup, false);
        ShopByCategoryAdapter.ViewHolder viewHolder = new ShopByCategoryAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShopByCategoryAdapter.ViewHolder viewHolder, final int position) {
    }


    @Override
    public int getItemCount() {
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
