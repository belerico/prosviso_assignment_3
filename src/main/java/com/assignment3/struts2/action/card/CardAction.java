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
    private String cardType;
    private Card card = new CardFaker().create();
    private Long activityId;


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String myType) {
        this.cardType = myType;
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
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String createCard() {
        BusinessActivity activity = ServiceFactory.getInstance().getBusinessActivityService().read(getActivityId());
        Card card = getCard();
        if (card instanceof StandardCard && getCardType().equals("SH"))
            card = new SharableCard(card.getCardNumber(), card.getQuantity());
        else if (card instanceof SharableCard && getCardType().equals("ST"))
            card = new StandardCard(card.getCardNumber(), card.getQuantity());
        activity.addCard(card);
        ServiceFactory.getInstance().getCardService().create(card);
        return ActionSupport.SUCCESS;
    }

    public String removeCard() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        cardService.delete(cardService.read(getCard().getId()));
        return ActionSupport.SUCCESS;
    }

    public String removeAllCards() {
        ServiceFactory.getInstance().getCardService().deleteAll();
        return ActionSupport.SUCCESS;
    }

    public String showCards() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() {
        if (card instanceof StandardCard)
            setCardType("ST");
        else if (card instanceof SharableCard)
            setCardType("SH");
    }

    @Override
    public Card getModel() {
        return card;
    }
}
