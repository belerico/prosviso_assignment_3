package com.assignment3.jpa.utils;

import com.assignment3.jpa.model.*;

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

    public static void resetIdAutoIncrement(Class tClass) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("ALTER TABLE " + tClass.getSimpleName() + " AUTO_INCREMENT=1", tClass)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    public static void dropDatabase() {
        /*new PlaceService().deleteAll();
        new BusinessActivityService().deleteAll();
        new UserService().deleteAll();*/
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete ignore from " + UserSharableCard.class.getSimpleName()).executeUpdate();
        entityManager.createNativeQuery("delete ignore from " + UserStandardCard.class.getSimpleName()).executeUpdate();
        entityManager.createNativeQuery("delete ignore from " + Card.class.getSimpleName()).executeUpdate();
        entityManager.createNativeQuery("delete ignore from " + User.class.getSimpleName()).executeUpdate();
        entityManager.createNativeQuery("delete ignore from " + Place.class.getSimpleName()).executeUpdate();
        entityManager.createNativeQuery("delete ignore from " + BusinessActivity.class.getSimpleName()).executeUpdate();
        entityManager.getTransaction().commit();
    }
}
