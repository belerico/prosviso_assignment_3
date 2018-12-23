import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.StandardCardService;
import com.assignment3.jpa.service.UserService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StandardCard st1 = new StandardCard();
        StandardCard st2 = new StandardCard();
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        User user1 = new User("n1", "s1", "p1", "e1", new Date(), true);
        User user2 = new User("n2", "s2", "p2", "e2", new Date(), true);
        UserService userService = new UserService();
        StandardCardService standardCardService = new StandardCardService();
        BusinessActivityService businessActivityService = new BusinessActivityService();

        ba1.addCard(st1);
        ba1.addCard(st2);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(ba1);
        System.out.println(ba2);

        user1.addStandardCard(st1);
        user1.addStandardCard(st2);
        user2.addStandardCard(st2);

        userService.create(user1);
        userService.create(user2);

        businessActivityService.create(ba1);
        businessActivityService.create(ba2);

        standardCardService.create(st1);
        standardCardService.create(st2);

        //standardCardService.deleteAll();
        businessActivityService.deleteAll();

        //System.out.println(standardCardService.readAll());
    }
}
