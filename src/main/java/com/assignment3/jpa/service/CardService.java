package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.CardDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;

public class CardService extends AbstractService<Card, Long, String> {

    public CardService() {
        super(new CardDao());
    }

    @Override
    public void delete(Card card) {
        BusinessActivity businessActivity = card.getBusinessActivity();
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeCard(card);
        getDao().delete(card);
        getDao().commit();
    }
}
