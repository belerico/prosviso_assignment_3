import com.assignment3.jpa.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("assignment3-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = new User();
        user.setName("user3");
        user.setSurname("surname");
        user.setPassword("password3");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c", User.class);
        List<User> results = query.getResultList();

        for (User c : results) {
            System.out.println(c);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
