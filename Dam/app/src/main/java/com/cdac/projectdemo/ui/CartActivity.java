package com.cdac.projectdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.NetworkUtil;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.background.BGTaskForTest;
import com.cdac.projectdemo.interfacebinding.IDataResponse;
import com.cdac.projectdemo.model.BookTest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements IDataResponse {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    List<BookTest> list = new ArrayList<BookTest>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        BGTaskForTest bgTaskForTest = new BGTaskForTest(CartActivity.this, this);
        bgTaskForTest.execute();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(CartActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);


        //recyclerView.setAdapter(new CartAdapter(CartActivity.this, 5));*/
    }


    @Override
    public void responseHandle(JSONArray jsonArray) {
        // From OnPostExecute og BG Task

        // parsing logic
        if (jsonArray != null && jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject != null) {
                        BookTest bookTest = new BookTest();

                        bookTest.setBookName(jsonObject.getString("productName"));
                        bookTest.setBookPrice(jsonObject.getString("perSqFtPrice"));
                        bookTest.setBookType(jsonObject.getString("productType"));
                        bookTest.setBookURL(jsonObject.getString("productImageURL"));
                        list.add(bookTest);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            recyclerView.setAdapter(new CartAdapter(CartActivity.this, list));
        }


    }
}
