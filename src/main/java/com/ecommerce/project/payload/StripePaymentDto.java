package com.ecommerce.project.payload;

import com.ecommerce.project.model.Address;
import lombok.Data;

import java.util.Map;


public class StripePaymentDto {
    private Long amount;
    private String currency;
    private String email;
    private String name;
    private Address address;
    private String description;
    private Map<String, String> metadata;

    // No-args constructor
    public StripePaymentDto() {
    }

    // All-args constructor
    public StripePaymentDto(Long amount, String currency, String email, String name,
                            Address address, String description, Map<String, String> metadata) {
        this.amount = amount;
        this.currency = currency;
        this.email = email;
        this.name = name;
        this.address = address;
        this.description = description;
        this.metadata = metadata;
    }

    // Getters and Setters
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    
    // toString
    @Override
    public String toString() {
        return "StripePaymentDto{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}