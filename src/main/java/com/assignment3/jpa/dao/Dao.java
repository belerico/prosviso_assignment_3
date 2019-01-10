package com.assignment3.jpa.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, Id extends Serializable, NaturalId extends Serializable> {

    void create(T entity);

    T readByNaturalId(String field, NaturalId naturalId);

    T read(Id id);

    T update(T entity);

    void delete(T entity);

    List<T> readAll();

    void deleteAll();

}
