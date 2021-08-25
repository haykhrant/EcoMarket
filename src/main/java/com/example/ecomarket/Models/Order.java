//package com.example.ecomarket.Models;
//
//import javax.persistence.*;
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String contactNumber;
//
//    @OneToOne
//    @JoinColumn(name = "customer_id",nullable = false)
//    private Customer customer;
//
//    @OneToOne
//    @JoinColumn(name = "adress_id",nullable = false)
//    private Adress adress;
//}
