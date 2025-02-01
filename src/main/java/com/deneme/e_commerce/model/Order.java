package com.deneme.e_commerce.model;

import com.deneme.e_commerce.utils.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private Double totalPrice;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp orderDate;

}
