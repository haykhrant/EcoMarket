package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
@Table(name="order_products")
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
