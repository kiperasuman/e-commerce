package com.deneme.e_commerce.dto;

import com.deneme.e_commerce.model.User;
import com.deneme.e_commerce.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoOrder {

    private Long id;
    private Long userId;
    private List<DtoOrderItem> orderItems;
    private OrderStatus status;
    private Double totalPrice;
    private Timestamp orderDate;

}
