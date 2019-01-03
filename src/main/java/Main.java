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
        StandardCard st3 = new StandardCard("CCCC");
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        User user1 = new User("n1", "s1", "p1", "e1", new Date(), true);
        User user2 = new User("n2", "s2", "p2", "e2", new Date(), true);
        UserService userService = new UserService();
        StandardCardService standardCardService = new StandardCardService();
        BusinessActivityService businessActivityService = new BusinessActivityService();

        ba1.addCard(st1);
        ba1.addCard(st2);
        ba2.addCard(st3);

        businessActivityService.create(ba1);
        businessActivityService.create(ba2);

        user1.addStandardCard(st1);
        user1.addStandardCard(st2);
        userService.create(user1);
        user2.addStandardCard(st2);
        userService.create(user2);
        user1.addStandardCard(st3);
        userService.create(user1);
        user1.setName("another");
        userService.update(user1);

        System.out.println(ba1.getCards());
        businessActivityService.deleteCard(ba1, st1);
        System.out.println(ba1.getCards());
        businessActivityService.deleteCard(ba1, st2);
        System.out.println(ba1.getCards());

        // Ciao Roby

        /*for (StandardCard s: user1.getStandardCards())
            user1.removeStandardCard(s);

        userService.delete(user1);*/
    }
}
