package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Size(max = 20)
    @Column(name = "username")
    private String userName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    // Default constructor
    public User() {
    }

    // Constructor without ID and relationships
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='********'" + // hide password
                ", roles=" + (roles != null ? roles.size() + " roles" : "null") +
                ", addresses=" + (addresses != null ? addresses.size() + " addresses" : "null") +
                '}';
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

/*
  
  ┌───────────────────────────────────────────────────────┐
│                        USER                          │
├───────────────────────────────────────────────────────┤
│  user_id (PK)                                         │
│  username (UQ) ───────────┐                           │
│  email (UQ) ──────────────┤                           │
│  password                 │                           │
└───────────────┬───────────┴───────────────────────────┘
                │
                │ 1:1
                ▼
┌───────────────────────────────────────────────────────┐
│                        CART                          │
├───────────────────────────────────────────────────────┤
│  cart_id (PK)                                         │
│  user_id (FK) ────────────┐                           │
│  total_price              │                           │
└───────────────┬───────────┘                           │
                │                                       │
                │ 1:M                                   │
                ▼                                       │
┌───────────────────────────────────────────────────────┐  M:1
│                     CART_ITEM                        │◄─────────────────┐
├───────────────────────────────────────────────────────┤                 │
│  cart_item_id (PK)                                    │                 │
│  cart_id (FK)                                         │                 │
│  product_id (FK) ─────────────────────────────────────┘                 │
│  quantity                                                               │
│  discount                                                               │
│  product_price                                                          │
└───────────────────────────────────────────────────────┘                 │
                                                                          │
┌───────────────────────────────────────────────────────┐  M:M           │
│                       ROLE                          │                 │
├───────────────────────────────────────────────────────┤                 │
│  role_id (PK)                                         │                 │
│  role_name (ENUM)                                     │                 │
└───────────────┬───────────────────────────────────────┘                 │
                │                                                         │
                │ M:M                                                     │
                │ through USER_ROLE                                       │
                ▼                                                         │
┌───────────────────────────────┐  M:M                   ┌───────────────────────────────────────────────────────┐
│          USER_ROLE           │                        │                      PRODUCT                          │
├───────────────────────────────┤                        ├───────────────────────────────────────────────────────┤
│  user_id (FK,PK) ─────────────┴───────────────────────┐│  product_id (PK)                                    │
│  role_id (FK,PK)                                      ││  product_name                                       │
└───────────────────────────────┘                        ││  description                                        │
                                                         ││  quantity                                           │
┌───────────────────────────────────────────────────────┐││  price                                              │
│                       ADDRESS                        │││  discount                                           │
├───────────────────────────────────────────────────────┤││  special_price                                      │
│  address_id (PK)                                      │││  seller_id (FK) ────────────────────────────────────┘
│  street                                               │││  category_id (FK) ────────────────┐
│  building_name                                        ││└───────────────────────────────────┬─────────────────┘
│  city                                                 ││                                    │
│  state                                                ││                                    │
│  country                                              ││                                    │
│  pincode                                              ││                                    │
└───────────────┬───────────────────────────────────────┘│                                    │
                │                                        │                                    │
                │ M:M                                    │                                    │
                │ through USER_ADDRESS                   │                                    │
                ▼                                        │                                    │
┌───────────────────────────────┐                        │                                    │
│        USER_ADDRESS          │                        │                                    │
├───────────────────────────────┤                        │                                    │
│  user_id (FK,PK) ─────────────┴───────────────────────┘                                    │
│  address_id (FK,PK)                                                                        │
└───────────────────────────────┘                                                            │
                                                                                             │
┌───────────────────────────────────────────────────────┐                                    │
│                      CATEGORY                        │                                    │
├───────────────────────────────────────────────────────┤                                    │
│  category_id (PK)                                      │                                    │
│  category_name                                         │                                    │
└───────────────────────────────────────────────────────┘                                    │
                                                                                             │
                                                                                             │
Key:                                                                                         │
PK = Primary Key                                                                             │
FK = Foreign Key                                                                             │
UQ = Unique Constraint                                                                       │
M:M = Many-to-Many (with join table)                                                         │
1:M = One-to-Many                                                                            │
M:1 = Many-to-One                                                                            │
1:1 = One-to-One      
//++++++++++++++++++++++++++++++++++++++++




┌───────────┐       ┌───────────┐       ┌───────────┐
│   User    │       │   Role    │       │  Address  │
└───────────┘       └───────────┘       └───────────┘
      │                   ▲                   ▲
      ├───────────────────┘                   │
      │                                       │
      ▼                                       │
┌───────────┐       ┌───────────┐             │
│   Cart    │       │  Product  │◄────────────┘
└───────────┘       └───────────┘
      ▲                   ▲
      │                   │
      └───────┐           │
              │           │
          ┌───────────┐   │
          │ CartItem  │   │
          └───────────┘   │
                          │
                      ┌───────────┐
                      │ Category  │
                      └───────────┘
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  
  
  
  
  
  
  
  */
 