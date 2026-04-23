package com.seshagiri.ps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100,name = "name")
    private String name;
    @Column(length = 255,name = "description")
    private String description;
    @Column(length = 255,name = "price")
    private Double price;

    public ProductEntity(Integer id, String name, String description, Double price) {
        id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity() {

    }


    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public void setId(Integer id) {
        id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    

}
