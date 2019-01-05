package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Card;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }

    public void addCard(BusinessActivity businessActivity, Card card) {
        getDao().begin();
        businessActivity.addCard(card);
        getDao().commit();
    }

    public void deleteCard(Card card) {
        BusinessActivity businessActivity = card.getBusinessActivity();
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeCard(card);
        getDao().commit();
    }

    public void deleteAllCard(BusinessActivity businessActivity) {
        getDao().begin();
        if (businessActivity != null)
            businessActivity.removeAllCard();
        getDao().commit();
    }

    @Override
    public void delete(BusinessActivity b) {
        deleteAllCard(b);
        getDao().begin();
        getDao().delete(b);
        getDao().commit();
    }
}
