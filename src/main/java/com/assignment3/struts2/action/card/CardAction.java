package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.CardFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.util.List;

public class CardAction extends ActionSupport implements ModelDriven<Card>, Preparable {

    private List<Card> cards;
    private String type;
    private  Card card = new CardFaker().create();
    private Long activityId;

    public String getType() {
        return type;
    }

    public void setType(String myType) {
        this.type = myType;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String createCardPage() {
        return ActionSupport.SUCCESS;
    }

    public String createCard() {
        BusinessActivity activity = ServiceFactory.getInstance().getBusinessActivityService().read(getActivityId());
        Card card = getCard();
        activity.addCard(card);
        ServiceFactory.getInstance().getCardService().create(card);
        return ActionSupport.SUCCESS;
    }

    public String addStandardCard(){
        return "ciao";
    }

    public String showCards() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        if (getCard() instanceof StandardCard)
            setType("ST");
        else if (getCard() instanceof SharableCard)
            setType("SH");
    }

    @Override
    public Card getModel() {
        return card;
    }
}
