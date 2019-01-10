package com.assignment3.utils;

import com.assignment3.jpa.dao.EntityManagerSingleton;
import com.assignment3.jpa.model.*;
import com.assignment3.jpa.service.PlaceService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.PlaceFaker;

import javax.persistence.EntityManager;

public class Helper {

    private final static EntityManager entityManager;

    static {
        entityManager = EntityManagerSingleton.createEntityManager();
    }

    public static void resetIdAutoIncrement(Class tClass) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("ALTER TABLE " + tClass.getSimpleName() + " AUTO_INCREMENT=1", tClass)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    public static void populateDatabaseWithPlaces(int quantity) {
        PlaceFaker faker = new PlaceFaker();
        PlaceService placeService = ServiceFactory.getInstance().getPlaceService();
        for (int i = 0; i < quantity; i++)
            placeService.create(faker.create());
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