package com.assignment3.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable> implements Serializable {

    private final static EntityManagerFactory entityManagerFactory;
    private final static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private final Class<T> tClass;

    AbstractDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void begin() {
        getEntityManager().getTransaction().begin();
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void commit() {
        flush();
        getEntityManager().getTransaction().commit();
    }

    public void rollback() {
        getEntityManager().getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T read(Id id) {
        return getEntityManager().find(tClass, id);
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public T update(Id id) {
        return update(read(id));
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
