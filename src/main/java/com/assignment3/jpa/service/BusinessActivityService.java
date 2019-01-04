package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.StandardCard;

import java.util.ListIterator;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }

    public void deleteCard(Card c) {
        new StandardCardService().delete((StandardCard) c);
    }

    public void deleteAllCard(BusinessActivity b) {
        StandardCardService service = new StandardCardService();
        ListIterator<Card> iter = b.getCards().listIterator();
        while (iter.hasNext()) {
            Card c = iter.next();
            iter.remove();
            service.delete((StandardCard) c);
        }
    }

    @Override
    public void delete(BusinessActivity b) {
        deleteAllCard(b);
        getDao().begin();
        getDao().delete(b);
        getDao().commit();
    }

    @Override
    public void deleteAll() {
        for (BusinessActivity b : readAll())
            delete(b);
    }
}
