package com.assignment3.jpa;

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
        entityManager.createQuery("delete from UserSharableCard").executeUpdate();
        entityManager.createQuery("delete from UserStandardCard").executeUpdate();
        entityManager.createQuery("delete from Card").executeUpdate();
        entityManager.createQuery("delete from User").executeUpdate();
        entityManager.createQuery("delete from Place").executeUpdate();
        entityManager.createQuery("delete from BusinessActivity").executeUpdate();
        entityManager.getTransaction().commit();
    }
}
