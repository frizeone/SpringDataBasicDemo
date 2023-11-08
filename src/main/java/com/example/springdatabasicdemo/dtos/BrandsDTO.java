package com.example.springdatabasicdemo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.sql.Date;
import java.util.UUID;

public class BrandsDTO {

    private UUID id;

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @NotNull(message = "Дата создания не может быть равна null")
    @PastOrPresent(message = "Дата создания должна быть в прошлом или настоящем")
    private Date created;

    @NotNull(message = "Измененная дата не может быть равна null")
    @PastOrPresent(message = "Дата модификации должна быть в прошлом или настоящем")
    private Date modified;

    public BrandsDTO() {
    }

    public BrandsDTO(UUID id, String name, Date created, Date modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "BrandsDTO{" + "name='" + name + ", created=" + created + ", modified=" + modified + '}';
    }
}
