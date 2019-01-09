package com.assignment3.action.activity;

import com.assignment3.jpa.model.BusinessActivity;
import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.service.BusinessActivityService;
import com.assignment3.jpa.service.ServiceFactory;
import com.assignment3.utils.faker.BusinessActivityFaker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import javax.persistence.PersistenceException;
import java.util.List;

public class CreateActivityAction extends ActionSupport implements Preparable {

    private String name;
    private String type;
    private Long placeId;
    private List<Place> places;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String createActivityPage() {
        BusinessActivity businessActivity = new BusinessActivityFaker().create();
        setName(businessActivity.getName());
        setType(businessActivity.getType());
        return ActionSupport.SUCCESS;
    }

    public String createActivity() {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity.setName(getName());
        businessActivity.setType(getType());
        businessActivity.addPlace(ServiceFactory.getInstance().getPlaceService().read(placeId));
        BusinessActivityService businessActivityService = ServiceFactory.getInstance().getBusinessActivityService();
        try {
            businessActivityService.create(businessActivity);
        } catch (PersistenceException p) {
            businessActivityService.getDao().rollback();
            addActionError(p.toString());
            return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }
    @Override
    public void prepare() {
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }
}

