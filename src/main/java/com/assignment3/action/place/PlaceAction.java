package com.assignment3.action.place;

import com.assignment3.jpa.model.Place;
import com.assignment3.jpa.service.PlaceService;
import com.assignment3.jpa.service.ServiceFactory;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class PlaceAction extends ActionSupport {

    PlaceService placeService = ServiceFactory.getInstance().getPlaceService();
    List<Place> places;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String execute() {
        places = placeService.readAll();
        return ActionSupport.SUCCESS;
    }
}
