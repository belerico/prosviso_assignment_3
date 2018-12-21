package com.assignment3.jpa.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable> {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private final Class<T> tClass;

    AbstractDao(Class<T> tClass) {
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

    EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T read(Id id) {
        return getEntityManager().find(tClass, id);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public List<T> readAll(String query) {
        return getEntityManager().createQuery(query).getResultList();
    }

    abstract void deleteAll();
}
