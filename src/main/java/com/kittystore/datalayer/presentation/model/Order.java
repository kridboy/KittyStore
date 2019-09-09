package com.kittystore.datalayer.presentation.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {
    private int id;
    private int customerID;
    private Timestamp purchaseTime;

    public Order(int id, int customerID, Timestamp purchaseTime) {
        this.id = id;
        this.customerID = customerID;
        this.purchaseTime = purchaseTime;
    }

    public Order(int customerID, Timestamp purchaseTime) {
        this.customerID = customerID;
        this.purchaseTime = purchaseTime;
    }

    public Order(Order order) {
        this.id = order.getId();
        this.customerID = order.getCustomerID();
        this.purchaseTime = order.getPurchaseTime();
    }

    public int getId() {
        return id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
                getCustomerID() == order.getCustomerID() &&
                getPurchaseTime().equals(order.getPurchaseTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerID(), getPurchaseTime());
    }
}
