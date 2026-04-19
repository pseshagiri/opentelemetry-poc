package com.seshagiri.ps.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties()
public class Product implements Serializable{
    
    private Integer Id;    
    private String name;
    private String description;
    private Double price;

    public Product(Integer id, String name, String description, Double price) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return Id;
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
        Id = id;
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
