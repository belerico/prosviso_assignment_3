package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.BusinessActivity;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long, String> {

    public BusinessActivityDao() {
        super(BusinessActivity.class);
    }

 /*   public BusinessActivity findActivityByName(String name) {
        BusinessActivity activity = null;
        try {
            activity = getEntityManager()
                    .createNamedQuery("findActivityByName", gettClass())
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException n) {
            n.printStackTrace();
        }
        return activity;
    }*/

}
