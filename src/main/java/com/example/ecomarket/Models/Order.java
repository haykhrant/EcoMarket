package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contactNumber;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_info_id",nullable = false)
    private CustomerInfo customerInfo;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id",nullable = false)
    private Address address;
}
