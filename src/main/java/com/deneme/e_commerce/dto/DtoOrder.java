package com.deneme.e_commerce.dto;

import com.deneme.e_commerce.model.User;
import com.deneme.e_commerce.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class DtoOrder {

    private Long id;
    private Long userId;
    private List<DtoOrderItem> orderItems;
    private OrderStatus status;
    private Double totalPrice;
    private Timestamp orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<DtoOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<DtoOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
