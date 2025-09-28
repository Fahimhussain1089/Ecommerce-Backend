package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class CartDTO {
//    private Long cartId;
//    private Double totalPrice = 0.0;
//    private List<ProductDTO> products = new ArrayList<>();
//}



import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private Long cartId;
    private Double totalPrice = 0.0;
    private List<ProductDTO> products = new ArrayList<>();

    // Default constructor
    public CartDTO() {
    }

    // Parameterized constructor
    public CartDTO(Long cartId, Double totalPrice, List<ProductDTO> products) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    // Getters and Setters

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    // toString method

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                ", products=" + (products != null ? products.size() + " products" : "null") +
                '}';
    }
}

