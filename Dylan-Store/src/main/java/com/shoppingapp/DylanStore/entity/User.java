package com.shoppingapp.DylanStore.entity;

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
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;

    @Column(name = "Address", nullable = false, length = 200)
    private String address;

    @Column(name = "Phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Position", nullable = false, length = 100)
    private String position;

    @Column(name = "IsAdmin", nullable = false)
    private boolean isAdmin;

    @Column(name = "JoinDate", nullable = false)
    private Date joinDate;

}
