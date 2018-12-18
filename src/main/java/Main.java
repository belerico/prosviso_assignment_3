import com.assignment3.jpa.models.*;

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

        SharableCard sh1 = new SharableCard();
        SharableCard sh2 = new SharableCard();

        Place place1 = new Place("city1", "province1", "region1");
        Place place2 = new Place("city2", "province2", "region2");

        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);

        entityManager.persist(sc1);
        entityManager.persist(sc2);
        entityManager.persist(sc3);

        entityManager.persist(place1);
        entityManager.persist(place2);

        entityManager.persist(ba1);
        entityManager.persist(ba2);

        place1.addBusinessActivity(ba1);
        place1.addBusinessActivity(ba2);

        place1.addUser(user1);
        place1.addUser(user2);

        user1.addStandardCard(sc1);
        user1.addStandardCard(sc2);
        user1.addStandardCard(sc3);
        user2.addStandardCard(sc3);
        user2.addStandardCard(sc2);

        user1.addSharableCard(user2, sh1);
        user2.addSharableCard(user1, sh2);
        //user2.addSharableCard(user1, sh1);
        entityManager.getTransaction().commit();

        /*entityManager.getTransaction().begin();
        user1.removeStandardCard(sc2);
        user2.removeStandardCard(sc3);
        place1.removeUser(user1);
        place2.addUser(user2);
        place1.removeBusinessActivity(ba2);
        entityManager.getTransaction().commit();*/
    }
}
