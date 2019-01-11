package com.assignment3.struts2.action.card;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.service.CardService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.CardFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class CardAction extends ActionSupport implements ModelDriven<Card> {

    private List<Card> cards;
    private  Card card = new CardFaker().create();
    private Long businessId;


    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
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
        Long paramValue = Long.parseLong(ServletActionContext.getRequest().getParameter("activity.id"));
        setBusinessId(paramValue);
        return ActionSupport.SUCCESS;
    }

    public String createCard() {
        BusinessActivity activity = ServiceFactory.getInstance().getBusinessActivityService().read(getBusinessId());
        Card card = getCard();
        card.setBusinessActivity(activity);
        ServiceFactory.getInstance().getCardService().create(card);
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
