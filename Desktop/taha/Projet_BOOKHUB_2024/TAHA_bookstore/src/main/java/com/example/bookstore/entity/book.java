package com.example.bookstore.entity;


import javax.persistence.*;

@Entity
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long book_id;
    private String name ;
    private String auther ;
    private String description;
    private String imageURL;

    public book(Long book_id, String name, String auther, String price,String description) {
        this.book_id = book_id;
        this.name = name;
        this.auther = auther;
        this.price = price;
        this.description=description;
    }

    private String price ;

    public book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
