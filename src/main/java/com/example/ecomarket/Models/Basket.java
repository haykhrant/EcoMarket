package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_info_id",nullable = false)
    private CustomerInfo customerInfo;
}
