package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enumPacage.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "models")
public class Models  extends CreatedAndModified {

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Brands brands;

    public Models(String name, Category category, String imageUrl, Integer startYear, Integer endYear, Brands brands) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.brands = brands;
    }

    public Models() {
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

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }



    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name + ", category=" + category + ", imageUrl=" + imageUrl + ", startYear=" + startYear + ", endYear=" + endYear +", brand=" + brands + " }";
    }
}
