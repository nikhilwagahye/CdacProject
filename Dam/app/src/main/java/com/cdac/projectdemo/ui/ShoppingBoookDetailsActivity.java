package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CauroselPageAdapter;
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.pageindicator.PageControl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBoookDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PageControl page_control;
    private ImageView imageViewMinus;
    private ImageView imageViewPlus;
    private TextView textViewQty;
    private CauroselPageAdapter pagerAdapter;
    private LinearLayout linearLayoutAddToCart;
    private LinearLayout linearLayoutCheckout;
    private TextView textViewDesc;
    private TextView textViewName;
    private TextView textViewAuthor;
    private TextView textViewPublishedBy;
    private BookList bookObject;
    private TextView textViewQuanityAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_boook_details);


        Gson gson = new Gson();
        bookObject = gson.fromJson(getIntent().getStringExtra("BookObject"),BookList.class);


        initCarouselData(bookObject.getImageUrl());
        imageViewMinus = (ImageView) findViewById(R.id.imageViewMinus);
        imageViewPlus = (ImageView) findViewById(R.id.imageViewPlus);
        textViewQty = (TextView) findViewById(R.id.textViewQty);
        linearLayoutAddToCart = (LinearLayout) findViewById(R.id.linearLayoutAddToCart);
        linearLayoutCheckout = (LinearLayout) findViewById(R.id.linearLayoutCheckout);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAuthor = (TextView) findViewById(R.id.textViewAuthor);
        textViewPublishedBy = (TextView) findViewById(R.id.textViewPublishedBy);
        textViewQuanityAvailable = (TextView) findViewById(R.id.textViewQuanityAvailable);

        textViewDesc.setText(bookObject.getDescription());
        textViewAuthor.setText(bookObject.getAuthor());
        textViewName.setText(bookObject.getName());
        textViewPublishedBy.setText("Published by, "+bookObject.getPublisher());
        textViewQuanityAvailable.setText("Quantity Available : " + bookObject.getQuantity());

        SharedPreferenceManager.setApplicationContext(ShoppingBoookDetailsActivity.this);

        imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(textViewQty.getText().toString());
                if(qty < bookObject.getQuantity()) {
                    qty = qty + 1;
                    textViewQty.setText(qty + "");
                } else {
                    Toast.makeText(ShoppingBoookDetailsActivity.this, "Maximum available quantity of books reached.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(textViewQty.getText().toString());
                if (qty > 1) {
                    qty = qty - 1;
                    textViewQty.setText(qty + "");
                } else {
                    Toast.makeText(ShoppingBoookDetailsActivity.this, "Minimum 1 book should buy...", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Firebase logic to add

        linearLayoutAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });


        linearLayoutCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SharedPreferenceManager.getUserObjectFromSharedPreference() != null) {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, SignInActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

    private void initCarouselData(List<String> imageList) {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        page_control = (PageControl) findViewById(R.id.page_control);

        viewPager.setPageMargin(10);
        viewPager.setClipToPadding(false);
        pagerAdapter = new CauroselPageAdapter(ShoppingBoookDetailsActivity.this, imageList);
        viewPager.setAdapter(pagerAdapter);
        page_control.setViewPager(viewPager);
        page_control.setPosition(0);

    }
}
