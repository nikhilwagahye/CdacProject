package com.cdac.projectdemo.model;

import java.util.List;

/**
 * Created by Akruti on 23-01-2018.
 */

public class BookList
{
    String id;
    String name;
    String author;
    String description;
    String publisher;
    int pages;
    List<String> imageUrl;
    int quantity;
    double price;



    public BookList() {
    }

    public BookList(String id, String name, String author, String description,String publisher,int pages, List<String> imageUrl, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.publisher= publisher;
        this.pages=pages;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
