package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoOrderItem {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;

}
