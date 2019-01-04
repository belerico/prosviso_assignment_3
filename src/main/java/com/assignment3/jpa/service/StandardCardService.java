package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.StandardCardDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.StandardCard;
import com.assignment3.jpa.model.UserStandardCard;

import java.util.Iterator;

public class StandardCardService extends AbstractService<StandardCard, Long> {

    public StandardCardService() {
        super(new StandardCardDao());
    }

    @Override
    public void delete(StandardCard entity) {
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
        getDao().commit();
    }

    @Override
    public void deleteAll() {
        for (StandardCard s : readAll())
            delete(s);
    }
}
