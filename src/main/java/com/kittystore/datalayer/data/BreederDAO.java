package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Breeder;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kittystore.datalayer.data.util.FormatUtil.*;

public class BreederDAO implements DataAccessInterface<Breeder> {
    ResultSet results;

    @Override
    public void add(Breeder breeder) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(INSERT_BREEDER);
            setParameters(handler, breeder);
            handler.executeQuery();
        }
    }

    @Override
    public void remove(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.setTransaction(true);
            handler.prepareStatement(REMOVE_BREEDER_INVENTORY);
            handler.setParameter(id);
            handler.executeQuery();
            handler.prepareStatement(REMOVE_BREEDER);
            handler.setParameter(id);
            handler.executeQuery();
            handler.commit();
        }
    }

    @Override
    public void update(Breeder breeder) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(UPDATE_BREEDER);
            setParameters(handler, breeder);
        }
    }

    @Override
    public Breeder getByID(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_BREEDER_BY_ID);
            handler.setParameter(id);
            handler.executeQuery();
            results = handler.getResults();

            return new Breeder(results.getString(1), results.getString(2), results.getString(3));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }


    private void setParameters(JdbcHandler handler, Breeder breeder) {
        handler.setParameter(breeder.getName());
        handler.setParameter(breeder.getContact());
        handler.setParameter(breeder.getPhoneNumber());
    }
}
