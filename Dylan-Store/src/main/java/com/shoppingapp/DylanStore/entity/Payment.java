package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "PaymentDate", nullable = false)
    private Date paymentDate;

    @Column(name = "Amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "PaymentMethodID")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "PaymentStatusID")
    private PaymentStatus paymentStatus;
}
