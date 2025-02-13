package com.deneme.e_commerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;
    @ManyToMany
    @JoinTable(name = "product_supplier",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> supplier;
    @ManyToOne
    private Category category;
    @Column(name = "unit")
    private String unit;
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "unit_stock")
    private Integer unitStock;

}
