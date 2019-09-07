package com.kittystore.datalayer.data;


public interface DataAccessInterface<T> {
    T getByID(int id);

    void remove(int id);

    void add(T t);

    void update(T t);
}
