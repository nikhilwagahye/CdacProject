package com.cdac.projectdemo.ui;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.ImageView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.model.Category;
import com.cdac.projectdemo.model.ShopByCategoryAdapter;
import com.cdac.projectdemo.model.ShopByCategoryGridAdapter;
import com.cdac.projectdemo.model.TypesOfBoosAdapter;

import java.util.ArrayList;
import java.util.List;


public class ShopByCategoryActivity extends AppCompatActivity {

    private ShopByCategoryAdapter adapter;
    private GridView gridview;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_by_category);

        initViews();
        imageViewBack = (ImageView) findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });
    }

    private void initViews() {
       /* RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new ShopByCategoryAdapter(ShopByCategoryActivity.this, 10);
        recyclerView.setAdapter(adapter);*/
        gridview = (GridView) findViewById(R.id.gridview);

        List<Category> listOfCategories = new ArrayList<Category>();
        listOfCategories.add(new Category("Business and Economics",getResources().getDrawable(R.drawable.business)));
        listOfCategories.add(new Category("Children and Young Adult",getResources().getDrawable(R.drawable.children)));

        listOfCategories.add(new Category("Editor Corner",getResources().getDrawable(R.drawable.editor_corner)));

        listOfCategories.add(new Category("Fiction",getResources().getDrawable(R.drawable.fiction)));

        listOfCategories.add(new Category("Travel Books",getResources().getDrawable(R.drawable.travel)));
        listOfCategories.add(new Category("Used Books",getResources().getDrawable(R.drawable.used)));
        listOfCategories.add(new Category("Indian History",getResources().getDrawable(R.drawable.history)));
        listOfCategories.add(new Category("Society And Social Science",getResources().getDrawable(R.drawable.society)));



        //pass this in adapter
        gridview.setAdapter(new ShopByCategoryGridAdapter(ShopByCategoryActivity.this, listOfCategories));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // showDlg();

                Category category = (Category)  adapterView.getItemAtPosition(i);
                // navigate to Shop Books Activity
                Intent intent = new Intent(ShopByCategoryActivity.this, ShopBooksActivity.class);

                intent.putExtra("CategoryName", category.getCategoryName());
                startActivity(intent);


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

    @Override
    public void onBackPressed() {
        navigateToHome();
    }

    private void navigateToHome() {
        Intent intent = new Intent(ShopByCategoryActivity.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
