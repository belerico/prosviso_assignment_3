package com.assignment3.jpa.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractDao<T, Id extends Serializable> {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    AbstractDao() {
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

    EntityManager getEntityManager() {
        return entityManager;
    }

    abstract void create(T entity);

    abstract T read(Id id);

    abstract void update(T entity);

    abstract void delete(T entity);

    abstract Collection<T> readAll();

    abstract void deleteAll();
}
