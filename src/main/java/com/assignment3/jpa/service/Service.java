package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.AbstractDao;
import com.assignment3.jpa.dao.Dao;

import java.io.Serializable;
import java.util.List;

public class Service<T, Id extends Serializable> implements Serializable {

    private Dao<T, Id> dao;

    public Service(Dao<T, Id> dao) {
        this.dao = dao;
    }

    public Dao<T, Id> getDao() {
        return this.dao;
    }

    public void create(T entity) {
        dao.create(entity);
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

    public void update(Id id) {
        dao.begin();
        dao.update(id);
        dao.commit();
    }

    public void delete(T entity) {
        dao.begin();
        dao.delete(entity);
        dao.commit();
    }

    public void delete(Id id) {
        dao.begin();
        dao.delete(id);
        dao.commit();
    }

    public List<T> readAll() {
        dao.begin();
        List<T> s = dao.readAll();
        dao.commit();
        return s;
    }

    public void deleteAll() {
        dao.begin();
        dao.deleteAll();
        dao.commit();
    }

}
