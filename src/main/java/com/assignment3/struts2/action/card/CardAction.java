package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class CardAction extends ActionSupport {
    private Long id;
    private List<Card> cards;


    public List<Card> getCards() {
        return cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String showCards() {
        CardService cardService = ServiceFactory.getInstance().getCardService();
        setCards(cardService.readAll());
        return ActionSupport.SUCCESS;
    }
}
