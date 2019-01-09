package com.assignment3.action.activity;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.BusinessActivityFaker;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class BusinessActivityAction extends ActionSupport {


    private List<BusinessActivity> businessActivities;
    private BusinessActivityService businessActivityService;

    public List<BusinessActivity> getBusinessActivities() {
        return businessActivities;
    }

    public void setBusinessActivities(List<BusinessActivity> businessActivities) {
        this.businessActivities = businessActivities;
    }

    public String showActivities() {
        businessActivityService = ServiceFactory.getInstance().getBusinessActivityService();
        setBusinessActivities(businessActivityService.readAll());
        return ActionSupport.SUCCESS;
    }
}