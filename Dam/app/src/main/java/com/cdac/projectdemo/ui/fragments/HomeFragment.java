package com.cdac.projectdemo.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.model.BookList;
import com.cdac.projectdemo.ui.SearchActivity;
import com.cdac.projectdemo.ui.ShopByCategoryActivity;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private View rootView;
    private Button buttonShopByCategory;
    private LinearLayout linearLayoutSearch;
    private ImageView imageViewTrending1;
    private ImageView imageViewTrending2;
    private ImageView imageViewTrending3;
    private ArrayList<BookList> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();

        return rootView;
    }

    private void initViews() {
        buttonShopByCategory = (Button) rootView.findViewById(R.id.buttonShopByCategory);
        buttonShopByCategory.setOnClickListener(this);
        linearLayoutSearch = (LinearLayout) rootView.findViewById(R.id.linearLayoutSearch);
        linearLayoutSearch.setOnClickListener(this);

        imageViewTrending1 = (ImageView) rootView.findViewById(R.id.imageViewTrending1);
        imageViewTrending2 = (ImageView) rootView.findViewById(R.id.imageViewTrending2);
        imageViewTrending3 = (ImageView) rootView.findViewById(R.id.imageViewTrending3);
        imageViewTrending1.setOnClickListener(this);
        imageViewTrending2.setOnClickListener(this);
        imageViewTrending3.setOnClickListener(this);


        List<String> Elist3 = new ArrayList<String>();
        //Diary Of a Wimpy Kids=editors corner
        Elist3.add("https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg");
        Elist3.add("https://images-na.ssl-images-amazon.com/images/I/91R1lC3DVNL.jpg");
        Elist3.add("https://images-na.ssl-images-amazon.com/images/I/41YUa-2EQdL.jpg");

        List<String> Elist4 = new ArrayList<String>();
        //Diary Of a Wimpy Kids=editors corner
        Elist4.add("https://images-na.ssl-images-amazon.com/images/I/71ZNdhVPAEL.jpg");
        Elist4.add("https://images-na.ssl-images-amazon.com/images/I/819CNMucZ1L.jpg");

        List<String> Elist5 = new ArrayList<String>();
        //Diary Of a Wimpy Kids=editors corner
        Elist5.add("https://images-na.ssl-images-amazon.com/images/I/51rv6edfY6L.jpg");
        Elist5.add("https://images-na.ssl-images-amazon.com/images/I/41cXWaZTPQL.jpg");
        Elist5.add("https://images-na.ssl-images-amazon.com/images/I/41Ya5UnPezL.jpg");


        list = new ArrayList<BookList>();
        list.add(new BookList("3", "Looking For Alaska", "John Green", "This is an amazing first novel by a writer who is young enough to vividly remember his powerful years of high school and he expertly turns remembrance into story.",
                "Harpercollins; Latest edition (1 February 2013)", 271, Elist3, 5, 171));
        list.add(new BookList("4", "Steve Jobs", "Walter Isaacson", "An extraordinary book which gives us a unique insight into the life and thinking of the man who has single-handedly transformed the way we live today",
                "Little, Brown Book Group; 2015 edition (11 February 2015)", 592, Elist4, 6, 274));
        list.add(new BookList("5", "The Fault in our Stars", "John Green", "The Fault in Our Stars is distinct love story of two teenage cancer sufferers and revolves around a couple who fall for each other irrespective of the fact that they are struggling between life and death. This book blends in it all kinds of elements such as humor, sentiment and emotions.",
                "Penguin; Movie Tie-in Edition edition (28 May 2014)", 336, Elist5, 4, 199));


        Picasso.with(getActivity()).load(list.get(0).getImageUrl().get(0)).placeholder(R.drawable.book_image_new)
                .into(imageViewTrending1, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        imageViewTrending1.setImageResource(R.drawable.book_image_new);
                    }
                });


        Picasso.with(getActivity()).load(list.get(1).getImageUrl().get(0)).placeholder(R.drawable.book_image_new)
                .into(imageViewTrending2, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        imageViewTrending2.setImageResource(R.drawable.book_image_new);
                    }
                });

        Picasso.with(getActivity()).load(list.get(2).getImageUrl().get(0)).placeholder(R.drawable.book_image_new)
                .into(imageViewTrending3, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        imageViewTrending3.setImageResource(R.drawable.book_image_new);
                    }
                });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonShopByCategory:
                navigateToShopByCategory();
                break;

            case R.id.linearLayoutSearch:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;

            case R.id.imageViewTrending1:
                navigateToDetails(list.get(0));
                break;

            case R.id.imageViewTrending2:
                navigateToDetails(list.get(1));
                break;

            case R.id.imageViewTrending3:
                navigateToDetails(list.get(2));
                break;

        }

    }

    public void navigateToDetails(BookList bookList) {
        Intent intent = new Intent(getActivity(), ShoppingBoookDetailsActivity.class);

        Gson gson = new Gson();
        String objJSON = gson.toJson(bookList);
        intent.putExtra("BookObject", objJSON);
        startActivity(intent);
    }

    private void navigateToShopByCategory() {
        Intent intent = new Intent(getActivity(), ShopByCategoryActivity.class);
        startActivity(intent);
    }
}
