package com.assignment3.jpa.services;

import com.assignment3.jpa.daos.BusinessActivityDao;
import com.assignment3.jpa.models.BusinessActivity;

import java.util.List;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    private BusinessActivityDao bDao;

    public BusinessActivityService() {
        super(BusinessActivity.class, new BusinessActivityDao(BusinessActivity.class));
        bDao = (BusinessActivityDao) getDao();
    }

    @Override
    public void delete(BusinessActivity entity) {
        bDao.begin();
        bDao.delete(entity);
        bDao.commit();
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
        List<BusinessActivity> businessActivities = readAll();
        for (BusinessActivity b : businessActivities)
            delete(b);
    }
}
