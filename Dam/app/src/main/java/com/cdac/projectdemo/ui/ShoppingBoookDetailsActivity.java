package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CauroselPageAdapter;
import com.cdac.projectdemo.pageindicator.PageControl;

public class ShoppingBoookDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PageControl page_control;
    private ImageView imageViewMinus;
    private ImageView imageViewPlus;
    private TextView textViewQty;
    private CauroselPageAdapter pagerAdapter;
    private LinearLayout linearLayoutAddToCart;
    private LinearLayout linearLayoutCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_boook_details);

        initCarouselData();
        imageViewMinus = (ImageView) findViewById(R.id.imageViewMinus);
        imageViewPlus = (ImageView) findViewById(R.id.imageViewPlus);
        textViewQty = (TextView) findViewById(R.id.textViewQty);
        linearLayoutAddToCart = (LinearLayout) findViewById(R.id.linearLayoutAddToCart);
        linearLayoutCheckout = (LinearLayout) findViewById(R.id.linearLayoutCheckout);

        SharedPreferenceManager.setApplicationContext(ShoppingBoookDetailsActivity.this);

        imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(textViewQty.getText().toString());
                qty = qty + 1;
                textViewQty.setText(qty + "");
            }
        });

        imageViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(textViewQty.getText().toString());
                if (qty >= 1) {
                    qty = qty - 1;
                    textViewQty.setText(qty + "");
                }
            }
        });

        linearLayoutAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        linearLayoutCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SharedPreferenceManager.getUserObjectFromSharedPreference() != null) {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, CheckoutActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, SignInActivity.class);
                    startActivity(intent);
                }


            }
        });
    }

    private void initCarouselData() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        page_control = (PageControl) findViewById(R.id.page_control);

        viewPager.setPageMargin(10);
        viewPager.setClipToPadding(false);
        pagerAdapter = new CauroselPageAdapter(ShoppingBoookDetailsActivity.this, 5);
        viewPager.setAdapter(pagerAdapter);
        page_control.setViewPager(viewPager);
        page_control.setPosition(0);

    }
}
