package com.cdac.projectdemo.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.model.ShopByCategoryAdapter;
import com.cdac.projectdemo.model.ShopByCategoryGridAdapter;
import com.cdac.projectdemo.model.TypesOfBoosAdapter;


public class ShopByCategoryActivity extends AppCompatActivity {

    private ShopByCategoryAdapter adapter;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_by_category);

        initViews();
    }

    private void initViews() {
       /* RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new ShopByCategoryAdapter(ShopByCategoryActivity.this, 10);
        recyclerView.setAdapter(adapter);*/
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ShopByCategoryGridAdapter(ShopByCategoryActivity.this, 10));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDlg();
            }
        });
    }

    private void showDlg() {
        try {

            final Dialog dlg = new Dialog(ShopByCategoryActivity.this);
            dlg.setCanceledOnTouchOutside(true);
            dlg.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dlg.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            dlg.setContentView(LayoutInflater.from(ShopByCategoryActivity.this).inflate(R.layout.dialog_promt, null));
            dlg.show();

            RecyclerView recyclerView = (RecyclerView) dlg.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(ShopByCategoryActivity.this);
            recyclerView.setLayoutManager(mLayoutManager);

            recyclerView.setAdapter(new TypesOfBoosAdapter(ShopByCategoryActivity.this, 4));


        } catch (Exception ex) {

            Log.e("Exception:", "here");
        }

    }
}
