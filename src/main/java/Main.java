import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.StandardCardService;
import com.assignment3.jpa.service.UserService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StandardCard st1 = new StandardCard("AAAA");
        StandardCard st2 = new StandardCard("BBBB");
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        User user1 = new User("n1", "s1", "p1", "e1", new Date(), true);
        User user2 = new User("n2", "s2", "p2", "e2", new Date(), true);
        UserService userService = new UserService();
        StandardCardService standardCardService = new StandardCardService();
        BusinessActivityService businessActivityService = new BusinessActivityService();

        userService.create(user1);
        standardCardService.create(st1);

        /*user1 = userService.read(1L);
        st1 = standardCardService.read(1L);*/

        userService.getDao().begin();

        user1.addStandardCard(st1);

        userService.getDao().commit();

        userService.create(user1);

        /*List<BusinessActivity> l = businessActivityService.readAll();
        for (BusinessActivity b: l) {
            List<Card> c = b.getCards();
            for(Card x: c) {
                if (x instanceof StandardCard)
                    userService.removeUserStandardCard((StandardCard) x);
            }
        }*/

        //userService.removeUserStandardCard(st1);

        //standardCardService.deleteAll();
        //businessActivityService.deleteAll();

        //System.out.println(standardCardService.readAll());
    }
}
