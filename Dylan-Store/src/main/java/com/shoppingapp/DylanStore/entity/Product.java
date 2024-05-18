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
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "ProductName", nullable = false, length = 200)
    private String productName;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

    @Column(name = "ImageURL", length = 500)
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ManufacturerID")
    private Manufacturer manufacturer;


}
