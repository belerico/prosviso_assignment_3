package com.assignment3.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, Id extends Serializable, NaturalId extends Serializable> implements Dao<T, Id, NaturalId> {

    //private final static EntityManagerSingleton entityManagerFactory;
    private final static EntityManager entityManager;

    static {
        /*entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();*/
        entityManager = EntityManagerSingleton.createEntityManager();
    }

    private final Class<T> tClass;

    AbstractDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }

    public void begin() {
        getTransaction().begin();
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void commit() {
        flush();
        getTransaction().commit();
    }

    public void rollback() {
        getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> gettClass() {
        return tClass;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public T readByNaturalId(String field, NaturalId naturalId) {
        T t = null;
        try {
            t = getEntityManager()
                    .createQuery("SELECT t FROM " + tClass.getName() + " t WHERE t." + field + "=:naturalId", gettClass())
                    .setParameter("naturalId", naturalId)
                    .getSingleResult();
        } catch (NoResultException n) {
            n.printStackTrace();
        }
        return t;
    }

    public T read(Id id) {
        return getEntityManager().find(tClass, id);
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public List<T> readAll() {
        return getEntityManager().createQuery("from " + tClass.getName(), tClass).getResultList();
    }

    public void deleteAll() {
        for (T t : readAll())
            delete(t);
    }
}
