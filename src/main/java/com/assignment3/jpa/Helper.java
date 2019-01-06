package com.assignment3.jpa;

import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.PlaceService;
import com.assignment3.jpa.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Helper {

    private final static EntityManagerFactory entityManagerFactory;
    private final static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void dropDatabase() {
        new PlaceService().deleteAll();
        new BusinessActivityService().deleteAll();
        new UserService().deleteAll();
    }
}
