package com.assignment3.action.card;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class CardAction extends ActionSupport {
    private List<Card> cards;
    private CardService cardService;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String showCards() {
        cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }
}
