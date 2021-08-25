package com.example.ecomarket.Models;

import javax.persistence.*;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house;
}

