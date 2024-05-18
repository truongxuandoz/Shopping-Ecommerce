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
@Table(name = "Discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountID")
    private int discountId;

    @Column(name = "DiscountCode", nullable = false, length = 50)
    private String discountCode;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "DiscountValue", nullable = false)
    private double discountValue;

    @Column(name = "StartDate", nullable = false)
    private Date startDate;

    @Column(name = "EndDate", nullable = false)
    private Date endDate;
}
