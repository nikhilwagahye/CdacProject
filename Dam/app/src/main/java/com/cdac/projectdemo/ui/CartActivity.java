package com.cdac.projectdemo.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.NetworkUtil;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.background.BGTaskForCart;
import com.cdac.projectdemo.background.BGTaskForTest;
import com.cdac.projectdemo.interfacebinding.IDataResponse;
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.model.BookTest;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    List<Cart> list = new ArrayList<Cart>();
    private ProgressDialog progressDialog;
    private LinearLayout linearLayoutCheckout;
    private TextView textViewNoData;
    private CartAdapter adapter;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(CartActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        textViewNoData = (TextView) findViewById(R.id.textViewNoData);
        linearLayoutCheckout = (LinearLayout) findViewById(R.id.linearLayoutCheckout);

        imageViewBack=(ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

        progressDialog = new ProgressDialog(CartActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final List<Cart> list = new ArrayList<Cart>();

        User user = SharedPreferenceManager.getUserObjectFromSharedPreference();

        if (user != null) {
            String cartNode = user.getUserId() + "/cartlist";

            database.child(cartNode).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Cart cart = noteDataSnapshot.getValue(Cart.class);
                        list.add(cart);
                    }

                    progressDialog.cancel();

                    if (list.size() > 0) {
                        recyclerView.setVisibility(View.VISIBLE);
                        linearLayoutCheckout.setVisibility(View.VISIBLE);
                        textViewNoData.setVisibility(View.GONE);
                        Collections.reverse(list);
                        recyclerView.setAdapter(new CartAdapter(CartActivity.this, list, recyclerView, textViewNoData, linearLayoutCheckout));
                    } else {
                        textViewNoData.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        linearLayoutCheckout.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Log.e("Error", "Error");
                    progressDialog.cancel();

                }
            });
        }


        linearLayoutCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });


    }


}
