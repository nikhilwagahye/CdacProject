package com.cdac.projectdemo.model;

/**
 * Created by nikhilkumar.waghaye on 25-01-2018.
 */

public class Orders {

    String orderId;
    String name;
    int Quantity;
    double price;
    String modeOfPayment;
    boolean orderFlag;

    String imageURL;
    String orderDate;


    public Orders() {

    }

    public Orders(String orderId, String name, int quantity, double price, String modeOfPayment, boolean orderFlag, String imageURL, String orderDate) {
        this.orderId = orderId;
        this.name = name;
        Quantity = quantity;
        this.price = price;
        this.modeOfPayment = modeOfPayment;
        this.orderFlag = orderFlag;
        this.imageURL = imageURL;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public boolean isOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(boolean orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
