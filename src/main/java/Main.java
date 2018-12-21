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
        User user3 = new User("user3", "surname3", "pass3", "email3", new Date(), true);

        SharableCard sh1 = new SharableCard();
        SharableCard sh2 = new SharableCard();

        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");

        Place place1 = new Place("city1", "province1", "region1");
        Place place2 = new Place("city2", "province2", "region2");

        StandardCard sc1 = new StandardCard();
        StandardCard sc2 = new StandardCard();
        StandardCard sc3 = new StandardCard();

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);

        entityManager.persist(sc1);
        entityManager.persist(sc2);
        entityManager.persist(sc3);

        entityManager.persist(sh1);
        entityManager.persist(sh2);

        entityManager.persist(place1);
        entityManager.persist(place2);

        entityManager.persist(ba1);
        entityManager.persist(ba2);

        user1.addStandardCard(sc1);
        user1.addStandardCard(sc2);
        user1.addStandardCard(sc3);
        user2.addStandardCard(sc3);
        user2.addStandardCard(sc2);

        ba1.addCard(sc1);
        ba2.addCard(sc2);

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
        user1.addSharableCard(user2, sh2);
        user3.addSharableCard(user2, sh2);
        entityManager.getTransaction().commit();
    }
}
