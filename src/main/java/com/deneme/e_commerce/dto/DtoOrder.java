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
    private User user;
    private List<DtoOrderItem> orderItems;
    private OrderStatus status;
    private Double totalPrice;
    private Timestamp orderDate;

}
