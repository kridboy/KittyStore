package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Breeder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreederDAOTest {
private Breeder breeder;
private BreederDAO testDAO;

@BeforeEach
void beforeEach(){
    testDAO = new BreederDAO();
}

    @Test
    void add() {
        breeder = new Breeder("KittyKat","Casper The Ghost","//");
        assertDoesNotThrow(()->testDAO.add(breeder));
    }

    @Test
    void remove() {
    }

    @Test
    void update() {
    }

    @Test
    void getByID() {
    }
}