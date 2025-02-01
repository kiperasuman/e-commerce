package com.deneme.e_commerce.dto;

import com.deneme.e_commerce.utils.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
public class DtoPayment {

    private Long id;
    private DtoOrder order;
    private PaymentStatus status;
    private String transactionId;
    private Timestamp paymentDate;

}
