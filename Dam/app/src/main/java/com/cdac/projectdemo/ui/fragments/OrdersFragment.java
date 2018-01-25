package com.cdac.projectdemo.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.OrdersAdapter;
import com.cdac.projectdemo.adapters.ShoppingListAdapter;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.Orders;
import com.cdac.projectdemo.ui.CartActivity;
import com.cdac.projectdemo.ui.ShopBooksActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class OrdersFragment extends Fragment {


    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProgressDialog progressDialog;
    private TextView textViewNoData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_orders, container, false);


        SharedPreferenceManager.setApplicationContext(getActivity());
        final String ordersNode = "ordersListNew/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId();

       /* progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
*/

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        textViewNoData = (TextView) rootView.findViewById(R.id.textViewNoData);


        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final List<Orders> list = new ArrayList<Orders>();
        database.child(ordersNode).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Orders orders = noteDataSnapshot.getValue(Orders.class);
                    list.add(orders);
                }


                if(list.size() > 0) {
                  //  progressDialog.cancel();
                    recyclerView.setVisibility(View.VISIBLE);
                    textViewNoData.setVisibility(View.GONE);
                    recyclerView.setAdapter(new OrdersAdapter(getActivity(), list));
                } else {
                    recyclerView.setVisibility(View.GONE);
                    textViewNoData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.e("Error", "Error");
               // progressDialog.cancel();

            }
        });



        return rootView;
    }

}
