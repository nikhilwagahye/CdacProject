package com.cdac.projectdemo.model;



public class Cart {

    String bookName;
    String imageURL;
    double price;
    String cartId;
    int qty;


    public Cart() {
    }

    public Cart(String bookName, String imageURL, double price, String cartId, int qty) {
        this.bookName = bookName;
        this.imageURL = imageURL;
        this.price = price;
        this.cartId = cartId;
        this.qty = qty;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
