package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.CardFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import javax.persistence.PersistenceException;


public class CreateCardAction extends ActionSupport implements Preparable {
    private String cardNumber;
    private int quantity;
    private String type;
    private String [] typeCard;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String[] typeCard) {
        this.typeCard = typeCard;
    }

    public String createCardPage() {
        Card card = new CardFaker().create();
        if(card instanceof StandardCard)
            setType("ST");
        else
            setType("SH");
        setCardNumber(card.getCardNumber());
        setQuantity(card.getQuantity());
        return ActionSupport.SUCCESS;
    }

    public String createCard() {
        String type = getType();
        Card card;
        if(type.equals("ST"))
            card = new StandardCard();
        else
            card = new SharableCard();
        card.setCardNumber(getCardNumber());
        card.setQuantity(getQuantity());
        CardService cardService = ServiceFactory.getInstance().getCardService();
        try {
            cardService.create(card);
        } catch (PersistenceException p) {
            cardService.getDao().rollback();
            addActionError(p.toString());
            return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        setTypeCard(new String[]{"ST", "SH"});
    }
}
