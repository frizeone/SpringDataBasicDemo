package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enumPacage.Engine;
import com.example.springdatabasicdemo.enumPacage.Transmission;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offers extends CreatedAndModified{

    @Column(name = "description")
    private String description;

    @Column(name = "engine")
    @Enumerated(EnumType.ORDINAL)
    private Engine engine;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "miliage")
    private Integer mileage;

    @Column(name = "price")
    private Integer price;

    @Column(name = "transmission")
    @Enumerated(EnumType.ORDINAL)
    private Transmission transmission;

    @Column(name = "year")
    private Date year;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Models model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Users users;

    public Offers(String description, Engine engine, String imageUrl, Integer mileage, Integer price, Transmission transmission, Date year, Models model, Users users) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.users = users;
    }

    public Offers() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }


    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Student { id=" + id + ", description=" + description + ", engine=" + engine + ", imageUrl=" + imageUrl + ", miliage=" + mileage + ", price=" + price + ", transmission=" + transmission + ", year=" + year + ", model=" + model + ", seller=" + users + " }";
    }
}
