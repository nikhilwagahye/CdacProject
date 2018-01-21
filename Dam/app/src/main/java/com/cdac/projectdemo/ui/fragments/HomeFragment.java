package com.cdac.projectdemo.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.ui.SearchActivity;
import com.cdac.projectdemo.ui.ShopByCategoryActivity;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private View rootView;
    private Button buttonShopByCategory;
    private LinearLayout linearLayoutSearch;
    private ImageView imageViewTrending1;
    private ImageView imageViewTrending2;
    private ImageView imageViewTrending3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();

        return rootView;
    }

    private void initViews() {
        buttonShopByCategory = (Button) rootView.findViewById(R.id.buttonShopByCategory);
        buttonShopByCategory.setOnClickListener(this);
        linearLayoutSearch = (LinearLayout) rootView.findViewById(R.id.linearLayoutSearch);
        linearLayoutSearch.setOnClickListener(this);

        imageViewTrending1 = (ImageView)rootView.findViewById(R.id.imageViewTrending1);
        imageViewTrending2 = (ImageView)rootView.findViewById(R.id.imageViewTrending2);
        imageViewTrending3 = (ImageView)rootView.findViewById(R.id.imageViewTrending3);
        imageViewTrending1.setOnClickListener(this);
        imageViewTrending2.setOnClickListener(this);
        imageViewTrending3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonShopByCategory:
                navigateToShopByCategory();
                break;

            case R.id.linearLayoutSearch:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;

            case R.id.imageViewTrending1:
           navigateToDetails();
                break;

            case R.id.imageViewTrending2:
              navigateToDetails();
                break;

            case R.id.imageViewTrending3:
              navigateToDetails();
                break;

        }

    }

    public void navigateToDetails() {
        Intent intent = new Intent(getActivity(), ShoppingBoookDetailsActivity.class);
        startActivity(intent);
    }

    private void navigateToShopByCategory() {
        Intent intent = new Intent(getActivity(), ShopByCategoryActivity.class);
        startActivity(intent);
    }
}
