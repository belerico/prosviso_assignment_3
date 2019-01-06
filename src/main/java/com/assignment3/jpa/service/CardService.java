package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.CardDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;

public class CardService extends AbstractService<Card, Long> {

    public CardService() {
        super(new CardDao());
    }

    @Override
    public void delete(Card card) {
        BusinessActivity businessActivity = card.getBusinessActivity();
        if(businessActivity !=  null)
            new BusinessActivityService().removeCard(card);
        else  {
            getDao().begin();
            getDao().delete(card);
            getDao().commit();
        }
    }
}
