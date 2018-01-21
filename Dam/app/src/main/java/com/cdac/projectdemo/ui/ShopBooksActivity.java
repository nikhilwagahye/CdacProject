package com.cdac.projectdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.adapters.ShoppingListAdapter;

public class ShopBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_books);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ShopBooksActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setAdapter(new ShoppingListAdapter(ShopBooksActivity.this, 20));

    }
}
