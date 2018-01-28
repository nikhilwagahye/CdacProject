package com.cdac.projectdemo.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdac.projectdemo.R;

import java.util.List;

/**
 * Created by nikhilkumar.waghaye on 04-07-2017.
 */

public class ShopByCategoryGridAdapter extends BaseAdapter {

    Activity context;
    List<Category> list;

    public ShopByCategoryGridAdapter(Activity context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
        Category category = list.get(position);


        TextView textView = (TextView) myView.findViewById(R.id.textView);
        ImageView myImage=(ImageView) myView.findViewById(R.id.myimage);
        textView.setText(category.getCategoryName());
        myImage.setImageDrawable(category.getCategoryImage());



        return myView;
    }


}