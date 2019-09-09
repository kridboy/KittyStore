package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kittystore.datalayer.data.util.FormatUtil.*;

public class ItemDAO implements DataAccessInterface<Item> {
    ResultSet results;

    @Override
    public void add(Item item) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(INSERT_ITEM);
            handler.setParameter(item.getOrderID());
            handler.setParameter(item.getBreederID());
            handler.setParameter(item.getBreedID());
            handler.setParameter(item.getCount());
        }
    }

    @Override
    public void remove(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(REMOVE_ITEM);
            handler.setParameter(id);
        }

    }

    @Override
    public void update(Item item) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(UPDATE_ITEM);
            handler.setParameter(item.getCount());
        }
    }

    @Override
    public Item getByID(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_ITEM_BY_ID);
            handler.setParameter(id);
            handler.executeQuery();
            results.next();
            results = handler.getResults();

            return new Item(results.getInt(1), results.getInt(2), results.getInt(3), results.getInt(4));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
}
