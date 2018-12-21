package com.assignment3.jpa.services;

import com.assignment3.jpa.daos.StandardCardDao;
import com.assignment3.jpa.models.StandardCard;

import java.util.List;

public class StandardCardService extends AbstractService<StandardCard, Long> {

    private StandardCardDao scDao;

    public StandardCardService() {
        super(StandardCard.class, new StandardCardDao(StandardCard.class));
        scDao = (StandardCardDao) super.getDao();
    }

    @Override
    public void delete(StandardCard entity) {
        entity.getBusinessActivity().removeCard(entity);
        scDao.begin();
        scDao.delete(entity);
        scDao.commit();
    }

    @Override
    public List<StandardCard> readAll() {
        scDao.begin();
        List<StandardCard> s = scDao.readAll();
        scDao.commit();
        return s;
    }

    @Override
    public void deleteAll() {
        List<StandardCard> standardCards = readAll();
        for (StandardCard s : standardCards)
            delete(s);
    }
}
