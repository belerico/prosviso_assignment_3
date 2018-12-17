import com.assignment3.jpa.models.Place;
import com.assignment3.jpa.models.StandardCard;
import com.assignment3.jpa.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user1 = new User("user1", "surname1", "pass1", "email1", new Date(), true);
        User user2 = new User("user2", "surname2", "pass2", "email2", new Date(), true);

        StandardCard sc1 = new StandardCard();
        StandardCard sc2 = new StandardCard();
        StandardCard sc3 = new StandardCard();

        Place place1 = new Place("city1", "province1", "region1");
        // Place place2 = new Place("city2", "province2", "region2");

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);

        entityManager.persist(sc1);
        entityManager.persist(sc2);
        entityManager.persist(sc3);

        entityManager.persist(place1);
        // entityManager.persist(place2);

        place1.addUser(user1);
        place1.addUser(user2);

        user1.addStandardCard(sc1);
        user1.addStandardCard(sc2);

        user2.addStandardCard(sc3);
        user2.addStandardCard(sc2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        user1.removeStandardCard(sc2);
        entityManager.getTransaction().commit();

        /*TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c", User.class);
        List<User> results = query.getResultList();

        for (User c : results) {
            System.out.println(c);
        }

        entityManager.close();
        entityManagerFactory.close();*/
    }
}
