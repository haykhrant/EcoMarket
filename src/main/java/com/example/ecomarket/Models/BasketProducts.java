package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
@Table(name = "basketproducts")
public class BasketProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id",nullable = false)
    private Basket basket;
}
