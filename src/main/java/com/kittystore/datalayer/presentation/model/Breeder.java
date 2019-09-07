package com.kittystore.datalayer.presentation.model;

import java.util.Objects;

public class Breeder {
    private int id;
    private String name;
    private String contact;
    private String phoneNumber;

    public Breeder(int id, String name, String contact, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
    }

    public Breeder(String name, String contact, String phoneNumber) {
        this.name = name;
        this.contact = contact;
        this.phoneNumber = phoneNumber;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breeder breeder = (Breeder) o;
        return id == breeder.id &&
                getName().equals(breeder.getName()) &&
                getContact().equals(breeder.getContact()) &&
                getPhoneNumber().equals(breeder.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getContact(), getPhoneNumber());
    }
}
