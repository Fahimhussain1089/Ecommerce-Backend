package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain at least 3 characters")
    private String productName;

    private String image;

    @NotBlank
    @Size(min = 6, message = "Product description must contain at least 6 characters")
    private String description;

    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(Long productId, String productName, String image, String description,
                   Integer quantity, double price, double discount, double specialPrice,
                   Category category, User user) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.specialPrice = specialPrice;
        this.category = category;
        this.user = user;
    }

    // Getters and Setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", productName='" + productName + '\'' +
//                ", image='" + image + '\'' +
//                ", description='" + description + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                ", discount=" + discount +
//                ", specialPrice=" + specialPrice +
//                ", category=" + (category != null ? category.getCategoryId() : null) +
//                ", user=" + (user != null ? user.getId() : null) +
//                '}';
//    }
}



//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "products")
//@ToString
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long productId;
//
//    @NotBlank
//    @Size(min = 3, message = "Product name must contain atleast 3 characters")
//    private String productName;
//    private String image;
//
//    @NotBlank
//    @Size(min = 6, message = "Product description must contain atleast 6 characters")
//    private String description;
//    private Integer quantity;
//    private double price;
//    private double discount;
//    private double specialPrice;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @ManyToOne
//    @JoinColumn(name = "seller_id")
//    private User user;
//}
