package com.cdac.projectdemo.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.adapters.OrdersAdapter;
import com.cdac.projectdemo.adapters.ShoppingListAdapter;
import com.cdac.projectdemo.ui.ShopBooksActivity;


public class OrdersFragment extends Fragment {


    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_orders, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setAdapter(new OrdersAdapter(getActivity(), 6));
        return rootView;
    }

}
