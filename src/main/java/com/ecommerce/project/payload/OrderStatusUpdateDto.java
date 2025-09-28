package com.ecommerce.project.payload;
import lombok.Data;

import java.util.Objects;

public class OrderStatusUpdateDto {
    private String status;

    // No-args constructor
    public OrderStatusUpdateDto() {
    }

    // All-args constructor
    public OrderStatusUpdateDto(String status) {
        this.status = status;
    }

    // Getter and Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderStatusUpdateDto)) return false;
        OrderStatusUpdateDto that = (OrderStatusUpdateDto) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    // toString
    @Override
    public String toString() {
        return "OrderStatusUpdateDto{" +
                "status='" + status + '\'' +
                '}';
    }
}

