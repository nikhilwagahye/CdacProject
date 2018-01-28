package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.adapters.CauroselPageAdapter;
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.User;
import com.cdac.projectdemo.pageindicator.PageControl;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
    private TextView textViewPrice;
    private DatabaseReference database;

    boolean flagAddedToCart = true;
    private LinearLayout linearLayoutShoppingCart;
    private TextView textViewBadgeCountDashBoard;
    private ImageView imageViewBack;

    private ArrayList<Cart> list;

    int count = 0;
    private String cartNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_boook_details);

        Gson gson = new Gson();
        bookObject = gson.fromJson(getIntent().getStringExtra("BookObject"), BookList.class);

        initCarouselData(bookObject.getImageUrl());
        imageViewMinus = (ImageView) findViewById(R.id.imageViewMinus);
        imageViewPlus = (ImageView) findViewById(R.id.imageViewPlus);
        textViewQty = (TextView) findViewById(R.id.textViewQty);
        linearLayoutAddToCart = (LinearLayout) findViewById(R.id.linearLayoutAddToCart);
        // linearLayoutCheckout = (LinearLayout) findViewById(R.id.linearLayoutCheckout);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAuthor = (TextView) findViewById(R.id.textViewAuthor);
        textViewPublishedBy = (TextView) findViewById(R.id.textViewPublishedBy);
        textViewQuanityAvailable = (TextView) findViewById(R.id.textViewQuanityAvailable);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);

        linearLayoutShoppingCart = (LinearLayout) findViewById(R.id.linearLayoutShoppingCart);
        textViewBadgeCountDashBoard = (TextView) findViewById(R.id.textViewBadgeCountDashBoard);

        imageViewBack = (ImageView) findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        textViewDesc.setText(bookObject.getDescription());
        textViewAuthor.setText(bookObject.getAuthor());
        textViewName.setText(bookObject.getName());
        textViewPublishedBy.setText("Published by, " + bookObject.getPublisher());
        textViewQuanityAvailable.setText("Quantity Available : " + bookObject.getQuantity());
        textViewPrice.setText(bookObject.getPrice() + "");
        SharedPreferenceManager.setApplicationContext(ShoppingBoookDetailsActivity.this);

        imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(textViewQty.getText().toString());
                if (qty < bookObject.getQuantity()) {
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


        SharedPreferenceManager.setApplicationContext(ShoppingBoookDetailsActivity.this);

        database = FirebaseDatabase.getInstance().getReference();
        final User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
        if (user != null) {
            cartNode = user.getUserId() + "/cartlist";
        }

        linearLayoutAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user != null) {

                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            Cart cart = list.get(i);
                            if (bookObject.getName().equalsIgnoreCase(cart.getBookName())) {
                                flagAddedToCart = false;
                            }
                        }

                        if (flagAddedToCart) {
                            Cart cart = new Cart();
                            cart.setCartId(database.child(cartNode).push().getKey());
                            cart.setBookName(bookObject.getName());
                            cart.setImageURL(bookObject.getImageUrl().get(0));
                            cart.setPrice(bookObject.getPrice());
                            cart.setQtyOrdered(Integer.parseInt(textViewQty.getText().toString()));
                            cart.setTotalQtyAvailable(bookObject.getQuantity());
                            database.child(cartNode).child(cart.getCartId()).setValue(cart);
                            count = count + 1;
                            showCartCount(count);
                            list.add(cart);

                            Toast.makeText(ShoppingBoookDetailsActivity.this, "Added to cart.", Toast.LENGTH_SHORT).show();
                        } else {
                            flagAddedToCart = true;
                            Toast.makeText(ShoppingBoookDetailsActivity.this, "This book is already added to cart.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Cart cart = new Cart();
                        cart.setCartId(database.child(cartNode).push().getKey());
                        cart.setBookName(bookObject.getName());
                        cart.setImageURL(bookObject.getImageUrl().get(0));
                        cart.setPrice(bookObject.getPrice());
                        cart.setQtyOrdered(Integer.parseInt(textViewQty.getText().toString()));
                        cart.setTotalQtyAvailable(bookObject.getQuantity());
                        database.child(cartNode).child(cart.getCartId()).setValue(cart);
                        flagAddedToCart = true;
                        list.add(cart);
                        count = count + 1;
                        showCartCount(count);
                        Toast.makeText(ShoppingBoookDetailsActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            }
        });


     /*   linearLayoutCheckout.setOnClickListener(new View.OnClickListener() {
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
        });*/


        linearLayoutShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedPreferenceManager.getUserObjectFromSharedPreference() != null) {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, CartActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ShoppingBoookDetailsActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void showCartCount(int size) {
        if (size > 0) {
            textViewBadgeCountDashBoard.setVisibility(View.VISIBLE);
            textViewBadgeCountDashBoard.setText(size + "");
        } else {
            textViewBadgeCountDashBoard.setVisibility(View.GONE);
        }
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

    @Override
    protected void onResume() {
        super.onResume();

        list = new ArrayList<Cart>();

        final User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
        if (user != null) {
            cartNode = user.getUserId() + "/cartlist";

            database.child(cartNode).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Cart cart = noteDataSnapshot.getValue(Cart.class);
                        list.add(cart);
                        Log.e("Item" +
                                "3" +
                                ":", cart.getBookName());
                    }

                    count = list.size();
                    showCartCount(count);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("Error", "Error");
                }
            });
        }

    }

}
