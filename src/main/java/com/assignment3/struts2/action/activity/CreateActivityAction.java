package com.assignment3.struts2.action.activity;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.BusinessActivityFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import java.util.List;

public class CreateActivityAction extends ActionSupport implements ModelDriven<BusinessActivity>, Preparable {

    private BusinessActivity businessActivity = new BusinessActivityFaker().create();
    private Long placeId;
    private List<Place> places;

    public BusinessActivity getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(BusinessActivity businessActivity) {
        this.businessActivity = businessActivity;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String createActivityPage() {
        prepare();
        return ActionSupport.SUCCESS;
    }

    public String createActivity() {
        getBusinessActivity().addPlace(ServiceFactory.getInstance().getPlaceService().read(placeId));
        ServiceFactory.getInstance().getBusinessActivityService().create(getBusinessActivity());
        return ActionSupport.SUCCESS;
    }

    @Override
    public void validate() {
        if (ServiceFactory.getInstance().getBusinessActivityService().readByNaturalId(getBusinessActivity().getName()) != null)
            addFieldError("businessActivity.name", "Activity " + getBusinessActivity().getName() + " already registered");
    }

    @Override
    public void prepare() {
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }

    @Override
    public BusinessActivity getModel() {
        return businessActivity;
    }
}

