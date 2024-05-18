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
@Table(name = "Shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipmentID")
    private int shipmentId;

    @OneToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @Column(name = "ShipDate", nullable = false)
    private Date shipDate;

    @Column(name = "ShipAddress", nullable = false, length = 300)
    private String shipAddress;

    @Column(name = "ShipMethod", nullable = false, length = 100)
    private String shipMethod;

    @Column(name = "ShipStatus", nullable = false, length = 50)
    private String shipStatus;

}
