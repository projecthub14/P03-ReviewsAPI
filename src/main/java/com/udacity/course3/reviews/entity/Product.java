package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_count")
    private int productCount;

    @OneToMany(cascade = CascadeType.PERSIST , mappedBy = "product")
    @JsonIgnore
    private List<Review> reviews;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }



    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
