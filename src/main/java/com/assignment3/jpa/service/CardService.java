package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.CardDAO;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.SharableCard;
import com.assignment3.jpa.model.StandardCard;

import java.util.List;

public class CardService extends AbstractService<Card, Long, String> {

    public CardService() {
        super(new CardDAO());
    }

    @Override
    public void delete(Card card) {
        BusinessActivity businessActivity = card.getBusinessActivity();
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeCard(card);
        getDao().commit();
    }

    public List<StandardCard> getStandardCards() {
        return ((CardDAO) getDao()).getStandardCards();
    }

    public List<SharableCard> getSharableCards() {
        return ((CardDAO) getDao()).getSharableCards();
    }

}
