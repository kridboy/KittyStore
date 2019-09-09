package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Breed;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kittystore.datalayer.data.util.FormatUtil.*;

public class BreedDAO implements DataAccessInterface<Breed> {
    private ResultSet results;

    @Override
    public void add(Breed breed) {
        //TODO transaction om breed aan breeder toe te voegen.
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(INSERT_BREED);
            setParameters(handler, breed);
            handler.executeQuery();
        }
    }

    @Override
    public void remove(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(REMOVE_BREED);
            handler.setParameter(id);
            handler.executeQuery();
        }
    }


    public void update(Breed breed) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(UPDATE_BREED);
            setParameters(handler, breed);
            handler.executeUpdate();
        }
    }

    public Breed getByID(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_BREED_BY_ID);
            handler.setParameter(id);
            handler.executeQuery();
            results.next();
            results = handler.getResults();

            return new Breed(results.getInt(1), results.getString(2), results.getBigDecimal(3));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public Breed getByName(String name) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_BREED_BY_NAME);
            handler.setParameter(name);
            handler.executeQuery();
            results.next();
            results = handler.getResults();

            return new Breed(results.getInt(1), results.getString(2), results.getBigDecimal(3));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    private void setParameters(JdbcHandler handler, Breed breed) {
        handler.setParameter(breed.getName());
        handler.setParameter(breed.getPrice());
        handler.setParameter(breed.getID());
    }
}
