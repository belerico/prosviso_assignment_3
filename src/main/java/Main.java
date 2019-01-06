import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.UserService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StandardCard st1 = new StandardCard("AAAA");
        StandardCard st2 = new StandardCard("BBBB");
        StandardCard st3 = new StandardCard("CCCC");
        SharableCard sh1 = new SharableCard("SAAAA");
        SharableCard sh2 = new SharableCard("SBBBB");
        SharableCard sh3 = new SharableCard("SCCCC");
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        User user1 = new User("n1", "s1", "p1", "e1", new Date(), true);
        User user2 = new User("n2", "s2", "p2", "e2", new Date(), true);

        UserService userService = new UserService();
        CardService cardService = new CardService();
        BusinessActivityService businessActivityService = new BusinessActivityService();

        ba1.addCard(st1);
        ba1.addCard(st2);
        ba2.addCard(st3);
        ba1.addCard(sh1);
        ba1.addCard(sh2);
        ba2.addCard(sh3);

        businessActivityService.create(ba1);
        businessActivityService.create(ba2);

        userService.create(user1);
        userService.create(user2);

        user1.addSharableCard(user2, sh1);
        user1.addSharableCard(user2, sh2);
        user1.addStandardCard(st1);
        user1.addStandardCard(st2);
        userService.create(user1);
        user2.addSharableCard(user1, sh3);
        user2.addStandardCard(st2);
        userService.create(user2);
        user1.addStandardCard(st3);
        userService.create(user1);
        user1.setName("another");
        userService.update(user1);

        //ba1.removeAllCard();
        //businessActivityService.delete(ba1);
        cardService.deleteAll();
        //businessActivityService.deleteAllCard(ba1);
        userService.deleteAll();
        //businessActivityService.deleteCard(st1);
        businessActivityService.deleteAll();
        //userService.removeStandardCard(user1, st1);
        //userService.deleteAll();

        /*Place p1 = new Place("AAAA", "Bergamo", "BG", "Lombardia");
        Place p2 = new Place("BBBB", "Bergamo", "BG", "Lombardia");
        PlaceService placeService = new PlaceService();
        placeService.create(p1);
        placeService.create(p2);
        user1.addPlace(p1);
        userService.update(user1);
        placeService.deleteAll();*/
    }
}
