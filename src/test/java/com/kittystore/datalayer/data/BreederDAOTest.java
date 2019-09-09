package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Breeder;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BreederDAOTest {
    private BreederDAO testDAO;
    private static final String BREEDER_NAME = "Black Mystic Legend";
    private static final int BREEDER_ID = 1;
    private Breeder breeder;

    @BeforeEach
    void beforeEach() {
        testDAO = new BreederDAO();
        breeder = new Breeder("KittyKat", "Casper The Ghost", "//");
    }

    @Test
    @Order(1)
    void getByID() {
        breeder = testDAO.getByID(BREEDER_ID);
        assertEquals(breeder.getName(), BREEDER_NAME);
    }

    @Test
    @Order(2)
    void getByName() {
        breeder = testDAO.getByName(BREEDER_NAME);
        assertEquals(breeder.getID(), BREEDER_ID);
    }

    @Test
    @Order(3)
    void add() {
        assertDoesNotThrow(() -> testDAO.add(breeder));
    }

    @Test
    @Order(4)
    void update() {
        breeder = new Breeder(testDAO.getByName(breeder.getName()));
        breeder.setName("test123");
        testDAO.update(breeder);
        assertEquals(testDAO.getByID(breeder.getID()).getName(),breeder.getName());
    }

    @Test
    @Order(5)
    void remove() {
        breeder = new Breeder(testDAO.getByName("test123")); //replace breeder with db entry of it
        testDAO.remove(breeder.getID());
        assertThrows(RuntimeException.class,()->testDAO.getByID(breeder.getID()));

    }
}