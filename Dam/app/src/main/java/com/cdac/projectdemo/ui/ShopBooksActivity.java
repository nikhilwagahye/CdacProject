package com.cdac.projectdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.adapters.ShoppingListAdapter;
import com.cdac.projectdemo.background.BGTaskForShoppingBooks;
import com.cdac.projectdemo.interfacebinding.IDataResponse;
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.model.BookTest;
import com.cdac.projectdemo.ui.fragments.ShopByCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShopBooksActivity extends AppCompatActivity implements IDataResponse {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private String categoryName;
    private String api;
    List<BookList> list = new ArrayList<BookList>();
    private TextView textViewTitle;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_books);

        imageViewBack=(ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCategory();
            }
        });


        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        categoryName = getIntent().getStringExtra("CategoryName");
        textViewTitle.setText(categoryName);
        // pass this to API
        // https://booksellingappfirebase.firebaseio.com/booklist/.json
        api = "https://booksellingappfirebase.firebaseio.com/booklist/" + categoryName.replace(" ","%20") + "/.json"; // category wise API Call...
        // now write AsyncTask call
        // inteface handelling
        // set adapter of new data

        BGTaskForShoppingBooks bgTask = new BGTaskForShoppingBooks(ShopBooksActivity.this, this, api);
        bgTask.execute();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ShopBooksActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);


        //intent intent
        //api
        //get intent

    }

    @Override
    public void responseHandle(JSONArray jsonArray) {

        // parsing logic
        try {
            if (jsonArray != null && jsonArray.length() > 0) {
                jsonArray.remove(0); // removing null which is not required...
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject != null) {
                        BookList bookList = new BookList();

                        bookList.setId(jsonObject.getString("id"));
                        bookList.setName(jsonObject.getString("name"));
                        bookList.setAuthor(jsonObject.getString("author"));
                        bookList.setDescription(jsonObject.getString("description"));
                        bookList.setPublisher(jsonObject.getString("publisher"));
                        bookList.setPages(jsonObject.getInt("pages"));

                        JSONArray jsonArray1 = jsonObject.getJSONArray("imageUrl");
                        List<String> imageList = new ArrayList<String>();
                        for (int j = 0; j < jsonArray1.length(); j++) {
                            String imageUrl = jsonArray1.getString(j);
                            imageList.add(imageUrl);
                        }
                        bookList.setImageUrl(imageList);
                        bookList.setQuantity(jsonObject.getInt("quantity"));
                        bookList.setPrice(jsonObject.getDouble("price"));

                        list.add(bookList);
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(new ShoppingListAdapter(ShopBooksActivity.this, list));
    }

    @Override
    public void onBackPressed() {
        navigateToCategory();
    }

    private void navigateToCategory() {
        Intent intent = new Intent(ShopBooksActivity.this, ShopByCategory.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
