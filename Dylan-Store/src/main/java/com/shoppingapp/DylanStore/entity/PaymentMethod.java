package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PaymentMethods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentMethodID")
    private int paymentMethodId;

    @Column(name = "PaymentMethodName", nullable = false, length = 50)
    private String paymentMethodName;

    // Constructors, getters, and setters
}
