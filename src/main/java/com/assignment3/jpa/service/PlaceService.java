package com.assignment3.jpa.service;

import com.assignment3.jpa.dao.PlaceDao;
import com.assignment3.jpa.model.Place;

public class PlaceService extends AbstractService<Place, Long> {

    public PlaceService() { super(new PlaceDao()); }

    public void removeAllActivities(Place place) {
        getDao().begin();
        place.removeAllActivities();
        getDao().commit();
    }

    public void removeAllUser(Place place) {
        getDao().begin();
        place.removeAllUser();
        getDao().commit();
    }

    @Override
    public void delete(Place place) {
        removeAllUser(place);
        removeAllActivities(place);
        getDao().begin();
        getDao().delete(place);
        getDao().commit();
    }
}
