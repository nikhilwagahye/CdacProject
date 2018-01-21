package com.cdac.projectdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.adapters.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{


    private SearchAdapter searchAdapter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayoutSearch;
    private ImageView imageViewBack;
    private ImageView imageViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        linearLayoutSearch = (LinearLayout) findViewById(R.id.linearLayoutSearch);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageViewBack  = (ImageView) findViewById(R.id.imageViewBack);
        imageViewSearch = (ImageView) findViewById(R.id.imageViewSearch);

        imageViewBack.setOnClickListener(this);
        imageViewSearch.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imageViewBack:
                hideKeyBoard();
                finish();

                break;

            case R.id.imageViewSearch:
                hideKeyBoard();
                linearLayoutSearch.setVisibility(View.VISIBLE);
                setData();
                break;
        }
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public void setData() {
        List<String> list = new ArrayList<String>();
        list.add("The Jungle Book");
        list.add("The Mingle Book");
        list.add("The Book1 ");
        list.add("The Jungle Book 3");
        list.add("The Jungle Book 4");
        list.add("The Jungle Book 5");
        list.add("The Jungle Book 6");

        searchAdapter = new SearchAdapter(SearchActivity.this, list);
        recyclerView.setAdapter(searchAdapter);
    }

    @Override
    public void onBackPressed() {
    /*    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive() == true) {
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        } else {*/
        super.onBackPressed();
        //  }
    }
}
