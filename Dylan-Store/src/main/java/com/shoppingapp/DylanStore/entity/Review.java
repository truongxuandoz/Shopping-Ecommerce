package com.shoppingapp.DylanStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "ReviewText", nullable = false, length = 500)
    private String reviewText;

    @Column(name = "Rating", nullable = false)
    private int rating;

    @Column(name = "ReviewDate", nullable = false)
    private Date reviewDate;

    // Constructors, getters, and setters
}
