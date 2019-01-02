package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.BusinessActivityDao;
import com.assignment3.jpa.model.BusinessActivity;

public class BusinessActivityService extends AbstractService<BusinessActivity, Long> {

    public BusinessActivityService() {
        super(new BusinessActivityDao());
    }
}
