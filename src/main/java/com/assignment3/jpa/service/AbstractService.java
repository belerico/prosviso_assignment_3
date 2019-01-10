package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.AbstractDao;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<T, Id extends Serializable> implements Service<T, Id> {

    private AbstractDao<T, Id> dao;

    public AbstractService(AbstractDao<T, Id> dao) {
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

    public T readByNaturalId(String naturalId) {
        getDao().begin();
        T t = getDao().readByNaturalId(naturalId);
        getDao().commit();
        return t;
    }

    public T read(Id id) {
        dao.begin();
        T t = dao.read(id);
        dao.commit();
        return t;
    }

    public T update(T entity) {
        dao.begin();
        T t = dao.update(entity);
        dao.commit();
        return t;
    }

    public abstract void delete(T entity);

    public List<T> readAll() {
        dao.begin();
        List<T> l = dao.readAll();
        dao.commit();
        return l;
    }

    public void deleteAll() {
        List<T> list = readAll();
        for (T l : list)
            delete(l);
    }
}
