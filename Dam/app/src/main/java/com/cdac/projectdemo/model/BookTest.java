package com.cdac.projectdemo.model;

/**
 * Created by nikhilkumar.waghaye on 21-01-2018.
 */

public class BookTest {
    /*
     {
        "perSqFtPrice": "37",
        "productImageURL": "https://www.asianpaints.com/content/dam/asianpaints/website/products/packshots/royale%20aspira.png",
        "productName": "Royale Aspira*",
        "productType": "shade"
    },
     */

    String bookPrice;
    String bookURL;
    String bookName;
    String bookType;


    public BookTest() {
    }

    public BookTest(String bookPrice, String bookURL, String bookName, String bookType) {
        this.bookPrice = bookPrice;
        this.bookURL = bookURL;
        this.bookName = bookName;
        this.bookType = bookType;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookURL() {
        return bookURL;
    }

    public void setBookURL(String bookURL) {
        this.bookURL = bookURL;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
