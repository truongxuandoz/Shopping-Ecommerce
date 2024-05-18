package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Manufacturers")
public class Manufacturer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManufacturerID")
    private int manufacturerId;

    @Column(name = "ManufacturerName", nullable = false, length = 100)
    private String manufacturerName;

    @Column(name = "Address", nullable = false, length = 200)
    private String address;

    @Column(name = "Country", nullable = false, length = 50)
    private String country;
}
