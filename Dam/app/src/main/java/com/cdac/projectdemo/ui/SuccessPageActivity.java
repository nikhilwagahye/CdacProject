package com.cdac.projectdemo.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.adapters.CartAdapter;
import com.cdac.projectdemo.model.Cart;
import com.cdac.projectdemo.model.Orders;
import com.cdac.projectdemo.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SuccessPageActivity extends AppCompatActivity {

    private Button shopAgain;
    private ArrayList<Cart> list;
    private DatabaseReference database;

    boolean flag;
    private String cartNode;
    private String ordersNode;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        shopAgain = (Button) findViewById(R.id.shopAgain);

        shopAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToShopByCategory();
            }
        });


        SharedPreferenceManager.setApplicationContext(SuccessPageActivity.this);
        database = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<Cart>();

        user = SharedPreferenceManager.getUserObjectFromSharedPreference();

        if (user != null) {
            cartNode = user.getUserId() + "/cartlist";

            database.child(cartNode).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (flag == false) {
                        for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                            Cart cart = noteDataSnapshot.getValue(Cart.class);
                            list.add(cart);

                        }
                        addToOrders();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Log.e("Error", "Error");

                }
            });
        }


    }


    public void addToOrders() {

        // add to orders

        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a"); // format in which we need, 24/01/2018 07:30 pm --> a means pm/am , hh - 12 hr, HH - 24 hr format
        Date date = new Date();
        String datetime = myFormat.format(date);

        if (user != null) {
            ordersNode = user.getUserId() + "/ordersListNew";

            for (int i = 0; i < list.size(); i++) {
                Orders orders = new Orders();
                orders.setOrderId(database.child(ordersNode).push().getKey());
                orders.setModeOfPayment("COD");
                orders.setName(list.get(i).getBookName());
                orders.setOrderFlag(true); // means order is not cancelled.
                orders.setImageURL(list.get(i).getImageURL());
                orders.setQuantity(list.get(i).getQtyOrdered());
                orders.setOrderDate(datetime);
                double price = list.get(i).getQtyOrdered() * list.get(i).getPrice();
                orders.setPrice(price);

                database.child(ordersNode).child(orders.getOrderId()).setValue(orders);
                flag = false;
                // database.child("cartlist/" + SharedPreferenceManager.getUserObjectFromSharedPreference().getUserId()).child(list.get(i).getCartId()).removeValue();
            }

            flag = true;
            database.child(cartNode).setValue(null);


            // send notification
            showLocalNotification();

        }
    }

    private void showLocalNotification() {

        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                SuccessPageActivity.this);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();


        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.book_icn).setTicker("Order Successful").setWhen(0)
                .setAutoCancel(true)
                .setContentTitle("Order Successful")
                //.setContentIntent(resultPendingIntent)
                .setDefaults(defaults)
                .setStyle(inboxStyle)
                .setWhen(System.currentTimeMillis())
                //.setSmallIcon(R.drawable.notification_icon)
                .setSmallIcon(getNotificationIcon())
                .setContentText("Your Order is confirmed. Thanks")
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        notificationManager.notify(m, notification);
    }


    private int getNotificationIcon() {
        boolean useWhiteIcon = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.ic_stat_email : R.mipmap.book_icn;
    }
    private void navigateToShopByCategory() {
        Intent intent = new Intent(SuccessPageActivity.this, ShopByCategoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SuccessPageActivity.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
