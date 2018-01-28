package com.cdac.projectdemo.adapters;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.Orders;
import com.cdac.projectdemo.model.User;
import com.cdac.projectdemo.ui.ShoppingBoookDetailsActivity;
import com.cdac.projectdemo.ui.SuccessPageActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private final DatabaseReference database;
    Activity context;
    List<Orders> list;
    private String ordersNode;

    public OrdersAdapter(Activity context, List<Orders> list) {
        super();
        this.context = context;
        this.list = list;
        database = FirebaseDatabase.getInstance().getReference();

    }

    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_orders, viewGroup, false);
        OrdersAdapter.ViewHolder viewHolder = new OrdersAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OrdersAdapter.ViewHolder viewHolder, final int position) {

        final Orders orders = list.get(position);
        viewHolder.textViewName.setText(orders.getName());
        viewHolder.textViewPrice.setText(orders.getPrice() + "");
        viewHolder.textViewPaymentType.setText(orders.getModeOfPayment() + "");
        viewHolder.textViewQty.setText(orders.getQuantity() + "");
        viewHolder.orderDate.setText(orders.getOrderDate() + "");
        viewHolder.orderId.setText(orders.getOrderId());

        Picasso.with(context).load(orders.getImageURL()).placeholder(R.drawable.book_image_new)
                .into(viewHolder.imageView, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Log.i("Error", "Picasso Success - user profile pic");
                    }

                    public void onError() {
                        Log.i("", "Picasso Error - user profile pic");
                        viewHolder.imageView.setImageResource(R.drawable.book_image_new);
                    }
                });


        viewHolder.linearLayoutCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update to firebase
                orders.setOrderFlag(false);

                final User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
                if (user != null) {
                    ordersNode = user.getUserId() + "/ordersListNew";
                    database.child(ordersNode).child(orders.getOrderId()).setValue(orders);
                    // update local UI
                    updateList(orders, position);
                    showLocalNotification();
                }
            }
        });


        if (orders.isOrderFlag() == true) {
            // order is not cancelled
            viewHolder.linearLayoutCancel.setVisibility(View.VISIBLE);
            viewHolder.textViewCancelledOrderMsg.setVisibility(View.GONE);
        } else {
            // order is  cancelled
            viewHolder.linearLayoutCancel.setVisibility(View.GONE);
            viewHolder.textViewCancelledOrderMsg.setVisibility(View.VISIBLE);
        }
    }

    public void updateList(Orders orders, int position) {

        list.set(position, orders);
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName;
        TextView textViewQty;
        TextView textViewPrice;
        TextView textViewPaymentType;
        TextView orderDate;
        TextView orderId;
        TextView textViewCancelledOrderMsg;
        LinearLayout linearLayoutCancel;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewQty = (TextView) itemView.findViewById(R.id.textViewQty);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            textViewPaymentType = (TextView) itemView.findViewById(R.id.textViewPaymentType);
            orderDate = (TextView) itemView.findViewById(R.id.orderDate);
            orderId = (TextView) itemView.findViewById(R.id.orderId);
            textViewCancelledOrderMsg = (TextView) itemView.findViewById(R.id.textViewCancelledOrderMsg);
            linearLayoutCancel = (LinearLayout) itemView.findViewById(R.id.linearLayoutCancel);
        }
    }


    private void showLocalNotification() {

        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();


        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.book_icn).setTicker("Order Cancelled").setWhen(0)
                .setAutoCancel(true)
                .setContentTitle("Order Cancelled")
                //.setContentIntent(resultPendingIntent)
                .setDefaults(defaults)
                .setStyle(inboxStyle)
                .setWhen(System.currentTimeMillis())
                //.setSmallIcon(R.drawable.notification_icon)
                .setSmallIcon(getNotificationIcon())
                .setContentText("Your Order is cancelled. Thanks")
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        notificationManager.notify(m, notification);
    }


    private int getNotificationIcon() {
        boolean useWhiteIcon = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.ic_stat_email : R.mipmap.book_icn;
    }

}

