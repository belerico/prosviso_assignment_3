package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;

import java.util.ListIterator;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }

    public void deleteCard(Card c) {
        new CardService().delete(c);
    }

    public void deleteAllCard(BusinessActivity b) {
        CardService service = new CardService();
        ListIterator<Card> iter = b.getCards().listIterator();
        while (iter.hasNext()) {
            Card c = iter.next();
            iter.remove();
            service.delete(c);
        }
    }

    @Override
    public void delete(BusinessActivity b) {
        deleteAllCard(b);
        getDao().begin();
        getDao().delete(b);
        getDao().commit();
    }
}
