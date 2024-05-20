package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @Column(name = "OrderDate", nullable = false)
    private Date orderDate;

    @Column(name = "ShipAddress", nullable = false)
    private String shipAddress;

    @Column(name = "TotalAmount", nullable = false)
    private double totalAmount;

    @Column(name = "ShippingFee", nullable = false)
    private double shippingFee;

    @Column(name = "Status", nullable = false, length = 50)
    private String status;
}
