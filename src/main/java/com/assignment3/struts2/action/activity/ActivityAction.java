package com.assignment3.struts2.action.activity;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ActivityAction extends ActionSupport {

    private Long activityId;
    private List<BusinessActivity> businessActivities;

    public List<BusinessActivity> getBusinessActivities() {
        return businessActivities;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public void setBusinessActivities(List<BusinessActivity> businessActivities) {
        this.businessActivities = businessActivities;
    }

    public String removeActivity() {
        BusinessActivityService businessActivityService = ServiceFactory.getInstance().getBusinessActivityService();
        businessActivityService.delete(businessActivityService.read(getActivityId()));
        return ActionSupport.SUCCESS;
    }

    public String showActivities() {
        setBusinessActivities(ServiceFactory.getInstance().getBusinessActivityService().readAll());
        return ActionSupport.SUCCESS;
    }
}