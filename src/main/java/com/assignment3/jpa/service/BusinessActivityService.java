package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.User;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }

    public void deleteCard(BusinessActivity b, Card c) {
        getDao().begin();
        if (c instanceof StandardCard) {
            for (User u : ((StandardCard) c).getUsersList())
                u.removeStandardCard((StandardCard) c);
        }
        b.removeCard(c);
        getDao().commit();
    }

    public void deleteAllCard(BusinessActivity b) {
        for (Card c : b.getCards())
            deleteCard(b, c);
    }
}
