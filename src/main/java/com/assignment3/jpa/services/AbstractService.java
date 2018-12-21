package com.assignment3.jpa.services;

import com.assignment3.jpa.daos.AbstractDao;

import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractService<T, Id extends Serializable> {

    private final Class<T> tClass;
    private AbstractDao<T, Id> dao;

    public AbstractService(Class<T> tClass, AbstractDao<T, Id> dao) {
        this.tClass = tClass;
        this.dao = dao;
    }

    public AbstractDao<T, Id> getDao() {
        return this.dao;
    }

    public void create(T entity) {
        dao.begin();
        dao.create(entity);
        dao.commit();
    }

    public T read(Id id) {
        dao.begin();
        T t = dao.read(id);
        dao.commit();
        return t;
    }

    public void update(T entity) {
        dao.begin();
        dao.update(entity);
        dao.commit();
    }

    abstract void delete(T entity);

    abstract Collection<T> readAll();

    abstract void deleteAll();
}
