package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cdac.projectdemo.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class CauroselPageAdapter extends PagerAdapter {

    Activity activity;
    LayoutInflater inflater;
    List<String> imageList;


    public CauroselPageAdapter(Activity activity, List<String> imageList) {

        this.activity = activity;
        this.imageList = imageList;
    }


    @Override
    public int getCount() {
        return imageList.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int i) {
        inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View itemView = inflater.inflate(R.layout.item_carousel, container, false);
        final ImageView frame_img = (ImageView) itemView.findViewById(R.id.frame_img);
        Picasso.with(activity).load(imageList.get(i)).placeholder(R.drawable.book_image_new)
                .into(frame_img, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        frame_img.setImageResource(R.drawable.book_image_new);
                    }
                });
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 1f;
    }


}
