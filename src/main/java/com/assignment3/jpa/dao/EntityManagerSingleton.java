package com.assignment3.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {

    private final static String UNIT_NAME = "assignment3-unit";
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static synchronized EntityManager createEntityManager() {

        if (entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
