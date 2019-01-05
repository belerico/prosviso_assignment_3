package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.CardDao;
import com.assignment3.jpa.model.*;

import java.util.Iterator;

public class CardService extends AbstractService<Card, Long> {

    public CardService() {
        super(new CardDao());
    }

    private void deleteStandardCard(StandardCard entity) {
        getDao().begin();
        Iterator<UserStandardCard> i = entity.getUsers().iterator();
        while (i.hasNext()) {
            UserStandardCard u = i.next();
            i.remove();
            u.getUser().removeStandardCard(entity);
        }
        BusinessActivity b = entity.getBusinessActivity();
        if (b != null)
            b.removeCard(entity);
        getDao().delete(entity);
        getDao().commit();
    }

    private void deleteSharableCard(SharableCard entity) {
        getDao().begin();
        Iterator<UserSharableCard> i = entity.getUsers1().iterator();
        while (i.hasNext()) {
            UserSharableCard u = i.next();
            i.remove();
            u.getUser1().removeSharableCard(u.getUser2(), entity);
        }
        BusinessActivity b = entity.getBusinessActivity();
        if (b != null)
            b.removeCard(entity);
        getDao().delete(entity);
        getDao().commit();
    }

    @Override
    public void delete(Card entity) {
        if (entity instanceof StandardCard)
            deleteStandardCard((StandardCard) entity);
        else if (entity instanceof SharableCard)
            deleteSharableCard((SharableCard) entity);
    }
}
