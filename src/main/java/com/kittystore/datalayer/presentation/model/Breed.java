package com.kittystore.datalayer.presentation.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Breed {
    private int id;
    private String name;
    private BigDecimal price;

    public Breed(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Breed(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breed breed = (Breed) o;
        return id == breed.id &&
                getName().equals(breed.getName()) &&
                getPrice().equals(breed.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getPrice());
    }
}
