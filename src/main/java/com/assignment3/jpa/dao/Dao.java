package com.assignment3.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.Persistence.*;

public class Dao<T, Id extends Serializable> implements Serializable {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private final Class<T> tClass;

    public Dao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void rollback() {
        entityManager.getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T read(Id id) {
        return getEntityManager().find(tClass, id);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void update(Id id) {
        update(read(id));
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public void delete(Id id) {
        delete(read(id));
    }

    public List<T> readAll() {
        return getEntityManager().createQuery("from " + tClass.getName()).getResultList();
    }

    public void deleteAll() {
        List<T> list = readAll();
        for (T t : list)
            delete(t);
    }
}
