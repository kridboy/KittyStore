package com.kittystore.datalayer.data;

import com.kittystore.datalayer.presentation.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kittystore.datalayer.data.util.FormatUtil.*;

public class CustomerDAO implements DataAccessInterface<Customer> {
    ResultSet results;

    @Override
    public void add(Customer customer) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(INSERT_CUSTOMER);
            setParameters(handler, customer);
        }
    }

    @Override
    public void remove(int id) {
        //don't want them removed i think?
    }

    @Override
    public void update(Customer customer) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(UPDATE_CUSTOMER);
            setParameters(handler, customer);
        }
    }

    @Override
    public Customer getByID(int id) {
        try (JdbcHandler handler = JdbcHandler.getInstance()) {
            handler.prepareStatement(SELECT_CUSTOMER_BY_ID);
            handler.setParameter(id);
            handler.executeQuery();
            results.next();
            results = handler.getResults();

            return new Customer(results.getString(1), results.getString(2), results.getString(3), results.getString(4));
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    private void setParameters(JdbcHandler handler, Customer customer) {
        handler.setParameter(customer.getFirstName());
        handler.setParameter(customer.getLastName());
        handler.setParameter(customer.getAddress());
        handler.setParameter(customer.getEmail());
    }
}
