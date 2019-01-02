package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.StandardCardDao;
import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.StandardCard;

import java.util.List;

public class StandardCardService extends AbstractService<StandardCard, Long> {

    public StandardCardService() {
        super(new StandardCardDao());
    }

    @Override
    public void delete(StandardCard entity) {
        BusinessActivity b = entity.getBusinessActivity();
        if (b != null)
            b.removeCard(entity);
        super.delete(entity);
    }

    @Override
    public void deleteAll() {
        List<StandardCard> standardCards = readAll();
        for (StandardCard s : standardCards)
            delete(s);
    }
}
