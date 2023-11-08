package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enumPacage.Category;
import com.example.springdatabasicdemo.models.Models;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.util.UUID;

public class ModelsDTO {

    private UUID id;

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @NotNull(message = "Категория не может быть равна null")
    @Enumerated
    private Category category;

    @NotBlank(message = "URL-адрес изображения не может быть пустым")
    private String imageUrl;

    @Min(value = 2023, message = "Начальный год должен быть не менее 2023")
    @Max(value = 2030, message = "Конечный год должен быть не более 2030")
    private int startYear;

    @Min(value = 2023, message = "Начальный год должен быть не менее 2023")
    @Max(value = 2030, message = "Конечный год должен быть не более 2030")
    private int endYear;

    @NotNull(message = "Дата создания не может быть равна null")
    @PastOrPresent(message = "Дата создания должна быть в прошлом или настоящем")
    private Date created;

    @NotNull(message = "Измененная дата не может быть равна null")
    @PastOrPresent(message = "Дата модификации должна быть в прошлом или настоящем")
    private Date modified;

    @NotNull(message = "Бренды не могут быть равны null")
    private BrandsDTO brands;

    public ModelsDTO() {
    }

    public ModelsDTO(UUID id, String name, Category category, String imageUrl, int startYear, int endYear, Date created, Date modified, BrandsDTO brands) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brands = brands;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    public BrandsDTO getBrands() {
        return brands;
    }

    public void setBrands(BrandsDTO brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "ModelsDTO{" + "name='" + name + ", category=" + category + ", imageUrl='" + imageUrl + ", startYear=" + startYear + ", endYear=" + endYear + ", created=" + created + ", modified=" + modified + ", brand='" + brands +  '}';
    }
}
