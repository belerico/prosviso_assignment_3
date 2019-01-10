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

    private BusinessActivity activity = new BusinessActivityFaker().create();
    private Long placeId;
    private List<Place> places;

    public BusinessActivity getActivity() {
        return activity;
    }

    public void setActivity(BusinessActivity activity) {
        this.activity = activity;
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
        getActivity().addPlace(ServiceFactory.getInstance().getPlaceService().read(placeId));
        ServiceFactory.getInstance().getBusinessActivityService().create(getActivity());
        return ActionSupport.SUCCESS;
    }

    @Override
    public void validate() {
        if (ServiceFactory.getInstance().getBusinessActivityService().readByNaturalId(getActivity().getName()) != null)
            addFieldError("activity.name", "Activity " + getActivity().getName() + " already registered");
    }

    @Override
    public void prepare() {
        setPlaces(ServiceFactory.getInstance().getPlaceService().readAll());
    }

    @Override
    public BusinessActivity getModel() {
        return activity;
    }
}

