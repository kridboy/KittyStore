package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kittystore.datalayer.data.util.FormatUtil.*;

public class OrderDAO implements DataAccessInterface<Order>{
    ResultSet results;

    @Override
    public void add(Order order) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(INSERT_ORDER);
            setParameters(handler,order);
        }
    }

    @Override
    public void remove(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(REMOVE_ORDER);
            handler.setParameter(id);
        }
    }

    @Override
    public void update(Order order) {
        //no update possible
    }

    @Override
    public Order getByID(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_ORDER_BY_ID);
            handler.setParameter(id);
            handler.executeQuery();
            results = handler.getResults();

            return new Order(results.getInt(1),results.getTimestamp(2));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    private void setParameters(JdbcHandler handler,Order order){
        handler.setParameter(order.getCustomerID());
        handler.setParameter(order.getPurchaseTime());
    }
}
