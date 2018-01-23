package com.cdac.projectdemo.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cdac.projectdemo.R;


public class ShopByCategoryGridAdapter extends BaseAdapter {

    Activity context;
    int size;

    public ShopByCategoryGridAdapter(Activity context, int size) {
        this.context = context;
        this.size = size;
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View myView;
        if (convertView == null) {  // if it's not recycled, initialize some attribute
            //Inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.item_shop_by_category, null);
        } else {
            myView = (View) convertView;
        }

        TextView textView = (TextView) myView.findViewById(R.id.textView);
        textView.setText("Item " + position);


        return myView;
    }


}