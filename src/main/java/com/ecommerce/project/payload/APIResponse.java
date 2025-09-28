package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class APIResponse {

    private String message;
    private boolean status;

    // Default constructor
    public APIResponse() {
    }

    // Parameterized constructor
    public APIResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}

//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class APIResponse {
//    public String message;
//    private boolean status;
//}
