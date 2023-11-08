package com.example.springdatabasicdemo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brands extends CreatedAndModified {

    @Column(name = "name")
    private String name;


    public Brands(String name) {
        this.name = name;
    }

    public Brands() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name  + " }";
    }
}
