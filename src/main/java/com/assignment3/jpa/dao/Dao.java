package com.assignment3.jpa.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, Id extends Serializable> {

    T create(T entity);

    T read(Id id);

    T update(T entity);

    void delete(T entity);

    List<T> readAll();

    void deleteAll();
}
