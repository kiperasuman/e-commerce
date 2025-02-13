package com.deneme.e_commerce.dto;

import com.deneme.e_commerce.utils.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoPayment {

    private Long id;
    private Long orderId;
    private PaymentStatus status;
    private String transactionId;
    private Timestamp paymentDate;

}
