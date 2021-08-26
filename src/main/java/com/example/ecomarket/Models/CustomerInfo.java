package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
@Table(name="customer_infos")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private double rating;

    @OneToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "adress_id",nullable = false)
    private Adress adress;

}
