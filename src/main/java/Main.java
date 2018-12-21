import com.assignment3.jpa.models.BusinessActivity;
import com.assignment3.jpa.models.StandardCard;
import com.assignment3.jpa.services.BusinessActivityService;
import com.assignment3.jpa.services.StandardCardService;

public class Main {
    public static void main(String[] args) {
        StandardCard st1 = new StandardCard();
        StandardCard st2 = new StandardCard();
        BusinessActivity ba1 = new BusinessActivity("name1", "type1");
        BusinessActivity ba2 = new BusinessActivity("name2", "type2");
        StandardCardService standardCardService = new StandardCardService();
        BusinessActivityService businessActivityService = new BusinessActivityService();
        ba1.addCard(st1);
        ba1.addCard(st2);
        businessActivityService.create(ba1);
        businessActivityService.create(ba2);
        standardCardService.deleteAll();
        businessActivityService.deleteAll();

        //System.out.println(standardCardService.readAll());
    }
}
