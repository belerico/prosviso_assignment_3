package com.assignment3.jpa.services;

import java.io.Serializable;
import java.util.Collection;

public interface ServiceInterface<T, Id extends Serializable> {

    void create(T entity);

    T read(Id id);

    void update(T entity);

    void delete(T entity);

    Collection<T> readAll();

    void deleteAll();
}
