package com.assignment3.action;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.BusinessActivityFaker;
import com.opensymphony.xwork2.ActionSupport;

public class BusinessActivityAction extends ActionSupport {


    private BusinessActivityFaker faker = new BusinessActivityFaker();
    private BusinessActivityService BusinessService = ServiceFactory.getInstance().getBusinessActivityService();
    private BusinessActivity businessActivity;

    public String executeBusinessActivity() {
        businessActivity = faker.create();
        BusinessService.create(businessActivity);
        return SUCCESS;
    }

    public BusinessActivity getBusinessActivity()
    {
        return businessActivity;
    }
}
