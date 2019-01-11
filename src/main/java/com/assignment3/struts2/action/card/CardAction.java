package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.CardFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class CardAction extends ActionSupport implements ModelDriven<Card> {

    private List<Card> cards;
    private  Card card = new CardFaker().create();

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
        ServiceFactory.getInstance().getCardService().create(getCard());
        return ActionSupport.SUCCESS;
    }

    public String showCards() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }

    @Override
    public Card getModel() {
        return card;
    }
}
