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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
