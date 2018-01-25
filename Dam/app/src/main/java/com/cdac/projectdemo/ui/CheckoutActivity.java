package com.cdac.projectdemo.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.adapters.CheckoutAdapter;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView recyclerView1;
    private LinearLayout linearLayoutPayment;
    private ProgressDialog progressDialog;
    private EditText editTextAddress;
    private RelativeLayout lineLayoutAddress;
    private TextView textViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        linearLayoutPayment = (LinearLayout) findViewById(R.id.linearLayoutPayment);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(CheckoutActivity.this);
        recyclerView1.setLayoutManager(mLayoutManager);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        textViewTotal = (TextView) findViewById(R.id.textViewTotal);


        SharedPreferenceManager.setApplicationContext(CheckoutActivity.this);
        User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
        editTextAddress.setText(user.getAddress());
        lineLayoutAddress = (RelativeLayout) findViewById(R.id.lineLayoutAddress);

        progressDialog = new ProgressDialog(CheckoutActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        // Get Cart List from Firebase

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final List<Cart> list = new ArrayList<Cart>();
        database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Cart cart = noteDataSnapshot.getValue(Cart.class);
                    list.add(cart);
                }

                progressDialog.cancel();

                if (list.size() > 0) {
                    recyclerView1.setVisibility(View.VISIBLE);
                    recyclerView1.setAdapter(new CheckoutAdapter(CheckoutActivity.this, list));
                } else {
                    recyclerView1.setVisibility(View.GONE);
                }


                double total = 0;
                for(int i = 0; i < list.size(); i++) {
                    double price = list.get(i).getQty() * list.get(i).getPrice();
                    total = total + price;
                }

                textViewTotal.setText(total+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.e("Error", "Error");
                progressDialog.cancel();

            }
        });








        lineLayoutAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              editTextAddress.setEnabled(true);
            }
        });




        linearLayoutPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CheckoutActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                if (result.equalsIgnoreCase("SUCCESS")) {

                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }
    
}
