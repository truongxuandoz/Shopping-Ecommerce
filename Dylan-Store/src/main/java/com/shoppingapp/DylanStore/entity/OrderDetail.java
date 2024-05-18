package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "SalePrice", nullable = false)
    private double salePrice;

    @ManyToOne
    @JoinColumn(name = "DiscountID")
    private Discount discount;
}