package com.assignment3.jpa.dao;

import java.io.Serializable;
import java.util.List;

/*
    Dao interface. This class define the basic CRUD operation plus two more useful operations
 */
public interface Dao<T, Id extends Serializable, NaturalId extends Serializable> {

    void create(T entity);

    T readByNaturalId(NaturalId naturalId);

    T read(Id id);

    T update(T entity);

    void delete(T entity);

    List<T> readAll();

    void deleteAll();

}
