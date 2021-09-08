package com.example.ecomarket.Facade.DTO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomerDTO {

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    private Long id;

    private String fullname;

    private String username;

    private String password;

    private String role;

    public CustomerDTO() {}

    public CustomerDTO(Long id, String fullname, String username, String password, String role) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = bCryptPasswordEncoder.encode(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = "USER";
    }

    //endregion

}