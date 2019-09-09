package com.kittystore.datalayer.presentation.model;

import java.util.Objects;

public class Item {
    private int id;
    private int breedID;
    private int breederID;
    private int orderID;
    private int count;

    public Item(int id, int orderID, int breederID, int breedID, int count) {
        this.id = id;
        this.orderID = orderID;
        this.breederID = breederID;
        this.breedID = breedID;
        this.count = count;
    }

    public Item(int orderID, int breederID, int breedID, int count) {
        this.orderID = orderID;
        this.breederID = breederID;
        this.breedID = breedID;
        this.count = count;
    }

    public Item(Item item) {
        this.id = item.getId();
        this.orderID = item.getOrderID();
        this.breederID = item.getBreederID();
        this.breedID = item.getBreedID();
        this.count = item.getCount();
    }

    public int getId() {
        return id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getBreederID() {
        return breederID;
    }

    public void setBreederID(int breederID) {
        this.breederID = breederID;
    }

    public int getBreedID() {
        return breedID;
    }

    public void setBreedID(int breedID) {
        this.breedID = breedID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                getOrderID() == item.getOrderID() &&
                getBreederID() == item.getBreederID() &&
                getBreedID() == item.getBreedID() &&
                getCount() == item.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderID(), getBreederID(), getBreedID(), getCount());
    }
}
