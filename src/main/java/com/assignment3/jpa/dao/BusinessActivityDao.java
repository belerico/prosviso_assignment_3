package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.BusinessActivity;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long, String> {

    public BusinessActivityDao() {
        super(BusinessActivity.class);
    }

}
