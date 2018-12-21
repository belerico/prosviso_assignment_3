package com.assignment3.jpa.services;

import com.assignment3.jpa.daos.BusinessActivityDao;
import com.assignment3.jpa.models.BusinessActivity;

import java.util.List;

public class BusinessActivityService implements ServiceInterface<BusinessActivity, Long> {

    private static BusinessActivityDao bDao;

    public BusinessActivityService() {
        bDao = new BusinessActivityDao();
    }

    @Override
    public void create(BusinessActivity entity) {
        bDao.begin();
        bDao.create(entity);
        bDao.commit();
    }

    @Override
    public BusinessActivity read(Long id) {
        bDao.begin();
        BusinessActivity b = bDao.read(id);
        bDao.commit();
        return b;
    }

    @Override
    public void update(BusinessActivity entity) {
        bDao.begin();
        bDao.update(entity);
        bDao.commit();
    }

    @Override
    public void delete(BusinessActivity entity) {

    }

    @Override
    public List<BusinessActivity> readAll() {
        bDao.begin();
        List<BusinessActivity> bs = bDao.readAll();
        bDao.commit();
        return bs;
    }

    @Override
    public void deleteAll() {

    }
}
