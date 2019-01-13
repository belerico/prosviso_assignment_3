package com.assignment3.jpa.dao;

import com.assignment3.jpa.model.Place;

public class PlaceDAO extends AbstractDAO<Place, Long, String> {

    public PlaceDAO() {
        super(Place.class);
    }
}
