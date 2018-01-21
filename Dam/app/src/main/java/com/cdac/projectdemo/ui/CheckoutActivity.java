package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.adapters.CheckoutAdapter;

public class CheckoutActivity extends AppCompatActivity {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView recyclerView1;
    private LinearLayout linearLayoutPayment;

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
        recyclerView1.setAdapter(new CheckoutAdapter(CheckoutActivity.this, 2));


        linearLayoutPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CheckoutActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
    
    
    
}
