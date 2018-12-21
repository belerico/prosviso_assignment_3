package com.assignment3.jpa.daos;

import com.assignment3.jpa.models.BusinessActivity;

import java.util.List;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long> {


    @Override
    public void create(BusinessActivity entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public BusinessActivity read(Long id) {
        return getEntityManager().find(BusinessActivity.class, id);
    }

    @Override
    public void update(BusinessActivity entity) {
        getEntityManager().merge(entity);
    }

    @Override
    void delete(BusinessActivity entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public List<BusinessActivity> readAll() {
        return getEntityManager().createQuery("from BusinessActivity").getResultList();
    }

    @Override
    void deleteAll() {
        List<BusinessActivity> businessActivities = readAll();
        for (BusinessActivity b : businessActivities)
            delete(b);
    }
}
