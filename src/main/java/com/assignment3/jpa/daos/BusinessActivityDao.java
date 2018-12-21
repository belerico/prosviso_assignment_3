package com.assignment3.jpa.daos;

import com.assignment3.jpa.models.BusinessActivity;

import java.util.List;

public class BusinessActivityDao extends AbstractDao<BusinessActivity, Long> {

    public BusinessActivityDao(Class<BusinessActivity> businessActivityClass) {
        super(businessActivityClass);
    }

    public List<BusinessActivity> readAll() {
        return readAll("from BusinessActivity");
    }

    @Override
    public void deleteAll() {
        List<BusinessActivity> businessActivities = readAll();
        for (BusinessActivity b : businessActivities)
            delete(b);
    }
}
