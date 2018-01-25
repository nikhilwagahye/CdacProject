package com.cdac.projectdemo.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.Orders;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuccessPageActivity extends AppCompatActivity {

    private Button shopAgain;
    private ArrayList<Cart> list;
    private DatabaseReference database;

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        shopAgain = (Button) findViewById(R.id.shopAgain);


        shopAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToShopByCategory();
            }
        });


        SharedPreferenceManager.setApplicationContext(SuccessPageActivity.this);
        database = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<Cart>();
        database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (flag == false) {
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Cart cart = noteDataSnapshot.getValue(Cart.class);
                        list.add(cart);

                    }
                    addToOrders();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.e("Error", "Error");

            }
        });


    }


    public void addToOrders() {

        // add to orders

        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        String datetime = myFormat.format(date);

        final String ordersNode = "ordersListNew/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId();

        for (int i = 0; i < list.size(); i++) {
            Orders orders = new Orders();
            orders.setOrderId(database.child(ordersNode).push().getKey());
            orders.setModeOfPayment("Cash On Delivery");
            orders.setName(list.get(i).getBookName());
            orders.setOrderFlag(true);
            orders.setImageURL(list.get(i).getImageURL());
            orders.setQuantity(list.get(i).getQty());
            orders.setOrderDate(datetime);

            double price = list.get(i).getQty() * list.get(i).getPrice();
            orders.setPrice(price);

            database.child(ordersNode).child(orders.getOrderId()).setValue(orders);
            flag = false;
            // database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).child(list.get(i).getCartId()).removeValue();
        }

        flag = true;
        database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).setValue(null);

    }

    private void navigateToShopByCategory() {
        Intent intent = new Intent(SuccessPageActivity.this, ShopByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SuccessPageActivity.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
