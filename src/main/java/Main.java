import com.assignment3.jpa.dao.CardDao;
import com.assignment3.jpa.model.*;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.jpa.service.UserService;
import com.assignment3.utils.Helper;
import com.assignment3.utils.faker.PlaceFaker;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Helper.dropDatabase();
        StandardCard st1 = new StandardCard("AAAA");
        StandardCard st2 = new StandardCard("BBBB");
        StandardCard st3 = new StandardCard("CCCC");
        SharableCard sh1 = new SharableCard("SAAAA");
        SharableCard sh2 = new SharableCard("SBBBB");
        SharableCard sh3 = new SharableCard("SCCCC");
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        User user1 = new User("n1", "s1", "p1", "e1", LocalDate.now(), true);
        User user2 = new User("n2", "s2", "p2", "e2", LocalDate.now(), true);

        UserService userService = ServiceFactory.getInstance().getUserService();
        CardService cardService = ServiceFactory.getInstance().getCardService();
        BusinessActivityService businessActivityService = ServiceFactory.getInstance().getBusinessActivityService();
        cardService.create(st1);
        cardService.create(st2);
        cardService.create(st3);
        cardService.create(sh1);
        cardService.create(sh2);
        cardService.create(sh3);
        //cardService.deleteAll();
        CardDao cardProva = new CardDao();
        List<Card> cardP = cardProva.getStandardCard();
        System.out.println(cardP);
        Place p = new PlaceFaker().create();

        /*ba1.addPlace(p);
        ba1.addCard(st1);
        ba1.addCard(st2);
        ba2.addCard(st3);
        ba1.addCard(sh1);
        ba1.addCard(sh2);
        ba2.addCard(sh3);*/

        businessActivityService.create(ba1);
        businessActivityService.create(ba2);

        userService.create(user1);
        userService.create(user2);

        user1.addSharableCard(user2, sh1);
        //user1.addSharableCard(user2, sh2);
        userService.create(user1);
        List<Card> card = cardService.readAll();
        System.out.println(card.get(0));
        /*user1.addStandardCard(st1);
        user1.addStandardCard(st2);*/

        //userService.update(user1);
        //userService.getDao().flush();
        /*user2.addSharableCard(user1, sh3);
        user2.addStandardCard(st2);
        userService.create(user2);
        user1.addStandardCard(st3);
        userService.create(user1);
        user1.setName("another");
        userService.update(user1);*/

        //ba1.removeAllCard();
        //businessActivityService.delete(ba1);
        //cardService.deleteAll();
        //businessActivityService.deleteAllCard(ba1);
        //userService.deleteAll();
        //System.out.println(businessActivityService.getCards(ba1));
        //System.out.println(ba1.getCards().size());
        //businessActivityService.deleteAll();
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
        //Helper.dropDatabase();
    }
}
