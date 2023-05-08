package com.codewithGaurav.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique=true)
    private String username;
    private String name;
    @Column(unique=true)

    private String email;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
