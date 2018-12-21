package com.assignment3.jpa.services;

import com.assignment3.jpa.daos.StandardCardDao;
import com.assignment3.jpa.models.StandardCard;

import java.util.List;

public class StandardCardService implements ServiceInterface<StandardCard, Long> {

    private StandardCardDao scDao;

    public StandardCardService() {
        scDao = new StandardCardDao();
    }

    @Override
    public void create(StandardCard entity) {
        scDao.begin();
        scDao.create(entity);
        scDao.commit();
    }

    @Override
    public StandardCard read(Long id) {
        scDao.begin();
        StandardCard sc = scDao.read(id);
        scDao.commit();
        return sc;
    }

    @Override
    public void update(StandardCard entity) {
        scDao.begin();
        scDao.update(entity);
        scDao.commit();
    }

    @Override
    public void delete(StandardCard entity) {

    }

    @Override
    public List<StandardCard> readAll() {
        scDao.begin();
        List<StandardCard> scs = scDao.readAll();
        scDao.commit();
        return scs;
    }

    @Override
    public void deleteAll() {

    }
}
