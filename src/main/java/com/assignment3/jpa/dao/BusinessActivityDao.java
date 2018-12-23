package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.BusinessActivity;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long> {

    public BusinessActivityDao(Class<BusinessActivity> businessActivityClass) {
        super(businessActivityClass);
    }

}
