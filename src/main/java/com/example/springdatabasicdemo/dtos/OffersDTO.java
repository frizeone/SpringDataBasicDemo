package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enumPacage.Engine;
import com.example.springdatabasicdemo.enumPacage.Transmission;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import java.sql.Date;
import java.util.UUID;

public class OffersDTO {

    private UUID id;

    @NotBlank(message = "Описание не может быть пустым")
    private String description;

    @NotNull
    @Enumerated
    private Engine engine;

    @NotBlank(message = "URL-адрес изображения не может быть пустым")
    private String imageUrl;

    @Min(value = 0, message = "Пробег должен быть положительным числом")
    private int mileage;

    @Min(value = 0, message = "Цена должна быть положительным числом")
    private int price;

    @NotNull
    @Enumerated
    private Transmission transmission;

    @NotNull(message = "Год не может быть null")
    @PastOrPresent(message = "Год должен быть в прошлом или настоящем")
    private Date year;

    @NotNull(message = "Дата создания не может быть равна null")
    @PastOrPresent(message = "Дата создания должна быть в прошлом или настоящем")
    private Date created;

    @NotNull(message = "Измененная дата не может быть равна null")
    @PastOrPresent(message = "Дата модификации должна быть в прошлом или настоящем")
    private Date modified;

    @NotNull
    private ModelsDTO model;

    @NotNull
    private UserDTO users;

    public OffersDTO(UUID id, String description, Engine engine, String imageUrl, int mileage, int price, Transmission transmission, Date year, Date created, Date modified, ModelsDTO model, UserDTO users) {
        this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.users = users;
    }

    public OffersDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public ModelsDTO getModel() {
        return model;
    }

    public void setModel(ModelsDTO model) {
        this.model = model;
    }

    public UserDTO getUsers() {
        return users;
    }

    public void setUsers(UserDTO users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "OffersDTO{" + "id=" + id + ", description='" + description + ", engine=" + engine + ", imageUrl='" + imageUrl + ", mileage=" + mileage + ", price=" + price + ", transmission=" + transmission + ", year=" + year + ", created=" + created + ", modified=" + modified + ", models=" + model + ", user=" + users + '}';
    }
}
